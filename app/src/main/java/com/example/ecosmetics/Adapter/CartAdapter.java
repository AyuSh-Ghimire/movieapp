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

import java.io.InputStream;
import java.net.URL;
import java.util.List;

import static com.example.ecosmetics.DashboardActivity.lstpro;
import static com.example.ecosmetics.strictmode.StrictModeClass.StrictMode;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {
    CartAdapter a = this;
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
    cartViewHolder.txt_productname.setText(lstpro.get(position).getProductname());
    cartViewHolder.txt_productdesc.setText(lstpro.get(position).getProductdesc());
    cartViewHolder.txt_productrate.setText(new StringBuilder("Rs").append(lstpro.get(position).getRate()));
    cartViewHolder.txtquantity.setNumber(String.valueOf(lstpro.get(position).getQuantity()));
        String imgPath = url.BASE_URL + "uploads/" + lstpro.get(position).getProductimg();
        StrictMode();
        try {
            URL url=new URL(imgPath);
            cartViewHolder.img_product.setImageBitmap(BitmapFactory.decodeStream((InputStream) url.getContent()));
        } catch (Exception e) {
        }
    }

    @Override
    public int getItemCount() {
        return cartModels.size();
    }
    private void StrictMode() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }

    public class CartViewHolder extends RecyclerView.ViewHolder{
        ImageView img_product;
        TextView txt_productname, txt_productdesc,txt_productrate;
        ElegantNumberButton txtquantity;
        View view;

        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
            img_product=(ImageView)itemView.findViewById(R.id.cartimgproduct);
            txt_productname=(TextView)itemView.findViewById(R.id.txtcproname);
            txt_productdesc=(TextView)itemView.findViewById(R.id.txtcprodesc);
            txt_productrate=(TextView)itemView.findViewById(R.id.txtcprate);
            txtquantity=(ElegantNumberButton) itemView.findViewById(R.id.txtquantity);

        }
        public View getView(){
            return view;
        }
    }
}
