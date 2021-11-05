package com.example.patosdegoma;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import android.util.Log;

import com.example.patosdegoma.activities.CrearPedido;
import com.example.patosdegoma.clases.Bezeroa;
import com.example.patosdegoma.clases.Produktua;
import com.example.patosdegoma.clases.Salmenta;

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
        if (!SalmentakQuery.isAlive()){
            SalmentakQuery.start();
        }
    }

    public static void ProduktuakQuery(){
        ProduktuakQuery.setPriority(Thread.MAX_PRIORITY);
        if (!ProduktuakQuery.isAlive()){
            ProduktuakQuery.start();
        }
    }

    public static void BezeroakQuery(){
        BezeroakQuery.setPriority(Thread.MAX_PRIORITY);
        if (!BezeroakQuery.isAlive()){
            BezeroakQuery.start();
        }
    }

    public static void SoIdQuery(){
        SoIdQuery.setPriority(Thread.MAX_PRIORITY);
        if (!SoIdQuery.isAlive()){
            SoIdQuery.start();
        }
    }

    public static void SolIdQuery(){
        SolIdQuery.setPriority(Thread.MAX_PRIORITY);
        if (!SolIdQuery.isAlive()){
            SolIdQuery.start();
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


    public String getUrl() {
        return url;
    }

    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }
}
