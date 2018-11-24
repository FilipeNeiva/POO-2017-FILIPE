package ifpi.edu.br.calculadora;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Tela1Activity extends AppCompatActivity {

    private EditText edtNome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela1);

        edtNome = findViewById(R.id.edt_nome);
    }

    public void nomeUsuario(View view) {

        if (!edtNome.getText().toString().trim().isEmpty()){

            SharedPreferences preferences = getSharedPreferences("usuarioCalculadora.file", MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();

            editor.putString("usuarioNome", edtNome.getText().toString());

            editor.commit();

            startActivity(new Intent(this, Tela2Activity.class));
        }
        else
            Toast.makeText(this, R.string.preencher_campus, Toast.LENGTH_SHORT).show();

    }
}
