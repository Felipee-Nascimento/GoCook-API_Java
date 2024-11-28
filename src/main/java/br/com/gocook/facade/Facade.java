package br.com.gocook.facade;

import br.com.gocook.domain.receitas.Receita;
import br.com.gocook.domain.user.User;
import br.com.gocook.dto.ReceitaDTO;
import br.com.gocook.repositories.ReceitaRepository;
import br.com.gocook.specification.ReceitaSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class Facade {

    @Autowired
    private ReceitaRepository repository;

    public ReceitaDTO criar(ReceitaDTO receitaDTO, User user){
        Receita receita = new Receita();
        receita.setTitulo(receitaDTO.getTitulo());
        receita.setIngrediente(receitaDTO.getIngrediente());
        receita.setTempoDePreparo(receitaDTO.getTempoDePreparo());
        receita.setModoDePreparo(receitaDTO.getModoDePreparo());
        receita.setQuantidadeDePessoasServidas(receitaDTO.getQuantidadeDePessoasServidas());
        receita.setUser(user);
        repository.save(receita);
        receitaDTO.setId(receita.getId());
        return receitaDTO;
    }

    public ReceitaDTO atualizar(ReceitaDTO receitaDTO, Long receitaId) {
        Receita receitaDatabase = repository.getReferenceById(receitaId);
        receitaDatabase.setTitulo(receitaDTO.getTitulo());
        receitaDatabase.setIngrediente(receitaDTO.getIngrediente());
        receitaDatabase.setTempoDePreparo(receitaDTO.getTempoDePreparo());
        receitaDatabase.setModoDePreparo(receitaDTO.getModoDePreparo());
        receitaDatabase.setQuantidadeDePessoasServidas(receitaDTO.getQuantidadeDePessoasServidas());

        repository.save(receitaDatabase); // Persist the changes

        return new ReceitaDTO(receitaDatabase); // Return the updated entity as DTO
    }


    public ReceitaDTO getById(Long receitaId){
        Receita receita = repository.getReferenceById(receitaId);
        return new ReceitaDTO(receita);
    }

    private ReceitaDTO converter(Receita receita) {
         return new ReceitaDTO(receita);
    }

    public List<ReceitaDTO> getAll (String userId){
        return repository.findByUserId(userId) // Filtra receitas pelo usuário
                .stream()
                .map(this::converter)
                .collect(Collectors.toList());
    }

    public List<ReceitaDTO> getFilteredReceitas(String userId, String nome, String categoria) {
        // Cria a Specification com base nos parâmetros
        Specification<Receita> specification = Specification.where(ReceitaSpecification.hasUserId(userId))
                .and(ReceitaSpecification.hasNome(nome))
                .and(ReceitaSpecification.hasCategoria(categoria));

        // Envia a Specification para o repositório e retorna as receitas filtradas
        return repository.findAll(specification)
                .stream()
                .map(this::converter)
                .collect(Collectors.toList());
    }


    public String delete(Long receitaId){
        repository.deleteById(receitaId);
        return "DELETED";
    }
}
