package ifpi.edu.br.gerenciadorterefas;

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

public class CadastroUsuarioActivity extends AppCompatActivity {

    private EditText edtNome;
    private EditText edtSenha;
    private EditText edtSenha2;
    private Box<Usuario> usuarioBox;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_usuario);
        edtNome = findViewById(R.id.edt_usuario);
        edtSenha = findViewById(R.id.edt_senha);
        edtSenha2 = findViewById(R.id.edt_senha2);
        usuarioBox = ((App)getApplication()).getBoxStore().boxFor(Usuario.class);
    }

    public void cadastrarUsuario(View view) {

        List<Usuario> cadastrados = usuarioBox.query()
                .equal(Usuario_.nome, edtNome.getText().toString())
                .build()
                .find();

        if (edtNome.getText().toString().trim().isEmpty() || edtSenha.getText().toString().trim().isEmpty() || edtSenha2.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, R.string.preencher_campus, Toast.LENGTH_LONG).show();
        } else if (cadastrados.size() > 0) {
            Toast.makeText(this, R.string.usuario_ja_cadastrado, Toast.LENGTH_SHORT).show();
        }else if (!edtSenha.getText().toString().equals(edtSenha2.getText().toString())) {
            Toast.makeText(this, R.string.senhas_diferentes, Toast.LENGTH_LONG).show();
        } else {
            Usuario novo = new Usuario(edtNome.getText().toString(), edtSenha.getText().toString());

            usuarioBox.put(novo);
            Toast.makeText(this, R.string.usuario_cadastrado, Toast.LENGTH_LONG).show();
            finish();
        }
    }
}