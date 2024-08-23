package com.example.cortemaestro;


import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class
MenuActivity extends ListActivity {

    String [] categoriasProducotos = new String[]{"Entradas", "Platos Fuertes", "Bebidas", "Postres"};
    ListView listaCategorias = null;
    ListAdapter adaptadorLista = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        listaCategorias = findViewById(android.R.id.list);
        adaptadorLista = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, categoriasProducotos);

        listaCategorias.setAdapter(adaptadorLista);
    }
    protected void onListItemClick (ListView lv, View v, int position, long id){


        if(position == 0){

            Intent i; //intent : forma en la que se comunican las clases
            i= new Intent(this, ProductoActivity.class); //(actividad actual , a donde quiere ir)
            startActivity(i); //lanzar la actividad
        }
        if(position == 1){

            Intent i;
            i= new Intent(this, PlatoFuerteActivity.class);
            startActivity(i);
        }
        if(position == 2){

            Intent i;
            i= new Intent(this, BebidaActivity.class);
            startActivity(i);
        }
        if(position == 3){

            Intent i;
            i= new Intent(this, PostreActivity.class);
            startActivity(i);
        }
        if(position == 4){

            Intent i;
            i= new Intent(this, PostreActivity.class);
            startActivity(i);
        }


    }

}