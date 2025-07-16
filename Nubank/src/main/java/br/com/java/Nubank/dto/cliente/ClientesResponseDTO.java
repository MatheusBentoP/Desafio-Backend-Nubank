package br.com.java.Nubank.dto.cliente;

import br.com.java.Nubank.dto.contato.ContatosResponseDTO;
import br.com.java.Nubank.models.Contatos;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientesResponseDTO {//METODO GET

    private Long id;
    private String nome;
    private List<ContatosResponseDTO> contatos = new ArrayList<>();

}
