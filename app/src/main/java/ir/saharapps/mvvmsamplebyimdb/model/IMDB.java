package ir.saharapps.mvvmsamplebyimdb.model;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface IMDB {

    @GET("SearchMovie/k_h652qt5l/{MovieName}/")
    Call<JsonObject> getNameImage(@Path("MovieName") String movieName);

    @GET("Ratings/k_h652qt5l/{MovieId}/")
    Call<JsonObject> getMovieDetail(@Path("MovieId") String movieId);
}
