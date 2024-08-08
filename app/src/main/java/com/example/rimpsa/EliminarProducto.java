package com.example.rimpsa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class EliminarProducto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eliminar_producto);

        Button btnConfirmDelete = findViewById(R.id.btnConfirmDelete);
        Button btnCancelDelete = findViewById(R.id.btnCancelDelete);

        btnConfirmDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Aquí puedes añadir la lógica para eliminar el producto
                Intent intent = new Intent(EliminarProducto.this, Producto.class);
                startActivity(intent);
                finish();
            }
        });

        btnCancelDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
