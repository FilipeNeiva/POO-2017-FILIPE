package com.example.aluno.biblioteca;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aluno.biblioteca.model.App;
import com.example.aluno.biblioteca.model.Livro;
import com.example.aluno.biblioteca.model.Usuario;

import java.util.List;

import io.objectbox.Box;

public class DesejadoActivity extends AppCompatActivity {

    private long posicao;
    private Box<Usuario> usuarioBox;
    private Usuario userLog;
    private TextView txtNome;
    private TextView txtNomeAutor;
    private TextView txtNumPag;
    private List<Livro> livros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desejado);


        final SharedPreferences preferences = getSharedPreferences("bibliotecaLog.file", MODE_PRIVATE);
        final long idUser = preferences.getLong("usuarioId", -1);


        stupViews();
        userLog = usuarioBox.get(idUser);

        livros = userLog.getLivros();

        txtNome.setText(userLog.buscaLivro(posicao).getNome());
        txtNomeAutor.setText(userLog.buscaLivro(posicao).getAutor());
        txtNumPag.setText("" + (userLog.buscaLivro(posicao).getNumPag()));
    }

    void stupViews(){

        usuarioBox = ((App)getApplication()).getBoxStore().boxFor(Usuario.class);
        posicao = getIntent().getLongExtra("posicao", -1);
        txtNome = findViewById(R.id.txt_nome);
        txtNomeAutor = findViewById(R.id.txt_autor);
        txtNumPag = findViewById(R.id.txt_num_pag);

    }

    public void iniciarLeitura(View view) {


        userLog.buscaLivro(posicao).setSituacao("lendo");
        ((App) getApplication()).getBoxStore().boxFor(Livro.class).put(userLog.buscaLivro(posicao));
        usuarioBox.put(userLog);
        finish();
    }
}
