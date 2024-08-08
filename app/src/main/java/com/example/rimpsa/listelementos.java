package com.example.rimpsa;

public class listelementos {
    public String color;
    public String nombre;
    public String puesto;
    public String estatus;


    public listelementos(String color, String nombre, String puesto, String estatus) {
        this.color = color;
        this.nombre = nombre;
        this.puesto = puesto;
        this.estatus = estatus;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
}
