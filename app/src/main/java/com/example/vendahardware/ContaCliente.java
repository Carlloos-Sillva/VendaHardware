package com.example.vendahardware;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class ContaCliente {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id;
    @ColumnInfo(name="Nome")
    private String nome;
    @ColumnInfo(name="Cpf")
    private String cpf;
    @ColumnInfo(name="Email")
    private String email;
    @ColumnInfo(name="Senha")
    private String senha;
    @ColumnInfo(name="Conta")
    private String conta;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }
}
