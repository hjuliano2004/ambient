package projeto.ambiente.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 32, unique = true)
    private String nome;

    @Column(nullable = false, length = 64)
    private String descricao;

    @Column(nullable = false, length = 16)
    private String regiao;

    private double estimaCo2;

    @OneToMany(mappedBy = "projeto")
    private List<Organizacao> organizacoes;

}
