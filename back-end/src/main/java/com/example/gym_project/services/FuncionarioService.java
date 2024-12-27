package com.example.gym_project.services;

import com.example.gym_project.dto.FuncionarioDTO;
import com.example.gym_project.models.Funcionario;
import com.example.gym_project.repositories.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class FuncionarioService {
    private FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public boolean create(FuncionarioDTO funcionarioDTO) {
        try{
            System.out.println(funcionarioDTO);
            Funcionario newFuncionario = new Funcionario();
            newFuncionario.setNome(funcionarioDTO.getNome());
            newFuncionario.setCPF(funcionarioDTO.getCPF());
            newFuncionario.setDataNascimento(funcionarioDTO.getDataNascimento());
            save(newFuncionario);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public boolean update(FuncionarioDTO funcionarioDTO) {
        Optional<Funcionario> optionalFuncionario = funcionarioRepository.findById(funcionarioDTO.getId());
        if(optionalFuncionario.isPresent()){
            Funcionario funcionario = optionalFuncionario.get();
            funcionario.setNome(funcionarioDTO.getNome());
            funcionario.setCPF(funcionarioDTO.getCPF());
            funcionario.setDataNascimento(funcionarioDTO.getDataNascimento());
            save(funcionario);
            return true;
        }else{
            return false;
        }

    }

    public List<FuncionarioDTO> getAll() {
        List<Funcionario> funcionarios = funcionarioRepository.findAll();
        return funcionarios.stream()
                .map(FuncionarioDTO::new)
                .collect(Collectors.toList());

    }

    public Optional<Funcionario> getById(UUID id) {
            Optional<Funcionario> funcionario = funcionarioRepository.findById(id);
            return funcionario;
    }

    public boolean save(Funcionario funcionario) {
        try{
            funcionarioRepository.save(funcionario);
            return true;
        }catch (Exception e){
            return false;
        }

    }

    public boolean delete(UUID id) {
        if(funcionarioRepository.existsById(id)) {
            funcionarioRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

}
