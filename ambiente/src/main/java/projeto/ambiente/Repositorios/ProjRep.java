package projeto.ambiente.Repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import projeto.ambiente.entities.Projeto;

public interface ProjRep extends JpaRepository<Projeto, Long> {
        List<Projeto> findByNomeContainingIgnoreCase(String nome);

    @Query("SELECT m " +
    "FROM Projeto m " +
     "WHERE UPPER(m.nome)        LIKE '%'||UPPER(:search)||'%'" + 
        "OR UPPER(m.descricao) LIKE '%'||UPPER(:search)||'%'")
    List<Projeto> findByNomeOrDescricao(String search);

    @Query("SELECT m " + 
    "FROM Projeto m " +
     "WHERE UPPER(m.nome)        LIKE '%'||UPPER(:search)||'%'" + 
        "OR UPPER(m.descricao) LIKE '%'||UPPER(:search)||'%'")
    List<String>findNomesByNomeOrDescricao(String search);
}