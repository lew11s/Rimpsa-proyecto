package com.example.rimpsa;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ProductoAdapter extends BaseAdapter {

    private List<ProductoItem> productos;
    private Context context;

    public ProductoAdapter(Context context, List<ProductoItem> productos) {
        this.context = context;
        this.productos = productos;
    }

    @Override
    public int getCount() {
        return productos.size();
    }

    @Override
    public Object getItem(int position) {
        return productos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_producto, parent, false);
        }

        ProductoItem producto = productos.get(position);

        ImageView imageView = convertView.findViewById(R.id.imageViewProducto);
        TextView textViewId = convertView.findViewById(R.id.textViewId); // Nuevo
        TextView textViewNombre = convertView.findViewById(R.id.textViewNombre);
        TextView textViewMarca = convertView.findViewById(R.id.textViewMarca); // Nuevo
        TextView textViewDescripcion = convertView.findViewById(R.id.textViewDescripcion);
        TextView textViewPrecio = convertView.findViewById(R.id.textViewPrecio); // Nuevo
        TextView textViewEstatus = convertView.findViewById(R.id.textViewEstatus); // Nuevo
        Button btnEditar = convertView.findViewById(R.id.btnEditar);
        Button btnEliminar = convertView.findViewById(R.id.btnEliminar);

        imageView.setImageResource(producto.getImagen());
        textViewId.setText(producto.getId());
        textViewNombre.setText(producto.getNombre());
        textViewMarca.setText(producto.getMarca());
        textViewDescripcion.setText(producto.getDescripcion());
        textViewPrecio.setText(producto.getPrecio());
        textViewEstatus.setText(producto.getEstatus());

        btnEditar.setOnClickListener(v -> {
            Intent intent = new Intent(context, EditarProducto.class);
            intent.putExtra("id", producto.getId());
            intent.putExtra("nombre", producto.getNombre());
            intent.putExtra("marca", producto.getMarca());
            intent.putExtra("descripcion", producto.getDescripcion());
            intent.putExtra("precio", producto.getPrecio());
            intent.putExtra("estatus", producto.getEstatus());
            ((Producto) context).startActivityForResult(intent, ((Producto) context).REQUEST_CODE_EDITAR);
        });

        btnEliminar.setOnClickListener(v -> {
            productos.remove(position);
            notifyDataSetChanged();
        });

        return convertView;
    }
}
