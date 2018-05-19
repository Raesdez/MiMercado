package com.android.example.mimercado;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class ProductList extends AppCompatActivity {

    public static final String EXTRA_REPLY = "com.android.example.mimercado.extra.REPLY";
    RecyclerView mRecyclerView;
    List mProductList;
    Product mProduct;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mRecyclerView = findViewById(R.id.recyclerview);
        GridLayoutManager mGridLayoutManager = new GridLayoutManager(ProductList.this, 2);
        mRecyclerView.setLayoutManager(mGridLayoutManager);

        mProductList = new ArrayList<>();


        ProductAdapter myAdapter = new ProductAdapter(ProductList.this, mProductList);
        mRecyclerView.setAdapter(myAdapter);


        //
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    //Falta colocar el método que devuelva a la vista bb

}
