package br.com.java.Nubank.controller;

import br.com.java.Nubank.dto.cliente.ClientesDTO;
import br.com.java.Nubank.dto.cliente.ClientesResponseDTO;
import br.com.java.Nubank.dto.contato.ContatosResponseDTO;
import br.com.java.Nubank.models.Clientes;
import br.com.java.Nubank.service.ClientesService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClientesController {
    private final ClientesService clientesService;

    public ClientesController(ClientesService clientesService) {
        this.clientesService = clientesService;
    }

    @PostMapping
    public ResponseEntity<Clientes> criar(@RequestBody ClientesDTO dto){
        Clientes clientesSalvo = clientesService.cadastroCliente(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(clientesSalvo);
    }

    @GetMapping
    public ResponseEntity<List<ClientesResponseDTO>>mostrarTudo(){
        return ResponseEntity.ok(clientesService.listarClientes());
    }
    @GetMapping("/{id}/contatos")
    public ResponseEntity<List<ContatosResponseDTO>>listraContatos(@PathVariable Long id){
        return ResponseEntity.ok(clientesService.listarContatosPorCliente(id));
    }
}
