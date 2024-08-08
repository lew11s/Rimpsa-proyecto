package com.example.rimpsa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class EditarProducto extends AppCompatActivity {

    private EditText editTextId;
    private EditText editTextNombre;
    private EditText editTextMarca;
    private EditText editTextDescripcion;
    private EditText editTextPrecio;
    private EditText editTextEstatus;
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
        btnGuardar = findViewById(R.id.btnGuardar);

        Intent intent = getIntent();
        editTextId.setText(intent.getStringExtra("id"));
        editTextNombre.setText(intent.getStringExtra("nombre"));
        editTextMarca.setText(intent.getStringExtra("marca"));
        editTextDescripcion.setText(intent.getStringExtra("descripcion"));
        editTextPrecio.setText(intent.getStringExtra("precio"));
        editTextEstatus.setText(intent.getStringExtra("estatus"));

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("id", editTextId.getText().toString());
                resultIntent.putExtra("nombre", editTextNombre.getText().toString());
                resultIntent.putExtra("marca", editTextMarca.getText().toString());
                resultIntent.putExtra("descripcion", editTextDescripcion.getText().toString());
                resultIntent.putExtra("precio", editTextPrecio.getText().toString());
                resultIntent.putExtra("estatus", editTextEstatus.getText().toString());
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }
}
