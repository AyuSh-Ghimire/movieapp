package com.example.mywearapps;

import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class WearActivity extends WearableActivity {

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
                Intent i = new Intent(WearActivity.this,DashboardActivity.class);
                startActivity(i);
                finish();


            }
        });
    }


}
