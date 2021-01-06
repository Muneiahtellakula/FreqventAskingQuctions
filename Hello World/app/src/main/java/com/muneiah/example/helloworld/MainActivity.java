package com.muneiah.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.muneiah.example.helloworld.databinding.ActivityMainBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        EndpointInterface endpointInterface=RetrofitService.getRetrofit().create(EndpointInterface.class);
        Call<String> call=endpointInterface.getData();
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
              /*  Log.i("ding",response.body());
                Toast.makeText(MainActivity.this, ""+response.body(), Toast.LENGTH_SHORT).show();
            */
                try {
                    JSONObject rootObj=new JSONObject(response.body());
                    JSONArray rootAry=rootObj.getJSONArray("items");
                    JSONObject itemsObj=rootAry.getJSONObject(0);
                    JSONObject volumInfoObj=itemsObj.getJSONObject("volumeInfo");
                    String resultTitle=volumInfoObj.getString("title");
                    binding.textView.setText("Book Title is :"+resultTitle);


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }

}