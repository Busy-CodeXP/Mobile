package services;

import java.util.List;

import model.Repo;
import model.User;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by GIS on 16/03/2018.
 */

public interface IBusyService {
    @GET("users/{user}/repos")
    Call<List<Repo>> listRepos(@Path("user") String user);

    @GET("users")
    Call<List<User>> listUsers();


}
