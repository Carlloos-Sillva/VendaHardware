package com.example.vendahardware;

import android.app.Activity;
import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
    // Inicializando as variaveis
    private List<ContaCliente> dataList;
    private Activity context;
    private BaseDados database;
    public MainAdapter(VerContas context, List<ContaCliente>dataList)
    { this.dataList = dataList;}
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.linha_recyclerview,parent,false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // INICIALIZANDO A TABELA
        ContaCliente data = dataList.get(position);
        // INICIALIZANDO DATABASE
        database = BaseDados.getInstance(context);
        // setando o text no textview
        holder.nome.setText(data.getNome());
        holder.cpf.setText(data.getCpf());
        holder.email.setText(data.getEmail());
        holder.senha.setText(data.getSenha());
        holder.conta.setText(data.getConta());
        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // inicialisando o mainData /
                ContaCliente d = dataList.get(holder.getAdapterPosition());
                int Id = d.getId();
                String snome = d.getNome();
                String scpf = d.getCpf();
                String semail = d.getEmail();
                String ssenha = d.getSenha();
                String sconta = d.getConta();
                final Dialog dialog  = new Dialog(v.getContext());
                 dialog.setCancelable(true);
                 dialog.setContentView(R.layout.layout_update);
                EditText editnome = dialog.findViewById(R.id.edtNomeEdit);
                EditText editcpf = dialog.findViewById(R.id.edtCpfEdit);
                EditText editemail = dialog.findViewById(R.id.edtEmailEdit);
                EditText editsenha = dialog.findViewById(R.id.edtSenhaEdit);
                EditText editconta = dialog.findViewById(R.id.edtContaEdit);
                Button btUpdate = dialog.findViewById(R.id.button);
                editnome.setText(snome);
                editcpf.setText(scpf);
                editemail.setText(semail);
                editsenha.setText(ssenha);
                editconta.setText(sconta);
                btUpdate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // DISSMISS DIALOGO/
                        dialog.dismiss();
                        String unome = editnome.getText().toString();
                        String ucpf = editcpf.getText().toString();
                        String uemail = editemail.getText().toString();
                        String usenha = editsenha.getText().toString();
                        String uconta = editconta.getText().toString();
                        database.getDAO().update(Id,unome,ucpf,uemail,usenha,uconta);
                        // NOTIFICA QUANDO DADO FOR ALTERADO/
                        dataList.clear();
                        dataList.addAll(database.getDAO().getAll());
                        notifyDataSetChanged();
                    }}
                );
  dialog.show();
            }
        });

        holder.del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // INICIALIZANDO MAINDATA
                ContaCliente d = dataList.get(holder.getAdapterPosition());
                database.getDAO().DeletarConta(d);
                int position = holder.getAdapterPosition();
                dataList.remove(position);
                notifyItemRemoved(position);
               notifyItemRangeChanged(position,dataList.size());
            }
        });
    }
    @Override
    public int getItemCount() {
        return dataList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView nome,cpf,email,senha,conta;
        ImageView del,edit;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nome = itemView.findViewById(R.id.linha_nome);
            cpf = itemView.findViewById(R.id.linha_cpf);
            email = itemView.findViewById(R.id.linha_email);
            senha = itemView.findViewById(R.id.linha_senha);
            conta = itemView.findViewById(R.id.linha_cc);
            del = itemView.findViewById(R.id.imgdel);
            edit = itemView.findViewById(R.id.imgedit);
        }
    }
}
