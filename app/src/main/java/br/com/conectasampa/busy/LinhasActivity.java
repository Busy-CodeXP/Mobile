package br.com.conectasampa.busy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import model.Linhas;
import br.com.conectasampa.busy.adapter.LinhasAdapter;

public class LinhasActivity extends AppCompatActivity {

    private ArrayList<Linhas> adicionarLinhas() {

        ArrayList<Linhas> linhas = new ArrayList<Linhas>();

        Linhas l = new Linhas("178L - Hosp. Clínicas","dsdjnsjksdnvnkn", R.drawable.bus_red3);

        linhas.add(l);
        l = new Linhas("778R - Cohab Raposo Tavares","sjsjxcvxvxfjsljfl",R.drawable.bus_green3);

        linhas.add(l);
        l = new Linhas("669A - Term. Santo Amaro","sjuwexverwuiqe",R.drawable.bus_yellow3);

        linhas.add(l);
        l = new Linhas("7281 - Lapa","sjuweawdwesduiqe",R.drawable.bus_red3);

        linhas.add(l);
        l = new Linhas("1598 - Vila Mariana","dnvasdADADnkn",R.drawable.bus_yellow3);

        linhas.add(l);
        l = new Linhas("967P - Pinheiros","sjsjfADADAjsljfl",R.drawable.bus_green3);

        linhas.add(l);

         return linhas;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final ListView lista = (ListView) findViewById(R.id.lvLinhas);
        //ArrayList<Linhas> linhas = adicionarLinhas();
        ArrayAdapter adapter = new LinhasAdapter(this, adicionarLinhas());
        lista.setAdapter(adapter);

    }







}
