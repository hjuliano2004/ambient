package projeto.ambiente.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "organizacao")
public class Organizacao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 32, unique = true)
    private String nome;

    @Column(nullable = false, length = 32)
    private String email;

    @ManyToOne//oneToOne é semelhante, mas consegue espelhar as classes ao apagar
    @JoinColumn(nullable = false, name = "id_projeto")
    private Projeto projeto;
}