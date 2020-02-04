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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnlogin,btnloginwithfb,btnsignup;
    private EditText username,password;
    private TextView forgetpassword;
    Vibrator vibrator;


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
            case R.id.btnSignup:
                openSignUp();
                break;
            case R.id.txtforgetpassword:
               openForgetpwd();
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

        String uname = username.getText().toString();
        String pwd = password.getText().toString();

        LoginBLL loginBLL = new LoginBLL();
        StrictModeClass.StrictMode();
        if (loginBLL.checkUser(username, password)) {
            Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(this, "Either username or password is incorrect", Toast.LENGTH_SHORT).show();
            username.requestFocus();
        }
    }
//    User user= new User(username.getText().toString(), password.getText().toString());
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(url.BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        LoginAPI loginApi = retrofit.create(LoginAPI.class);
//        Call<LoginResponse> loginCall =loginApi.login(user);
//        loginCall.enqueue(new Callback<LoginResponse>() {
//            @Override
//            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
//                if(!response.isSuccessful()){
//                    Toast.makeText(LoginActivity.this, "Login Error", Toast.LENGTH_SHORT).show();
//                    vibrator=(Vibrator) getSystemService(VIBRATOR_SERVICE);
//                    //vibrate in ms
//                    vibrator.vibrate(50);
//                    return;
//                }
//                System.out.println(response.body().getToken());
//                openDashBoard();
//            }
//
//            @Override
//            public void onFailure(Call<LoginResponse> call, Throwable t) {
//                Toast.makeText(LoginActivity.this, "Error " + t.getLocalizedMessage() , Toast.LENGTH_SHORT).show();
//            }
//        });
    //}

    public void openDashBoard(){
        Intent openDash = new Intent(this, DashboardActivity.class);
        startActivity(openDash);
    }
    public void openSignUp(){
        Intent openSignup = new Intent(this, SignupActivity.class);
        startActivity(openSignup);
    }
    public void openForgetpwd(){
        Intent openForgetpwd = new Intent(this, ForgetPasswordActivity.class);
        startActivity(openForgetpwd);
    }
}
