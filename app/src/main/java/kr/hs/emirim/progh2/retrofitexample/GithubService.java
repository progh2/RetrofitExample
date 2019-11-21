package kr.hs.emirim.progh2.retrofitexample;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GithubService {
    @GET("users/{user}/repos")
    Call<List<GitHubRepo>> reposForUser(@Path("user") String username);

    @GET("meal/")
    Call<Meal> mealsToday();
//
//    @GET("meals/{year}/{month}/{day}")
//    Call<List<Meal>> meals(@Path("year") int year, @Path("month") int month, @Path("day") int day );
}
