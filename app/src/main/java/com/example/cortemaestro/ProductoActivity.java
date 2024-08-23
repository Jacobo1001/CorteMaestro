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

public class ProductoActivity extends ListActivity {

    public class Producto {
        private String nombreProducto;
        private String ingredientesProducto;
        private String precioProducto;

        private Integer imagenProducto;
    }

    private MyAdapter adaptador = null;
    private static ArrayList<Producto> arregloProducto = new ArrayList<Producto>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setData();
        adaptador = new MyAdapter(this);
        setListAdapter (adaptador);
        //setContentView(R.layout.activity_producto);
    }
    private void setData(){
        arregloProducto.clear();

        Producto productoActual1 = new Producto();
        productoActual1.nombreProducto = this.getResources().getString(R.string.entrada1);
        productoActual1.ingredientesProducto = this.getResources().getString(R.string.ingentrada1);
        productoActual1.precioProducto = this.getResources().getString(R.string.pre_entrada1);
        productoActual1.imagenProducto = R.drawable.carpa;
        arregloProducto.add(productoActual1);

        Producto productoActual2 = new Producto();
        productoActual2.nombreProducto = this.getResources().getString(R.string.entrada2);
        productoActual2.ingredientesProducto = this.getResources().getString(R.string.ingentrada2);
        productoActual2.precioProducto = this.getResources().getString(R.string.pre_entrada2);
        productoActual2.imagenProducto = R.drawable.empanadas;
        arregloProducto.add(productoActual2);

        Producto productoActual3 = new Producto();
        productoActual3.nombreProducto = this.getResources().getString(R.string.entrada3);
        productoActual3.ingredientesProducto = this.getResources().getString(R.string.ingentrada3);
        productoActual3.precioProducto = this.getResources().getString(R.string.pre_entrada3);
        productoActual3.imagenProducto = R.drawable.provoleta;
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
                view = inflater.inflate(R.layout.activity_plato_fuerte, null);
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