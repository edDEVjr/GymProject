package com.example.gym_project.models;

import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Table (name = "funcionario")
public class Funcionario  {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String nome;
    private Date DataNascimento;
    private String CPF;

    @Deprecated
    public Funcionario() {}

    public Funcionario(String nome, Date dataNascimento, String CPF){
        this.nome = nome;
        DataNascimento = dataNascimento;
        this.CPF = CPF;
    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return DataNascimento;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public void setDataNascimento(Date dataNascimento) {
        DataNascimento = dataNascimento;
    }
}
