package com.example.rimpsa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText TxtUsuario, TxtContra;
    Button BtnIniciar;


    private final String validUsername = "luis";
    private final String validPassword = "1234";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TxtUsuario = findViewById(R.id.TxtUsuario);
        TxtContra = findViewById(R.id.Txtcontra);
        BtnIniciar = findViewById(R.id.BtnIniciar);

        BtnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = TxtUsuario.getText().toString();
                String password = TxtContra.getText().toString();

                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Por favor, ingresa todos los campos", Toast.LENGTH_SHORT).show();
                } else {
                    validateLogin(username, password);
                }
            }
        });
    }

    private void validateLogin(String username, String password) {
        if (username.equals(validUsername) && password.equals(validPassword)) {

            Intent ventana = new Intent(MainActivity.this, Menu.class);
            startActivity(ventana);
        } else {

            Toast.makeText(MainActivity.this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
        }
    }
}
