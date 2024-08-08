package com.example.rimpsa;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class listadaptador extends RecyclerView.Adapter<listadaptador.ViewHolder> {

    private List<listelementos> mData;
    private LayoutInflater mInflater;
    private Context context;

    public listadaptador(List<listelementos> itemList, Context context) {
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.mData = itemList;
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @NonNull
    @Override
    public listadaptador.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.list_elementos, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final listadaptador.ViewHolder holder, final int position) {
        holder.bindData(mData.get(position));
    }

    public void setItems(List<listelementos> items) {
        mData = items;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iCuenta;
        TextView nombre, puesto, estatus;

        ViewHolder(View itemView) {
            super(itemView);
            iCuenta = itemView.findViewById(R.id.iCuenta);
            nombre = itemView.findViewById(R.id.txtnombre);
            puesto = itemView.findViewById(R.id.txtPuesto);
            estatus = itemView.findViewById(R.id.txtEstatus);
        }

        void bindData(final listelementos item) {
            iCuenta.setColorFilter(Color.parseColor(item.getColor()), PorterDuff.Mode.SRC_IN);
            nombre.setText(item.getNombre());
            puesto.setText(item.getPuesto());
            estatus.setText(item.getEstatus());
        }
    }
}

