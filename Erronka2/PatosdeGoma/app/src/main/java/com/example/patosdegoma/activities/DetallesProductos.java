package com.example.patosdegoma.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.patosdegoma.R;
import com.example.patosdegoma.clases.OnSwipeTouchListener;
import com.example.patosdegoma.clases.ProductoCarrito;
import com.example.patosdegoma.clases.Produktua;

import java.util.ArrayList;

public class DetallesProductos extends AppCompatActivity {

    private TextView textNombre;
    private TextView textCategoria;
    private TextView textPrecio;
    private ImageView img;
    private View layout;
    private ArrayList<Produktua> prods;
    private Produktua p1;
    private ImageView addCarrito;
    private Button btnaceptar, btncancelar;
    private LinearLayout overbox, modal;
    private Animation modalanim, overboxanim;
    private int kant = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_productos);

        /**Icono y color del texto del menu**/
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#b99932'>Patinhos Gomosos</font>"));

        textNombre = findViewById(R.id.textNombre);
        textPrecio = findViewById(R.id.texPrecio);
        textCategoria = findViewById(R.id.textCategoria);
        img = findViewById(R.id.imageView);
        p1 = (Produktua) getIntent().getSerializableExtra("prod");
        prods = (ArrayList<Produktua>) getIntent().getSerializableExtra("array");
        textNombre.setText(p1.getName());
        textCategoria.setText(p1.getCategoria());
        float precio = (float) p1.getPrezioa();
        textPrecio.setText(String.format("%.2f", precio) + " €");
        int imageRes = getResources().getIdentifier("@drawable/nofoto", null, getPackageName());
        Drawable draw = getResources().getDrawable(imageRes);
        img.setImageDrawable(draw);

        try {
            img.setImageDrawable(getResources().getDrawable(getResources().getIdentifier("@drawable/" + p1.getImagen(), null, getPackageName())));
        } catch (Exception e) {
            img.setImageDrawable(getResources().getDrawable(getResources().getIdentifier("@drawable/nofoto", null, getPackageName())));
        }

        layout = findViewById(R.id.Layout);
        layout.setOnTouchListener(new OnSwipeTouchListener(DetallesProductos.this) {
            Produktua px;
            int size = prods.size() - 1;

            public void onSwipeLeft() {
                try {
                    px = prods.get(prods.indexOf(p1) + 1);
                } catch (IndexOutOfBoundsException e) {
                    px = prods.get(0);
                }
//                    if(prods.indexOf(p1) < size){
//                        px = prods.get(prods.indexOf(p1)+1);
//                    }else  {
//                        Log.d("index", String.valueOf(prods.indexOf(p1)));
//                    }

                textNombre.setText(px.getName());
                textCategoria.setText(px.getCategoria());
                float precio = (float) px.getPrezioa();
                textPrecio.setText(String.format("%.2f", precio) + " €");
                int imageRes = getResources().getIdentifier("@drawable/nofoto", null, getPackageName());
                Drawable draw = getResources().getDrawable(imageRes);
                img.setImageDrawable(draw);
                try {
                    img.setImageDrawable(getResources().getDrawable(getResources().getIdentifier("@drawable/" + px.getImagen(), null, getPackageName())));
                } catch (Exception e) {
                    img.setImageDrawable(getResources().getDrawable(getResources().getIdentifier("@drawable/nofoto", null, getPackageName())));
                }
                p1 = px;
                Log.d("TAG", "onSwipeRight: " + px.toString());
            }

            public void onSwipeRight() {
                try {
                    px = prods.get(prods.indexOf(p1) - 1);
                } catch (IndexOutOfBoundsException e) {
                    px = prods.get(size);
                }
//                    if(index > 0){
//                        px = prods.get(index-1);
//                    }else  {
//                        Log.d("index", String.valueOf(index));
//                        px = prods.get(size);
//                    }
                textNombre.setText(px.getName());
                textCategoria.setText(px.getCategoria());
                float precio = (float) px.getPrezioa();
                textPrecio.setText(String.format("%.2f", precio) + " €");
                int imageRes = getResources().getIdentifier("@drawable/nofoto", null, getPackageName());
                Drawable draw = getResources().getDrawable(imageRes);
                img.setImageDrawable(draw);
                try {
                    img.setImageDrawable(getResources().getDrawable(getResources().getIdentifier("@drawable/" + px.getImagen(), null, getPackageName())));
                } catch (Exception e) {
                    img.setImageDrawable(getResources().getDrawable(getResources().getIdentifier("@drawable/nofoto", null, getPackageName())));
                }
                p1 = px;
                Log.d("TAG", "onSwipeLeft: " + px.toString());
            }

        });


        addCarrito = findViewById(R.id.addCarrito);
        btnaceptar = (Button) findViewById(R.id.btnaceptar);
        btncancelar = (Button) findViewById(R.id.btncancelar);
        modalanim = AnimationUtils.loadAnimation(this, R.anim.modalanim);
        overboxanim = AnimationUtils.loadAnimation(this, R.anim.overboxanim);
        modal = findViewById(R.id.modal);
        overbox = findViewById(R.id.overbox);
        modal.setAlpha(0);
        overbox.setAlpha(0);

        addCarrito.setOnClickListener(this::abrirModal);
        btnaceptar.setOnClickListener(this::añadir);
        btncancelar.setOnClickListener(this::cerrarModal);
    }

    public void añadir(View v) {
        try {
            kant = Integer.parseInt(((TextView) findViewById(R.id.kantText)).getText().toString());
        } catch (Exception e) {
        }
        addToCart(p1, kant);
        cerrarModal(v);
    }

    public void addToCart(Produktua prod, int kant) {
        boolean esta = false;
        for (ProductoCarrito p : ProductoCarrito.carrito) {
            if (p.getProducto().getId() == prod.getId()) {
                esta = true;
                p.setCantidad(kant);
                p.setPrecio();

                Toast.makeText(getApplicationContext(), p.getCantidad() + " " +
                        p.getProducto().getName() + " daude saskian", Toast.LENGTH_SHORT).show();
                break;
            }
        }
        if (!esta) {
            ProductoCarrito pc = new ProductoCarrito(prod, kant);
            ProductoCarrito.carrito.add(pc);
            if (kant != 1) {
                Toast.makeText(getApplicationContext(), pc.getCantidad() + " " +
                        pc.getProducto().getName() +
                        " sartu dira saskian", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), pc.getProducto().getName() +
                        " bat sartu da saskian", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void abrirModal(View v) {
        overbox.setAlpha(1);
        overbox.startAnimation(overboxanim);
        modal.setAlpha(1);
        modal.startAnimation(modalanim);
    }

    public void cerrarModal(View v) {
        modal.setAlpha(0);
        overbox.setAlpha(0);
    }
}