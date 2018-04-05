package br.com.conectasampa.busy;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import static br.com.conectasampa.busy.util.MessageHelper.MostraMensagem;

public class PesquisaLinhaActivity extends AppCompatActivity {

    private TextView txt_buscaLinha;
    private EditText Busca;
    private Button BtnBusca;
    private ProgressBar carrega;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesquisa_linha);

        Busca = (EditText) findViewById(R.id.busca);
        BtnBusca = (Button) findViewById(R.id.btn_busca);
        carrega=(ProgressBar)findViewById(R.id.progressBar2);
        carrega.setVisibility(View.GONE);

        BtnBusca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                carrega.setVisibility(View.VISIBLE);
                String BuscaLinha = Busca.getText().toString();
                Intent intent = new Intent(getApplicationContext(), LinhasActivity.class);
                intent.putExtra("Busca", BuscaLinha);
                startActivity(intent);

            }
        });
    }
}
