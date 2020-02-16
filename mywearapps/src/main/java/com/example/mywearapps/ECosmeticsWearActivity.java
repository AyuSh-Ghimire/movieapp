package com.example.mywearapps;

import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.wearable.activity.WearableActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mywearapps.bll.LoginBLL;
import com.example.mywearapps.strictmode.StrictModeClass;

public class ECosmeticsWearActivity extends WearableActivity {

    private EditText etusername,etpassword;
    private Button btnlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ecosmetics_wear);

        etusername = findViewById(R.id.username);
        etpassword = findViewById(R.id.password);
        btnlogin = findViewById(R.id.btnlogin);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ECosmeticsWearActivity.this,DashboardActivity.class);
                startActivity(i);
                finish();


            }
        });
    }


}
