package com.example.ecosmetics;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.ecosmetics.Fragment.DashboardFragment;
import com.example.ecosmetics.Model.Category;

import java.util.ArrayList;
import java.util.List;

public class DashboardActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private Toolbar toolbar;
    private FrameLayout frameLayout;
    public static List<Category> lstcat= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        getSupportActionBar().hide();


           mDrawerLayout= findViewById(R.id.drawyerlayout);
          // Toolbar toolbar = findViewById(R.id.app_cart);
           mToggle= new ActionBarDrawerToggle(this, mDrawerLayout,toolbar,R.string.open,R.string.close);

            mDrawerLayout.addDrawerListener(mToggle);
            mToggle.syncState();

            lstcat=new ArrayList<>();
            lstcat.add(new Category(R.drawable.bg,"logo"));
            lstcat.add(new Category(R.drawable.bg,"logo"));
            lstcat.add(new Category(R.drawable.bg,"logo"));

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
