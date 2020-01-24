package com.example.ecosmetics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ecosmetics.API.LoginAPI;
import com.example.ecosmetics.Model.User;
import com.example.ecosmetics.URL.url;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignupActivity extends AppCompatActivity {
    private EditText etfirstname, etlastname, etaddress, etphoneno, etemail, etusername, etpassword, etconfirmpassword;
    private Button btnsignup;
    private TextView txtlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        etfirstname = findViewById(R.id.firstname);
        etlastname = findViewById(R.id.lastname);
        etaddress = findViewById(R.id.address);
        etphoneno = findViewById(R.id.phoneno);
        etemail = findViewById(R.id.email);
        etusername = findViewById(R.id.username);
        etpassword = findViewById(R.id.password);
        etconfirmpassword = findViewById(R.id.confirmpassword);
        btnsignup = findViewById(R.id.btnsignup);
        txtlogin = findViewById(R.id.txtlogin);
        txtlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(i);

            }
        });

        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etpassword.getText().toString().equals(etconfirmpassword.getText().toString())) {
                    if (validate()) {
                        signUp();
                    }
                } else {
                    Toast.makeText(SignupActivity.this, "Password does not match", Toast.LENGTH_SHORT).show();
                    etpassword.requestFocus();
                    return;
                }
            }
        });
    }


    private void signUp() {
        String Firstname = etfirstname.getText().toString();
        String Lastname = etlastname.getText().toString();
        String Address = etaddress.getText().toString();
        String Phoneno = etphoneno.getText().toString();
        String Email = etemail.getText().toString();
        String Username = etusername.getText().toString();
        String Password = etpassword.getText().toString();


           User regUser = new User(Firstname,Lastname,Address,Phoneno,Email,Username,Password);
                LoginAPI loginAPI = url.getInstance().create(LoginAPI.class);
                Call<Void> voidCall = loginAPI.register(regUser);

                voidCall.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                    if(!response.isSuccessful()){
                        Toast.makeText(SignupActivity.this, "User not registered" + response.code(), Toast.LENGTH_SHORT).show();
                        return;
                    }
                    Toast.makeText(SignupActivity.this,"Succesfully registered", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                    Toast.makeText(SignupActivity.this, "Error found" + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }


    private boolean validate() {
        boolean status=true;
        if (etusername.getText().toString().length() < 6) {
            etusername.setError("Minimum 6 character");
            status=false;
        }
        return status;
    }


    }

