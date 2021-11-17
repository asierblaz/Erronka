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


    //Konexio funtzioa
    public static Connection Connect() throws SQLException, ClassNotFoundException {
        //Konexioa egiten saiatzen da
        try {
            //PostgreSQL-ren driver-a
            Class.forName("org.postgresql.Driver");
            /*
            Helbidea, erabiltzailea eta pasahitzaren bitartez konexioa egin eta bueltatzen da
            url   =>  jdbc:postgresql://192.168.65.15:5432/PatitosdeGoma
            user  =>  openpg
            pass  =>  openpgpwd
            */
            Connection conn = DriverManager.getConnection(url, user, pass);
            return conn;
        //SQL salbuespena
        } catch (SQLException se) {
            Log.d("SQLException", "No se puede conectar. Error: " + se.toString());
        //Driver sabuespena
        } catch (ClassNotFoundException e) {
            Log.d("ClassNotFoundException", "No se encuentra la clase. Error: " + e.getMessage());
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

    //Produktuen lista hartzen duen haria
    static Thread ProduktuakQuery = new Thread(() ->
    {
        //Produktuak hartzeko saiakera egiten du
        try {
            //Query-a
            String query = "select product_template.id, product_template.name, " +
                    "product_category.complete_name as category, product_template.list_price, " +
                    "product_template.default_code from product_template\n" +
                    "inner join product_category on product_template.categ_id =product_category.id \n" +
                    "order by name asc";
            //Connect() funtzioari deitzen zaio konexioa gordetzeko
            Connection conn = Connect();
            //Query-a gorde eta exekutatzen da
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            //Hemen bueltatutako produktu guztiak Produktua klasean dagoen produktuak ArrayList-ean gordetzen dira
            while (rs.next()) {
                Produktua p = new Produktua(
                        rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getFloat(4), rs.getString(5).toLowerCase()
                );
                Produktua.produktuak.add(p);
            }
            //Kategoriak Produktua klasean dagoen categorias ArrayList-ean gordetzen dira
            Produktua.categoriasToArray();
            //Konexioa ixten da
            conn.close();
        //Salbuespena
        } catch (Exception e) {
            Log.d("Exception", "run: Failed " + e.getMessage());
        }
    });

    //Bezeroen lista hartzen duen haria
    static Thread BezeroakQuery = new Thread(() ->
    {
        //Bezeroak hartzeko saiakera egiten du
        try {
            //Query-a
            String query = "select id, name from res_partner where user_id = 12";
            //Connect() funtzioari deitzen zaio konexioa gordetzeko
            Connection conn = Connect();
            //Query-a gorde eta exekutatzen da
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            //Hemen bueltatutako bezero guztiak Bezeroa klasean dagoen bezeroak ArrayList-ean gordetzen dira
            while (rs.next()) {
                Bezeroa b = new Bezeroa(
                        rs.getInt(1), rs.getString(2)
                );
                Bezeroa.bezeroak.add(b);
            }
            //Konexioa ixten da
            conn.close();
            //Salbuespena
        } catch (Exception e) {
            Log.d("Exception", "run: Failed " + e.getMessage());
        }
    });

    //sale_order taulako azken Id-a hartzen duen haria
    static Thread SoIdQuery = new Thread(() ->
    {
        //Id-a hartzeko saiakera egiten du
        try {
            //Query-a
            String query = "select MAX(id) from sale_order";
            //Connect() funtzioari deitzen zaio konexioa gordetzeko
            Connection conn = Connect();
            //Query-a gorde eta exekutatzen da
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            /*
            Hemen bueltatutako id-ari 1 gehitzen zaio eta CrearPedido klasean dagoen so_id aldagaian gordetzen da.
            Salmenta egiteko beharrezkoa den salmenta izena era sortzen da eta CrearPedido klasean dagoen so_name aldagaian gordetzen da.
            */
            while (rs.next()) {
                CrearPedido.so_id = rs.getInt(1)+1;
                CrearPedido.so_name = "S000" + CrearPedido.so_id;
            }
            //Konexioa ixten da
            conn.close();
            //Salbuespena
        } catch (Exception e) {
            Log.d("Exception", "run: Failed " + e.getMessage());
        }
    });

    //sale_order_line taulako azken Id-a hartzen duen haria
    static Thread SolIdQuery = new Thread(() ->
    {
        //Id-a hartzeko saiakera egiten du
        try {
            //Query-a
            String query = "select MAX(id) from sale_order_line";
            //Connect() funtzioari deitzen zaio konexioa gordetzeko
            Connection conn = Connect();
            //Query-a gorde eta exekutatzen da
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            //Hemen bueltatutako id-ari 1 gehitzen zaio eta CrearPedido klasean dagoen sol_id aldagaian gordetzen da.
            while (rs.next()) {
                CrearPedido.sol_id = rs.getInt(1)+1;
            }
            //Konexioa ixten da
            conn.close();
            //Salbuespena
        } catch (Exception e) {
            Log.d("Exception", "run: Failed " + e.getMessage());
        }
    });

    //Salmenten lista hartzen duen haria
    static Thread SalmentakQuery = new Thread(() ->
    {
        //Salmentak hartzeko saiakera egiten du
        try {
            //Query-a
            String query = "Select id, name, state, date_order, create_date, partner_id, " +
                    "invoice_status, amount_untaxed, amount_tax, amount_total from sale_order " +
                    "order by name desc";
            //Connect() funtzioari deitzen zaio konexioa gordetzeko
            Connection conn = Connect();
            //Query-a gorde eta exekutatzen da
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            //Hemen bueltatutako produktu guztiak Salmenta klasean dagoen salmentak ArrayList-ean gordetzen dira
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
            //Konexioa ixten da
            conn.close();
            //Salbuespena
        } catch (Exception e) {
            Log.d("Exception", "run: Failed"+ e.getMessage());
        }
    });

    //Salmenta sortzen duen haria
    static Thread InsertOrderQuery = new Thread(() ->
    {
        //Query-a
        String query = "insert into sale_order(id, require_signature, require_payment, " +
                "partner_id, partner_invoice_id, partner_shipping_id, pricelist_id, currency_id," +
                "name, state, date_order, create_date, invoice_status, amount_untaxed, " +
                "amount_tax, amount_total, currency_rate, company_id, team_id, create_uid, " +
                "write_uid, write_date, picking_policy, warehouse_id)" +
                "values (" + CrearPedido.so_id + ", true, false, " + CrearPedido.partner_id + ", " +
                CrearPedido.partner_id + ", " + CrearPedido.partner_id + ", 1 , 1, '" +
                CrearPedido.so_name + "','draft', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'no', " +
                CrearPedido.so_amount + ", 0, " + CrearPedido.so_amount + ", 1, 1, 1, 2, 2, " +
                "CURRENT_TIMESTAMP, 'direct', 1)";
        //Salmenta sortzeko saiakera
        try {
            //Semaforora sartzen da
            CrearPedido.pedido.acquire();
            //Salmenta-ren query-a exekutatzen saiatzen da
            try {
                //Connect() funtzioari deitzen zaio konexioa gordetzeko
                Connection conn = Connect();
                //Query-a gorde eta exekutatzen da
                Statement st = conn.createStatement();
                st.executeUpdate(query);
                //Konexioa ixten da
                conn.close();
            } finally {
                //Semaforotik irtetzen da
                CrearPedido.pedido.release();
            }
        //Salbuespena
        } catch (Exception e) {
            Log.d("InsertOrderQuery", e.getMessage());
        }
    });

    //Salmenta lerroa(k) sortzen dituen haria
    static Thread InsertLineQuery = new Thread(() ->
    {
        try {
            //Semaforora sartzen da eta salmenta lerroa(k) sortzeko saiakera
            CrearPedido.pedido.acquire();
            try {
                //Connect() funtzioari deitzen zaio konexioa gordetzeko
                Connection conn = DataConnect.Connect();
                //Lerro bakoitzeko insert bat egiten da
                for (ProductoCarrito p : ProductoCarrito.carrito) {
                    //Query-a
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
                    //Query-a gorde eta exekutatzen da
                    Statement st = conn.createStatement();
                    st.executeUpdate(query);
                    //Erabilitako id-ari 1 gehitzen zaio eta CrearPedido klasean dagoen sol_id aldagaian gordetzen da.
                    CrearPedido.sol_id -=- 1;
                }
            } finally {
                //Semaforotik irtetzen da eta saskia huzten du
                CrearPedido.pedido.release();
                ProductoCarrito.carrito.clear();
            }
        //Salbuespena
        } catch (Exception e) {
            Log.d("InsertLineQuery", e.getMessage());
            e.printStackTrace();
        }
    });
}
