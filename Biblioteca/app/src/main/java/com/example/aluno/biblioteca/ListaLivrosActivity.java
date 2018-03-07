package com.example.aluno.biblioteca;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aluno.biblioteca.adapters.LivrosRvAdapter;
import com.example.aluno.biblioteca.model.App;
import com.example.aluno.biblioteca.model.Livro;
import com.example.aluno.biblioteca.model.Usuario;

import java.util.ArrayList;
import java.util.List;

import io.objectbox.Box;

public class ListaLivrosActivity extends AppCompatActivity {

    private Box<Usuario> usuarioBox;
    private TextView vazioDesejado;
    private TextView vazioLendo;
    private TextView vazioLido;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_livros);


        if (!logado()){
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        }

        usuarioBox = ((App)getApplication()).getBoxStore().boxFor(Usuario.class);
        vazioDesejado = findViewById(R.id.vazio_desejado);
        vazioLendo = findViewById(R.id.vazio_lendo);
        vazioLido = findViewById(R.id.vazio_lido);
    }


    @Override
    protected void onResume() {
        super.onResume();

        reloaData();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_logout, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.item_sair){
            preferences = getSharedPreferences("bibliotecaLog.file", MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.clear();
            editor.commit();
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        }
        return true;
    }

    private boolean logado() {
        preferences = getSharedPreferences("bibliotecaLog.file", MODE_PRIVATE);
        long usuarioId = preferences.getLong("usuarioId", -1);
        return usuarioId == -1 ? false : true;
    }

    private Usuario obterUsuarioLogado() {
        preferences = getSharedPreferences("bibliotecaLog.file", MODE_PRIVATE);
        final long id = preferences.getLong("usuarioId", -1);
        return usuarioBox.get(id);
    }

    public void chamaCadastroLivro(View view) {
        startActivity(new Intent(this, CadastroLivroActivity.class));
    }

    public void reloaData(){
        Usuario userLogado = obterUsuarioLogado();

        List<Livro> livrosDesejados = new ArrayList<>();

        for(int i = 0; i < userLogado.getLivros().size(); i++){
            if(userLogado.getLivros().get(i).getSituacao().equals("Desejado")){
                livrosDesejados.add(userLogado.getLivros().get(i));
            }
        }

        if (livrosDesejados.size() == 0){
            vazioDesejado.setText("Vazio");
        }else {
            vazioDesejado.setText("");
        }


        RecyclerView rvDesejados = findViewById(R.id.desejados_recyclerview);
        LivrosRvAdapter adpterDesejados = new LivrosRvAdapter(this, livrosDesejados, usuarioBox, userLogado);
        rvDesejados.setAdapter(adpterDesejados);
        rvDesejados.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rvDesejados.setHasFixedSize(true);

        List<Livro> livrosLendo = new ArrayList<>();

        for(int i = 0; i < userLogado.getLivros().size(); i++){
            if(userLogado.getLivros().get(i).getSituacao().equals("lendo")){
                livrosLendo.add(userLogado.getLivros().get(i));
            }
        }

        if (livrosLendo.size() == 0){
            vazioLendo.setText("Vazio");
        }else {
            vazioLendo.setText("");
        }


        RecyclerView rvLendo = findViewById(R.id.lendo_recyclerview);
        LivrosRvAdapter adpterLendo = new LivrosRvAdapter(this, livrosLendo, usuarioBox,userLogado);
        rvLendo.setAdapter(adpterLendo);
        rvLendo.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rvLendo.setHasFixedSize(true);

        List<Livro> livrosLidos = new ArrayList<>();

        for(int i = 0; i < userLogado.getLivros().size(); i++){
            if(userLogado.getLivros().get(i).getSituacao().equals("Lido")){
                livrosLidos.add(userLogado.getLivros().get(i));
            }
        }

        if (livrosLidos.size() == 0){
            vazioLido.setText("Vazio");
        }else {
            vazioLido.setText("");
        }


        RecyclerView rvlidos = findViewById(R.id.lidos_recyclerview);
        LivrosRvAdapter adpterLidos = new LivrosRvAdapter(this, livrosLidos, usuarioBox, userLogado);
        rvlidos.setAdapter(adpterLidos);
        rvlidos.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rvlidos.setHasFixedSize(true);

    }
}
