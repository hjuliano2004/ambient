package projeto.ambiente.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;

import projeto.ambiente.dtos.ProjRequestDto;
import projeto.ambiente.dtos.ProjResponseDto;
import projeto.ambiente.entities.Projeto;
import projeto.ambiente.servicos.ProjetoServices;

@RestController
@RequestMapping("projetos")
public class ProjetoController {
    @Autowired
    private ProjetoServices service;

    @GetMapping
    public List<ProjResponseDto> get(String search){
        return service.findAll(search);
    }

    @GetMapping("{id}")
    public ProjResponseDto findById(@PathVariable Long id){
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProjResponseDto post(@RequestBody ProjRequestDto dto){
        return service.create(dto);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

    @PutMapping("{id}")
    public Projeto put(@PathVariable Long id, @RequestBody Projeto projeto){
        projeto.setId(id);
        return service.save(projeto);
    }
    
}
