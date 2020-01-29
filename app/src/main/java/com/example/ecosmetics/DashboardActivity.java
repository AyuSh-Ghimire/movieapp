package com.example.ecosmetics;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.ecosmetics.API.CategoryAPI;
import com.example.ecosmetics.Fragment.DashboardFragment;
import com.example.ecosmetics.Model.Category;
import com.example.ecosmetics.Model.Product;
import com.example.ecosmetics.URL.url;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashboardActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private Toolbar toolbar;
    private FrameLayout frameLayout;
    public static List<Category> lstcat= new ArrayList<>();
    public static List<Product> lstpro =new ArrayList<>();
    private static final String TAG = "DashboardActivity";

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

//            lstcat=new ArrayList<>();
//            lstcat.add(new Category(R.drawable.serum,"serum"));
//            lstcat.add(new Category(R.drawable.moist,"moisturizer"));
//            lstcat.add(new Category(R.drawable.cleanser,"cleanser"));
//            lstcat.add(new Category(R.drawable.s,"sunscreen"));

        CategoryAPI categoryAPI = url.getInstance().create(CategoryAPI.class);
        Call<List<Category>> categoryCall = categoryAPI.getAllCategory();
        categoryCall.enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
                lstcat = response.body();
                Toast.makeText(DashboardActivity.this, "Error:"+lstcat, Toast.LENGTH_SHORT).show();
                Log.e(TAG, "onResponse: "+lstcat);

            }

            @Override
            public void onFailure(Call<List<Category>> call, Throwable t) {
                Toast.makeText(DashboardActivity.this, "Error:"+t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                 }

        });

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
