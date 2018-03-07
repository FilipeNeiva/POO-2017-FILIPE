package com.example.aluno.biblioteca.adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.example.aluno.biblioteca.CadastroLivroActivity;
import com.example.aluno.biblioteca.DesejadoActivity;
import com.example.aluno.biblioteca.LendoActivity;
import com.example.aluno.biblioteca.LidoActivity;
import com.example.aluno.biblioteca.ListaLivrosActivity;
import com.example.aluno.biblioteca.R;

import java.util.ArrayList;
import java.util.List;

import com.example.aluno.biblioteca.model.App;
import com.example.aluno.biblioteca.model.Livro;
import com.example.aluno.biblioteca.model.Usuario;

import io.objectbox.Box;

/**
 * Created by aluno on 22/02/18.
 */

public class LivrosRvAdapter extends RecyclerView.Adapter<LivrosRvAdapter.ViewHolder>{


    private Context context;
    private List<Livro> livros = new ArrayList<>();
    private Usuario userLog;
    private Box<Usuario> usuarioBox;


    public LivrosRvAdapter(Context context, List<Livro> livros, Box<Usuario> usuarioBox,Usuario userLog){

        this.context = context;
        this.livros = livros;
        this.usuarioBox = usuarioBox;
        this.userLog = userLog;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        final LayoutInflater inflater = LayoutInflater.from(context);

        View linha = inflater.inflate(R.layout.item_livros, parent, false);

        return new ViewHolder(linha);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Livro livro = livros.get(position);

        holder.tvNome.setText(livro.getNome());

        holder.itemView.setOnClickListener(view -> {
            if(livro.getSituacao().equalsIgnoreCase("Desejado")){
                context.startActivity(new Intent(context, DesejadoActivity.class).putExtra("posicao", livro.getId()));
            }else if (livro.getSituacao().equalsIgnoreCase("Lendo")){
                context.startActivity(new Intent(context, LendoActivity.class).putExtra("posicao", livro.getId()));
            }else{
                context.startActivity(new Intent(context, LidoActivity.class).putExtra("posicao", livro.getId()));
            }
        });
        holder.itemView.setOnLongClickListener(view -> {
            PopupMenu popupMenu = new PopupMenu(context, holder.itemView);
            popupMenu.getMenuInflater().inflate(R.menu.menu_popup, popupMenu.getMenu());
            popupMenu.setOnMenuItemClickListener(menuItem -> {
                if(menuItem.getItemId() == R.id.excluir){
                    livros.remove(livro);
                    userLog.removeLivro(livro);
                    usuarioBox.put(userLog);
                    notifyItemRangeChanged(position, getItemCount());
                    notifyItemRemoved(position);
                }/*else if(menuItem.getItemId()   == R.id.editar){
                    Intent intent = new Intent(context, CadastroLivroActivity.class);
                    intent.putExtra("position", position);
                    context.startActivity(intent);
                }*/
                return true;
            });
            popupMenu.show();
            return true;
        });

    }


    @Override
    public int getItemCount() {
        return this.livros.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private TextView tvNome;

        public ViewHolder(View itemView) {
            super(itemView);

            tvNome = itemView.findViewById(R.id.tv_nome);
        }
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

}