package com.example.vendahardware;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class VerContas extends AppCompatActivity {

    RecyclerView recicle_view;
    List<ContaCliente> dataList = new ArrayList<>();
    LinearLayoutManager linearLayoutManager;
    BaseDados dataBase;
    MainAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_contas);

        recicle_view = findViewById(R.id.recycler_view);
        // INICIALIZANDO DATABASE
        dataBase = BaseDados.getInstance(this);
        // LISTANDO O MEU DATABASE NO OBJETO DATALIST
        dataList = dataBase.getDAO().getAll();
        // inicializando linear layout gerenciador
        linearLayoutManager = new LinearLayoutManager(this);
        // setando layout gerenciador
        recicle_view.setLayoutManager(linearLayoutManager);
        // inializando adapter
        adapter = new MainAdapter(VerContas.this,dataList);
        // setando adapter
        recicle_view.setAdapter(adapter);

}
}