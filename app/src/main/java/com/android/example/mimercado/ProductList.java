package com.android.example.mimercado;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class ProductList extends AppCompatActivity {

    // array de productos que se llena con getListaProducto
    public List<Product> listaProducto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        listaProducto = getListaProducto();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        RecyclerView cardlist = (RecyclerView) findViewById(R.id.cardlist);
        cardlist.setLayoutManager(layoutManager);
        ProductAdapter adaptadorProductos = new ProductAdapter(this,listaProducto);
        cardlist.setAdapter(adaptadorProductos);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }

//metodo que agruega productos al array listaProducto
    public List<Product> getListaProducto() {
        List<Product> listaProducto = new ArrayList<Product>();
        listaProducto.add(new Product("Harina","Importada","PAN",1,1500,""));
        listaProducto.add(new Product("Manzanas","Local","ManzanCA",1,2000,""));
        listaProducto.add(new Product("Peras","Local","PeraCA",1,2500,""));
        listaProducto.add(new Product("Leche","Local","MIVACA",2,5000,""));
        listaProducto.add(new Product("Aceite","Importado","MACEITE",1,6500,""));
        listaProducto.add(new Product("Arroz","Local","MARY",2,5000,""));
        listaProducto.add(new Product("Lentejas","Local","MARY",1,4500,""));
        listaProducto.add(new Product("Guisantes","Importado","LOS GUISANTES",2,350,""));
        listaProducto.add(new Product("Mantequilla","Local","MAVESA",1,3500,""));
        listaProducto.add(new Product("Margarina","Local","MAVESA",1,2500,""));
        listaProducto.add(new Product("Pasta","Local","MARY",1,1500,""));
        listaProducto.add(new Product("Jamon","Local","PLUMROSE",1,2500,""));
        listaProducto.add(new Product("Tocineta","Local","PLUMROSE",1,1500,""));
        listaProducto.add(new Product("Queso","Local","Paisa",2,1000,""));
        listaProducto.add(new Product("Queso Crema","Importado","Andinita",1,3000,""));
        listaProducto.add(new Product("Tomates","Local","EL CAMPO",2,1000,""));
        listaProducto.add(new Product("Lechugas","Local","EL CAMPO",1,1300,""));
        listaProducto.add(new Product("Berenjena","Local","EL CAMPO",1,1600,""));
        listaProducto.add(new Product("Jugo de Naranja","Local","Yukeri",1,1000,""));
        listaProducto.add(new Product("Jugo de Manzana","Local","Yukeri",1,1500,""));
        listaProducto.add(new Product("Jugo de Pera","Local","Yukeri",1,1000,""));
        return listaProducto;
    }
}
