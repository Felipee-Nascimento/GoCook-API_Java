package br.com.gocook.facade;

import br.com.gocook.dto.ReceitaDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class Facade {
    private static final Map<Long, ReceitaDTO> receitas = new HashMap<>();

    public ReceitaDTO criar(ReceitaDTO receitaDTO){
        Long nextId = receitas.keySet().size() + 1L;
        receitaDTO.setId(nextId);
        receitas.put(nextId, receitaDTO);
        return receitaDTO;
    }

    public ReceitaDTO atualizar(ReceitaDTO receitaDTO, Long receitaId){
        receitas.put(receitaId, receitaDTO);
        return receitaDTO;
    }

    public ReceitaDTO getById(Long receitaId){
        return receitas.get(receitaId);
    }

    public List<ReceitaDTO> getAll (){
        return new ArrayList<>(receitas.values());
    }

    public String delete(Long receitaId){
        receitas.remove(receitaId);
        return "DELETE";
    }
}
