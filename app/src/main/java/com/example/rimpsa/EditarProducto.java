package com.example.rimpsa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class EditarProducto extends AppCompatActivity {

    private EditText editTextId;
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
        setContentView(R.layout.editar_producto);

        editTextId = findViewById(R.id.editTextId);
        editTextNombre = findViewById(R.id.editTextNombre);
        editTextMarca = findViewById(R.id.editTextMarca);
        editTextDescripcion = findViewById(R.id.editTextDescripcion);
        editTextPrecio = findViewById(R.id.editTextPrecio);
        editTextEstatus = findViewById(R.id.editTextEstatus);
        editTextCantidad = findViewById(R.id.editTextCantidad);
        btnGuardar = findViewById(R.id.btnGuardar);

        Intent intent = getIntent();
        ProductoItem producto = (ProductoItem) intent.getSerializableExtra("producto");

        if (producto != null) {
            editTextId.setText(producto.getId());
            editTextNombre.setText(producto.getNombre());
            editTextMarca.setText(producto.getMarca());
            editTextDescripcion.setText(producto.getDescripcion());
            editTextPrecio.setText(producto.getPrecio());
            editTextEstatus.setText(producto.getEstatus());
            editTextCantidad.setText(String.valueOf(producto.getCantidad()));
        }

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validarCampos()) {
                    ProductoItem productoEditado = new ProductoItem(
                            editTextId.getText().toString(),
                            editTextNombre.getText().toString(),
                            editTextMarca.getText().toString(),
                            editTextDescripcion.getText().toString(),
                            editTextPrecio.getText().toString(),
                            editTextEstatus.getText().toString(),
                            Integer.parseInt(editTextCantidad.getText().toString()),
                            R.drawable.ic_launcher_background // Revisar si este recurso es correcto

                    );

                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("productoEditado", productoEditado);
                    setResult(RESULT_OK, resultIntent);
                    finish();
                }
            }
        });
    }

    private boolean validarCampos() {
        boolean isValid = true;

        if (editTextId.getText().toString().trim().isEmpty()) {
            editTextId.setError("Ingrese un ID");
            isValid = false;
        }

        if (editTextNombre.getText().toString().trim().isEmpty()) {
            editTextNombre.setError("Ingrese un nombre");
            isValid = false;
        }

        if (editTextMarca.getText().toString().trim().isEmpty()) {
            editTextMarca.setError("Ingrese una marca");
            isValid = false;
        }

        if (editTextDescripcion.getText().toString().trim().isEmpty()) {
            editTextDescripcion.setError("Ingrese una descripción");
            isValid = false;
        }

        if (editTextPrecio.getText().toString().trim().isEmpty()) {
            editTextPrecio.setError("Ingrese un precio");
            isValid = false;
        }

        if (editTextEstatus.getText().toString().trim().isEmpty()) {
            editTextEstatus.setError("Ingrese un estatus");
            isValid = false;
        }

        if (editTextCantidad.getText().toString().trim().isEmpty()) {
            editTextCantidad.setError("Ingrese una cantidad");
            isValid = false;
        } else {
            try {
                Integer.parseInt(editTextCantidad.getText().toString());
            } catch (NumberFormatException e) {
                editTextCantidad.setError("Ingrese una cantidad válida");
                isValid = false;
            }
        }

        if (!isValid) {
            Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show();
        }

        return isValid;
    }
}