package com.example.gym_project.repositories;

import com.example.gym_project.models.Contato;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ContatoRepository extends JpaRepository<Contato, UUID> {
}
