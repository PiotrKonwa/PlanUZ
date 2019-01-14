package com.example.piotrkonwa.planuz.pojo;

import retrofit2.Call;
import retrofit2.Callback;

public class ApiService {

    public void getClientList(Callback<DataBody> callback) {

        ApiClient service = ApiClientBuilder.getMGClient();

        Call<DataBody> result = service.getData();

        result.enqueue(callback);

    }
}
