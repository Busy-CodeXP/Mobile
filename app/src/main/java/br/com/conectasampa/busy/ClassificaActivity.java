package br.com.conectasampa.busy;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;

import static br.com.conectasampa.busy.UTIL.MessageHelper.MostraMensagem;
import static java.lang.Float.valueOf;

public class ClassificaActivity extends AppCompatActivity {


    private RatingBar ratingBar;
    //private TextView txtValorAvaliacao;
    private Button btnSubmit;
    private final Activity act = this;
    String valor;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classifica);
        addListenerOnRatingBar();
        addListenerOnButton();
    }

    public void addListenerOnRatingBar() {
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);

        //se o valor de avaliação mudar,
        //exiba o valor de avaliação atual no resultado (textview) automaticamente

        //txtValorAvaliacao = (TextView) findViewById(R.id.txtValorAvaliacao);

        //se o valor de avaliação mudar,
        //exiba o valor de avaliação atual no resultado (textview) automaticamente
        ratingBar.setOnRatingBarChangeListener(new OnRatingBarChangeListener() {
            public void onRatingChanged(RatingBar ratingBar, float avaliacao, boolean fromUser) {
                //txtValorAvaliacao.setText(String.valueOf(avaliacao));
                valor = String.valueOf(avaliacao);


            }
        });
    }

    public void addListenerOnButton() {
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);

        //se o botão for clicado, exiba o valor de avaliação corrente.
        btnSubmit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                MostraMensagem(act, "Avaliação", "Obrigado por avaliar!" + "\n" + "\n" + valor);
                                return;
                //Toast.makeText(ClassificaActivity.this,
                  //      String.valueOf(ratingBar.getRating()),
                    //    Toast.LENGTH_SHORT).show();
            }
        });
    }
}


