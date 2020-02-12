package com.example.ecosmetics.Fragment;


import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.ecosmetics.API.CartAPI;
import com.example.ecosmetics.Adapter.CartAdapter;
import com.example.ecosmetics.Model.CartModel;
import com.example.ecosmetics.R;
import com.example.ecosmetics.URL.url;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.MODE_PRIVATE;

/**
 * A simple {@link Fragment} subclass.
 */
public class CartFragment extends Fragment {
    RecyclerView recycler_cart;
    Button btnpro_order,btnback;


    public CartFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_cart, container, false);

        recycler_cart= view.findViewById(R.id.recycart);
        recycler_cart.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
        recycler_cart.setHasFixedSize(true);
        btnback=view.findViewById(R.id.btnback);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btnpro_order=view.findViewById(R.id.btnplaceorder);
        getCart();
        return (view);
    }

    private void getCart() {
        CartAPI api= url.getInstance().create(CartAPI.class);

        SharedPreferences sharedPreferences=this.getActivity().getSharedPreferences("User",MODE_PRIVATE);
        String uid = sharedPreferences.getString("id","");
        Call<List<CartModel>> listCall=api.getbyid(url.token);

        listCall.enqueue(new Callback<List<CartModel>>() {
            @Override
            public void onResponse(Call<List<CartModel>> call, Response<List<CartModel>> response) {
                if (!response.isSuccessful()){
                    Toast.makeText(getView().getContext(), response.toString(), Toast.LENGTH_SHORT).show();
                    return;
                }

                final List<CartModel> cartModels=response.body();
                CartAdapter adapter = new CartAdapter(getView().getContext(),cartModels);

                recycler_cart.setAdapter(adapter);
                recycler_cart.setLayoutManager(new LinearLayoutManager(getView().getContext()));
            }

            @Override
            public void onFailure(Call<List<CartModel>> call, Throwable t) {
                Toast.makeText(getView().getContext(),"error"+t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
