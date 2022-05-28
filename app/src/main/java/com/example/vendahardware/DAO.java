package com.example.vendahardware;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;


@Dao
public interface DAO {
   @Insert
   void InsereConta(ContaCliente conta);

    @Query("SELECT * FROM ContaCliente")
    List<ContaCliente> getAll();

    @Query("SELECT * FROM ContaCliente WHERE cpf=(:cpfcc) and senha=(:senhacc)")
    ContaCliente Logar(String cpfcc, String senhacc);

@Delete
     void DeletarConta(ContaCliente conta);
    // @Delete
    // void resetListaContas(List<ContaCliente>conta);
    @Query("UPDATE ContaCliente SET Nome = :Snome, Cpf =:Scpf, Email =:Semail, Senha =:Ssenha, Conta=:Sconta   WHERE id = :Sid")
     void update(int Sid, String Snome,String Scpf,String Semail,String Ssenha, String Sconta);
    //@Query("UPDATE ContaCliente SET Nome = :Snome WHERE id = :Sid")
   // void update(int Sid, String Snome);
}
