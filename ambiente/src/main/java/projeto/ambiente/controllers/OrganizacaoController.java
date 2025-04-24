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

import projeto.ambiente.dtos.OrganRequestDto;
import projeto.ambiente.dtos.OrganResponseDto;
import projeto.ambiente.entities.Organizacao;
import projeto.ambiente.servicos.OrganizacaoService;


@RestController
@RequestMapping("organizacao")

public class OrganizacaoController {

    @Autowired
    private OrganizacaoService service;

    @GetMapping
    public List<OrganResponseDto> get(String search){
        return service.findAll(search);
    }

    @GetMapping("{id}")
    public OrganResponseDto getById(@PathVariable Long id){
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrganResponseDto post(@RequestBody OrganRequestDto dto){
        return service.create(dto);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id){
        service.delete(id);
    }

    @PutMapping("{id}")
    public Organizacao put(@PathVariable Long id, @RequestBody Organizacao organizacao){
        organizacao.setId(id);
        return service.save(organizacao);
    }
}
