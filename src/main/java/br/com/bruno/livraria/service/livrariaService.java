package br.com.bruno.livraria.service;

import br.com.bruno.livraria.model.livrariaModel;
import br.com.bruno.livraria.repository.livrariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class livrariaService {

    @Autowired
    private livrariaRepository repository;

    public livrariaModel cadastrarLivro(livrariaModel livro) {
        livro.setAtivo(Boolean.TRUE);
        livro.setDatacriacao(LocalDate.now());
        return repository.save(livro);
    }

    public Iterable<livrariaModel> listarLivros() {
        Iterable<livrariaModel> livros = repository.findAll();
        return livros;
    }

    public livrariaModel listarLivro(int id){
        Optional<livrariaModel> livro = repository.findById(id);
        return livro.get();
    }

}
