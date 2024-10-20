package br.com.gocook.api;

import br.com.gocook.dto.ReceitaDTO;
import br.com.gocook.facade.Facade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@Controller
@RequestMapping(value = "/receitas", produces = MediaType.APPLICATION_JSON_VALUE)
public class ReceitasAPI {

    @Autowired
    private Facade facade;

    @PostMapping
    @ResponseBody
    public ReceitaDTO criar(@RequestBody ReceitaDTO receitaDTO){
        return facade.criar(receitaDTO);
    }

    @PutMapping("/{receitaId}")
    @ResponseBody
    public ReceitaDTO atualizar(@PathVariable("receitaId") Long receitaId, @RequestBody ReceitaDTO receitaDTO){
        return facade.atualizar(receitaDTO, receitaId);
    }

    @GetMapping
    @ResponseBody
    public List<ReceitaDTO> getAll(){
        return facade.getAll();
    }

    @DeleteMapping("/{receitaId}")
    @ResponseBody
    public String deletar(@PathVariable("receitaId") Long receitaId){
        return facade.delete(receitaId);
    }
}
