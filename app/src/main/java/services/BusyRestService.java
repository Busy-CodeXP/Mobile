package services;

import java.util.ArrayList;
import java.util.List;

import interfaces.ApiResponde;
import model.Linhas;
import model.Usuario;
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
                .baseUrl("http://ffaae593.ngrok.io/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        this.service = retrofit.create(IBusyService.class);
    }

    public void cadastrarUsuario(Usuario usuario, final ApiResponde.ApiResponse<Usuario> callback){
        Call<Usuario> novousuario = service.cadastrarUsuario(usuario);
        novousuario.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                callback.OnSucess(response.body());
            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                callback.OnError(t);
            }
        });
    }

    public void listaLinhas(String linha, final ApiResponde.ApiResponse<ArrayList<Linhas>> callback){
        Call<ArrayList<Linhas>> linhas = service.listaLinhas(linha);
        linhas.enqueue(new Callback<ArrayList<Linhas>>() {
            @Override
            public void onResponse(Call<ArrayList<Linhas>> call, Response<ArrayList<Linhas>> response) {
                callback.OnSucess(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<Linhas>> call, Throwable t) {
                callback.OnError(t);
            }
        });
    }
}