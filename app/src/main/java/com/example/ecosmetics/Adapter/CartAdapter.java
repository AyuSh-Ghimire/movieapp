package com.example.ecosmetics.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.example.ecosmetics.Model.CartModel;
import com.example.ecosmetics.Model.Product;
import com.example.ecosmetics.R;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {
    Context context;
    List<CartModel> cartModels;

    public CartAdapter(Context context, List<CartModel> cartModels) {
        this.context = context;
        this.cartModels = cartModels;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.activity_cart,parent,false);

        return new CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder cartViewHolder, int position) {

        final CartModel model = cartModels.get(position);
    cartViewHolder.txt_productname.setText(cartModels.get(position).getProductname());
    cartViewHolder.txt_productdesc.setText(cartModels.get(position).getProductdesc());
    cartViewHolder.txt_productrate.setText(new StringBuilder("Rs").append(cartModels.get(position).getRate()));
    cartViewHolder.txtquantity.setNumber(String.valueOf(cartModels.get(position).getQuantity()));

    }

    @Override
    public int getItemCount() {
        return cartModels.size();
    }

    public class CartViewHolder extends RecyclerView.ViewHolder{
        ImageView img_product;
        TextView txt_productname, txt_productdesc,txt_productrate;
        ElegantNumberButton txtquantity;

        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
            img_product=(ImageView)itemView.findViewById(R.id.cartimgproduct);
            txt_productname=(TextView)itemView.findViewById(R.id.txtcproname);
            txt_productdesc=(TextView)itemView.findViewById(R.id.txtcprodesc);
            txt_productrate=(TextView)itemView.findViewById(R.id.txtcprate);
            txtquantity=(ElegantNumberButton) itemView.findViewById(R.id.txtquantity);

        }
    }
}
