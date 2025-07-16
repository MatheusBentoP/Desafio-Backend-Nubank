package br.com.java.Nubank.repository;

import br.com.java.Nubank.models.Contatos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IContatosRepository extends JpaRepository<Contatos, Long> {
}
