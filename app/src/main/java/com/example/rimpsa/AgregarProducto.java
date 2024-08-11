package com.example.rimpsa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class AgregarProducto extends AppCompatActivity {

    private EditText editTextID;
    private EditText editTextNombre;
    private EditText editTextMarca;
    private EditText editTextDescripcion;
    private EditText editTextPrecio;
    private EditText editTextEstatus;
    private EditText editTextCantidad;
    private Button btnGuardar;

    private List<ProductoItem> productos;

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

        // Obtener la lista de productos desde Producto
        productos = Producto.obtenerListaProductos();

        btnGuardar.setOnClickListener(v -> {
            if (validarCampos()) {
                String id = editTextID.getText().toString();
                String nombre = editTextNombre.getText().toString();
                String marca = editTextMarca.getText().toString();
                String descripcion = editTextDescripcion.getText().toString();
                String precio = editTextPrecio.getText().toString();
                String estatus = editTextEstatus.getText().toString();
                int cantidad = Integer.parseInt(editTextCantidad.getText().toString());

                if (!esIDRepetido(id)) {
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
                    Toast.makeText(this, "El ID ya existe, por favor ingrese un ID diferente", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "Por favor, complete todos los campos correctamente", Toast.LENGTH_SHORT).show();
                Toast.makeText(this, "Precio o Cantidad invalidos", Toast.LENGTH_LONG).show();
            }
        });
    }

    private boolean validarCampos() {
        return !editTextID.getText().toString().trim().isEmpty() &&
                !editTextNombre.getText().toString().trim().isEmpty() &&
                !editTextMarca.getText().toString().trim().isEmpty() &&
                !editTextDescripcion.getText().toString().trim().isEmpty() &&
                !editTextPrecio.getText().toString().trim().isEmpty() &&
                esNumerico(editTextPrecio.getText().toString().trim()) &&
                !editTextEstatus.getText().toString().trim().isEmpty() &&
                !editTextCantidad.getText().toString().trim().isEmpty() &&
                esNumerico(editTextCantidad.getText().toString().trim());
    }

    private boolean esNumerico(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean esIDRepetido(String id) {
        for (ProductoItem producto : productos) {
            if (producto.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }
}
