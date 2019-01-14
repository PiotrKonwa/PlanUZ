package com.example.piotrkonwa.planuz.pojo;


import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class DataBody{
//    @SerializedName("results")
    private ArrayList results;
    @SerializedName("PG")
    private String PG;
    @SerializedName("Przedmiot")
    private String Przedmiot;
    @SerializedName("RZ")
    private String RZ;
    @SerializedName("Nauczyciel")
    private String Nauczyciel;
    @SerializedName("Nr_sali")
    private String Nr_sali;
    @SerializedName("GodzRozp")
    private String GodzRozp;
    @SerializedName("GodzZak")
    private String GodzZak;
    @SerializedName("Uwagi")
    private String Uwagi;

//    public void setResults(ArrayList results) {
//        this.results = results;
//    }

    public void setPG(String PG) {
        this.PG = PG;
    }

    public void setPrzedmiot(String przedmiot) {
        Przedmiot = przedmiot;
    }

    public void setRZ(String RZ) {
        this.RZ = RZ;
    }

    public void setNauczyciel(String nauczyciel) {
        Nauczyciel = nauczyciel;
    }

    public void setNr_sali(String nr_sali) {
        Nr_sali = nr_sali;
    }

    public void setGodzRozp(String godzRozp) {
        GodzRozp = godzRozp;
    }

    public void setGodzZak(String godzZak) {
        GodzZak = godzZak;
    }

    public void setUwagi(String uwagi) {
        Uwagi = uwagi;
    }

    public ArrayList getResults(){
        results.add(getPG());
        results.add(getRZ());
        results.add(getPrzedmiot());
        results.add(getNauczyciel());
        results.add(getNr_sali());
        results.add(getGodzRozp());
        results.add(getGodzZak());
        results.add(getUwagi());
        return results;
    }

    public String getPG() {
        return PG;
    }

    public String getPrzedmiot() {
        return Przedmiot;
    }

    public String getRZ() {
        return RZ;
    }

    public String getNauczyciel() {
        return Nauczyciel;
    }

    public String getNr_sali() {
        return Nr_sali;
    }

    public String getGodzRozp() {
        return GodzRozp;
    }

    public String getGodzZak() {
        return GodzZak;
    }

    public String getUwagi() {
        return Uwagi;
    }

}