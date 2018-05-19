package com.android.example.mimercado;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
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

    //Attributes
    private Context mContext;
    private List<Product> mProductList;   //All of the available products
    private List<Product> mSelectedProductsList;    //List of selected products, it can be empty or not, it is received from the main activity
    private int MAX_PRODUCTS = 10;  //A constant for the max of products that can be ordered


    //The constructor gets the Context from where it was created, the total product list and de selected product list
    ProductAdapter(Context mContext, List mProductList, List mSelectedProductsList) {
        this.mContext = mContext;
        this.mProductList = mProductList;
        this.mSelectedProductsList = new ArrayList<>();
        this.mProductList = mProductList;
        this.mSelectedProductsList = mSelectedProductsList;
    }


    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item_row, parent, false);
        return new ProductViewHolder(mView);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holders, final int position) {

        final ProductViewHolder holder = (ProductViewHolder) holders; //The holder and it's position

        //Retrieve all the information from the list using the position and adding it to the card
        holder.mImage.setImageResource(mProductList.get(position).getImage());
        holder.mTitle.setText(mProductList.get(position).getName());
        holder.mCategory.setText(mProductList.get(position).getCategory());
        holder.mMaker.setText(mProductList.get(position).getMaker());
        holder.mWeight.setText(String.format("%s Kg", Double.toString(mProductList.get(position).getWeight())));
        holder.mPrice.setText(String.format("%s $", Double.toString(mProductList.get(position).getPrice())));


        //If the selected product list has products, it selects the product on the card
        selectDeselectCard(holder, position);


        /**
         * A click listener for the card view that selects or deselects the products and updates the
         * list, it also doesn't let you add more products than the max
         */
        holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mSelectedProductsList.contains(mProductList.get(position)))   //It has been deselected
                {
                    holder.mCheck.setChecked(false);                             //Uncheck the check box
                    mSelectedProductsList.remove(mProductList.get(position));
                    System.out.println("Deleted" + mContext.getString(mProductList.get(position).getName()));

                } else                                                        //It has been selected
                {
                    if (mSelectedProductsList.size() != MAX_PRODUCTS) {
                        holder.mCheck.setChecked(true);                      //Check the check box
                        mSelectedProductsList.add(mProductList.get(position)); //Add the product to the list of selected
                        System.out.println("Added" + mContext.getString(mProductList.get(position).getName()));

                    } else {
                        Snackbar.make(view, R.string.alert_maximun_products, Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                    }
                }
            }
        });
    }


    /**
     * Getter for the Selected Product List
     *
     * @return the Selected Product List
     */
    public List<Product> getmSelectedProductsList() {
        return (mSelectedProductsList);
    }

    /**
     * At creation of each card, it selects those that were already selected before calling the product list view
     *
     * @param holder
     * @param position
     */
    private void selectDeselectCard(ProductViewHolder holder, int position) {

        if (mSelectedProductsList.contains(mProductList.get(position)))
            holder.mCheck.setChecked(true);
        else
            holder.mCheck.setChecked(false);

    }

    /**
     * [DEPRECATED] It was mandatory to override this method
     *
     * @return the size of the product list
     */
    @Override
    public int getItemCount() {
        return mProductList.size();
    }

}


// A view holder that contains the cards for the product list
class ProductViewHolder extends RecyclerView.ViewHolder {

    //Attributes, in this case, the views of the cards
    ImageView mImage;
    TextView mTitle, mCategory, mMaker, mWeight, mPrice;
    CardView mCardView = itemView.findViewById(R.id.cardview);
    CheckBox mCheck;

    //Assignment of the elements from the layout to the View Holder
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