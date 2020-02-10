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
    CartAdapter a = this;

    public CartAdapter(Context context, List<CartModel> cartModels) {
        this.context = context;
        this.cartModels = cartModels;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(context).inflate(R.layout.activity_cart,parent,false);

        return new CartViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder cartViewHolder, int position) {
        final CartModel model = cartModels.get(position);
        cartViewHolder.img_product.setImageResource(productList.get(position).getProductimg());
        cartViewHolder.txt_productname.setText(cartModels.get(position).getProductname());
        cartViewHolder.txt_productdesc.setText(cartModels.get(position).getProductdesc());
        cartViewHolder.txt_productrate.setText(new StringBuilder("Rs").append(cartModels.get(position).getRate()));
        cartViewHolder.txtquantity.setNumber(String.valueOf(cartModels.get(position).getQuantity()));
//        holder.txtquantity.setOnValueChangeListener(new ElegantNumberButton.OnValueChangeListener() {
//            @Override
//            public void onValueChange(ElegantNumberButton view, int oldValue, int newValue) {
//                Product cart= productList.get(position);
//                cart.quantity= newValue;
//                Common.cartRepository.updateCart(cart);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return cartModels.size();
    }

    public class CartViewHolder extends RecyclerView.ViewHolder{
        ImageView img_product;
        TextView txt_productname, txt_productdesc,txt_productrate;
        ElegantNumberButton txtquantity;

        public CartViewHolder(@NonNull View cartView) {
            super(cartView);

            img_product=(ImageView)cartView.findViewById(R.id.cartimgproduct);
            txt_productname=(TextView)cartView.findViewById(R.id.txtcproname);
            txt_productdesc=(TextView)cartView.findViewById(R.id.txtcprodesc);
            txt_productrate=(TextView)cartView.findViewById(R.id.txtcprate);
            txtquantity=(ElegantNumberButton) cartView.findViewById(R.id.txtquantity);

        }
    }
}
