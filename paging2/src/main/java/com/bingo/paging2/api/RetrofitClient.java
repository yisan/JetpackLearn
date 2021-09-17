
package com.bingo.paging2.api;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ing on 2021/9/16
 */
public class RetrofitClient {
    private static final String BASE_URL = "http://10.200.32.153:8080/bingo/";
    private static RetrofitClient mInstance;
    private final Retrofit retrofit;

    private RetrofitClient() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(getClient())
                .build();
    }

    public static synchronized RetrofitClient getInstance() {
        if (mInstance == null) {
            mInstance = new RetrofitClient();
        }
        return mInstance;
    }

    private OkHttpClient getClient() {
        return new OkHttpClient.Builder().build();
    }

    public Api getApi() {
        return retrofit.create(Api.class);
    }
}
