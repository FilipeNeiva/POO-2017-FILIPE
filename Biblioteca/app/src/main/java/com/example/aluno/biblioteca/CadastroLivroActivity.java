package com.example.aluno.biblioteca;

import android.app.DatePickerDialog;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import io.objectbox.Box;
import com.example.aluno.biblioteca.model.App;
import com.example.aluno.biblioteca.model.Livro;
import com.example.aluno.biblioteca.model.Usuario;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CadastroLivroActivity extends AppCompatActivity {

    private Box<Usuario> usuarioBox;
    private Usuario userLogado;
    private EditText edtNome;
    private Livro novo;
    private Livro velho;
    private EditText edtNumPag;
    private EditText edtAutor;
    private TextView txtData;
    private RadioGroup grupSituacao;
    private int posicaoLivro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_livro);



        usuarioBox = ((App)getApplication()).getBoxStore().boxFor(Usuario.class);

        final SharedPreferences preferences = getSharedPreferences("bibliotecaLog.file", MODE_PRIVATE);
        final long idUser = preferences.getLong("usuarioId", -1);
        posicaoLivro = getIntent().getIntExtra("position", -1);

        userLogado =  usuarioBox.get(idUser);
        setupViews();

        if (posicaoLivro != -1){
            velho = userLogado.getLivros().get(posicaoLivro);
            loadEdit();
        }

    }

    public void cadastrar(View view) {
        if(edtNome.getText().toString().trim().isEmpty() || edtNumPag.getText().toString().trim().isEmpty() || edtAutor.getText().toString().trim().isEmpty()|| grupSituacao.getCheckedRadioButtonId() < 0){
            Toast.makeText(this, R.string.preencher_campos, Toast.LENGTH_LONG).show();
        }else{
            novo.setNome(edtNome.getText().toString());
            novo.setNumPag(Integer.parseInt((edtNumPag.getText().toString())));
            novo.setAutor(edtAutor.getText().toString());
            novo.setDataLancamento(txtData.getText().toString());

            if (grupSituacao.getCheckedRadioButtonId() == R.id.desejado){
                novo.setSituacao("Desejado");
            }else if (grupSituacao.getCheckedRadioButtonId() == R.id.lendo){
                novo.setSituacao("lendo");
            }else if (grupSituacao.getCheckedRadioButtonId() == R.id.lido){
                novo.setSituacao("Lido");
            }
            if(posicaoLivro != -1){
                userLogado.changeLivro(novo, posicaoLivro);
                Toast.makeText(this, R.string.livro_atualizado, Toast.LENGTH_LONG).show();
            }else{
                userLogado.addLivro(novo);
                Toast.makeText(this, R.string.add_livro_suc, Toast.LENGTH_LONG).show();
            }
            usuarioBox.put(userLogado);
            finish();
        }
    }

    void loadEdit(){
        edtNome.setText(velho.getNome());
        edtNumPag.setText(velho.getNumPag());
        edtAutor.setText(velho.getAutor());
        txtData.setText(velho.getDataLancamento());
    }

    void setupViews(){
        edtNome = findViewById(R.id.edt_nome);
        edtNumPag = findViewById(R.id.edt_num_pag);
        edtAutor = findViewById(R.id.edt_autor);
        txtData = findViewById(R.id.txt_data_lancamento);
        grupSituacao = findViewById(R.id.situacao);
        novo = new Livro();
    }

    public void pegarData(View view) {
        final Calendar calendario = Calendar.getInstance();
        int ano = calendario.get(Calendar.YEAR);
        int mes = calendario.get(Calendar.MONTH);
        int dia = calendario.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                (datePicker, i, i1, i2) -> {
                    calendario.set(i, i1, i2);
                    txtData.setText(new SimpleDateFormat("dd/MM/yyyy")
                            .format(calendario.getTime()));
                }, ano, mes, dia);

        /** Definir data mínima a ser escolhida sendo a data atual */
        datePickerDialog.getDatePicker().setMinDate(calendario.getTimeInMillis());
        datePickerDialog.show();
    }
}
