package com.example.rimpsa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class AgregarProducto extends AppCompatActivity {

    private EditText editTextID;
    private EditText editTextNombre;
    private EditText editTextMarca;
    private EditText editTextDescripcion;
    private EditText editTextPrecio;
    private EditText editTextEstatus;
    private EditText editTextCantidad;
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
        editTextCantidad = findViewById(R.id.editTextCantidad);
        btnGuardar = findViewById(R.id.btnGuardar);

        btnGuardar.setOnClickListener(v -> {
            if (validarCampos()) {
                String id = editTextID.getText().toString();
                String nombre = editTextNombre.getText().toString();
                String marca = editTextMarca.getText().toString();
                String descripcion = editTextDescripcion.getText().toString();
                String precio = editTextPrecio.getText().toString();
                String estatus = editTextEstatus.getText().toString();
                int cantidad = Integer.parseInt(editTextCantidad.getText().toString());

                ProductoItem nuevoProducto = new ProductoItem(
                        id,
                        nombre,
                        marca,
                        descripcion,
                        precio,
                        estatus,
                        cantidad,
                        ProductoItem.DEFAULT_IMAGE_ID
                );

                Intent resultIntent = new Intent();
                resultIntent.putExtra("nuevoProducto", nuevoProducto);
                setResult(RESULT_OK, resultIntent);
                finish();
            } else {
                Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private boolean validarCampos() {
        boolean isValid = true;

        if (editTextID.getText().toString().trim().isEmpty()) {
            isValid = false;
        }
        if (editTextNombre.getText().toString().trim().isEmpty()) {
            isValid = false;
        }
        if (editTextMarca.getText().toString().trim().isEmpty()) {
            isValid = false;
        }
        if (editTextDescripcion.getText().toString().trim().isEmpty()) {
            isValid = false;
        }
        if (editTextPrecio.getText().toString().trim().isEmpty()) {
            isValid = false;
        }
        if (editTextEstatus.getText().toString().trim().isEmpty()) {
            isValid = false;
        }
        if (editTextCantidad.getText().toString().trim().isEmpty()) {
            isValid = false;
        }

        return isValid;
    }
}