package com.example.ecosmetics.Fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ecosmetics.Adapter.CategoryAdapter;
import com.example.ecosmetics.R;

import static com.example.ecosmetics.DashboardActivity.lstcat;

/**
 * A simple {@link Fragment} subclass.
 */
public class DashboardFragment extends Fragment {


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

        return view;
    }

}
