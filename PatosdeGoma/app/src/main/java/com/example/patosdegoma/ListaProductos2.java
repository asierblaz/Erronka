package com.example.patosdegoma;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class ListaProductos2 extends AppCompatActivity implements SearchView.OnQueryTextListener {

    private ListView listaProductos;
    private ArrayAdapter<Produktua> produktuakAdapter = null;
    private ArrayList<Produktua> produktuak = Produktua.produktuak;
    private ArrayList<Produktua> produktuakfiltro = Produktua.produktuak;
    private SearchView txtBuscar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_productos2);
        //definir elementos
        listaProductos = findViewById(R.id.listProductos);
        txtBuscar= findViewById(R.id.txtBuscar);

        //adapter lista productos
        produktuakAdapter = new ArrayAdapter<Produktua>(this, android.R.layout.simple_list_item_1, produktuak);
        listaProductos.setAdapter(produktuakAdapter);


        //evento list View
        listaProductos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Produktua p1 = produktuak.get(position);
                Intent intent = new Intent(ListaProductos2.this, DetallesProductos.class);
                intent.putExtra("prod", p1);
                startActivity(intent);
                //Toast.makeText(ListaCat.this, "Has pulsado: "+ p1.getName(), Toast.LENGTH_LONG).show();
            }
        });

        txtBuscar.setOnQueryTextListener(this);



    }


    @Override
    public boolean onQueryTextSubmit(String s) {
        filtrado(s);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {

        filtrado(s);
        return false;
    }


//    public void filtrado(String txtBuscar){
//        int longitud = txtBuscar.length();
//
//        if(longitud==0){
//            produktuakfiltro.clear();
//            produktuakfiltro.addAll(produktuak);
//
//        } else{
//            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
//                List<Produktua> collection = produktuakfiltro.stream()
//                        .filter(i -> i.getName().toLowerCase().contains(txtBuscar.toLowerCase()))
//                        .collect(Collectors.toList());
//                produktuakfiltro.clear();
//                produktuakfiltro.addAll(collection);
//            }
//            else{
//                for(Produktua p:produktuak){
//                    if(p.getName().toLowerCase().contains(txtBuscar.toLowerCase())){
//                        produktuakfiltro.add(p);
//                    }
//                }
//            }
//        }
//        produktuakAdapter = new ArrayAdapter<Produktua>(this, android.R.layout.simple_list_item_1, produktuakfiltro);
//        listaProductos.setAdapter(produktuakAdapter);
//    }

    public void filtrado(String name){
        ArrayList<Produktua> prods = new ArrayList<Produktua>();
        if (!name.isEmpty()) {
            for (Produktua p : Produktua.produktuak) {
                if (p.getName().toLowerCase().contains(name)) {
                    prods.add(p);
                }
                produktuakAdapter = new ArrayAdapter<Produktua>(this, android.R.layout.simple_list_item_1, prods);
                listaProductos.setAdapter(produktuakAdapter);

            }
        } else {
            produktuakAdapter = new ArrayAdapter<Produktua>(this, android.R.layout.simple_list_item_1, produktuak);
            listaProductos.setAdapter(produktuakAdapter);
        }
    }
}