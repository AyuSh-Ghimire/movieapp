package com.example.ecosmetics.Adapter;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.StrictMode;
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
import com.example.ecosmetics.URL.url;
import com.google.android.gms.common.internal.service.Common;

import java.io.InputStream;
import java.net.URL;
import java.util.List;

import static com.example.ecosmetics.strictmode.StrictModeClass.StrictMode;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {
    Context context;
    List<CartModel> cartModels;
    CartAdapter a = this;
    public CartAdapter(Context context, List<CartModel> cartModels){
        this.context =context;
        this.cartModels=cartModels;
    }


    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(context).inflate(R.layout.activity_cart,parent,false);

        return new CartViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder cartViewHolder, int position) {

//        final CartModel model = cartModels.get(position);

//        cartViewHolder.txt_productname.setText(model.getProductcart());
//        cartViewHolder.txt_productrate.setText(new StringBuilder("Rs").append(model.getCproductrate()));
//        cartViewHolder.txtquantity.setNumber(String.valueOf(model.getQuantity()));
//        String imgPath = url.BASE_URL + "uploads/" + model.getCproductimg();
//          StrictMode();
//      try {
//            URL url=new URL(imgPath);
//            cartViewHolder.img_product.setImageBitmap(BitmapFactory.decodeStream((InputStream) url.getContent()));
//        } catch (Exception e) {
//        }
//        cartViewHolder.txtquantity.setOnValueChangeListener(new ElegantNumberButton.OnValueChangeListener() {
//            @Override
//            public void onValueChange(ElegantNumberButton view, int oldValue, int newValue) {
//                Product cart= model.get(position);
//                cart.getQuantity()= newValue;
//                Common.cartRepository.updateCart(cart);
//            }
//      });
    }
    private void StrictMode() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }

    @Override
    public int getItemCount() {
        return cartModels.size();
    }

    public class CartViewHolder extends RecyclerView.ViewHolder{
        ImageView img_product;
        TextView txt_productname,txt_productrate;
        ElegantNumberButton txtquantity;
        View view;

        public CartViewHolder(@NonNull View cartView) {
            super(cartView);
            this.view = cartView;

            img_product=(ImageView)cartView.findViewById(R.id.cartimgproduct);
            txt_productname=(TextView)cartView.findViewById(R.id.txtcproname);
            txt_productrate=(TextView)cartView.findViewById(R.id.txtcprate);
            txtquantity=(ElegantNumberButton) cartView.findViewById(R.id.txtquantity);

        }
        public View getView(){
            return view;
        }
    }
}
