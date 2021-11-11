package com.example.patosdegoma;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import android.util.Log;

import com.example.patosdegoma.activities.CrearPedido;
import com.example.patosdegoma.models.Bezeroa;
import com.example.patosdegoma.models.ProductoCarrito;
import com.example.patosdegoma.models.Produktua;
import com.example.patosdegoma.models.Salmenta;

public class DataConnect extends Thread {

    final public static String url = "jdbc:postgresql://192.168.65.15:5432/PatitosdeGoma";
    final public static String user = "openpg";
    final public static String pass = "openpgpwd";


    public static Connection Connect() throws SQLException, ClassNotFoundException {
        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(url, user, pass);
            return conn;
        } catch (SQLException se) {
            Log.d("SQLException", "oops! No se puede conectar. Error: " + se.toString());
        } catch (ClassNotFoundException e) {
            Log.d("ClassNotFoundException", "oops! No se encuentra la clase. Error: " + e.getMessage());
        }
        return null;
    }

    public static void SalmentakQuery(){
        SalmentakQuery.setPriority(Thread.MAX_PRIORITY);
        if (SalmentakQuery.getState() == State.NEW){
            SalmentakQuery.start();
        }
    }

    public static void ProduktuakQuery(){
        ProduktuakQuery.setPriority(Thread.MAX_PRIORITY);
        if (ProduktuakQuery.getState() == State.NEW){
            ProduktuakQuery.start();
        }
    }

    public static void BezeroakQuery(){
        BezeroakQuery.setPriority(Thread.MAX_PRIORITY);
        if (BezeroakQuery.getState() == State.NEW){
            BezeroakQuery.start();
        }
    }

    public static void SoIdQuery(){
        SoIdQuery.setPriority(Thread.MAX_PRIORITY);
        if (SoIdQuery.getState() == State.NEW){
            SoIdQuery.start();
        }
    }

    public static void SolIdQuery(){
        SolIdQuery.setPriority(Thread.MAX_PRIORITY);
        if (SolIdQuery.getState() == State.NEW){
            SolIdQuery.start();
        }
    }

    public static void InsertOrderQuery(){
        InsertOrderQuery.setPriority(Thread.MAX_PRIORITY);
        if (InsertOrderQuery.getState() == State.NEW){
            InsertOrderQuery.start();
        }
    }

    public static void InsertLineQuery(){
        InsertLineQuery.setPriority(Thread.NORM_PRIORITY);
        if (InsertLineQuery.getState() == State.NEW){
            InsertLineQuery.start();
        }
    }

    static Thread ProduktuakQuery = new Thread(() ->
    {
        try {
            String query = "select product_template.id, product_template.name, " +
                    "product_category.complete_name as category, product_template.list_price, " +
                    "product_template.default_code from product_template\n" +
                    "inner join product_category on product_template.categ_id =product_category.id \n" +
                    "order by name asc";
            Connection conn = Connect();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Produktua p = new Produktua(
                        rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getFloat(4), rs.getString(5).toLowerCase()
                );
                Produktua.produktuak.add(p);
            }
            Produktua.categoriasToArray();
            conn.close();
        } catch (Exception e) {
            Log.d("Exception", "run: Failed " + e.getMessage());
        }
    });

    static Thread BezeroakQuery = new Thread(() ->
    {
        try {
            String query = "select id, name from res_partner where user_id = 12";
            Connection conn = Connect();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Bezeroa b = new Bezeroa(
                        rs.getInt(1), rs.getString(2)
                );
                Bezeroa.bezeroak.add(b);
            }
            conn.close();
        } catch (Exception e) {
            Log.d("Exception", "run: Failed " + e.getMessage());
        }
    });

    static Thread SoIdQuery = new Thread(() ->
    {
        try {
            String query = "select MAX(id) from sale_order";
            Connection conn = Connect();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                CrearPedido.so_id = rs.getInt(1)+1;
                CrearPedido.so_name = "S000" + CrearPedido.so_id;
            }
            conn.close();
        } catch (Exception e) {
            Log.d("Exception", "run: Failed " + e.getMessage());
        }
    });

    static Thread SolIdQuery = new Thread(() ->
    {
        try {
            String query = "select MAX(id) from sale_order_line";
            Connection conn = Connect();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                CrearPedido.sol_id = rs.getInt(1)+1;
            }
            conn.close();
        } catch (Exception e) {
            Log.d("Exception", "run: Failed " + e.getMessage());
        }
    });

    static Thread SalmentakQuery = new Thread(() ->
    {
        try {
            String query = "Select id, name, state, date_order, create_date, partner_id, " +
                    "invoice_status, amount_untaxed, amount_tax, amount_total from sale_order " +
                    "order by name desc";
            Connection conn = Connect();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Salmenta s = new Salmenta(
                        rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5),
                        rs.getInt(6), rs.getString(7),
                        rs.getFloat(8), rs.getFloat(9),
                        rs.getFloat(10)
                );
                Salmenta.salmentak.add(s);
            }
            conn.close();
        } catch (Exception e) {
            Log.d("Exception", "run: Failed"+ e.getMessage());
        }
    });

    //Thread que inserta un pedido
    static Thread InsertOrderQuery = new Thread(() ->
    {
        String query = "insert into sale_order(id, require_signature, require_payment, partner_id," +
                "partner_invoice_id, partner_shipping_id, pricelist_id, currency_id," +
                "name, state, date_order, create_date, invoice_status," +
                "amount_untaxed, amount_tax, amount_total, currency_rate, company_id, team_id, " +
                "create_uid, write_uid, write_date, picking_policy, warehouse_id)" +
                "values (" + CrearPedido.so_id + ", true, false, " + CrearPedido.partner_id + ", " + CrearPedido.partner_id + ", " +
                CrearPedido.partner_id + ", 1 , 1, '" + CrearPedido.so_name + "','draft', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, " +
                "'no', " + CrearPedido.so_amount + ", 0, " + CrearPedido.so_amount + ", 1, 1, 1, 2, 2, " +
                "CURRENT_TIMESTAMP, 'direct', 1)";

        try {
            CrearPedido.pedido.acquire();
            try {
                Log.d("SO_Query", query);
                Connection conn = DataConnect.Connect();
                Statement st = conn.createStatement();
                st.executeUpdate(query);
                conn.close();
            } finally {
                CrearPedido.pedido.release();
            }
        } catch (Exception e) {
            Log.d("InsertOrderQuery", e.getMessage());
        }
    });

    //Thread que inserta las lineas de pedido
    static Thread InsertLineQuery = new Thread(() ->
    {
        try {
            CrearPedido.pedido.acquire();
            try {
                Connection conn = DataConnect.Connect();
                for (ProductoCarrito p : ProductoCarrito.carrito) {
                    String query = "insert into sale_order_line(id, order_id, name, sequence, invoice_status, " +
                            "price_unit, price_tax, price_subtotal, price_total, price_reduce, price_reduce_taxinc, " +
                            "price_reduce_taxexcl, discount, product_id, product_uom, product_uom_qty, " +
                            "qty_delivered_method, qty_delivered, qty_delivered_manual, qty_to_invoice, " +
                            "qty_invoiced,untaxed_amount_invoiced, untaxed_amount_to_invoice, currency_id, " +
                            "company_id, order_partner_id, state, customer_lead, create_uid, create_date, " +
                            "write_uid, write_date)" +
                            "values( " + CrearPedido.sol_id + ", " + CrearPedido.so_id + ", '" + p.getProducto().getName() +
                            "' , 10, 'no', " + p.getProducto().getPrezioa() + ", 0, " + p.getPrecio() +
                            ", " + p.getPrecio() + ", " + p.getPrecio() + ", " + p.getPrecio() +
                            ", " + p.getPrecio() + ", 0, " + p.getProducto().getId() + ", 1, " +
                            p.getCantidad() + ", 'stock_move', 0, 0, 0, 0, 0, " + p.getPrecio() +
                            ", 1, 1, " + CrearPedido.partner_id + ", 'draft', 0, 2, CURRENT_TIMESTAMP, 2, " +
                            "CURRENT_TIMESTAMP)";
                    Log.d("SOL_Query", query);
                    Statement st = conn.createStatement();
                    st.executeUpdate(query);
                    CrearPedido.sol_id -= -1;
                }
            } finally {
                CrearPedido.pedido.release();
                ProductoCarrito.carrito.clear();
            }
        } catch (Exception e) {
            Log.d("InsertLineQuery", e.getMessage());
            e.printStackTrace();
        }

    });
}
