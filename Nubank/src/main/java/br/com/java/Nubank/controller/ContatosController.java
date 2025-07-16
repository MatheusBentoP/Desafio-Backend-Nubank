package br.com.java.Nubank.controller;

import br.com.java.Nubank.dto.contato.ContatosDTO;
import br.com.java.Nubank.models.Clientes;
import br.com.java.Nubank.models.Contatos;
import br.com.java.Nubank.repository.IClientesRepository;
import br.com.java.Nubank.repository.IContatosRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/contatos")
public class ContatosController {
    private final IContatosRepository contatosRepository;
    private final IClientesRepository clientesRepository;

    public ContatosController(IContatosRepository contatosRepository, IClientesRepository clientesRepository) {
        this.contatosRepository = contatosRepository;
        this.clientesRepository = clientesRepository;
    }

    @PostMapping
    public ResponseEntity<?> criar(@RequestBody ContatosDTO dto) {
        Optional<Clientes> clientesOptional = clientesRepository.findById(dto.getClienteId());

        if (clientesOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("CLIENTE NÃO ENCONTRADO");
        }
        Contatos contatos = new Contatos();
        contatos.setClientes(clientesOptional.get());
        contatos.setEmail(dto.getEmail());
        contatos.setTelefone(dto.getTelefone());
        contatosRepository.save(contatos);

        return ResponseEntity.status(HttpStatus.CREATED).body(contatos);
    }


}
