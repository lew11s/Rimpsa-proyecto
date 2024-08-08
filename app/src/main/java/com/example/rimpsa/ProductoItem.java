package com.example.rimpsa;

public class ProductoItem {
    private String id;
    private String nombre;
    private String marca;
    private String descripcion;
    private String precio;
    private String estatus;
    private int imagen;

    public ProductoItem(String id, String nombre, String marca, String descripcion, String precio, String estatus, int imagen) {
        this.id = id;
        this.nombre = nombre;
        this.marca = marca;
        this.descripcion = descripcion;
        this.precio = precio;
        this.estatus = estatus;
        this.imagen = imagen;
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
