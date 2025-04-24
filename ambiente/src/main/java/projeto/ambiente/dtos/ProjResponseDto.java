package projeto.ambiente.dtos;

public record ProjResponseDto(
    Long id,
    String nome,
    String descricao,
    String regiao,
    double estimaCo2
){}