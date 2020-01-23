package com.example.ecosmetics;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ecosmetics.Model.User;
import com.example.ecosmetics.URL.url;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {
    private Button btnlogin,btnloginwithfb,btnsignup;
    private EditText username,password;
    private TextView forgetpassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        btnlogin=findViewById(R.id.btnlogin);
        btnloginwithfb=findViewById(R.id.btnLoginWithFb);
        btnsignup=findViewById(R.id.btnSignup);
        forgetpassword=findViewById(R.id.txtforgetpassword);

        btnlogin.setOnClickListener(this);
        btnloginwithfb.setOnClickListener(this);
        btnsignup.setOnClickListener(this);
        forgetpassword.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.txtsignup:
                openSignUp();
                break;
            case R.id.txtforgetpassword:
                Toast.makeText(this, "Go to Change Password", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnlogin:
                login();
                break;
            case R.id.btnLoginWithFb:
                Toast.makeText(this, "Login with facebook", Toast.LENGTH_SHORT).show();
                break;
        }
    }
    public void login(){
    User userlogin= new User(username.getText().toString(), password.getText().toString());
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
