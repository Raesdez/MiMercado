package com.android.example.mimercado;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.ColorRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter {

    private Context mContext;
    private List<Product> mProductList;
    private List<Product> mSelectedProductsList;

    ProductAdapter(Context mContext, List mProductListList) {
        this.mContext = mContext;
        this.mProductList = mProductListList;
        this.mSelectedProductsList = new ArrayList<>();

    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item_row, parent, false);
        return new ProductViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holders, final int position) {

        final ProductViewHolder holder = (ProductViewHolder) holders;

        holder.mImage.setImageResource(mProductList.get(position).getImage());
        holder.mTitle.setText(mProductList.get(position).getName());
        holder.mCategory.setText(mProductList.get(position).getCategory());
        holder.mMaker.setText(mProductList.get(position).getMaker());
        holder.mWeight.setText(Double.toString(mProductList.get(position).getWeight())+" Kg");
        holder.mPrice.setText(Double.toString(mProductList.get(position).getPrice())+" $");

        holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (mSelectedProductsList.contains(mProductList.get(position)))   //It has been deselected
                {
                    holder.mCheck.setChecked(false);

                    mSelectedProductsList.remove(mProductList.get(position));
                    System.out.println("Deselected");
                } else                                                        //It has been selected
                {
                    if (mSelectedProductsList.size() != 10) {
                        holder.mCheck.setChecked(true);
                        mSelectedProductsList.add(mProductList.get(position)); //Add the product to the list of selected
                        //  holder.mCardView.setCardBackgroundColor(Color.WHITE);
                        System.out.println("Selected");
                    } else {
                        Toast.makeText(mContext, "Máximo 10 productos por compra", Toast.LENGTH_LONG).show();
                    }
                }


            }
        });
    }


    @Override
    public int getItemCount() {
        return mProductList.size();
    }
}


class ProductViewHolder extends RecyclerView.ViewHolder {

    ImageView mImage;
    TextView mTitle, mCategory, mMaker, mWeight, mPrice;
    CardView mCardView = itemView.findViewById(R.id.cardview);
    CheckBox mCheck;


    ProductViewHolder(View itemView) {
        super(itemView);

        mImage = itemView.findViewById(R.id.ivImage);
        mTitle = itemView.findViewById(R.id.tvTitle);
        mCategory = itemView.findViewById(R.id.tvCategory);
        mMaker = itemView.findViewById(R.id.tvMaker);
        mWeight = itemView.findViewById(R.id.tvWeight);
        mPrice = itemView.findViewById(R.id.tvPrice);
        mCheck = itemView.findViewById(R.id.checkBox);

    }
}