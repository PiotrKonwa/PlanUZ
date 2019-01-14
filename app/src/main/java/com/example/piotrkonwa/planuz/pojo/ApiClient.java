package com.example.piotrkonwa.planuz.pojo;


import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiClient {
    @GET("/test_1.php") // deklarujemy endpoint oraz metodę
    Call<DataBody> getData();

//    @POST("/wsexample/") // deklarujemy endpoint, metodę oraz dane do wysłania
//    Call<DataBody> postData(@Body DataBody pBody);
}
