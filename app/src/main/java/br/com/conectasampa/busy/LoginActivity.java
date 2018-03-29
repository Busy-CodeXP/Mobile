package br.com.conectasampa.busy;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import services.BusyRestService;

import static br.com.conectasampa.busy.util.MessageHelper.MostraMensagem;

public class LoginActivity extends AppCompatActivity {

    // UI references.
    private AutoCompleteTextView mEmailView;
    private EditText mPasswordView;
    private View mProgressView;
    private View mLoginFormView;
    private final Activity act = this;
    private TextView mSemCadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Set up the login form.
        mEmailView = (AutoCompleteTextView) findViewById(R.id.email);
        mPasswordView = (EditText) findViewById(R.id.password);

        mSemCadastro = (TextView) findViewById(R.id.txt_semCadastro);
        mSemCadastro.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(act, PesquisaLinhaActivity.class);
                startActivity(i);
                finish();
            }
        });

        //Criando um restservice aqui, é o metodo que vai fazer a comunicação com back
        final BusyRestService service = new BusyRestService();

        Button mEmailSignInButton = (Button) findViewById(R.id.email_sign_in_button);
        mEmailSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mEmailView.getText().toString();
                String password = mPasswordView.getText().toString();


                if(!isEmailValid(email)){
                    MostraMensagem(act, "Erro na validação", "E-mail não cadastrado, deseja se cadastrar?");

                    /*Se o email nao existir perguntar se deseja se cadastrar e chamar a activity Cadastro.
                    Intent i = new Intent(act, CadastroActivity.class);
                    startActivity(i);
                    finish();
                    */

                    return;

                }


                if (!isPasswordValid(password)){
                    MostraMensagem(act, "Erro na validação", "Senha inválida");
                    return;
                }

                Intent i = new Intent(act, PesquisaLinhaActivity.class);
                startActivity(i);
                finish();
            }
        });


    }

    private boolean isEmailValid(String email) {
        //TODO: Replace this with your own logic
        return email.contains("@");
    }

    private boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        return password.length() > 4;
    }
}

