package com.android.example.mimercado;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ProductList extends AppCompatActivity {

    RecyclerView mRecyclerView;                                       //The recycler view that will contain all the generated cards
    List mProductList;
    ArrayList<Product>mSelectedProductList= new ArrayList<>(); //The product list and the already selected products

    public static final String EXTRA_REPLY = "com.twoactivities.gian.twoactivites.extra.REPLY";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Enables the back button
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Intent intent = getIntent(); //Get the intent that started the activity

        Bundle bundle = intent.getExtras();


        mSelectedProductList.add((Product)bundle.getSerializable(getString(R.string.product_name_flour)));

        //TODO this was when it was parcelable
        //mSelectedProductList=intent.getParcelableArrayListExtra("Lista");


        mRecyclerView = findViewById(R.id.recyclerview);        //Recycler view object
        GridLayoutManager mGridLayoutManager = new GridLayoutManager(ProductList.this,2); //Creates a manager of two columns
        mRecyclerView.setLayoutManager(mGridLayoutManager);     //Sets the grid to the recycler


        //TODO Call the adapter to select the products that were already selected, if any
        mProductList = generateProductList(); //Generate the product list
        //mSelectedProductList.add((Product)mProductList.get(0)); //TODO delete this, it's just a test
        //mSelectedProductList.add((Product)mProductList.get(2));


        ProductAdapter myAdapter = new ProductAdapter(ProductList.this, mProductList,mSelectedProductList);
        mRecyclerView.setAdapter(myAdapter);


        //TODO Replace it with a "select products action"
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, R.string.test_delete_later, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    /**
     * Method that returns to the Main Activity and sends the product list
     * @param view
     */
    public void returnReply(View view) {

        mSelectedProductList = (ArrayList<Product>)((ProductAdapter)mRecyclerView.getAdapter()).getmSelectedProductsList(); //Obtains the selected product list

        Intent replyIntent = new Intent(); //We must create a new intent

        replyIntent.putExtras(generateReturnBundle());

       //TODO for Parcelable
       // replyIntent.putParcelableArrayListExtra("List",mSelectedProductList);

        setResult(RESULT_OK,replyIntent);
        finish();
    }

    public Bundle generateReturnBundle()
    {
        Bundle bundle = new Bundle();

        for(Product product: mSelectedProductList) //Iterates all of the selected products and adds them
        {
            bundle.putSerializable(getString(product.getName()),product);
        }

        return bundle;
    }




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



}


