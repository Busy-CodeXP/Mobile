package br.com.conectasampa.busy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import br.com.conectasampa.busy.adapter.LinhasAdapter;
import br.com.conectasampa.busy.adapter.LinhasDetalheAdapter;
import interfaces.ApiResponde;
import model.LinhaDetalheResult;
import model.Linhas;
import model.LinhasDetalhe;
import services.BusyRestService;

public class LinhasDetalheActivity extends AppCompatActivity {
    private final Activity act = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linhas_detalhes);

        Intent intent = getIntent();

        final ListView lista = (ListView) findViewById(R.id.lvLinhas);
        List<LinhasDetalhe> linhas = new ArrayList<LinhasDetalhe>();

        String numLinha = intent.getStringExtra("numlinha");
        String nomeLinha = intent.getStringExtra("nomelinha");

       final ArrayAdapter adapter = new LinhasDetalheAdapter(this, linhas, numLinha, nomeLinha);

        lista.setAdapter(adapter);

        final BusyRestService service = new BusyRestService();


        int buscaLinhaSensor  = intent.getIntExtra("prefixo", 0);

        service.listaLinhasSensor(buscaLinhaSensor, new ApiResponde.ApiResponse<LinhaDetalheResult>() {
            @Override
            public void OnSucess(LinhaDetalheResult data) {
                if (data != null){
                    adapter.clear();
                    adapter.addAll(data.vs);
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void OnError(Throwable t) {
               // MostraMensagem(act, "Erro na pesquisa", "Erro na pesquisa");
               // return;
            }
        });


    }



}
