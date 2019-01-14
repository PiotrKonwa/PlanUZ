package com.example.piotrkonwa.planuz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.piotrkonwa.planuz.pojo.DataBody;
import com.example.piotrkonwa.planuz.pojo.MyWebService;

import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PlanActivity extends AppCompatActivity {


    private static final String CLASS_TAG = "PlanActivity";    // tag, który jest wykorzystany do logowania
    Retrofit retrofit;  // adapter REST z Retrofita
    MyWebService service;   // nasz interfejs
    ListView listView;
    ArrayList<DataBody> dataBody = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan);

        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        okHttpClientBuilder.addInterceptor(logging);

        // ustawiamy wybrane parametry adaptera
        retrofit = new Retrofit.Builder()
                // adres API
                .baseUrl("https://projektplanuz.000webhostapp.com")
                .client(okHttpClientBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // tworzymy klienta
        service = retrofit.create(MyWebService.class);

        try {
            service.getData().enqueue(new Callback<DataBody>() {

                @Override
                public void onResponse(Call<DataBody> call, Response<DataBody> response) {
                    Log.d(CLASS_TAG, "onResponse: response..."+response);

                    dataBody = response.body().getResults();
                    createListView();
                }

                @Override
                public void onFailure(Call<DataBody> call, Throwable t) {
                    Log.d(CLASS_TAG, t.getLocalizedMessage());
                }
            });

        } catch (Exception e) {
            Log.d(CLASS_TAG, e.toString());
        }
    }

    public  void createListView(){
        PlanAdapter planAdapter = new PlanAdapter(getApplicationContext(), dataBody);
        listView = (ListView) findViewById(R.id.listView_plan_monday);
        listView.setAdapter(planAdapter);
    }
}
