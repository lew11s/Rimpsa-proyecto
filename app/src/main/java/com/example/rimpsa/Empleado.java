package com.example.rimpsa;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Empleado extends AppCompatActivity {

    List<listelementos> elementos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_empleado);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });

        init();
    }
    public void init() {
        elementos= new ArrayList<>();
        elementos.add(new listelementos("#775447","hector","desarrollador","activo"));
        elementos.add(new listelementos("#607d8b","mariana","CEO","activo"));
        elementos.add(new listelementos("#03a9f4","ceja","barrendero","activo"));
        elementos.add(new listelementos("#f44336","nahomy","secretaria","activo"));
        elementos.add(new listelementos("#009688","manuel","KFC","activo"));

        listadaptador listadaptador = new listadaptador(elementos, this);
        RecyclerView recyclerView = findViewById(R.id.listRecycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listadaptador);

    }
}