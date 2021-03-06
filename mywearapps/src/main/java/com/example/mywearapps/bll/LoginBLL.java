package com.example.mywearapps.bll;


import com.example.mywearapps.API.LoginAPI;
import com.example.mywearapps.URL.url;
import com.example.mywearapps.serverresponse.SignUpResponse;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class LoginBLL {
    boolean isSuccess = false;
    public boolean checkUser(String username, String password) {
        LoginAPI api = url.getInstance().create(LoginAPI.class);
        Call<SignUpResponse> usersCall = api.checkUser(username, password);

        try {
            Response<SignUpResponse> loginResponse = usersCall.execute();
            if(loginResponse.code()==200)
            {

                url.token += loginResponse.body().getToken();
                // Url.Cookie = imageResponseResponse.headers().get("Set-Cookie");
                isSuccess = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return isSuccess;

    }
}
