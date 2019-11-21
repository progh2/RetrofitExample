package kr.hs.emirim.progh2.retrofitexample;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Main2Activity extends AppCompatActivity {
    final String TAG = "레트로핏";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //ServiceGenerator.changeApiBaseUrl("https://api.github.com/");
        GithubService service = ServiceGenerator.createService(GithubService.class);
//        Call<List<GitHubRepo>> call =
//                service.reposForUser("progh2");
        Call<Meal> call = service.mealsToday();
        call.enqueue(new Callback<Meal>() {

            @Override
            public void onResponse(Call<Meal> call, Response<Meal> response) {
                if(response.isSuccessful()){
                    Meal meal = response.body();
                   // for(Meal meal : response.body()) {
                        Log.d(TAG, "Repo " + meal.get조식() + " (ID :"
                                        + meal.get중식() + ")");
                   // }
                }else{
                        Log.e(TAG, "Request failed: " +"Cannot request Github repositories");
                }
            }

            @Override
            public void onFailure(Call<Meal> call, Throwable t) {
                Log.e(TAG, "Error fetching repos" + t.getMessage());
            }
        });
    }
}
