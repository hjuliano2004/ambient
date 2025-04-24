package projeto.ambiente.dtos;

public record OrganResponseDto(
     Long id,
     String nome,
     String email,
     ProjResponseDto projeto
) {}