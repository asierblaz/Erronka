package com.example.patosdegoma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.patosdegoma.OnSwipeTouchListener;

import java.util.ArrayList;

public class DetallesProductos extends AppCompatActivity {

    private TextView textNombre;
    private TextView textCategoria;
    private TextView textPrecio;
    private ImageView img;
    private View layout;
    private ArrayList<Produktua> prods;
    private Produktua p1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_productos);
        //poner icono en action bar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#b99932'>Patinhos Gomosos </font>"));
        textNombre = findViewById(R.id.textNombre);
        textPrecio = findViewById(R.id.texPrecio);
        textCategoria = findViewById(R.id.textCategoria);
        img = findViewById(R.id.imageView);
         p1 = (Produktua) getIntent().getSerializableExtra("prod");
        prods = (ArrayList<Produktua>) getIntent().getSerializableExtra("array");
        textNombre.setText(p1.getName());
        textCategoria.setText(p1.getCategoria());
        float precio = (float) p1.getPrezioa();
        textPrecio.setText(String.format("%.2f", precio)+" €");

        int imageRes= getResources().getIdentifier("@drawable/nofoto",null,getPackageName());
            Drawable draw= getResources().getDrawable(imageRes);
            img.setImageDrawable(draw);

            try {
                img.setImageDrawable(getResources().getDrawable(getResources().getIdentifier("@drawable/" + p1.getImagen(), null, getPackageName())));

            } catch (Exception e) {
                img.setImageDrawable(getResources().getDrawable(getResources().getIdentifier("@drawable/nofoto", null, getPackageName())));

            }
        layout = findViewById(R.id.Layout);
            layout.setOnTouchListener(new OnSwipeTouchListener(DetallesProductos.this) {
                Produktua px;
                int size = prods.size()-1;
                public void onSwipeLeft() {
                    if(prods.indexOf(p1) < size){
                        px = prods.get(prods.indexOf(p1)+1);

                    }else  {
                        px = prods.get(0);
                    }
                    textNombre.setText(px.getName());
                    textCategoria.setText(px.getCategoria());
                    float precio = (float) px.getPrezioa();
                    textPrecio.setText(String.format("%.2f", precio)+" €");
                    int imageRes= getResources().getIdentifier("@drawable/nofoto",null,getPackageName());
                    Drawable draw= getResources().getDrawable(imageRes);
                    img.setImageDrawable(draw);
                    try {
                        img.setImageDrawable(getResources().getDrawable(getResources().getIdentifier("@drawable/" + px.getImagen(), null, getPackageName())));
                    } catch (Exception e) {
                        img.setImageDrawable(getResources().getDrawable(getResources().getIdentifier("@drawable/nofoto", null, getPackageName())));
                    }
                    p1 = px;
                    Log.d("TAG", "onSwipeRight: "+px.toString());
                }
                public void onSwipeRight() {
                    if(prods.indexOf(p1) > 0){
                        px = prods.get(prods.indexOf(p1)-1);
                    }else  {
                        px = prods.get(size);
                    }
                    textNombre.setText(px.getName());
                    textCategoria.setText(px.getCategoria());
                    float precio = (float) px.getPrezioa();
                    textPrecio.setText(String.format("%.2f", precio)+" €");
                    int imageRes= getResources().getIdentifier("@drawable/nofoto",null,getPackageName());
                    Drawable draw= getResources().getDrawable(imageRes);
                    img.setImageDrawable(draw);
                    try {
                        img.setImageDrawable(getResources().getDrawable(getResources().getIdentifier("@drawable/" + px.getImagen(), null, getPackageName())));
                    } catch (Exception e) {
                        img.setImageDrawable(getResources().getDrawable(getResources().getIdentifier("@drawable/nofoto", null, getPackageName())));
                    }
                    p1 = px;
                    Log.d("TAG", "onSwipeLeft: "+px.toString());
                }

            });

    }
}