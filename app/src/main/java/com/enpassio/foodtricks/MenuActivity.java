package com.enpassio.foodtricks;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.enpassio.foodtricks.api.APIClient;
import com.enpassio.foodtricks.api.APIInterface;
import com.enpassio.foodtricks.model.MenuList;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MenuActivity extends AppCompatActivity {

    TextView responseText;
    APIInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        responseText = (TextView) findViewById(R.id.text);
        apiInterface = APIClient.getClient().create(APIInterface.class);


        /**
         GET List Resources
         **/
        Call<List<MenuList>> call = apiInterface.doGetListResources();
        call.enqueue(new Callback<List<MenuList>>() {
            @Override
            public void onResponse(Call<List<MenuList>> call, Response<List<MenuList>> response) {

                Log.v("my_tag", "onResponse called :" + call.request().url());

                Log.d("my_tag", response.code() + "");

                String displayResponse = "";

                List<MenuList> resource = response.body();
                for (MenuList menuList : resource){
                    String name = menuList.getName();
                    displayResponse += name + "\n";
                }

                responseText.setText(displayResponse);

            }

            @Override
            public void onFailure(Call<List<MenuList>> call, Throwable t) {
                Log.i("my_tag ", t.getMessage());
                Log.v("my_tag", "" + "OnFailure called : "+call.request().url());
                call.clone().enqueue(this);
            }
        });
    }
}
