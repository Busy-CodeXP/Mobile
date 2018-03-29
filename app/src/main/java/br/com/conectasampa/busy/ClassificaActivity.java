package br.com.conectasampa.busy;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import services.BusyRestService;

import static br.com.conectasampa.busy.util.MessageHelper.MostraMensagem;
import static java.lang.Float.valueOf;

public class ClassificaActivity extends AppCompatActivity {

    private RatingBar ratingBar;
    private Button btnSubmit;
    private final Activity act = this;
    private SeekBar simpleSeekBar;
    String valor = "3.0";
    String seekBarValue = "Vazio/Confortável";
    int progressValor = 0;
    String linha;
    private TextView ExibeLinha;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classifica);
        addListenerOnRatingBar();
        addListenerOnButton();
        lotacao();

        final BusyRestService service = new BusyRestService();

        Intent intent = getIntent();
        String linha  = getIntent().getStringExtra("codlinha");
        ExibeLinha = (TextView) findViewById(R.id.linha);
        ExibeLinha.setText(linha);
    }

    private void lotacao() {

        simpleSeekBar = (SeekBar) findViewById(R.id.seekBar);

        simpleSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressValor = progress;
                if (progressValor == 0) {
                    seekBarValue = "Vazio/Confortável";
                    //simpleSeekBar.setThumb(getResources().getDrawable(R.drawable.bus_green3));
                }
                else if (progressValor == 1) {
                    seekBarValue = "Parcialmente ocupado";
                    //trocar o ícone par amarelo

                } else
                    seekBarValue = "Lotado";
                //trocar o ícone para vermelho

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }

        });
    }

    public void addListenerOnRatingBar() {
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);

        ratingBar.setOnRatingBarChangeListener(new OnRatingBarChangeListener() {
            public void onRatingChanged(RatingBar ratingBar, float avaliacao, boolean fromUser) {
                valor = String.valueOf(avaliacao);
         /*
          ***************************************************************
          * guardar o ID da linha, ID do usuário e o valor da avaliação
          *           *
          * *************************************************************
          */
            }
        });
    }

    public void addListenerOnButton() {

        btnSubmit = (Button) findViewById(R.id.btnSubmit);

        //se o botão for clicado, exiba o valor de avaliação corrente.
        btnSubmit.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                MostraMensagem(act, "Avaliação", "Obrigado por avaliar!" + "\n" + "\n" +
                        "Lotação do ônibus: "+ seekBarValue + "\n" + "Classificação da sua viagem: " + valor);

                return;

            }
        });
    }


}





