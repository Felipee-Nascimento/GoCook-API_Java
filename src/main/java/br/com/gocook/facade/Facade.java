package br.com.gocook.facade;

import br.com.gocook.domain.receitas.Receita;
import br.com.gocook.dto.ReceitaDTO;
import br.com.gocook.repositories.ReceitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public ReceitaDTO criar(ReceitaDTO receitaDTO){
        Receita receita = new Receita();
        receita.setTitulo(receitaDTO.getTitulo());
        receita.setIngrediente(receitaDTO.getIngrediente());
        receita.setTempoDePreparo(receitaDTO.getTempoDePreparo());
        receita.setModoDePreparo(receitaDTO.getModoDePreparo());
        receita.setQuantidadeDePessoasServidas(receitaDTO.getQuantidadeDePessoasServidas());
        repository.save(receita);
        receitaDTO.setId(receita.getId());
        return receitaDTO;
    }

    public ReceitaDTO atualizar(ReceitaDTO receitaDTO, Long receitaId){
        Receita receitaDatabase = repository.getOne(receitaId);
        receitaDatabase.setTitulo(receitaDTO.getTitulo());
        receitaDatabase.setIngrediente(receitaDTO.getIngrediente());
        receitaDatabase.setTempoDePreparo(receitaDTO.getTempoDePreparo());
        receitaDatabase.setModoDePreparo(receitaDTO.getModoDePreparo());
        receitaDatabase.setQuantidadeDePessoasServidas(receitaDTO.getQuantidadeDePessoasServidas());
        return receitaDTO;
    }

//    public ReceitaDTO getById(Long receitaId){
//
//    }
////
////    public ReceitaDTO getById(Long receitaId){
////        return receitas.get(receitaId);
////    }
////
    private ReceitaDTO converter(Receita receita) {
        ReceitaDTO result = new ReceitaDTO();
        result.setId(receita.getId());
        result.setTitulo(receita.getTitulo());
        result.setIngrediente(receita.getIngrediente());
        result.setTempoDePreparo(receita.getTempoDePreparo());
        result.setModoDePreparo(receita.getModoDePreparo());
        result.setQuantidadeDePessoasServidas(receita.getQuantidadeDePessoasServidas());
        return result;
    }

    public List<ReceitaDTO> getAll (){
        return repository.findAll()
                .stream()
                .map(this::converter)
                .collect(Collectors.toList());
    }



    public String delete(Long receitaId){
        repository.deleteById(receitaId);
        return "DELETED";
    }
}
