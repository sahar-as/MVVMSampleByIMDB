package ir.saharapps.mvvmsamplebyimdb.model;

import android.util.Log;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GetMovieInfo {
    private static final String TAG = "GetMovieInfo";

    String baseUrl = "https://imdb-api.com/en/API/";

    public interface ResultListener{
        void nameResult(JsonArray jsonArray);
        void detailResult(JsonObject jsonObject);
    }
    public void getMovieName(String name, ResultListener resultListener){
        OkHttpClient.Builder okHttpBuilder = new OkHttpClient.Builder();
        Retrofit.Builder retrofitBuilder = new Retrofit.Builder().baseUrl(baseUrl);
        Retrofit retrofit = retrofitBuilder.client(okHttpBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        IMDB IMDBApi = retrofit.create(IMDB.class);
        Call<JsonObject> call = IMDBApi.getNameImage(name);
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if(response.isSuccessful()){
                    resultListener.nameResult(response.body().getAsJsonArray("results"));
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
            }
        });
    }

    public void getMovieDetail(String movieId, ResultListener resultListener){
        OkHttpClient.Builder okHttpBuilder = new OkHttpClient.Builder();
        Retrofit.Builder retrofitBuilder = new Retrofit.Builder().baseUrl(baseUrl);
        Retrofit retrofit = retrofitBuilder.client(okHttpBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        IMDB IMDBApi = retrofit.create(IMDB.class);
        Call<JsonObject> call = IMDBApi.getMovieDetail(movieId);
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.isSuccessful()){
                    resultListener.detailResult(response.body());
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {

            }
        });
    }
}


//https://imdb-api.com/en/API/SearchMovie/k_h652qt5l/inception 2010
//https://imdb-api.com/en/API/Ratings/k_h652qt5l/tt1375666