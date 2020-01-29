package br.com.bruno.livraria.controller;

import br.com.bruno.livraria.model.livrariaModel;
import br.com.bruno.livraria.service.livrariaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class livrariaController {

    @Autowired
    private livrariaService service;

    @GetMapping
    public String mostrarHome(){
        return "index";
    }

    @PostMapping("/cadastrar")
    public String cadastrarLivro(livrariaModel livro){
        service.cadastrarLivro(livro);
        return "index";
    }

    @GetMapping("/livros")
    public ModelAndView listarLivros(){
        ModelAndView pagina = new ModelAndView("resposta");
        Iterable<livrariaModel> livros = service.listarLivros();
        pagina.addObject("livros", livros);
        return pagina;
    }

    @GetMapping("/buscar")
    public String retornarLivro(){
        return "buscarPorId";
    }

    @GetMapping("livro")
    public String listaLivros(@RequestParam("id") int id, Model model) {
        livrariaModel livro = service.listarLivro(id);
        if (livro != null) {
            model.addAttribute("livro", livro);
        }
        return "listarLivro";
    }

    @GetMapping("livro/{id}")
    public String listaLivrosPorPagina(@PathVariable("id") int id, Model model) {
        livrariaModel livro = service.listarLivro(id);
        if (livro != null) {
            model.addAttribute("livro", livro);
        }
        return "listarLivro";
    }
}