package com.android.example.mimercado;


import android.content.Context;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder> {

    private Context mContext;
    private List<Product> productList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, categoria, maker, weight, price;
        public ImageView image;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            categoria = (TextView) view.findViewById(R.id.categoriaField);
            weight = (TextView) view.findViewById(R.id.weightfield);
            price = (TextView) view.findViewById(R.id.pricefield);
            maker = (TextView) view.findViewById(R.id.makerfield);
            image = (ImageView) view.findViewById(R.id.thumbnail);
        }
    }


    public ProductAdapter(Context mContext, List<Product> productList) {
        this.mContext = mContext;
        this.productList = productList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Product product = productList.get(position);

        holder.title.setText(product.getName());
        holder.categoria.setText(product.getCategory());
        holder.maker.setText(product.getMaker());
        holder.weight.setText(product.getWeight()+"");
        holder.price.setText(product.getPrice()+"");
        //TODO Hacer el llenado de la imagen con Glide tomandolo del product.getImage()

    }



    @Override
    public int getItemCount() {
        return productList.size();
    }
}
