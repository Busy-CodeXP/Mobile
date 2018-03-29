package br.com.conectasampa.busy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import interfaces.ApiResponde;
import model.Linhas;
import br.com.conectasampa.busy.adapter.LinhasAdapter;
import services.BusyRestService;

public class LinhasActivity extends AppCompatActivity {

    private ArrayList<Linhas> adicionarLinhas() {

        ArrayList<Linhas> linhas = new ArrayList<Linhas>();

         return linhas;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final ListView lista = (ListView) findViewById(R.id.lvLinhas);
        ArrayList<Linhas> linhas = adicionarLinhas();
        final ArrayAdapter adapter = new LinhasAdapter(this, adicionarLinhas());
        lista.setAdapter(adapter);

        final BusyRestService service = new BusyRestService();

        Intent intent = getIntent();
        String pesquisa  = intent.getStringExtra("Busca");

        service.listaLinhas(pesquisa, new ApiResponde.ApiResponse<ArrayList<Linhas>>() {
            @Override
            public void OnSucess(ArrayList<Linhas> data) {
                adapter.clear();
                adapter.addAll(data);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void OnError(Throwable t) {

            }
        });

        pesquisa="";
    }







}
