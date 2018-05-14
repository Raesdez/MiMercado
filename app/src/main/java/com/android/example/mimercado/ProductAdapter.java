package com.android.example.mimercado;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductsViewHolder> {

    Context c;
    ArrayList<Product> products;

    public ProductAdapter(Context c, ArrayList<Product> products) {
        this.c = c;
        this.products = products;
    }
    @Override
    public ProductsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(c).inflate(R.layout.items_model,parent,false);
        return new ProductsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ProductsViewHolder holder, int position) {

        //BIND DATA
        //holder.productNameText.setText(products.get(position).getName());
        holder.productNameText.setText(products.get(position).getName());
        //REVISAR
        Long price = products.get(position).getPrice();
        holder.priceTxt.setText(price.toString());


    }

    @Override
    public int getItemCount() {
        return products.size();
    }
}
