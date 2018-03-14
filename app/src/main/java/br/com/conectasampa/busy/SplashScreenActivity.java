package br.com.conectasampa.busy;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import br.com.conectasampa.busy.LoginActivity;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        StartAnmimations();

    }

    private void StartAnmimations() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.animacao_splash);
        animation.reset();

        //Buscando o objeto que foi criado no layout (nossa imagem ou logo)
        ImageView imageView = findViewById(R.id.splash);
        if (imageView != null) {
            imageView.clearAnimation();
            imageView.startAnimation(animation);

        }

        int SPLASH_DISPLAY_LENGTH = 4000;

        Handler handler = new Handler();
        handler.postDelayed((new Runnable() {
            @Override
            public void run() {

                //Após o tempo definido irá executar a próxima
                Intent intent = new Intent(SplashScreenActivity.this, LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);

                //PARA IRMOS PARA UMA NOVA ACTIVITY
                startActivity(intent);
                SplashScreenActivity.this.finish();
            }
        }), SPLASH_DISPLAY_LENGTH);


    }

}