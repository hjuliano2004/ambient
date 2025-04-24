package projeto.ambiente.mappers;

import projeto.ambiente.dtos.OrganRequestDto;
import projeto.ambiente.dtos.OrganResponseDto;
import projeto.ambiente.entities.Organizacao;

public class OrganMapper {
    private OrganMapper(){};



    public static Organizacao toEntity(OrganRequestDto dto){

        Organizacao organizacao = new Organizacao();
        organizacao.setNome(dto.nome());
        organizacao.setEmail(dto.email());
        return organizacao;
    }

    public static OrganResponseDto toDto(Organizacao organizacao){
        return new OrganResponseDto(organizacao.getId(),
         organizacao.getNome(),
          organizacao.getEmail(),
        ProjMapper.toDto(organizacao.getProjeto()));
    }
}
