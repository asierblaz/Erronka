package com.example.patosdegoma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;

public class MainActivity extends AppCompatActivity {


    private Button verListaProductosBtn;
    private MenuItem aboutUs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //poner icono en action bar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#b99932'>Patinhos Gomosos </font>"));
        //Carga csv a produktuak
        Produktua.fileToArraylist(this);
        Produktua.categoriasToArray();
        verListaProductosBtn = findViewById(R.id.verProductosButton);
        verListaProductosBtn.setOnClickListener(this::goToListaProductos);

    }
// funcion para crear el menu
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuprincipal,menu);
        aboutUs = menu.findItem(R.id.app_bar_search);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.itemAbout:
                Intent intent = new Intent(this, AboutUsActivity.class);
                startActivity(intent);
                return true;
            case R.id.itemAjustes:
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


}
