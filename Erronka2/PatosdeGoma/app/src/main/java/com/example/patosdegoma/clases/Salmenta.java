package com.example.patosdegoma.clases;

import java.io.*;
import java.util.ArrayList;

public class Salmenta implements Serializable {

    public static ArrayList<Salmenta> salmentak = new ArrayList<>();
    private int id;
    private String name;
    private String state;
    private String date_order;
    private String create_date;
    private int partner_id;
    private String invoice_status;
    private float amount_untaxed;
    private float amount_tax;
    private float amount_total;

    public Salmenta(int id, String name, String state, String date_order, String create_date,
                    int partner_id, String invoice_status, float amount_untaxed,
                    float amount_tax, float amount_total) {
        super();
        this.id = id;
        this.name = name;
        this.state = state;
        this.date_order = date_order;
        this.create_date = create_date;
        this.partner_id = partner_id;
        this.invoice_status = invoice_status;
        this.amount_untaxed = amount_untaxed;
        this.amount_tax = amount_tax;
        this.amount_total = amount_total;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        switch (state){
            case "cancel":
                return "Cancelado";
            case "draft":
                return "Presupuesto";
            case "sale":
                return "Pedido de Ventas";
            case "done":
                return "Bloqueado";
            default:
                return state;
        }
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDate_order() {
        return date_order.substring(0,10);
    }

    public void setDate_order(String date_order) {
        this.date_order = date_order.substring(0,10);
    }

    public String getCreate_date() {
        return create_date.substring(0,10);
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }

    public int getPartner_id() {
        return partner_id;
    }

    public void setPartner_id(int partner_id) {
        this.partner_id = partner_id;
    }

    public String getInvoice_status() {
        switch (this.invoice_status){
            case "invoiced":
                return "Facturado";
            case "no":
                return "Sin facturar";
            default:
                return invoice_status;
        }
    }

    public void setInvoice_status(String invoice_status) {
        this.invoice_status = invoice_status;
    }

    public Float getAmount_untaxed() {
        return amount_untaxed;
    }

    public void setAmount_untaxed(Float amount_untaxed) {
        this.amount_untaxed = amount_untaxed;
    }

    public Float getAmount_tax() {
        return amount_tax;
    }

    public void setAmount_tax(Float amount_tax) {
        this.amount_tax = amount_tax;
    }

    public Float getAmount_total() {
        return amount_total;
    }

    public void setAmount_total(Float amount_total) {
        this.amount_total = amount_total;
    }

    @Override
    public String toString() {
        return this.getName();
    }

    public String toStringAll() {
        return "Id: " + this.getId() + " \tNombre: " + this.getName() + " \tEstado: " + this.getState() + " \tFecha de Pedido: " +
                this.getDate_order() + " \tFecha de Creacion: " + this.getCreate_date() + " \tId Cliente: " +
                this.getPartner_id() + " \tEstado de Facturacion: " + this.getInvoice_status() + " \t Precio sin Impuestos:" +
                this.getAmount_untaxed() + " \t Impuestos: " + this.getAmount_tax() + " \tPrecio Total: " +
                this.getAmount_total() +
                "\n";
    }

}


