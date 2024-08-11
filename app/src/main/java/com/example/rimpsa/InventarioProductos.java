package com.example.rimpsa;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class InventarioProductos extends AppCompatActivity {

    private TextView textViewCantidad;
    private List<ProductoItem> productos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inventario_productos);

        textViewCantidad = findViewById(R.id.textViewCantidad);

        productos = new ArrayList<>();
        productos.add(new ProductoItem("1", "Producto 1", "Marca A", "Descripción 1", "$10", "Activo", 50, R.drawable.ic_launcher_background));
        productos.add(new ProductoItem("2", "Producto 2", "Marca B", "Descripción 2", "$20", "Activo", 30, R.drawable.ic_launcher_background));

        actualizarInventario();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && data != null) {
            if (data.hasExtra("nuevoProducto")) {
                ProductoItem nuevoProducto = (ProductoItem) data.getSerializableExtra("nuevoProducto");
                productos.add(nuevoProducto);
            } else if (data.hasExtra("productoEditado")) {
                ProductoItem productoEditado = (ProductoItem) data.getSerializableExtra("productoEditado");
                actualizarProducto(productoEditado);
            }
            actualizarInventario();
        }
    }

    private void actualizarProducto(ProductoItem productoEditado) {
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getId().equals(productoEditado.getId())) {
                productos.set(i, productoEditado);
                break;
            }
        }
    }

    private void actualizarInventario() {
        int totalCantidad = 0;
        for (ProductoItem producto : productos) {
            totalCantidad += producto.getCantidad();
        }
        textViewCantidad.setText("Número total de productos disponibles: " + totalCantidad);
    }
}
