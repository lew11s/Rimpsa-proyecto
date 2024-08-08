package com.example.rimpsa;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class InventarioProductos extends AppCompatActivity {

    private TextView textViewCantidad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inventario_productos);

        textViewCantidad = findViewById(R.id.textViewCantidad);


        int cantidadProductos = 10;
        textViewCantidad.setText(String.valueOf(cantidadProductos));
    }
}
