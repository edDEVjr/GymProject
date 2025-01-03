package com.example.gym_project.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table( name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false)
    private String nome;
    @Column(unique = true,nullable = false)
    private String CPF;
    @Column(nullable = false)
    private LocalDate dataNascimento;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contato_id",referencedColumnName = "id")
    private Contato contato;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id",referencedColumnName = "id")
    private Endereco endereco;

    @Deprecated
    public Cliente() {}

    public Cliente(String nome, String CPF, LocalDate dataNascimento) {
        this.nome = nome;
        this.CPF = CPF;
        this.dataNascimento = dataNascimento;
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

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
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
