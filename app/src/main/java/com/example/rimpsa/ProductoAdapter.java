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
        TextView textViewId = convertView.findViewById(R.id.textViewId);
        TextView textViewNombre = convertView.findViewById(R.id.textViewNombre);
        TextView textViewMarca = convertView.findViewById(R.id.textViewMarca);
        TextView textViewDescripcion = convertView.findViewById(R.id.textViewDescripcion);
        TextView textViewPrecio = convertView.findViewById(R.id.textViewPrecio);
        TextView textViewEstatus = convertView.findViewById(R.id.textViewEstatus);
        TextView textViewCantidad = convertView.findViewById(R.id.textViewCantidad);
        Button btnEditar = convertView.findViewById(R.id.btnEditar);
        Button btnEliminar = convertView.findViewById(R.id.btnEliminar);

        imageView.setImageResource(producto.getImagen());
        textViewId.setText(producto.getId());
        textViewNombre.setText(producto.getNombre());
        textViewMarca.setText(producto.getMarca());
        textViewDescripcion.setText(producto.getDescripcion());
        textViewPrecio.setText(producto.getPrecio());
        textViewEstatus.setText(producto.getEstatus());
        textViewCantidad.setText(String.valueOf(producto.getCantidad()));

        btnEditar.setOnClickListener(v -> {
            Intent intent = new Intent(context, EditarProducto.class);
            intent.putExtra("producto", producto); // Pasar el objeto completo como Parcelable
            ((Producto) context).startActivityForResult(intent, Producto.REQUEST_CODE_EDITAR);
        });


        btnEliminar.setOnClickListener(v -> {
            productos.remove(position);
            notifyDataSetChanged();
        });

        return convertView;
    }
}
