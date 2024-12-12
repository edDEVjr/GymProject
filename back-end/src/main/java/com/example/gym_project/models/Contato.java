package com.example.gym_project.models;

import com.example.gym_project.repositories.FuncionarioRepository;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "contato")
public class Contato {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String email;
    private String telefone;

    @Deprecated
    public Contato() {}

    public Contato(String email, String telefone) {
        this.email = email;
        this.telefone = telefone;
    }

    public UUID getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }


}
