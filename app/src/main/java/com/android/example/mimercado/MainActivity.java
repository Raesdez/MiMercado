package com.android.example.mimercado;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static final String EXTRA_MESSAGE = "com.android.example.mimercado.extra.MESSAGE";
    public static final String EXTRA_REPLY = "com.android.example.mimercado.extra.REPLY";

    public static final int TEXT_REQUEST = 1;

    public static ArrayList<Product> products=new ArrayList<>();
    private static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        MainActivity.context = getApplicationContext();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "This is my Toast message!", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(MainActivity.this,ProductList.class));
            }
        });

        //-------
        //RECYCLERVIEW
        RecyclerView rv= (RecyclerView) findViewById(R.id.recycler_container);
        rv.setLayoutManager(new LinearLayoutManager(this));

        //FILL LIST
        fillItems();

        //CALCULATE SUBTOTAL
        /*long total = subTotal();
        TextView subTotalText = (TextView)  findViewById(R.id.subTotal_quantity);
        subTotalText.setText(String.valueOf(total));*/

        //ADAPTER
        ProductAdapterMain adapter=new ProductAdapterMain(this,products);
        rv.setAdapter(adapter);
    }

    /**
     * This method fill the list that is show in the view
     */
    private void fillItems() {
        products.clear();

        Product p=new Product();
        p.setName(R.string.product_test_name);
        p.setPrice(200);
        products.add(p);

        p=new Product();
        p.setName(R.string.product_test_name);
        p.setPrice(500);
        products.add(p);


        subTotal();

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

    /**
     *
     * This method calculates subtotal
     */
    private Double subTotal(){

        Double total = 0.0;

        for (Product product : products){
            total = total + product.getPrice();
        }
        TextView subTotalText = (TextView)  findViewById(R.id.total_text);
        subTotalText.setText(String.valueOf(total));
        return total;
    }

    /**
     *
     * This method call the list of products you can select for result
     * @param view
     */
    public void buyProduct(View view) {
        Intent intent = new Intent(this, Product.class);
        Bundle listOfProducts = new Bundle();
        intent.putParcelableArrayListExtra(EXTRA_MESSAGE, (ArrayList<? extends Parcelable>) products);
        startActivityForResult(intent, TEXT_REQUEST);

    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                products=data.getParcelableArrayListExtra("Lista");
            }
        }
    }

}
