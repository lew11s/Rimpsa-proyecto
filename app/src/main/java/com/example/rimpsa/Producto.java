package com.example.rimpsa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class Producto extends AppCompatActivity {

    public static final int REQUEST_CODE_AGREGAR = 1;
    public static final int REQUEST_CODE_EDITAR = 2;
    public static final int REQUEST_CODE_INVENTARIO = 3;

    private static List<ProductoItem> productos = new ArrayList<>();

    private ListView listViewProductos;
    private Button btnAgregar;
    private Button btnInventario;
    private ProductoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto);

        listViewProductos = findViewById(R.id.listViewProductos);
        btnAgregar = findViewById(R.id.btnAgregar);
        btnInventario = findViewById(R.id.btnInventario);

        // Inicializar productos si es necesario
        if (productos.isEmpty()) {
            productos.add(new ProductoItem("1", "Producto 1", "Marca 1", "Descripción del producto 1", "$100", "Disponible", 50, R.drawable.ic_launcher_background));
            productos.add(new ProductoItem("2", "Producto 2", "Marca 2", "Descripción del producto 2", "$150", "Agotado", 0, R.drawable.ic_launcher_background));
        }

        adapter = new ProductoAdapter(this, productos);
        listViewProductos.setAdapter(adapter);

        btnAgregar.setOnClickListener(v -> {
            Intent intent = new Intent(Producto.this, AgregarProducto.class);
            startActivityForResult(intent, REQUEST_CODE_AGREGAR);
        });

        btnInventario.setOnClickListener(v -> {
            Intent intent = new Intent(Producto.this, InventarioProductos.class);
            intent.putParcelableArrayListExtra("productos", new ArrayList<>(productos));
            startActivity(intent);
        });

        listViewProductos.setOnItemClickListener((parent, view, position, id) -> {
            ProductoItem producto = productos.get(position);
            Intent intent = new Intent(Producto.this, EditarProducto.class);
            intent.putExtra("producto", producto); // Enviar como Parcelable
            startActivityForResult(intent, REQUEST_CODE_EDITAR);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == REQUEST_CODE_AGREGAR) {
                ProductoItem nuevoProducto = data.getParcelableExtra("nuevoProducto");
                if (nuevoProducto != null) {
                    productos.add(nuevoProducto);
                    adapter.notifyDataSetChanged();

                    // Enviar lista completa de productos a InventarioProductos
                    Intent inventarioIntent = new Intent(Producto.this, InventarioProductos.class);
                    inventarioIntent.putParcelableArrayListExtra("productos", new ArrayList<>(productos));
                    startActivity(inventarioIntent);
                }
            } else if (requestCode == REQUEST_CODE_EDITAR) {
                ProductoItem productoEditado = data.getParcelableExtra("productoEditado");
                if (productoEditado != null) {
                    for (int i = 0; i < productos.size(); i++) {
                        if (productos.get(i).getId().equals(productoEditado.getId())) {
                            productos.set(i, productoEditado);
                            break;
                        }
                    }
                    adapter.notifyDataSetChanged();
                }
            } else if (requestCode == REQUEST_CODE_INVENTARIO) {
                // Actualizar inventario si es necesario
            }
        }
    }

    public static List<ProductoItem> obtenerListaProductos() {
        return productos;
    }
}
