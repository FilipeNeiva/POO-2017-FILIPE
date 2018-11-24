package ifpi.edu.br.gerenciadorterefas;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import ifpi.edu.br.gerenciadorterefas.model.App;
import ifpi.edu.br.gerenciadorterefas.model.Usuario;
import ifpi.edu.br.gerenciadorterefas.model.Usuario_;
import io.objectbox.Box;

public class IdentificadorUsuarioActivity extends AppCompatActivity {

    private EditText edtNome;
    private EditText edtSenha;
    private Box<Usuario> usuarioBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identificador_usuario);
        usuarioBox = ((App)getApplication()).getBoxStore().boxFor(Usuario.class);
        edtNome = findViewById(R.id.edt_nome);
        edtSenha = findViewById(R.id.edt_senha);
    }

    public void logar(View view) {

        List<Usuario> cadastradado = usuarioBox.query()
                .equal(Usuario_.nome, edtNome.getText().toString())
                .build()
                .find();

        List<Usuario> correto = usuarioBox.query()
                .equal(Usuario_.nome, edtNome.getText().toString())
                .equal(Usuario_.senha, edtSenha.getText().toString())
                .build()
                .find();

        if (edtNome.getText().toString().trim().isEmpty() || edtSenha.getText().toString().trim().isEmpty()){
            Toast.makeText(this, R.string.preencher_campus, Toast.LENGTH_LONG).show();
        }else if(cadastradado.size() == 0){
            Toast.makeText(this, R.string.usuario_nao_cadastrado, Toast.LENGTH_LONG).show();
        }else if(correto.size() == 0){
            Toast.makeText(this, R.string.senha_incorreta, Toast.LENGTH_LONG).show();
        }else{
            logar(correto.get(0));
        }

    }

    private void logar(Usuario usuario) {
        SharedPreferences preferences = getSharedPreferences("gerTarefa.file", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putLong("usuarioId", usuario.getId());
        editor.commit();

        startActivity(new Intent(this, ListaTarefasActivity.class));
        finish();
    }
}
