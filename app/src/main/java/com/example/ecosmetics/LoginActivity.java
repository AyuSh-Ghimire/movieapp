package com.example.ecosmetics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ecosmetics.API.LoginAPI;
import com.example.ecosmetics.Model.LoginResponse;
import com.example.ecosmetics.Model.User;
import com.example.ecosmetics.URL.url;
import com.example.ecosmetics.bll.LoginBLL;
import com.example.ecosmetics.strictmode.StrictModeClass;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {
    private Button btnlogin,btnloginwithfb,btnsignup;
    private EditText etusername,etpassword;
    private TextView forgetpassword;
    Vibrator vibrator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etusername=findViewById(R.id.username);
        etpassword=findViewById(R.id.password);
        btnlogin=findViewById(R.id.btnlogin);
        btnloginwithfb=findViewById(R.id.btnLoginWithFb);
        btnsignup=findViewById(R.id.btnSignup);
        forgetpassword=findViewById(R.id.txtforgetpassword);


        btnloginwithfb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this, "Login with facebook", Toast.LENGTH_SHORT).show();
            }
        });
        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openSignup = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(openSignup);
            }
        });
        forgetpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openForgetpwd = new Intent(LoginActivity.this, ForgetPasswordActivity.class);
                startActivity(openForgetpwd);
            }
        });


        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    private void login(){

        String username = etusername.getText().toString();
        String password = etpassword.getText().toString();

        LoginBLL loginBLL = new LoginBLL();
        StrictModeClass.StrictMode();
        if (loginBLL.checkUser(username, password)) {
            Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(this, "Either username or password is incorrect", Toast.LENGTH_SHORT).show();
            etusername.requestFocus();
        }
    }

}
