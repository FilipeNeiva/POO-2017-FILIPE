package ifpi.edu.br.gerenciadorterefas.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ifpi.edu.br.gerenciadorterefas.R;
import ifpi.edu.br.gerenciadorterefas.model.Tarefa;
import ifpi.edu.br.gerenciadorterefas.model.Usuario;
import io.objectbox.Box;

/**
 * Created by aluno on 14/03/18.
 */

public class rvAdapter extends RecyclerView.Adapter<rvAdapter.ViewHolder>{

    private Context context;
    private List<Tarefa> tarefas = new ArrayList<>();
    private Usuario userLog;
    private Box<Usuario> usuarioBox;


    public rvAdapter(Context context, List<Tarefa> tarefas, Box<Usuario> usuarioBox, Usuario userLog){

        this.context = context;
        this.tarefas = tarefas;
        this.usuarioBox = usuarioBox;
        this.userLog = userLog;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        final LayoutInflater inflater = LayoutInflater.from(context);

        View linha = inflater.inflate(R.layout.item_tarefa, parent, false);

        return new ViewHolder(linha);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        final Tarefa tarefa = tarefas.get(position);

        holder.txtTitulo.setText(tarefa.getTitulo());
        holder.txtDescricao.setText(tarefa.getDescricao());

        holder.itemView.setOnClickListener(view -> {
            if(tarefa.getEstado().equalsIgnoreCase("aFazer")) {
                tarefa.setEstado("fazendo");
            }
            else if(tarefa.getEstado().equalsIgnoreCase("fazendo")){
                tarefa.setEstado("feito");
            }
        });


    }


    @Override
    public int getItemCount() {
        return this.tarefas.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private TextView txtTitulo;
        private TextView txtDescricao;

        public ViewHolder(View itemView) {
            super(itemView);

            txtTitulo = itemView.findViewById(R.id.txt_titulo);
            txtDescricao = itemView.findViewById(R.id.txt_descricao);
        }
    }

    public void setTarefas(List<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }
}
