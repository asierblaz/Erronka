package com.example.patosdegoma;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.format.Time;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class CrearPedido extends AppCompatActivity {
    Spinner BezeroakSpinner;
    private ListView lineaPedido;
    private ArrayAdapter<ProductoCarrito> lineaPedidoAdapter = null;
    public static int id_sol;

    int so_id;
    final boolean so_require_signature = true;
    final boolean so_require_payment = false;
    int partner_id;
    int so_partner_invoice_id;
    int so_partner_shipping_id;
    final int so_pricelist_id = 1;
    final int currency_id = 1;
    String so_name;
    final String state = "draft";
    Time date_order = new Time();
    Time create_date = new Time();
    final String invoice_status = "no";
    float so_amount_untaxed;
    final int so_amount_tax = 0;
    float so_amount_total;
    final int currency_rate = 1;
    final int company_id = 1;
    final int team_id = 1;
    final int create_uid = 2;
    final int write_uid = 2;
    Time write_date = new Time();
    final String so_picking_policy = "direct";
    final int so_warehouse_id = 1;

    int sol_id;
    String sol_name;
    final int sol_sequence = 10;
    float sol_price_unit;
    float sol_price_subtotal;
    float sol_price_total;
    float sol_price_reduce;
    float sol_price_reduce_taxinc;
    float sol_price_reduce_taxexcl;
    final int sol_discount = 0;
    int sol_product_id;
    final int sol_product_uom = 1;
    int sol_product_uom_qty;
    final String sol_qty_delivered_method = "stock_move";
    final int sol_qty_delivered = 0;
    final int sol_qty_delivered_manual = 0;
    final int sol_qty_to_invoice = 0;
    final int sol_qty_invoiced = 0;
    final int sol_untaxed_amount_invoiced = 0;
    float sol_untaxed_amount_to_invoice;
    final int sol_customer_lead = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_pedido);
        ArrayAdapter<Bezeroa> bezeroak = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, Bezeroa.bezeroak);
        lineaPedido = findViewById(R.id.lineaPedido);

        lineaPedidoAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ProductoCarrito.carrito);
        lineaPedido.setAdapter(lineaPedidoAdapter);
        ((Spinner)findViewById(R.id.BezeroakSpinner)).setAdapter(bezeroak);
        ((Spinner)findViewById(R.id.BezeroakSpinner)).setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                partner_id=Bezeroa.bezeroak.get(i).getId();
                so_partner_invoice_id = partner_id;
                so_partner_shipping_id = partner_id;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        //so_id = ((int) getIntent().getSerializableExtra("iDpedido"))+1;
        Log.d("ID", String.valueOf(so_id));
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        InsertQuery.setPriority(Thread.MAX_PRIORITY);

    }

    public Connection Connect() {
        String url = "jdbc:postgresql://192.168.65.15:5432/PatitosdeGoma";
        String user = "openpg";
        String pass = "openpgpwd";
        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(url, user, pass);
            Log.d("Connection", conn.toString());
            return conn;
        } catch (SQLException se) {
            Log.d("SQLException", "oops! No se puede conectar. Error: " + se.toString());
        } catch (ClassNotFoundException e) {
            Log.d("ClassNotFoundException", "oops! No se encuentra la clase. Error: " + e.getMessage());
        }
        return null;
    }

    Thread InsertQuery = new Thread(() ->
    {
        String so = "insert into sale_order(id, require_signature, require_payment, partner_id," +
                "partner_invoice_id, partner_shipping_id, pricelist_id, currency_id," +
                "name, state, date_order, create_date, invoice_status," +
                "amount_untaxed, amount_tax, amount_total, currency_rate, company_id, team_id, " +
                "create_uid, write_uid, write_date, picking_policy, warehouse_id)" +
                "values (" + so_id + ", " + so_require_signature + ", " + so_require_payment + ", " +
                partner_id + ", " + so_partner_invoice_id + ", " + so_partner_shipping_id + ", " +
                so_pricelist_id + ", " + currency_id + ", " + so_name + "," + state + ", " +
                date_order + ", " + create_date + ", " + invoice_status + ", " + so_amount_untaxed +
                ", " + so_amount_tax + ", " + so_amount_total + ", " + currency_rate + ", " +
                company_id + ", " + team_id + ", " + create_uid + ", " + write_uid + ", " + write_date +
                ", " +  so_picking_policy + ", " + so_warehouse_id + ")";

        String sol = "insert into sale_order_line(id, order_id, name, sequence, invoice_status, " +
                "price_unit,price_subtotal, price_total, price_reduce, price_reduce_taxinc, " +
                "price_reduce_taxexcl, discount, product_id, product_uom, product_uom_qty, " +
                "qty_delivered_method, qty_delivered, qty_delivered_manual, qty_to_invoice, " +
                "qty_invoiced,untaxed_amount_invoiced, untaxed_amount_to_invoice, currency_id, " +
                "company_id, order_partner_id, state, customer_lead, create_uid, create_date, " +
                "write_uid, write_date)"+
                "values( " + sol_id + ", " + so_id + ", " + sol_name + " , " + sol_sequence + ", " +
                invoice_status + ", " + sol_price_unit + ", " + sol_price_subtotal + ", " +
                sol_price_total + ", " + sol_price_reduce + ", " + sol_price_reduce_taxinc + ", " +
                sol_price_reduce_taxexcl + ", " + sol_discount + ", " + sol_product_id + ", " +
                sol_product_uom + ", " + sol_product_uom_qty + ", " + sol_qty_delivered_method + ", " +
                sol_qty_delivered + ", " + sol_qty_delivered_manual + ", " + sol_qty_to_invoice + ", " +
                sol_qty_invoiced + ", " + sol_untaxed_amount_invoiced + ", " +
                sol_untaxed_amount_to_invoice + ", " + currency_id + ", " + company_id + ", " +
                partner_id + ", " + state + ", " + sol_customer_lead + ", " + create_uid + ", " +
                create_date + ", " + write_uid + ", " + write_date + ")";
        try {
            Connection conn = Connect();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(so);
            conn.close();
        } catch (Exception e) {
            Log.d("TAG", "run: Failed"+ e.getMessage());
        }
    });
}