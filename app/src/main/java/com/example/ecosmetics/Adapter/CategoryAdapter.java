package com.example.ecosmetics.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecosmetics.Model.Category;
import com.example.ecosmetics.R;

import java.util.List;

public class CategoryAdapter extends  RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>{
    Context mContext;
    List<Category> categoryList;

    public CategoryAdapter(Context context, List<Category>categoryList){
        this.mContext =mContext;
        this.categoryList = categoryList;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view =LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.category_item,viewGroup,false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
    Category cat = categoryList.get(position);
    holder.category_img.setImageResource(cat.getImage());
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder{

        private ImageView category_img;
        private TextView category_name;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            category_img=itemView.findViewById(R.id.cat_image);
            category_name=itemView.findViewById(R.id.cat_name);
        }
    }
}
