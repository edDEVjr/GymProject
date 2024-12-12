package com.example.gym_project.services;

import com.example.gym_project.dto.FuncionarioDTO;
import com.example.gym_project.models.Funcionario;
import com.example.gym_project.repositories.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FuncionarioService {
    private FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public boolean create(FuncionarioDTO funcionarioDTO) {
        try{
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
    

    public List<Funcionario> findAll() {
        return funcionarioRepository.findAll();
    }

    public Funcionario findById(FuncionarioDTO funcionarioDTO) {
        if (funcionarioRepository.existsById(funcionarioDTO.getId())) {
            return funcionarioRepository.findById(funcionarioDTO.getId()).get();
        }
        return null;
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
