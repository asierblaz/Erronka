package com.example.patosdegoma.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.Html;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.patosdegoma.DataConnect;
import com.example.patosdegoma.R;
import com.example.patosdegoma.models.Bezeroa;
import com.example.patosdegoma.models.ProductoCarrito;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.concurrent.Semaphore;

/**
 * Activity Crear Pedido
 **/
public class CrearPedido extends AppCompatActivity {
    /*
      Variables para las queries
      so_id => sale_order.id (ID de pedido de ventas)
      sol_id => sale_order_line.id (ID de linea de pedido de ventas)
      so_name => sale_order.name (Formato S000+id)
      partner_id => res_partner.id (ID de cliente)
      so_amount => sale_order.amount_total (se usa paradefinir el total del pedido)
     */
    public static int so_id;
    public static int sol_id;
    public static String so_name;
    public static int partner_id;
    public static float so_amount = 0;

    /*
      Semáforo para que la inserción de lineas de pedido
      no se haga antes de que la inserción del pedido termine
     */
    public static Semaphore pedido = new Semaphore(1, true);

    /*
      Variables para mostrar las lineas del pedido actual
      lineaPedidoAdapter => ArrayAdapter que recoge los objetos del carrito
      lineaPedido => ListView en el que se muestan las lineas de pedido
     */
    public ArrayAdapter<ProductoCarrito> lineaPedidoAdapter;
    public ListView lineaPedido;

    //objeto que se usará para formatear los datos de tipo Float
    DecimalFormat f = new DecimalFormat("##.00");

    /*
      Variables relacionadas con objetos del layout
      CrearPedidoBtn => Botón que lanza los métodos necesarios para meter los datos en PostgreSQL
      BezeroakSpinner => Spinner en el que se mostrarán los clientes
     */
    Button CrearPedidoBtn;
    Spinner BezeroakSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_pedido);

        DataConnect.SoIdQuery();
        DataConnect.SolIdQuery();

        try{
            ((TextView) findViewById(R.id.CPBezeroa)).setText(getResources().getIdentifier("@string/" + MainActivity.lang + "_CPBezeroa", null, getPackageName()));
            ((TextView) findViewById(R.id.CPProduktuak)).setText(getResources().getIdentifier("@string/" + MainActivity.lang + "_CPProduktuak", null, getPackageName()));
            ((Button) findViewById(R.id.CPEskaeraSortu)).setText(getResources().getIdentifier("@string/" + MainActivity.lang + "_CPEskaeraSortu", null, getPackageName()));
            ((MenuItem)findViewById(R.id.MenuSortu)).setTitle(getResources().getIdentifier("@string/"+MainActivity.lang+"_MenuSortu",null,getPackageName()));
        }catch(Exception e){
            Log.d("String", e.getMessage());
        }

        //Icono y color del texto del menu
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#b99932'>Salmenta Saskia</font>"));

        ArrayAdapter<Bezeroa> bezeroak = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, Bezeroa.bezeroak);
        lineaPedido = findViewById(R.id.lineaPedido);

        lineaPedidoAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ProductoCarrito.carrito);
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

        CrearPedidoBtn = findViewById(R.id.CPEskaeraSortu);
        CrearPedidoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataConnect.InsertOrderQuery();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                DataConnect.InsertLineQuery();
                goBack();
            }
        });
    }

    private float getTotal() {
        float total = 0;
        for (ProductoCarrito p : ProductoCarrito.carrito) {
            total += p.getPrecio();
        }
        return total;
    }

    private void goBack() {
        Toast.makeText(getApplicationContext(), "Salmenta sortu da", Toast.LENGTH_SHORT).show();
        this.finish();
    }
}