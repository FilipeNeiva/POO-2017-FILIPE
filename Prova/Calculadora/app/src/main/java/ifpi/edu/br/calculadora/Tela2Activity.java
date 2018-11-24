package ifpi.edu.br.calculadora;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Tela2Activity extends AppCompatActivity {

    private EditText edtNota1;
    private EditText edtNota2;
    private TextView txtResult;
    private String nome;
    private float mediaPonderada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);

        edtNota1 = findViewById(R.id.edt_nota1);
        edtNota2 = findViewById(R.id.edt_nota2);
        txtResult = findViewById(R.id.txt_resultado);
        SharedPreferences preferences = getSharedPreferences("usuarioCalculadora.file", MODE_PRIVATE);
        nome = preferences.getString("usuarioNome", "");
        mediaPonderada = getIntent().getFloatExtra("mediaPonderada", -1);

    }

    @Override
    protected void onResume() {
        super.onResume();

        txtResult.setText("");

        if (mediaPonderada != -1){
            if (mediaPonderada >= 7){
                txtResult.setText("Parabens "+nome+", você foi aprovado com media "+mediaPonderada);
            }else if(mediaPonderada > 4){
                final float notaRequerida = 12 - mediaPonderada;
                txtResult.setText("Cuidado "+nome+", você ficou de prova final. sua media foi "+mediaPonderada+" e você precisa obter "+notaRequerida);
            }else{
                txtResult.setText("Sinto muito "+nome+", você foi reprovado. Sua media foi "+mediaPonderada);
            }

        }
    }

    public void calculaMedia(View view) {
        if (!edtNota1.getText().toString().trim().isEmpty() || !edtNota2.getText().toString().trim().isEmpty())

            startActivity(new Intent(this, Tela3Activity.class).putExtra("nota1", Float.valueOf(edtNota1.getText().toString())).putExtra("nota2", Float.valueOf(edtNota2.getText().toString())));
        
        else
            Toast.makeText(this, R.string.preencher_campus, Toast.LENGTH_SHORT).show();
        
    }
}
