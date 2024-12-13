package com.example.gym_project.controllers;

import com.example.gym_project.dto.FuncionarioDTO;
import com.example.gym_project.services.FuncionarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    private final FuncionarioService funcionarioService;
    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @GetMapping("")
    public ResponseEntity<List<FuncionarioDTO>>showFuncionarios() {
        List<FuncionarioDTO> funcionarios = funcionarioService.getAll();
        return new ResponseEntity<>(funcionarios,HttpStatus.OK);
    }


    @PostMapping("/new")
    public ResponseEntity<FuncionarioDTO> createFuncionario(@RequestBody FuncionarioDTO funcionarioDTO) {
        if(this.funcionarioService.create(funcionarioDTO)){
            return new ResponseEntity<>(funcionarioDTO,HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }










}
