package com.example.gym_project.controllers;

import com.example.gym_project.dto.FuncionarioDTO;
import com.example.gym_project.models.Funcionario;
import com.example.gym_project.services.FuncionarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    private final FuncionarioService funcionarioService;
    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @GetMapping("")
    public ResponseEntity<List<FuncionarioDTO>>index() {
        List<FuncionarioDTO> funcionarios = funcionarioService.getAll();
        return new ResponseEntity<>(funcionarios,HttpStatus.OK);
    }


    @PostMapping("/new")
    public ResponseEntity<FuncionarioDTO> create(@RequestBody FuncionarioDTO funcionarioDTO) {
        if(this.funcionarioService.create(funcionarioDTO)){
            return new ResponseEntity<>(funcionarioDTO,HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> show(@PathVariable UUID id) {
            Optional<Funcionario> funcionario = funcionarioService.getById(id);
            if(funcionario.isPresent()){
                return new ResponseEntity<>(funcionario.get(),HttpStatus.OK);
            }else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

    }

    @PutMapping("/{id}/edit")
    public ResponseEntity<FuncionarioDTO> update(@PathVariable UUID id, @RequestBody FuncionarioDTO funcionarioDTO) {
        Optional<Funcionario> funcionario = funcionarioService.getById(id);
        if(funcionario.isPresent()) {
            funcionarioDTO.setId(id);
            funcionarioService.update(funcionarioDTO);
            return new ResponseEntity<>(funcionarioDTO, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }









}
