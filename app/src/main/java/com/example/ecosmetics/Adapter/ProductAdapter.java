package com.example.ecosmetics.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecosmetics.Model.Product;
import com.example.ecosmetics.R;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    Context mContext;
    List<Product> productList;
    public ProductAdapter(Context mContext, List<Product> productList){
        this.mContext =mContext;
        this.productList=productList;
    }


    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View v  =LayoutInflater.from(mContext).inflate(R.layout.product_cardview,parent,false);
    return new ProductViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {

    Product pro=productList.get(position);
    holder.produtname.setText(productList.get(position).getProductname());
    holder.productimg.setImageResource(productList.get(position).getProductimg());

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

  public class ProductViewHolder extends RecyclerView.ViewHolder {
    ImageView productimg;
    TextView produtname;
    CardView cardView;

      public ProductViewHolder(@NonNull View itemView) {
          super(itemView);

          produtname=itemView.findViewById(R.id.product_name_id);
          productimg=itemView.findViewById(R.id.product_img_id);
          cardView=itemView.findViewById(R.id.cardview);
      }
  }
}
