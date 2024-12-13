package com.example.gym_project.services;

import com.example.gym_project.dto.FuncionarioDTO;
import com.example.gym_project.models.Funcionario;
import com.example.gym_project.repositories.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public List<FuncionarioDTO> getAll() {
        List<Funcionario> funcionarios = funcionarioRepository.findAll();
        return funcionarios.stream()
                .map(FuncionarioDTO::new)
                .collect(Collectors.toList());

    }

    public FuncionarioDTO findById(FuncionarioDTO funcionarioDTO) {
        if (funcionarioRepository.existsById(funcionarioDTO.getId())) {
            Funcionario funcionario = funcionarioRepository.findById(funcionarioDTO.getId()).get();
            return new FuncionarioDTO(funcionario);
        }else{
            return null;
        }
    }

    public boolean save(Funcionario funcionario) {
        try{
            funcionarioRepository.save(funcionario);
            return true;
        }catch (Exception e){
            return false;
        }

    }

    public boolean delete(FuncionarioDTO funcionarioDTO) {
        if(funcionarioRepository.existsById(funcionarioDTO.getId())) {
            funcionarioRepository.deleteById(funcionarioDTO.getId());
            return true;
        }else{
            return false;
        }
    }

}
