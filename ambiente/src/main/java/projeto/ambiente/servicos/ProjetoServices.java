package projeto.ambiente.servicos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projeto.ambiente.Repositorios.ProjRep;
import projeto.ambiente.dtos.ProjRequestDto;
import projeto.ambiente.dtos.ProjResponseDto;
import projeto.ambiente.entities.Projeto;
import projeto.ambiente.mappers.ProjMapper;

@Service
public class ProjetoServices {

    @Autowired 
    private ProjRep repository;

    public List<ProjResponseDto>findAll(String search){
        List<Projeto> projetos;
        if(search == null || search.isEmpty()){
            projetos = repository.findAll();
        }else{
            projetos = repository.findByNomeOrDescricao(search);
        }

        List<ProjResponseDto> response = new ArrayList<>();

        for(Projeto projeto : projetos){
            response.add(ProjMapper.toDto(projeto));
        }

        return response;
    }

    public ProjResponseDto findById(Long id){
        Optional<Projeto> projetoOpt = repository.findById(id);
        if(projetoOpt.isPresent()){
            Projeto projeto = projetoOpt.get();
            return ProjMapper.toDto(projeto);
        }
        return null;
    }

    public ProjResponseDto create(ProjRequestDto dto){
        Projeto projeto = ProjMapper.toEntit(dto);
        projeto = repository.save(projeto);
        return ProjMapper.toDto(projeto);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public Projeto findByIdn(Long id){
        return repository.findById(id).orElse(null);
    }

    public Projeto save(Projeto projeto){
        if(projeto.getId() != null){
           Projeto old = findByIdn(projeto.getId());
           if(old != null){
            projeto.setId(old.getId());
           }else{
            projeto.setId(null);
           }
        }
        return repository.save(projeto);
    }

}