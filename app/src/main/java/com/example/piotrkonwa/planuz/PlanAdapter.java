package com.example.piotrkonwa.planuz;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.piotrkonwa.planuz.pojo.DataBody;
import com.google.gson.internal.LinkedTreeMap;

import java.util.ArrayList;

public class PlanAdapter extends BaseAdapter {


    Context context;
    ArrayList<DataBody> plan;

    public PlanAdapter(Context context, ArrayList<DataBody> plan) {
        this.context = context;
        this.plan = plan;
    }

    @Override
    public int getCount() {
        return plan.size();
    }

    @Override
    public DataBody getItem(int i) {
        return this.plan.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        if(view == null)
        {
            view = LayoutInflater.from(context).inflate(R.layout.item_plan,viewGroup,false);
        }

        TextView pg = (TextView) view.findViewById(R.id.list_plan_pg);
        TextView przedmiot = (TextView) view.findViewById(R.id.list_plan_przedmiot);
        TextView rz = (TextView) view.findViewById(R.id.list_plan_rz);
        TextView nauczyciel = (TextView) view.findViewById(R.id.list_plan_nauczyciel);
        TextView nrSali = (TextView) view.findViewById(R.id.list_plan_sala);
        TextView godzinaOd = (TextView) view.findViewById(R.id.list_plan_od);
        TextView godzinaDo = (TextView) view.findViewById(R.id.list_plan_do);
        TextView uwagi = (TextView) view.findViewById(R.id.list_plan_uwagi);


        Object getrow = this.plan.get(i);
        LinkedTreeMap<Object,Object> rowmap = (LinkedTreeMap) getrow;
        String PG = rowmap.get("PG").toString();
        String Przedmiot = rowmap.get("Przedmiot").toString();
        String RZ = rowmap.get("RZ").toString();
        String Nauczyciel = rowmap.get("Nauczyciel").toString();
        String Nr_sali = rowmap.get("Nr_sali").toString();
        String Godz_rozp = rowmap.get("Godz_rozp").toString();
        String Godz_zak = rowmap.get("Godz_Zak").toString();
        String Uwagi = rowmap.get("Uwagi").toString();

        pg.setText(PG);
        przedmiot.setText(Przedmiot);
        rz.setText(RZ);
        nauczyciel.setText(Nauczyciel);
        nrSali.setText(Nr_sali);
        godzinaOd.setText(Godz_rozp);
        godzinaDo.setText(Godz_zak);
        uwagi.setText(Uwagi);

        return view;
    }
}
