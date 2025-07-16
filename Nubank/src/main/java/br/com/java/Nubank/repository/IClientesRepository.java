package br.com.java.Nubank.repository;

import br.com.java.Nubank.models.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClientesRepository extends JpaRepository<Clientes, Long> {
}
