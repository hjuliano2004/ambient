package projeto.ambiente.servicos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projeto.ambiente.Repositorios.OrganRep;
import projeto.ambiente.dtos.OrganRequestDto;
import projeto.ambiente.dtos.OrganResponseDto;
import projeto.ambiente.entities.Organizacao;
import projeto.ambiente.entities.Projeto;
import projeto.ambiente.mappers.OrganMapper;


@Service
public class OrganizacaoService {
    
    @Autowired
    private OrganRep repository;

    @Autowired
    private ProjetoServices projetoservice;

        public List<OrganResponseDto>findAll(String search){
        List<Organizacao> organizacoes;
        if(search == null || search.isEmpty()){
            organizacoes = repository.findAll();
        }else{
            organizacoes = repository.findByNomeOrEmail(search);
        }

        List<OrganResponseDto> response = new ArrayList<>();

        for(Organizacao organizacao : organizacoes){
            response.add(OrganMapper.toDto(organizacao));
        }

        return response;
    }


    public OrganResponseDto findById(Long id){
            return OrganMapper.toDto(findEntityById(id));
    }

    private Organizacao findEntityById(Long id){
        Optional<Organizacao> organizacaoOpt = repository.findById(id);
        if(organizacaoOpt.isPresent()){
            return organizacaoOpt.get();
        }
        return null;
    }


    public OrganResponseDto create(OrganRequestDto dto){
        Organizacao organizacao = OrganMapper.toEntity(dto);
        //TODO validar e buscar categoria existente
        Projeto projeto = projetoservice.findByIdn(dto.projetoId());
        if(projeto != null){
            organizacao.setProjeto(projeto);
        }else{
            //o ideal é retornar 'throw'
            return null;
        }

        organizacao = repository.save(organizacao);
        return OrganMapper.toDto(organizacao);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }  


    public Organizacao findByIdn(Long id){
        return repository.findById(id).orElse(null);
    }

    public OrganResponseDto update(Long id, OrganRequestDto dto){
        Organizacao organizacao = findEntityById(id);
        if(organizacao != null){
            organizacao.setNome(dto.nome());
            organizacao.setEmail(dto.email());
            organizacao.setProjeto(projetoservice.findByIdn(dto.projetoId()));
        }


        return null;
    }


    /*insert or update */

    public Organizacao save (Organizacao organizacao){
        if(organizacao.getId() != null){
            Organizacao old = findByIdn(organizacao.getId());
            if(old != null){
                organizacao.setId(old.getId());
            }else{
                organizacao.setId(null);
            }
        }
        return repository.save(organizacao);
    }

    
}