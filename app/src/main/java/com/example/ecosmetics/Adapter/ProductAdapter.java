package com.example.ecosmetics.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecosmetics.Model.Product;

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
    public ProductAdapter.ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View v= LayoutInflater.from(mContext).inflate(R.la)
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.ProductViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class
}
