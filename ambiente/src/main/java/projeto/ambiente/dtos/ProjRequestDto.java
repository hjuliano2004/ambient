package projeto.ambiente.dtos;

public record ProjRequestDto(
    String nome,
    String descricao,
    String regiao,
    double estimaCo2
){}