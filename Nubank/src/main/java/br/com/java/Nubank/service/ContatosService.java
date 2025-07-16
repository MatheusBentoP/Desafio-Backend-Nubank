package br.com.java.Nubank.service;

import br.com.java.Nubank.repository.IContatosRepository;
import org.springframework.stereotype.Service;

@Service
public class ContatosService {
    private final IContatosRepository iContatosRepository;

    public ContatosService(IContatosRepository iContatosRepository) {
        this.iContatosRepository = iContatosRepository;
    }
}
