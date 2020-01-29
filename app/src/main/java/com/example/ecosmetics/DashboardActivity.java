package com.example.ecosmetics;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.example.ecosmetics.Fragment.DashboardFragment;
import com.example.ecosmetics.Model.Category;
import com.example.ecosmetics.Model.Product;

import java.util.ArrayList;
import java.util.List;

public class DashboardActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private Toolbar toolbar;
    private FrameLayout frameLayout;
    public static List<Category> lstcat= new ArrayList<>();
    public static List<Product> lstpro =new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        getSupportActionBar().hide();


           mDrawerLayout= findViewById(R.id.drawyerlayout);
            Toolbar toolbar = findViewById(R.id.app_cart);
            toolbar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i=new Intent(DashboardActivity.this, CartActivity.class);
                    startActivity(i);
                }
            });
           mToggle= new ActionBarDrawerToggle(this, mDrawerLayout,toolbar,R.string.open,R.string.close);

            mDrawerLayout.addDrawerListener(mToggle);
            mToggle.syncState();

            lstcat=new ArrayList<>();
            lstcat.add(new Category(R.drawable.serum,"serum"));
            lstcat.add(new Category(R.drawable.moist,"moisturizer"));
            lstcat.add(new Category(R.drawable.cleanser,"cleanser"));
            lstcat.add(new Category(R.drawable.s,"sunscreen"));

            lstpro=new ArrayList<>();
            lstpro.add(new Product("Serum","Removes you blemishes",800,R.drawable.serum));
            lstpro.add(new Product("Moisturizer","makes your skin hydratate",800,R.drawable.moist));
            lstpro.add(new Product("Sunscreen","protects your skin from uv-rays",800,R.drawable.s));
            lstpro.add(new Product("Cleanser","Removes all your impurities",800,R.drawable.cleanser));
            lstpro.add(new Product("hairmask","Strong your hair",800,R.drawable.ordinary));
            lstpro.add(new Product("hairmask","Strong your hair",800,R.drawable.ordmoist));



            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            frameLayout=findViewById(R.id.framelayout);
            setFragment(new DashboardFragment());
        }

        public boolean onOptionsItemSelected(MenuItem item){
            if(mToggle.onOptionsItemSelected(item)){
                return true;
            }

            return super.onOptionsItemSelected(item);
    }

    public void setFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(frameLayout.getId(),fragment);
        fragmentTransaction.commit();

    }
}
