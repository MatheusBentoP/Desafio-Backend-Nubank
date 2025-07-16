package br.com.java.Nubank.service;

import br.com.java.Nubank.dto.cliente.ClientesDTO;
import br.com.java.Nubank.dto.cliente.ClientesResponseDTO;
import br.com.java.Nubank.dto.contato.ContatosResponseDTO;
import br.com.java.Nubank.models.Clientes;
import br.com.java.Nubank.models.Contatos;
import br.com.java.Nubank.repository.IClientesRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Service
public class ClientesService {
    private final IClientesRepository clientesRepository;
    private final ContatosService contatosService;

    public ClientesService(IClientesRepository clientesRepository, ContatosService contatosService) {
        this.clientesRepository = clientesRepository;
        this.contatosService = contatosService;
    }


    public Clientes cadastroCliente(ClientesDTO dto){
        Clientes clientes = new Clientes();
        clientes.setNome(dto.getNome());

        if (dto.getContatos() != null && dto.getContatos().size() > 0){
            List<Contatos> contatos = dto.getContatos().stream()
                    .map(c -> {
                        Contatos contato = new Contatos();
                        contato.setEmail(c.getEmail());
                        contato.setTelefone(c.getTelefone());
                        contato.setClientes(clientes);
                        return contato;
                    }).collect(Collectors.toList());
                    clientes.setContatos(contatos);
        }
        return clientesRepository.save(clientes);
    }
    public List<ClientesResponseDTO> listarClientes(){
        return clientesRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<ContatosResponseDTO> listarContatosPorCliente(Long clienteId){
        Clientes clientes = clientesRepository.findById(clienteId)
                .orElseThrow(()-> new RuntimeException("CLIENTE NÃO FOI ENCONTRADO"));
        return clientes.getContatos().stream().map(c->{
            ContatosResponseDTO contatosResponseDTO = new ContatosResponseDTO();
            contatosResponseDTO.setEmail(c.getEmail());
            contatosResponseDTO.setTelefone(c.getTelefone());
            contatosResponseDTO.setId(c.getId());
            return contatosResponseDTO;
        }).collect(Collectors.toList());

    }


    private ClientesResponseDTO toDTO(Clientes cliente){
        ClientesResponseDTO dto = new ClientesResponseDTO();
        dto.setId(cliente.getId());
        dto.setNome(cliente.getNome());

        List<ContatosResponseDTO> contatos = dto.getContatos().stream()
                .map(c -> {
                    ContatosResponseDTO contatosResponseDTO = new ContatosResponseDTO();
                    contatosResponseDTO.setEmail(c.getEmail());
                    contatosResponseDTO.setTelefone(c.getTelefone());
                    contatosResponseDTO.setId(c.getId());
                    return contatosResponseDTO;
                }).collect(Collectors.toList());
                    dto.setContatos(contatos);
        return dto;
    }
}
