package com.example.rimpsa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class AgregarProducto extends AppCompatActivity {

    private EditText editTextID;
    private EditText editTextNombre;
    private EditText editTextMarca;
    private EditText editTextDescripcion;
    private EditText editTextPrecio;
    private EditText editTextEstatus;
    private Button btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.agregar_producto);

        editTextID = findViewById(R.id.editTextID);
        editTextNombre = findViewById(R.id.editTextNombre);
        editTextMarca = findViewById(R.id.editTextMarca);
        editTextDescripcion = findViewById(R.id.editTextDescripcion);
        editTextPrecio = findViewById(R.id.editTextPrecio);
        editTextEstatus = findViewById(R.id.editTextEstatus);
        btnGuardar = findViewById(R.id.btnGuardar);

        btnGuardar.setOnClickListener(v -> {
            String id = editTextID.getText().toString();
            String nombre = editTextNombre.getText().toString();
            String marca = editTextMarca.getText().toString();
            String descripcion = editTextDescripcion.getText().toString();
            String precio = editTextPrecio.getText().toString();
            String estatus = editTextEstatus.getText().toString();

            // Return result to Producto Activity
            Intent resultIntent = new Intent();
            resultIntent.putExtra("id", id);
            resultIntent.putExtra("nombre", nombre);
            resultIntent.putExtra("marca", marca);
            resultIntent.putExtra("descripcion", descripcion);
            resultIntent.putExtra("precio", precio);
            resultIntent.putExtra("estatus", estatus);
            setResult(RESULT_OK, resultIntent);
            finish();
        });
    }
}
