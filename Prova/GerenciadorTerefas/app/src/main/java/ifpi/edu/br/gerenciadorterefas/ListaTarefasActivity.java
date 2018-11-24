package ifpi.edu.br.gerenciadorterefas;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import ifpi.edu.br.gerenciadorterefas.adapters.rvAdapter;
import ifpi.edu.br.gerenciadorterefas.model.App;
import ifpi.edu.br.gerenciadorterefas.model.Tarefa;
import ifpi.edu.br.gerenciadorterefas.model.Usuario;
import io.objectbox.Box;

public class ListaTarefasActivity extends AppCompatActivity {

    SharedPreferences preferences;
    private Box<Usuario> usuarioBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_tarefas);

        usuarioBox = ((App)getApplication()).getBoxStore().boxFor(Usuario.class);

        if (!logado()){
            startActivity(new Intent(this, IdentificadorUsuarioActivity.class));
            finish();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        Usuario userLogado = obterUsuarioLogado();

        List<Tarefa> tarefasAfazer = new ArrayList<>();

        for(int i = 0; i < userLogado.getTarefas().size(); i++){
            if(userLogado.getTarefas().get(i).getEstado().equals("aFazer")){
                tarefasAfazer.add(userLogado.getTarefas().get(i));
            }
        }

        RecyclerView rvAFazer = findViewById(R.id.a_fazer_recycler);
        rvAdapter adapterAFazer = new rvAdapter(this, tarefasAfazer, usuarioBox, userLogado);
        rvAFazer.setAdapter(adapterAFazer);
        rvAFazer.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rvAFazer.setHasFixedSize(true);

        List<Tarefa> tarefasFazendo = new ArrayList<>();

        for(int i = 0; i < userLogado.getTarefas().size(); i++){
            if(userLogado.getTarefas().get(i).getEstado().equals("fazendo")){
                tarefasFazendo.add(userLogado.getTarefas().get(i));
            }
        }

        RecyclerView rvFazendo = findViewById(R.id.fazendo_recycler);
        rvAdapter adapterFazendo = new rvAdapter(this, tarefasFazendo, usuarioBox,userLogado);
        rvFazendo.setAdapter(adapterFazendo);
        rvFazendo.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rvFazendo.setHasFixedSize(true);

        List<Tarefa> tarefasFeitas = new ArrayList<>();

        for(int i = 0; i < userLogado.getTarefas().size(); i++){
            if(userLogado.getTarefas().get(i).getEstado().equals("Lido")){
                tarefasFeitas.add(userLogado.getTarefas().get(i));
            }
        }

        RecyclerView rvFeito = findViewById(R.id.feito_recycler);
        rvAdapter adapterFeitos = new rvAdapter(this, tarefasFeitas, usuarioBox, userLogado);
        rvFeito.setAdapter(adapterFeitos);
        rvFeito.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rvFeito.setHasFixedSize(true);
    }

    private boolean logado() {
        preferences = getSharedPreferences("gerTarefa.file", MODE_PRIVATE);
        long usuarioId = preferences.getLong("usuarioId", -1);
        return usuarioId == -1 ? false : true;
    }

    private Usuario obterUsuarioLogado() {
        preferences = getSharedPreferences("gerTarefa.file", MODE_PRIVATE);
        final long id = preferences.getLong("usuarioId", -1);
        return usuarioBox.get(id);
    }

    public void chamaCadastroTarefa(View view) {
        startActivity(new Intent(this, CadastroTarefaActivity.class));
    }
}
