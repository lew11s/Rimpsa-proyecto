package com.example.rimpsa;

import android.os.Parcel;
import android.os.Parcelable;

public class ProductoItem implements Parcelable {
    private String id;
    private String nombre;
    private String marca;
    private String descripcion;
    private String precio;
    private String estatus;
    private int cantidad;
    private int imagen;

    public static final int DEFAULT_IMAGE_ID = R.drawable.ic_launcher_background;

    public ProductoItem(String id, String nombre, String marca, String descripcion, String precio, String estatus, int cantidad, int imageResId) {
        this.id = id;
        this.nombre = nombre;
        this.marca = marca;
        this.descripcion = descripcion;
        this.precio = precio;
        this.estatus = estatus;
        this.cantidad = cantidad;
        this.imagen = imageResId != 0 ? imageResId : DEFAULT_IMAGE_ID;
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

    // Métodos de acceso (getters y setters)

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }


    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(nombre);
        parcel.writeString(marca);
        parcel.writeString(descripcion);
        parcel.writeString(precio);
        parcel.writeString(estatus);
        parcel.writeInt(cantidad);
        parcel.writeInt(imagen);
    }
}
