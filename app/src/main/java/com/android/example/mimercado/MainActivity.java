package com.android.example.mimercado;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Product> products=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    startActivity(new Intent(MainActivity.this,ProductList.class));
            }
        });

        //-------
        //RECYCLERVIEW
        RecyclerView rv= (RecyclerView) findViewById(R.id.recycler_view_items_list);
        rv.setLayoutManager(new LinearLayoutManager(this));

        //FILL LIST
        fillItems();

        //CALCULATE SUBTOTAL
        long total = subTotal();
        TextView subTotalText = (TextView)  findViewById(R.id.subTotal_quantity);
        subTotalText.setText(String.valueOf(total));

        //ADAPTER
        ProductAdapter adapter=new ProductAdapter(this,products);
        rv.setAdapter(adapter);
    }

    /**
     * This method fill the list that is show in the view
     */
    private void fillItems() {
        products.clear();

        Product p=new Product();
        p.setName("Queso");
        p.setPrice(200);
        products.add(p);

        p=new Product();
        p.setName("Jamón");
        p.setPrice(500);
        products.add(p);
        p=new Product();

        p.setName("Jamón");
        p.setPrice(500);
        products.add(p);

        p=new Product();
        p.setName("Jamón");
        p.setPrice(500);
        products.add(p);

        p=new Product();
        p.setName("Jamón");
        p.setPrice(500);
        products.add(p);

        p=new Product();
        p.setName("Jamón");
        p.setPrice(500);
        products.add(p);

        p=new Product();
        p.setName("Jamón");
        p.setPrice(500);
        products.add(p);


    }
    private long subTotal(){

        long total = 0;

        for (Product product : products){
            total = total + product.getPrice();
        }

        return total;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void addButton(View view) {
        Intent intent = new Intent(this, ProductList.class);
        startActivity(intent);

    }
}
