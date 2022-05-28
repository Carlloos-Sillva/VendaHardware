package com.example.vendahardware;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Random;

public class CriaConta extends AppCompatActivity {
EditText nome,cpf,email,senha,conta;
Button gravar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cria_conta);

        nome = findViewById(R.id.edtNomeCria);
        cpf = findViewById(R.id.edtCpfCria);
        email = findViewById(R.id.edtEmailCria);
        senha = findViewById(R.id.edtSenhaCria);
        gravar = findViewById(R.id.btnCriaConta);
        conta = findViewById(R.id.edtConta);
        gravar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GravarDados();
            }
        });
    }
    public String geraConta(){

        Random numero = new Random();
        int conta = 1 + numero.nextInt(9999);
        int digito = 1 + numero.nextInt(9);
    String  v=  conta +"-"+ digito;
        return v;
    }
    public void GravarDados()
    {
      String y =   geraConta();

        ContaCliente cc = new ContaCliente();
        cc.setNome(nome.getText().toString());
        cc.setCpf(cpf.getText().toString());
        cc.setEmail(email.getText().toString());
        cc.setSenha(senha.getText().toString());
        conta.setText(y);
        cc.setConta(conta.getText().toString());

        BaseDados.getInstance(this).getDAO().InsereConta(cc);


    }

}