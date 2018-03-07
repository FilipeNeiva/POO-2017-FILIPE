package com.example.aluno.biblioteca;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import io.objectbox.Box;

import com.example.aluno.biblioteca.model.App;
import com.example.aluno.biblioteca.model.Usuario;
import com.example.aluno.biblioteca.model.Usuario_;

import java.util.List;

import static com.example.aluno.biblioteca.R.*;

public class CadastroUsuarioActivity extends AppCompatActivity {

    private EditText edtNome;
    private EditText edtEmail;
    private EditText edtSenha;
    private EditText edtSenha2;
    private Box<Usuario> usuarioBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_cadastro_usuario);
        usuarioBox = ((App)getApplication()).getBoxStore().boxFor(Usuario.class);
        setupView();
    }

    private void setupView(){
        edtNome = findViewById(id.edt_nome);
        edtEmail = findViewById(id.edt_email);
        edtSenha = findViewById(id.edt_senha);
        edtSenha2 = findViewById(id.edt_senha2);
    }

    public void cadastrarUsuario(View view) {

        List<Usuario> cadastrados = usuarioBox.query()
                .equal(Usuario_.email,edtEmail.getText().toString())
                .build()
                .find();

        if(edtNome.getText().toString().trim().isEmpty() || edtEmail.getText().toString().trim().isEmpty() || edtSenha.getText().toString().trim().isEmpty() || edtSenha2.getText().toString().trim().isEmpty()){
            Toast.makeText(this, string.preencher_campos, Toast.LENGTH_LONG).show();
        }else if(cadastrados.size() > 0){
            Toast.makeText(this, string.email_cadastrado, Toast.LENGTH_LONG).show();
        }else if(!edtSenha.getText().toString().equals(edtSenha2.getText().toString())){
            Toast.makeText(this, string.senhas_diferentes, Toast.LENGTH_LONG).show();
        }else{
            Usuario novo = new Usuario();
            novo.setNome(edtNome.getText().toString());
            novo.setEmail(edtEmail.getText().toString());
            novo.setSenha(edtSenha.getText().toString());

            usuarioBox.put(novo);
            Toast.makeText(this, string.cad_usuario_sucesso, Toast.LENGTH_LONG).show();
            finish();
        }
    }
}
