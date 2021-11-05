package com.example.patosdegoma.models;

import java.util.ArrayList;

public class ProductoCarrito {
    Produktua producto;
    int cantidad = 1;
    float precio;

    public static ArrayList<ProductoCarrito> carrito = new ArrayList<>();

    public ProductoCarrito(Produktua producto) {
        this.producto = producto;
        this.precio = producto.getPrezioa()*cantidad;
    }
    public ProductoCarrito(Produktua producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio = producto.getPrezioa()*cantidad;
    }

    public Produktua getProducto() {
        return producto;
    }

    public void setProducto(Produktua producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad += cantidad;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio() {
        this.precio = this.producto.getPrezioa()*cantidad;
    }

    @Override
    public String toString() {
        return producto + "x" + cantidad + " " + String.format("%.2f", precio) + " €";
    }
}
