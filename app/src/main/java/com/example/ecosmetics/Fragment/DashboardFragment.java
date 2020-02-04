package com.example.ecosmetics.Fragment;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.ecosmetics.API.CategoryAPI;
import com.example.ecosmetics.Adapter.CategoryAdapter;
import com.example.ecosmetics.Adapter.ProductAdapter;
import com.example.ecosmetics.DashboardActivity;
import com.example.ecosmetics.Model.Category;
import com.example.ecosmetics.R;
import com.example.ecosmetics.URL.url;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.ecosmetics.DashboardActivity.lstcat;
import static com.example.ecosmetics.DashboardActivity.lstpro;

/**
 * A simple {@link Fragment} subclass.
 */
public class DashboardFragment extends Fragment {

    Context context;
    String TAG="DashboardFragment";

    public DashboardFragment() {
        // Required empty public constructor
    }
    private RecyclerView procat_recyclerview, rv_product;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view = inflater.inflate(R.layout.fragment_dashboard, container, false);
       procat_recyclerview=view.findViewById(R.id.procat_recyclerview);
       rv_product=view.findViewById(R.id.pro_recyclerview);

        CategoryAdapter categoryAdapter=new CategoryAdapter(getContext(),lstcat);
        procat_recyclerview.setAdapter(categoryAdapter);
        procat_recyclerview.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));

        ProductAdapter productAdapter =new ProductAdapter(getContext(),lstpro);
        rv_product.setAdapter(productAdapter);
        rv_product.setLayoutManager(new GridLayoutManager(getContext(),3));

        CategoryAPI categoryAPI= url.getInstance().create(CategoryAPI.class);
        Call<List<Category>> categoryCall = categoryAPI.getAllCategory();

        categoryCall.enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
                lstcat = response.body();
                CategoryAdapter ca = new CategoryAdapter(context,lstcat);
                procat_recyclerview.setAdapter(ca);

            }

            @Override
            public void onFailure(Call<List<Category>> call, Throwable t) {
                Toast.makeText(context, "fail"+t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                Log.e(TAG, "onFailure: "+t.getLocalizedMessage());

            }
        });

        return view;
    }

}
