package br.com.gocook.controllers;

import br.com.gocook.domain.receitas.Receita;
import br.com.gocook.domain.user.User;
import br.com.gocook.dto.ReceitaDTO;
import br.com.gocook.facade.Facade;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.List;

@Controller
@RequestMapping(value = "/receitas", produces = MediaType.APPLICATION_JSON_VALUE)
public class ReceitaController {

    @Autowired
    private Facade facade;

    @PostMapping
    @ResponseBody
    public ReceitaDTO criar(@RequestBody ReceitaDTO receitaDTO) throws Exception {
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        if(!(authentication.getPrincipal() instanceof User)){
            throw new Exception("USER NOT FOUND");
        }
        return facade.criar(receitaDTO, user);
    }


    @PutMapping("/{receitaId}")
    @ResponseBody
    public ReceitaDTO atualizar(@PathVariable("receitaId") Long receitaId, @RequestBody ReceitaDTO receitaDTO){
        return facade.atualizar(receitaDTO, receitaId);
    }

    @GetMapping
    @ResponseBody
    public List<ReceitaDTO> getAll(
            @RequestParam(required = false) String titulo,
            @RequestParam(required = false) Integer tempoDePreparo,
            @RequestParam(required = false) Integer quantidadeDePessoasServidas
    ) throws Exception {
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        if(!(authentication.getPrincipal() instanceof User)){
            throw new Exception("USER NOT FOUND");
        }
        return facade.getAll(user.getId(), titulo, tempoDePreparo, quantidadeDePessoasServidas);
    }

    @GetMapping("/{receitaId}")
    @ResponseBody
    public ReceitaDTO getById(@PathVariable("receitaId") Long receitaId){
        return facade.getById(receitaId);
    }

    @DeleteMapping("/{receitaId}")
    @ResponseBody
    public String deletar(@PathVariable("receitaId") Long receitaId){
        return facade.delete(receitaId);
    }
}
