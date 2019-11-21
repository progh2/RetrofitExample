package kr.hs.emirim.progh2.retrofitexample;

import android.text.TextUtils;


import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {
    //private static final String BASE_URL = "https://api.github.com/";
    private static final String BASE_URL = "https://hambob.emirim.kr/";

    private static Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = builder.build();

    // for logging
    private static HttpLoggingInterceptor logging =
            new HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY);

    private static OkHttpClient.Builder httpClient =
            new OkHttpClient.Builder();

    public static <S> S createService(
            Class<S> serviceClass) {

        if(!httpClient.interceptors().contains(logging)){
            httpClient.addInterceptor(logging);
            builder.client(httpClient.build());
            retrofit = builder.build();
        }
        return retrofit.create(serviceClass);
    }

    public static void changeApiBaseUrl(String s) {
        //
    }
}
