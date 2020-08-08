package com.readmycourse.android.apiclient.ApiLayer.Abstract;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

public interface IApplicationRetrofitInterface {
    OkHttpClient getUnsafeOkHttpClient();
    Retrofit getRetrofitClient();
    void setBaseUrl(String url);

}
