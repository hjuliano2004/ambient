package projeto.ambiente.Repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import projeto.ambiente.entities.Organizacao;

public interface OrganRep extends JpaRepository<Organizacao, Long>{
    List<Organizacao> findByNomeContainingIgnoreCase(String nome);

    @Query("SELECT m " +
    "FROM Organizacao m " +
    "WHERE UPPER(m.nome)  LIKE '%'||UPPER(:search)||'%'" +
    "OR UPPER(m.email)    LIKE '%'||UPPER(:search)||'%'")
    List<Organizacao> findByNomeOrEmail(String search);

    @Query("SELECT m " +
    "FROM Organizacao m " +
    "WHERE UPPER(m.nome)  LIKE '%'||UPPER(:search)||'%'" +
    "OR UPPER(m.email)    LIKE '%'||UPPER(:search)||'%'")
    List<Organizacao> findNomesByNomeOrEmail(String search);
    
}
