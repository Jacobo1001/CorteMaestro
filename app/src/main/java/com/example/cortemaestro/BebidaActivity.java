package com.example.cortemaestro;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.app.ListActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class BebidaActivity extends ListActivity {

    public class Bebida {
        private String nombreProducto;
        private String ingredientesProducto;
        private String precioProducto;

        private Integer imagenProducto;
    }

    private MyAdapter adaptador = null;
    private static ArrayList<Bebida> arregloProducto = new ArrayList<Bebida>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setData();
        adaptador = new MyAdapter(this);
        setListAdapter (adaptador);
    }
    private void setData(){
        arregloProducto.clear();

        Bebida productoActual1 = new Bebida();
        productoActual1.nombreProducto = this.getResources().getString(R.string.bebida1);
        productoActual1.ingredientesProducto = this.getResources().getString(R.string.ingbebida1);
        productoActual1.precioProducto = this.getResources().getString(R.string.pre_bebida1);
        productoActual1.imagenProducto = R.drawable.sangria;
        arregloProducto.add(productoActual1);

        Bebida productoActual2 = new Bebida();
        productoActual2.nombreProducto = this.getResources().getString(R.string.bebida2);
        productoActual2.ingredientesProducto = this.getResources().getString(R.string.ingbebida2);
        productoActual2.precioProducto = this.getResources().getString(R.string.pre_bebida2);
        productoActual2.imagenProducto = R.drawable.mojito;
        arregloProducto.add(productoActual2);

        Bebida productoActual3 = new Bebida();
        productoActual3.nombreProducto = this.getResources().getString(R.string.bebida3);
        productoActual3.ingredientesProducto = this.getResources().getString(R.string.ingbebida3);
        productoActual3.precioProducto = this.getResources().getString(R.string.pre_bebida3);
        productoActual3.imagenProducto = R.drawable.malbec;
        arregloProducto.add(productoActual3);


    }

    public static class MyAdapter extends BaseAdapter{
        private Context myContexto;
        public MyAdapter(Context c){
            myContexto = c;
        }

        @Override
        public int getCount(){
            return arregloProducto.size();
        }
        @Override
        public Object getItem(int arg){
            return arregloProducto.get(arg);
        }
        @Override
        public long getItemId(int arg){
            return 0;
        }
        @Override
        public View getView(int position, View vista, ViewGroup arg2){

            View view = null;
            if (vista == null){
                LayoutInflater inflater = (LayoutInflater) myContexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(R.layout.activity_bebida, null);
            }
            else{
                view = vista;
            }
            ImageView imgProducto = view.findViewById(R.id.imageViewProducto);
            imgProducto.setImageDrawable(myContexto.getResources().getDrawable(arregloProducto.get(position).imagenProducto));

            TextView nombreProducto = (TextView) view.findViewById(R.id.textViewProduct);
            nombreProducto.setText(arregloProducto.get(position).nombreProducto);

            TextView ingredientesProducto = (TextView) view.findViewById(R.id.textViewIngredient);
            ingredientesProducto.setText(arregloProducto.get(position).ingredientesProducto);

            TextView precioProducto = (TextView) view.findViewById(R.id.textViewPrecioProd);
            precioProducto.setText(arregloProducto.get(position).precioProducto);

            return view;
            // View view = convertView;
        }
    }

}