package ir.saharapps.mvvmsamplebyimdb.viewModel;

import android.util.Log;

import androidx.databinding.ObservableField;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ir.saharapps.mvvmsamplebyimdb.model.GetMovieInfo;
import ir.saharapps.mvvmsamplebyimdb.model.Movie;

public class AppViewModel extends ViewModel {
    private static final String TAG = "AppViewModel";

    public ObservableField<String> cityName =  new ObservableField<>("");
    public MutableLiveData<List<Movie>> mutableLiveDataMovieList = new MutableLiveData<>();

    GetMovieInfo mGetMovieInfo = new GetMovieInfo();
    public void getMovies(){
        mGetMovieInfo.getMovieName(cityName.get(), new GetMovieInfo.ResultListener() {
            @Override
            public void nameResult(JsonArray jsonArray) {
                List<Movie> movieList = new ArrayList<>();
                for(int i=0; i<jsonArray.size() ; i++){
                    JsonObject oneMovie = (JsonObject) jsonArray.get(i);
                    List list = Arrays.asList(oneMovie.get("image").getAsString().split("/"));
                    String imageUrl = "https://m.media-amazon.com/images/M/" + list.get(list.size()-1).toString();
                    Movie movie = new Movie(oneMovie.get("id").getAsString()
                            ,oneMovie.get("title").getAsString(), imageUrl);
                    movieList.add(movie);
                }
                mutableLiveDataMovieList.setValue(movieList);
            }
            @Override
            public void detailResult(JsonObject jsonObject) {
                //not thing important here
            }
        });
    }

    public void getMovieDetail(String movieId){
        mGetMovieInfo.getMovieDetail(movieId, new GetMovieInfo.ResultListener() {
            @Override
            public void nameResult(JsonArray jsonArray) {
                //not thing important here
            }

            @Override
            public void detailResult(JsonObject jsonObject) {
                String type = jsonObject.get("type").getAsString();
                String year= jsonObject.get("year").getAsString();
                String imdb = jsonObject.get("imDb").getAsString();
                Log.d(TAG, "nameResult: 00000000000 " + type + "/" + year + "/" + imdb);
            }
        });
    }
}
