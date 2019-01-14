package com.example.piotrkonwa.planuz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.piotrkonwa.planuz.pojo.ApiService;
import com.example.piotrkonwa.planuz.pojo.DataBody;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlanActivity extends AppCompatActivity {


    private static final String CLASS_TAG = "PlanActivity";    // tag, który jest wykorzystany do logowania
    ListView listView;
    PlanAdapter planAdapter;
    ArrayList<DataBody> dataBody = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan);
        try {
            new ApiService().getClientList(new Callback<DataBody>() {

                @Override
                public void onResponse(Call<DataBody> call, Response<DataBody> response) {
                    Log.d(CLASS_TAG, "onResponse: response..." + response);

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
        planAdapter = new PlanAdapter(getApplicationContext(), dataBody);
        listView = (ListView) findViewById(R.id.listView_plan_monday);
        listView.setAdapter(planAdapter);
    }
}
