package br.com.java.Nubank.dto.contato;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContatosDTO {//METODO POST
    private String telefone;
    private String email;
    private Long clienteId;


}
