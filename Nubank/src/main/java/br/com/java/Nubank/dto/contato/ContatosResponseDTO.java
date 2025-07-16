package br.com.java.Nubank.dto.contato;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContatosResponseDTO {//METODO GET
    private Long id;
    private String telefone;
    private String email;
    private String nomeCliente;
    private Long clienteId;
}
