package com.example.gym_project.dto;

import com.example.gym_project.models.Funcionario;


import java.time.LocalDate;
import java.util.UUID;

public class FuncionarioDTO {
    private UUID id;
    private String nome;
    private String CPF;
    private LocalDate dataNascimento;

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

    public FuncionarioDTO(Funcionario funcionario) {
        this.id = funcionario.getId();
        this.nome = funcionario.getNome();
        this.CPF = funcionario.getCPF();
        this.dataNascimento = funcionario.getDataNascimento();
    }
}
