package ifpi.edu.br.gerenciadorterefas;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import ifpi.edu.br.gerenciadorterefas.model.App;
import ifpi.edu.br.gerenciadorterefas.model.Tarefa;
import ifpi.edu.br.gerenciadorterefas.model.Usuario;
import io.objectbox.Box;

public class CadastroTarefaActivity extends AppCompatActivity {

    private EditText edtTitulo;
    private EditText edtDescricao;
    private Box<Usuario> usuarioBox;
    SharedPreferences preferences;
    private Usuario userLogado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_tarefa);

        edtTitulo = findViewById(R.id.edt_titulo);
        edtDescricao = findViewById(R.id.edt_descricao);
        usuarioBox = ((App)getApplication()).getBoxStore().boxFor(Usuario.class);
        preferences = getSharedPreferences("gerTarefa.file", MODE_PRIVATE);
        final long id = preferences.getLong("usuarioId", -1);
        userLogado = usuarioBox.get(id);

    }

    public void cadastrarTarefa(View view) {
        if(edtDescricao.getText().toString().trim().isEmpty() || edtTitulo.getText().toString().trim().isEmpty()){
            Toast.makeText(this, R.string.preencher_campus, Toast.LENGTH_LONG).show();
        }else{

            Tarefa nova = new Tarefa(edtTitulo.getText().toString(),edtDescricao.getText().toString(),"afazer");
            userLogado.addTarefa(nova);
            Toast.makeText(this,"Tarefa adicionada com sucesso", Toast.LENGTH_LONG).show();
            usuarioBox.put(userLogado);
            finish();
        }
    }
}
