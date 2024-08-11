package com.example.rimpsa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class Producto extends AppCompatActivity {

    public static final int REQUEST_CODE_EDITAR = 2;
    private ListView listViewProductos;
    private Button btnAgregar;
    private Button btnInventario;
    private List<ProductoItem> productos;
    private ProductoAdapter adapter;
    private final int REQUEST_CODE_AGREGAR = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto);

        listViewProductos = findViewById(R.id.listViewProductos);
        btnAgregar = findViewById(R.id.btnAgregar);
        btnInventario = findViewById(R.id.btnInventario);

        productos = new ArrayList<>();


        productos.add(new ProductoItem("1", "Producto 1", "Marca 1", "Descripción del producto 1", "$100", "Disponible", 50, R.drawable.ic_launcher_background));
        productos.add(new ProductoItem("2", "Producto 2", "Marca 2", "Descripción del producto 2", "$150", "Agotado", 0, R.drawable.ic_launcher_background));

        adapter = new ProductoAdapter(this, productos);
        listViewProductos.setAdapter((ListAdapter) adapter);

        btnAgregar.setOnClickListener(v -> {
            Intent intent = new Intent(Producto.this, AgregarProducto.class);
            startActivityForResult(intent, REQUEST_CODE_AGREGAR);
        });

        btnInventario.setOnClickListener(v -> {
            Intent intent = new Intent(Producto.this, InventarioProductos.class);
            startActivity(intent);
        });

        listViewProductos.setOnItemClickListener((parent, view, position, id) -> {
            ProductoItem producto = productos.get(position);
            Intent intent = new Intent(Producto.this, EditarProducto.class);
            intent.putExtra("id", producto.getId());
            intent.putExtra("nombre", producto.getNombre());
            intent.putExtra("marca", producto.getMarca());
            intent.putExtra("descripcion", producto.getDescripcion());
            intent.putExtra("precio", producto.getPrecio());
            intent.putExtra("estatus", producto.getEstatus());
            intent.putExtra("cantidad", producto.getCantidad());
            startActivityForResult(intent, REQUEST_CODE_EDITAR);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == REQUEST_CODE_AGREGAR) {
                String id = data.getStringExtra("id");
                String nombre = data.getStringExtra("nombre");
                String marca = data.getStringExtra("marca");
                String descripcion = data.getStringExtra("descripcion");
                String precio = data.getStringExtra("precio");
                String estatus = data.getStringExtra("estatus");
                int cantidad = data.getIntExtra("cantidad", 0);

                productos.add(new ProductoItem(id, nombre, marca, descripcion, precio, estatus, cantidad, R.drawable.ic_launcher_background));
                adapter.notifyDataSetChanged();
            } else if (requestCode == REQUEST_CODE_EDITAR) {
                String id = data.getStringExtra("id");
                String nombre = data.getStringExtra("nombre");
                String marca = data.getStringExtra("marca");
                String descripcion = data.getStringExtra("descripcion");
                String precio = data.getStringExtra("precio");
                String estatus = data.getStringExtra("estatus");
                int cantidad = data.getIntExtra("cantidad", 0);

                for (ProductoItem producto : productos) {
                    if (producto.getId().equals(id)) {
                        producto.setNombre(nombre);
                        producto.setMarca(marca);
                        producto.setDescripcion(descripcion);
                        producto.setPrecio(precio);
                        producto.setEstatus(estatus);
                        producto.setCantidad(cantidad);
                        break;
                    }
                }
                adapter.notifyDataSetChanged();
            }
        }
    }
}
