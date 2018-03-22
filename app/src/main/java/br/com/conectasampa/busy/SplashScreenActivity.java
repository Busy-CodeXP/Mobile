package br.com.conectasampa.busy;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;
import br.com.conectasampa.busy.LoginActivity;

public class SplashScreenActivity extends AppCompatActivity {

    private final Activity act = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        StartAnimations();
        /*


        //GUARDAR PREFERENCIA DE QUE O PROJETO JÁ FOI ABERTO E NAO CARREGAR SPLASH

        SharedPreferences preferences =
                getSharedPreferences("user_preferences", MODE_PRIVATE);

            if (preferences.contains("ja_abriu_app")) {
                Intent i = new Intent(act, LoginActivity.class);
                startActivity(i);
                finish();
            } else {
                 adicionarPreferenceJaAbriu(preferences);
                 StartAnimations();
            }
            */

    }

    /*
    private void adicionarPreferenceJaAbriu(SharedPreferences preferences) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("ja_abriu_app", true);
        editor.commit();
    }
    */



    private void StartAnimations() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.animacao_splash);
        animation.reset();

        LinearLayout l = (LinearLayout) findViewById(R.id.linearLayout_splash1);
        if (l != null){
            l.clearAnimation();
            l.startAnimation(animation);
        }

        animation = AnimationUtils.loadAnimation(this, R.anim.translate);
        animation.reset();
        //Buscando o objeto que foi criado no layout (nossa imagem ou logo)

        ImageView imageView = (ImageView) findViewById(R.id.splash);
        if (imageView != null) {
            imageView.clearAnimation();
            imageView.startAnimation(animation);
        }

        TextView textView = (TextView) findViewById(R.id.tvName) ;
        if (textView != null) {
            textView.clearAnimation();
            textView.startAnimation(animation);
        }

        int SPLASH_DISPLAY_LENGTH = 2500;

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //Após o tempo definido irá executar a próxima
                Intent intent = new Intent(SplashScreenActivity.this, LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);

                //PARA IRMOS PARA UMA NOVA ACTIVITY
                startActivity(intent);
                SplashScreenActivity.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }



}