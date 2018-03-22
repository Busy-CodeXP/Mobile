package services;

import java.util.List;

import interfaces.ApiResponde;
import model.Repo;
import model.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by GIS on 16/03/2018.
 */

public class BusyRestService {


    IBusyService service;

    public BusyRestService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        this.service = retrofit.create(IBusyService.class);
    }

    public void repos(String username, final ApiResponde.ApiResponse<List<Repo>> callback) {
        Call<List<Repo>> repos = service.listRepos(username);
        repos.enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                callback.OnResponse(response.body());
            }

            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {
                callback.OnError(t);
            }
        });
    }

    public void users(final ApiResponde.ApiResponse<List<User>> callback) {
        Call<List<User>> repos = service.listUsers();
        repos.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                callback.OnResponse(response.body());
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                callback.OnError(t);
            }
        });
    }

}
