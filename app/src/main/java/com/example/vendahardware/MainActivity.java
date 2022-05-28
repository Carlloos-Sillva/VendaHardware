package com.example.vendahardware;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText login,senha;
    Button logar;
    TextView abrirConta, verContas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        abrirConta = findViewById(R.id.txtAbrirConta);
        login = findViewById(R.id.edtLoginLogin);
        senha = findViewById(R.id.edtSenhaLogin);
        logar = findViewById(R.id.btnLogarLogin);
        logar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Logar();
            }
        });
        abrirConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chamaTela();
            }
        });

        verContas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VerConta();
            }
        });
    }

    public void chamaTela()
    {
        Intent telaCriaConta = new Intent(this, CriaConta.class);
        startActivity(telaCriaConta);
    }

    public void Logar()
    {
        String c= login.getText().toString();
        String s =  senha.getText().toString();
        ContaCliente cc = new ContaCliente();
        if (login.getText().toString().isEmpty() && senha.getText().toString().isEmpty()){
            Toast.makeText(this, "LOGIN INVÁLIDO", Toast.LENGTH_LONG).show();
        }else if ( BaseDados.getInstance(this).getDAO().Logar(c,s)==null){
            Toast.makeText(this, "LOGIN INVÁLIDO", Toast.LENGTH_LONG).show();
        }else{

            Intent telaConta = new Intent(this, Conta.class);
            startActivity(telaConta);
        }
    }
    public void VerConta(){
        Intent telaVerConta = new Intent(this, VerContas.class);
        startActivity(telaVerConta);
    }
}