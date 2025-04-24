package projeto.ambiente.mappers;

import projeto.ambiente.dtos.ProjRequestDto;
import projeto.ambiente.dtos.ProjResponseDto;
import projeto.ambiente.entities.Projeto;

public class ProjMapper {
    private ProjMapper(){}

    public static Projeto toEntit(ProjRequestDto dto){
        Projeto projeto = new Projeto();
        projeto.setNome(dto.nome());
        projeto.setDescricao(dto.descricao());
        projeto.setEstimaCo2(dto.estimaCo2());
        projeto.setRegiao(dto.regiao());

        return projeto;
    }









    public static ProjResponseDto toDto(Projeto projeto){
        if(projeto == null){
            return null;
        }
        return new ProjResponseDto(
         projeto.getId(),
         projeto.getNome(),
         projeto.getDescricao(),
         projeto.getRegiao(), projeto.getEstimaCo2());
    }
    
}