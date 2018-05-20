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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final int TEXT_REQUEST = 1;

    public static ArrayList<Product> products=new ArrayList<>();
    private ArrayList<Product> allProducts = (ArrayList<Product>) generateProductList();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    /**
     *
     * This method call the list of products you can select for result
     * @param view
     */
    public void buyProduct(View view) {
        Intent intent = new Intent(this, ProductList.class);
        Bundle listOfProducts = new Bundle();

        listOfProducts=generateBundle();
        intent.putExtras(listOfProducts);

        startActivityForResult(intent, TEXT_REQUEST);

    }


    /**
     * This method generate bundle with list of products clients want to buy
     * @return
     */
    private Bundle generateBundle() {
        Bundle bundle = new Bundle();

        //mSelectedProductList = (ArrayList<Product>) ((ProductAdapter) mRecyclerView.getAdapter()).getmSelectedProductsList();
        for (Product product : products) //Iterates all of the selected products and adds them
        {
            bundle.putSerializable(getString(product.getName()), product);
        }
        return bundle;
    }


    /**
     * This method receive list of products client want to add to a shopping card
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        products.clear();
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {

                Bundle bundle = data.getExtras();

                if (bundle != null) {
                    for (Product product : allProducts) {
                        if (bundle.getSerializable(getString(product.getName())) != null) {
                            products.add(product);
                        }
                    }
                }
                //products.add((Product)bundle.getSerializable(getString(R.string.product_name_flour)));

            }
        }
        updateListOfProducts();
    }

    /**
     * This method update list of product activity shows in the recycler view
     */
    private void updateListOfProducts(){
        //-------
        //RECYCLERVIEW
        RecyclerView rv= (RecyclerView) findViewById(R.id.recycler_container);
        rv.setLayoutManager(new LinearLayoutManager(this));

        //FILL LIST
        //fillItems();

        //CALCULATE SUBTOTAL
        /*long total = subTotal();
        TextView subTotalText = (TextView)  findViewById(R.id.subTotal_quantity);
        subTotalText.setText(String.valueOf(total));*/

        //ADAPTER
        ProductAdapterMain adapter=new ProductAdapterMain(this,products);
        rv.setAdapter(adapter);
        subTotal();
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


    //TODO
    /**
     * Generate the 20-product-list that will be used on the app
     * @return the products list
     */
    private List<Product> generateProductList() {
        List<Product> productList = new ArrayList<>();

        productList.add(new Product(R.string.product_name_flour, R.string.product_category_imported, "PAN", 1, 1.69, R.drawable.flour));

        productList.add(new Product(R.string.product_name_apple, R.string.product_category_local, "ManzanCA", 3, 2.99, R.drawable.apple));

        productList.add(new Product(R.string.product_name_pear, R.string.product_category_local, "PeraCA", 3, 1.99, R.drawable.pear));

        productList.add(new Product(R.string.product_name_milk, R.string.product_category_local, "Mi Vaca", 1, 1.32, R.drawable.milk));

        productList.add(new Product(R.string.product_name_olive, R.string.product_category_imported, "Carbonell", 3, 16.99, R.drawable.olive));

        productList.add(new Product(R.string.product_name_rice, R.string.product_category_local, "Mary", 1, 0.99, R.drawable.rice));

        productList.add(new Product(R.string.product_name_lemons, R.string.product_category_local, "El camión", 5, 2.99, R.drawable.lemon));

        productList.add(new Product(R.string.product_name_watermelon, R.string.product_category_local, "El camión", 5, 4.00, R.drawable.watermelon));

        productList.add(new Product(R.string.product_name_bellpepper, R.string.product_category_local, "El camión", 1, 4.00, R.drawable.bellpepper));

        productList.add(new Product(R.string.product_name_pasta, R.string.product_category_local, "Mary", 1, 0.99, R.drawable.pasta));

        productList.add(new Product(R.string.product_soda_can, R.string.product_category_imported, "Coca Cola", 0.750, 1.67, R.drawable.sodacan));

        productList.add(new Product(R.string.product_name_bacon, R.string.product_category_local, "Plumrose", 5, 7.99, R.drawable.bacon));

        productList.add(new Product(R.string.product_name_cheese, R.string.product_category_local, "Paisa", 1, 6.34, R.drawable.cheese));

        productList.add(new Product(R.string.product_name_meat, R.string.product_category_local, "Rey David", 8, 24.67, R.drawable.meat));

        productList.add(new Product(R.string.product_name_ketchup, R.string.product_category_imported, "Heinz", 1, 3.99, R.drawable.ketchup));

        productList.add(new Product(R.string.product_name_lettuce, R.string.product_category_local, "El Campo", 0.5, 2.99, R.drawable.lettuce));

        productList.add(new Product(R.string.product_name_eggplant, R.string.product_category_local, "El Campo", 3, 7.21, R.drawable.eggplant));

        productList.add(new Product(R.string.product_name_orange_juice, R.string.product_category_local, "Yukeri", 0.255, 0.99, R.drawable.orangejuice));

        productList.add(new Product(R.string.product_name_apple_juice, R.string.product_category_local, "Yukeri", 0.255, 0.99, R.drawable.applejuice));

        productList.add(new Product(R.string.product_name_beer, R.string.product_category_local, "Solera", 1.5, 7.88, R.drawable.beer));

        productList.add(new Product(R.string.product_name_wine, R.string.product_category_imported, "Gato negro", 1.5, 20.55, R.drawable.wine));

        System.out.println(productList.size()); //Shows list size in order to check if it has 20 products
        return productList;
    }

    @Override
    protected void onResume() {
      // updateListOfProducts();
        super.onResume();
    }
}
