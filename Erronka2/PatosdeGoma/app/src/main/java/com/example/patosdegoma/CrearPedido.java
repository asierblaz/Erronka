package com.example.patosdegoma;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class CrearPedido extends AppCompatActivity {
    int id;
    final boolean require_signature = true;
    final boolean require_payment = false;
    int partner_id;
    int partner_invoice_id;
    int partner_shipping_id;
    final int pricelist_id = 1;
    final int company_id = 1;
    final String picking_policy = "direct";
    final int warehouse_id = 1;
    String name;
    final String state = "draft";
    final String invoice_status = "no";
    float amount_total;

    String s ="insert into sale_order(id,require_signature,require_payment,partner_id," +
            "partner_invoice_id,partner_shipping_id,pricelist_id,company_id,picking_policy,warehouse_id," +
            "name,state,date_order,create_date,invoice_status,amount_total)"+
            "values (31,true,false,3,3,3,1,1,'direct',1,'S00031','draft',NOW(),NOW(),'no',19.9)";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_pedido);
    }
}