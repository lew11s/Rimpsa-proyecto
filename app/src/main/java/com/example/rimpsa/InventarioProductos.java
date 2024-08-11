package com.example.rimpsa;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class InventarioProductos extends AppCompatActivity {

    private TextView textViewListaProductos;
    private TextView textViewCantidad;
    private List<ProductoItem> productos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inventario_productos);

        textViewListaProductos = findViewById(R.id.textViewListaProductos);
        textViewCantidad = findViewById(R.id.textViewCantidad);

        productos = new ArrayList<>();

        // Recibir lista de productos del Intent
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("productos")) {
            productos = intent.getParcelableArrayListExtra("productos");
        }

        actualizarInventario();
    }

    private void actualizarInventario() {
        StringBuilder listaProductos = new StringBuilder();
        int totalCantidad = 0;

        for (ProductoItem producto : productos) {
            listaProductos.append(producto.getNombre())
                    .append(": ")
                    .append(producto.getCantidad())
                    .append(" unidades\n");
            totalCantidad += producto.getCantidad();
        }

        textViewListaProductos.setText(listaProductos.toString());
        textViewCantidad.setText("Número total de productos disponibles: " + totalCantidad);
    }
}
