package br.com.conectasampa.busy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;
import static br.com.conectasampa.busy.util.CustomApplication.initTextType;


import static br.com.conectasampa.busy.util.MessageHelper.MostraMensagem;

public class CadastroActivity extends AppCompatActivity {

    private EditText mEmailView;
    private EditText mPasswordView;
    private EditText mNomeView;
    private EditText mTelefoneView;
    private final Activity act = this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        mEmailView = (EditText) findViewById(R.id.id_email);
        mPasswordView = (EditText) findViewById(R.id.id_senha);
        mNomeView = (EditText) findViewById(R.id.id_nome);
        mTelefoneView = (EditText) findViewById(R.id.id_telefone);

        Button Cadastrar = (Button) findViewById(R.id.btn_cadastro);
        Cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mEmailView.getText().toString();
                String password = mPasswordView.getText().toString();
                String nome = mNomeView.getText().toString();
                String telefone = mTelefoneView.getText().toString();

                if (!isEmailValid(email)) {
                    MostraMensagem(act, "Erro na validação", "E-mail inválido");
                    return;
                }

                if (!isPasswordValid(password)) {
                    MostraMensagem(act, "Erro na validação", "Senha inválida, deve conter mais que 4 caracteres");
                    return;
                }

                if (!isNomeValid(nome)) {
                    MostraMensagem(act, "Erro na validação", "Nome inválido");
                    return;
                }

                if (!isTelefoneValid(telefone)) {
                    MostraMensagem(act, "Erro na validação", "Telefone inválido, digite o número com DDD");
                    return;
                }


                Intent i = new Intent(act, ClassificaActivity.class);
                startActivity(i);
                finish();
            }
        });
    }

    private boolean isEmailValid(String email) {
       return email.contains("@");
    }

    private boolean isPasswordValid(String password) {
        return password.length() > 4;
    }

    private boolean isNomeValid(String nome) {
        return nome.length() > 3;
    }

    private boolean isTelefoneValid(String telefone) {
        return telefone.length() == 11;
    }
}
