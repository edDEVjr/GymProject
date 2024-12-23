package com.example.gym_project.dto;

import com.example.gym_project.models.Contato;
import com.example.gym_project.models.Endereco;
import com.example.gym_project.models.Funcionario;


import java.time.LocalDate;
import java.util.UUID;

public class FuncionarioDTO {
    private UUID id;
    private String nome;
    private String CPF;
    private LocalDate dataNascimento;
    private Endereco endereco;
    private Contato contato;

    public FuncionarioDTO() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public Endereco getEndereco() {
        return endereco;
    }
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Contato getContato() {
        return contato;
    }
    public void setContato(Contato contato) {
        this.contato = contato;
    }


    public FuncionarioDTO(Funcionario funcionario){
        this.id = funcionario.getId();
        this.nome = funcionario.getNome();
        this.CPF = funcionario.getCPF();
        this.dataNascimento = funcionario.getDataNascimento();
        this.endereco = funcionario.getEndereco();
        this.contato = funcionario.getContato();
    }

    public FuncionarioDTO toFuncionario(Funcionario funcionario){
        return new FuncionarioDTO(funcionario);
    }
}
