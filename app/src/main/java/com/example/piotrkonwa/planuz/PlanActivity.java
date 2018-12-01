package com.example.piotrkonwa.planuz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class PlanActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan);

        listView = (ListView)findViewById(R.id.listView_plan_monday);
    }
    @Override
    protected void onResume() {
        super.onResume();
        listView.setAdapter(null);

//        PlanAdapter planAdapter = new PlanAdapter(this, R.layout.item_plan);
//        listView.setAdapter(planAdapter);
    }
}
