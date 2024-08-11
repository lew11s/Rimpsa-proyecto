package com.example.rimpsa;

import android.os.Parcel;
import android.os.Parcelable;

public class ProductoItem implements Parcelable {
    public static final int DEFAULT_IMAGE_ID = 0;
    private String id;
    private String nombre;
    private String marca;
    private String descripcion;
    private String precio;
    private String estatus;
    private int cantidad;
    private int imagen;

    public ProductoItem(String id, String nombre, String marca, String descripcion, String precio, String estatus, int cantidad, int imagen) {
        this.id = id;
        this.nombre = nombre;
        this.marca = marca;
        this.descripcion = descripcion;
        this.precio = precio;
        this.estatus = estatus;
        this.cantidad = cantidad;
        this.imagen = imagen;
    }

    protected ProductoItem(Parcel in) {
        id = in.readString();
        nombre = in.readString();
        marca = in.readString();
        descripcion = in.readString();
        precio = in.readString();
        estatus = in.readString();
        cantidad = in.readInt();
        imagen = in.readInt();
    }

    public static final Creator<ProductoItem> CREATOR = new Creator<ProductoItem>() {
        @Override
        public ProductoItem createFromParcel(Parcel in) {
            return new ProductoItem(in);
        }

        @Override
        public ProductoItem[] newArray(int size) {
            return new ProductoItem[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(nombre);
        dest.writeString(marca);
        dest.writeString(descripcion);
        dest.writeString(precio);
        dest.writeString(estatus);
        dest.writeInt(cantidad);
        dest.writeInt(imagen);
    }

    // getters y setters

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMarca() {
        return marca;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getPrecio() {
        return precio;
    }

    public String getEstatus() {
        return estatus;
    }

    public int getImagen() {
        return imagen;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}