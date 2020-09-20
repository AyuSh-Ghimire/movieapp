package com.example.Movie.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.Movie.Model.Product;
import com.example.Movie.URL.url;
import com.example.Movie.DashboardActivity;
import com.example.Movie.ProductDetailedActivity;
import com.example.Movie.R;

import java.io.InputStream;
import java.net.URL;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    Context mContext;
    List<Product> lstpro;
    public ProductAdapter(Context context, List<Product> lstpro){
        this.mContext =context;
        this.lstpro=lstpro;
    }


    @NonNull
    @Override
    public ProductAdapter.ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View v  =LayoutInflater.from(parent.getContext()).inflate(R.layout.product_cardview,parent,false);
    return new ProductViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, final int position) {

        holder.produtname.setText(lstpro.get(position).getProductname());
        holder.productrate.setText(String.valueOf(lstpro.get(position).getRate()));
        String imgPath = url.BASE_URL + "uploads/" + lstpro.get(position).getProductimg();
        StrictMode();
        try {
            URL url=new URL(imgPath);
            holder.productimg.setImageBitmap(BitmapFactory.decodeStream((InputStream) url.getContent()));
        } catch (Exception e) {
        }
        holder.getView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, ProductDetailedActivity.class);
                intent.putExtra("product_image",lstpro.get(position).getProductimg());
                intent.putExtra("product_name",lstpro.get(position).getProductname());
                intent.putExtra("product_desc",lstpro.get(position).getProductdesc());
                intent.putExtra("product_rate",lstpro.get(position).getRate());
                ((DashboardActivity) mContext).startActivity(intent);


            }
        });

    }
    private void StrictMode() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }

    @Override
    public int getItemCount() {
        return lstpro.size();
    }

  public class ProductViewHolder extends RecyclerView.ViewHolder {
    CircleImageView productimg;
    TextView produtname,productrate;
      View view;

      public ProductViewHolder(@NonNull View itemView) {
          super(itemView);
          this.view = itemView;
          produtname=itemView.findViewById(R.id.product_name_id);
          productrate=itemView.findViewById(R.id.product_rate_id);
          productimg=itemView.findViewById(R.id.product_img_id);

      }
      public View getView(){
          return view;
      }
  }
}
