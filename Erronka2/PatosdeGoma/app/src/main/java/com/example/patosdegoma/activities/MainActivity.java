package com.example.patosdegoma.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.patosdegoma.DataConnect;
import com.example.patosdegoma.R;
import com.example.patosdegoma.models.Produktua;

public class MainActivity extends AppCompatActivity {

    String url = "jdbc:postgresql://192.168.65.15:5432/PatitosdeGoma";
    String user = "openpg";
    String pass = "openpgpwd";

    private Button verListaProductosBtn;
    private Button verListaVentasBtn;
    private MenuItem aboutUs;
    public static String lang = "es";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            ((Button) findViewById(R.id.MainProduktuak)).setText(getResources().getIdentifier("@string/" + lang + "_MainProduktuak", null, getPackageName()));
            ((Button) findViewById(R.id.MainProduktuak)).setText(getResources().getIdentifier("@string/" + lang + "_MainProduktuak", null, getPackageName()));
            ((Button) findViewById(R.id.MainBezeroak)).setText(getResources().getIdentifier("@string/" + lang + "_MainBezeroak", null, getPackageName()));
            ((Button) findViewById(R.id.MainSalmentak)).setText(getResources().getIdentifier("@string/" + lang + "_MainSalmentak", null, getPackageName()));
            ((MenuItem) findViewById(R.id.MenuAukerak)).setTitle(getResources().getIdentifier("@string/" + lang + "_MenuAukerak", null, getPackageName()));
            ((MenuItem) findViewById(R.id.MenuGureBuruz)).setTitle(getResources().getIdentifier("@string/" + lang + "_MenuGureBuruz", null, getPackageName()));
        }catch(Exception e){
            Log.d("String", e.getMessage());
        }

        //Icono y color del texto del menu
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#b99932'>Patinhos Gomosos</font>"));

        verListaProductosBtn = findViewById(R.id.MainProduktuak);
        verListaVentasBtn = findViewById(R.id.MainSalmentak);

        verListaProductosBtn.setOnClickListener(this::goToListaProductos);
        verListaVentasBtn.setOnClickListener(this::goToListaVentas);
        Produktua.categorias.add("Guztiak");

        DataConnect.BezeroakQuery();
        DataConnect.ProduktuakQuery();
        DataConnect.SalmentakQuery();
        DataConnect.SolIdQuery();
    }

    // funcion para crear el menu
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuprincipal, menu);
        aboutUs = menu.findItem(R.id.MenuBilatu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.MenuGureBuruz:
                Intent intent = new Intent(this, AboutUsActivity.class);
                startActivity(intent);
                return true;
            case R.id.MenuAukerak:
                Intent intent2 = new Intent(this, ListaProductos.class);
                startActivity(intent2);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void goToListaProductos(View view) {
        Intent intent = new Intent(this, ListaProductos.class);
        startActivity(intent);
    }

    public void goToListaVentas(View view) {
        Intent intent = new Intent(this, ListaVentas.class);
        startActivity(intent);
    }
}
