package com.example.patosdegoma;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.concurrent.Semaphore;

public class CrearPedido extends AppCompatActivity {
    private final Semaphore pedido = new Semaphore(1, true);

    public static int sol_id;
    public static int so_id;
    public static String so_name;
    int partner_id;
    float so_amount = 0;
    DecimalFormat f = new DecimalFormat("##.00");

    Button CrearPedidoBtn;
    Spinner BezeroakSpinner;

    Thread SoIdQuery = new Thread(() ->
    {
        try {
            String query = "select MAX(id) from sale_order";
            Connection conn = Connect();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                CrearPedido.so_id = rs.getInt(1) + 1;
                Log.d("soq_id", String.valueOf(so_id));
                CrearPedido.so_name = "S000" + so_id;

            }
            conn.close();
        } catch (Exception e) {
            Log.d("Exception", "run: Failed " + e.getMessage());
        }
    });

    Thread SolIdQuery = new Thread(() ->
    {
        try {
            String query = "select MAX(id) from sale_order_line";
            Connection conn = Connect();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                CrearPedido.sol_id = rs.getInt(1) + 1;
                Log.d("solq_id", String.valueOf(sol_id));
            }
            conn.close();
        } catch (Exception e) {
            Log.d("Exception", "run: Failed " + e.getMessage());
        }
    });

    Thread InsertOrderQuery = new Thread(() ->
    {
        String query = "insert into sale_order(id, require_signature, require_payment, partner_id," +
                "partner_invoice_id, partner_shipping_id, pricelist_id, currency_id," +
                "name, state, date_order, create_date, invoice_status," +
                "amount_untaxed, amount_tax, amount_total, currency_rate, company_id, team_id, " +
                "create_uid, write_uid, write_date, picking_policy, warehouse_id)" +
                "values (" + so_id + ", true, false, " + partner_id + ", " + partner_id + ", " +
                partner_id + ", 1 , 1, '" + so_name + "','draft', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, " +
                "'no', " + so_amount + ", 0, " + so_amount + ", 1, 1, 1, 2, 2, " +
                "CURRENT_TIMESTAMP, 'direct', 1)";

        try {
            pedido.acquire();
            try {
                Log.d("SO_Query", query);
                Connection conn = Connect();
                Statement st = conn.createStatement();
                st.executeUpdate(query);
                conn.close();
            } finally {
                pedido.release();
            }
        } catch (Exception e) {
            Log.d("SO_q", "run: Failed; " + e.getMessage());
        }
    });

    Thread InsertLineQuery = new Thread(() ->
    {
        try {
            pedido.acquire();
            try {
                Log.d("1", "1");
                Connection conn = Connect();
                Log.d("2", "2");
                for (ProductoCarrito p : ProductoCarrito.carrito) {
                    String query = "insert into sale_order_line(id, order_id, name, sequence, invoice_status, " +
                            "price_unit, price_tax, price_subtotal, price_total, price_reduce, price_reduce_taxinc, " +
                            "price_reduce_taxexcl, discount, product_id, product_uom, product_uom_qty, " +
                            "qty_delivered_method, qty_delivered, qty_delivered_manual, qty_to_invoice, " +
                            "qty_invoiced,untaxed_amount_invoiced, untaxed_amount_to_invoice, currency_id, " +
                            "company_id, order_partner_id, state, customer_lead, create_uid, create_date, " +
                            "write_uid, write_date)" +
                            "values( " + sol_id + ", " + so_id + ", '" + p.getProducto().getName() +
                            "' , 10, 'no', " + p.getProducto().getPrezioa() + ", 0, " + p.getPrecio() +
                            ", " + p.getPrecio() + ", " + p.getPrecio() + ", " + p.getPrecio() +
                            ", " + p.getPrecio() + ", 0, " + p.getProducto().getId() + ", 1, " +
                            p.getCantidad() + ", 'stock_move', 0, 0, 0, 0, 0, " + p.getPrecio() +
                            ", 1, 1, " + partner_id + ", 'draft', 0, 2, CURRENT_TIMESTAMP, 2, " +
                            "CURRENT_TIMESTAMP)";
                    Log.d("SOL_Query", query);
                    Statement st = conn.createStatement();
                    st.executeUpdate(query);
                    sol_id -= -1;
                }
            } finally {
                pedido.release();
            }
        } catch (Exception e) {
            Log.d("SOL_q", "run: Failed; " + e.getMessage());
        }

    });

    public static Connection Connect() {
        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(DataConnect.url, DataConnect.user, DataConnect.pass);
            Log.d("Connection", conn.toString());
            return conn;
        } catch (SQLException se) {
            Log.d("SQLException", "oops! No se puede conectar. Error: " + se.toString());
        } catch (ClassNotFoundException e) {
            Log.d("ClassNotFoundException", "oops! No se encuentra la clase. Error: " + e.getMessage());
        }
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_pedido);

        ArrayAdapter<Bezeroa> bezeroak = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, Bezeroa.bezeroak);
        ListView lineaPedido = findViewById(R.id.lineaPedido);

        ArrayAdapter<ProductoCarrito> lineaPedidoAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ProductoCarrito.carrito);
        lineaPedido.setAdapter(lineaPedidoAdapter);
        ((Spinner) findViewById(R.id.BezeroakSpinner)).setAdapter(bezeroak);
        ((Spinner) findViewById(R.id.BezeroakSpinner)).setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                partner_id = Bezeroa.bezeroak.get(i).getId();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                partner_id = Bezeroa.bezeroak.get(0).getId();
            }
        });

        for (ProductoCarrito p : ProductoCarrito.carrito) {
            so_amount += p.getPrecio();
        }
        so_amount = Float.parseFloat(f.format(so_amount));

        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        SoIdQuery.setPriority(10);
        SoIdQuery.start();
        SolIdQuery.setPriority(10);
        SolIdQuery.start();
        InsertOrderQuery.setPriority(10);
        InsertLineQuery.setPriority(2);
        CrearPedidoBtn = findViewById(R.id.CrearPedidoBtn);
        CrearPedidoBtn.setOnClickListener(view -> {
            InsertOrderQuery.start();
            InsertLineQuery.start();
        });

    }

    private float getTotal() {
        float total = 0;
        for (ProductoCarrito p : ProductoCarrito.carrito) {
            total += p.getPrecio();
        }
        return total;
    }
}