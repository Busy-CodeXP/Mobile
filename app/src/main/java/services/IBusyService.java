package services;

import java.util.ArrayList;
import java.util.List;

import model.Linhas;
import model.Repo;
import model.Usuario;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by GIS on 16/03/2018.
 */

public interface IBusyService {
    @GET("OlhoVivo/buscaLinha")
    Call<ArrayList<Linhas>> listaLinhas(@Query("buscaLinha") String buscaLinha);

    @POST("usuarios")
    Call<Usuario> cadastrarUsuario(@Body Usuario email);
}
