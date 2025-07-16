package br.com.java.Nubank.dto.cliente;

import br.com.java.Nubank.dto.contato.ContatosDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ClientesDTO {//Metodo POST
    private String nome;
    private List<ContatosDTO> contatos = new ArrayList<>();
}
