package com.example.ecosmetics;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toolbar;

import com.example.ecosmetics.Fragment.DashboardFragment;

public class DashboardActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
   private Toolbar toolbar;
    private FrameLayout frameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        getSupportActionBar().hide();


            mDrawerLayout= (DrawerLayout) findViewById(R.id.drawyerlayout);

            //Toolbar toolbar = findViewById(R.id.app_cart);
            mToggle= new ActionBarDrawerToggle(this, mDrawerLayout,R.string.open,R.string.close);

            mDrawerLayout.addDrawerListener(mToggle);
            mToggle.syncState();
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
