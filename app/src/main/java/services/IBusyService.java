package services;

import java.util.ArrayList;

import model.LinhaDetalheResult;
import model.Linhas;
import model.LinhasDetalhe;
import model.Usuario;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by GIS on 16/03/2018.
 */

public interface IBusyService {
    @GET("OlhoVivo/buscaLinha")
    Call<ArrayList<Linhas>> listaLinhas(@Query("buscaLinha") String buscaLinha);

    @GET("OlhoVivo/codigoLinhaSensor")
    Call<LinhaDetalheResult> listaLinhasSensor(@Query("codigoLinha") Integer buscaLinhaSensor);

    @POST("usuarios")
    Call<Usuario> cadastrarUsuario(@Body Usuario email);
}
