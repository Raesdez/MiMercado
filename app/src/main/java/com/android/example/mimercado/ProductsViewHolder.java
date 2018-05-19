package com.android.example.mimercado;

import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

//El view Holder es algo asi como la celda, es quien referencia a esa celda, que en este caso sería el items model
public class ProductsViewHolder extends RecyclerView.ViewHolder {

    TextView titleTxt,productNameText,priceTxt;

    public ProductsViewHolder(View itemView) {
        super(itemView);

        titleTxt= (TextView) itemView.findViewById(R.id.title_item_text);
        productNameText= (TextView) itemView.findViewById(R.id.name_item_text);
        priceTxt = (TextView) itemView.findViewById(R.id.price_item_text);


    }




}
