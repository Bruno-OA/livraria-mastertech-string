package br.com.bruno.livraria.service;

import br.com.bruno.livraria.model.livrariaModel;
import br.com.bruno.livraria.repository.livrariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class livrariaService {

    @Autowired
    private livrariaRepository repository;

    public livrariaModel cadastrarLivro(livrariaModel livro) {
        return repository.save(livro);
    }
}
