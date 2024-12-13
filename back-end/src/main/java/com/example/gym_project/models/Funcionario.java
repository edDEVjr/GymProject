package com.example.gym_project.models;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table (name = "funcionario")
public class Funcionario  {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String nome;
    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;
    private String CPF;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contato_id",referencedColumnName = "id")
    private Contato contato;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id",referencedColumnName = "id")
    private Endereco endereco;

    @Deprecated
    public Funcionario() {}

    public Funcionario(String nome, LocalDate dataNascimento, String CPF){
        this.nome = nome;
        this.dataNascimento = dataNascimento;
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

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }


    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
