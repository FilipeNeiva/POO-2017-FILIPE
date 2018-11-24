package ifpi.edu.br.calculadora;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Tela3Activity extends AppCompatActivity {

    private EditText edtPeso1;
    private EditText edtPeso2;
    private float nota1;
    private float nota2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela3);

        edtPeso1 = findViewById(R.id.edt_peso1);
        edtPeso2 = findViewById(R.id.edt_peso2);

        nota1 = getIntent().getFloatExtra("nota1", -1);
        nota2 = getIntent().getFloatExtra("nota2", -1);
    }

    public void calculaMediaPonderada(View view) {
        float peso1 = Float.valueOf(edtPeso1.getText().toString());
        float peso2 = Float.valueOf(edtPeso2.getText().toString());
        final float mediaPonderada = ((nota1 * peso1) + (nota2 * peso2)) / (peso1 + peso2);

        startActivity(new Intent(this, Tela2Activity.class).putExtra("mediaPonderada", mediaPonderada));
    }

    public void cancelar(View view) {
        startActivity(new Intent(this, Tela2Activity.class));
    }
}
