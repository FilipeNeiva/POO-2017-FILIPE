package com.example.aluno.biblioteca;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aluno.biblioteca.model.App;
import com.example.aluno.biblioteca.model.Usuario;
import com.example.aluno.biblioteca.model.Usuario_;

import java.util.List;

import io.objectbox.Box;

public class LoginActivity extends AppCompatActivity {

    private EditText edtEmail;
    private EditText edtSenha;
    private Box<Usuario> usuarioBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setupViews();
    }


    public void logar(View view) {
        List<Usuario> cadastradado = usuarioBox.query()
                .equal(Usuario_.email, edtEmail.getText().toString())
                .build()
                .find();

        List<Usuario> correto = usuarioBox.query()
                .equal(Usuario_.email, edtEmail.getText().toString())
                .equal(Usuario_.senha, edtSenha.getText().toString())
                .build()
                .find();

        if (edtEmail.getText().toString().trim().isEmpty() || edtSenha.getText().toString().trim().isEmpty()){
            Toast.makeText(this, R.string.preencher_campos, Toast.LENGTH_LONG).show();
        }else if(cadastradado.size() == 0){
            Toast.makeText(this, R.string.email_nao_cadastrado, Toast.LENGTH_LONG).show();
        }else if(correto.size() == 0){
            Toast.makeText(this, R.string.es_incorreto, Toast.LENGTH_LONG).show();
        }else{
            logar(correto.get(0));
        }


    }

    public void chamaCadastroUsuario(View view) {
        startActivity(new Intent(this, CadastroUsuarioActivity.class));
    }

    private void logar(Usuario usuario) {
        SharedPreferences preferences = getSharedPreferences("bibliotecaLog.file", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putLong("usuarioId", usuario.getId());
        editor.commit();

        startActivity(new Intent(this, ListaLivrosActivity.class));
        finish();
    }

    private void setupViews(){
        usuarioBox = ((App)getApplication()).getBoxStore().boxFor(Usuario.class);
        edtEmail = findViewById(R.id.edit_email);
        edtSenha = findViewById(R.id.edit_senha);
    }
}
