package com.example.ecosmetics;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ecosmetics.Fragment.CartFragment;
import com.example.ecosmetics.Model.Product;
import com.example.ecosmetics.URL.url;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class CartActivity extends AppCompatActivity {

    private FrameLayout frameLayout;
    String product_name;
    String product_rate;
    String product_image;
    ImageView product_img;
    String quantity;
    private FrameLayout cframelayout;
    private TextView textViewName,textViewRate,textViewQuantity;
    RecyclerView.LayoutManager layoutManager;
    public static List<Product> lstproduct = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        cframelayout=findViewById(R.id.cartframelayout);
        product_img = findViewById(R.id.cartimgproduct);
        textViewName= findViewById(R.id.txtcproname);
        textViewRate = findViewById(R.id.txtcprate);
        textViewQuantity = findViewById(R.id.txtquantity);
        setFragment(new CartFragment());

        Bundle extras =getIntent().getExtras();
        if(extras!=null){
            product_image=extras.getString("product_img");
            product_rate=extras.getString("textViewRate");
            product_name=extras.getString("textViewName");
            textViewName.setText(product_name);
            textViewRate.setText(product_rate);
            textViewQuantity.setText(quantity);
            quantity=extras.getString("quantity");
            String imgPath = url.BASE_URL + "uploads/" + product_image;
            try {
                URL url=new URL(imgPath);
                product_img.setImageBitmap(BitmapFactory.decodeStream((InputStream) url.getContent()));
            } catch (Exception e) {
            }
        }
    }

    private void setFragment(CartFragment cartFragment) {
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(cframelayout.getId(),cartFragment);
        fragmentTransaction.commit();
    }


}
