package br.com.fecaf.controller;

import br.com.fecaf.model.Livro;
import br.com.fecaf.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/livros")
@CrossOrigin(
        origins = {"http://localhost:5500", "http://127.0.0.1:5500"},
        allowedHeaders = "*"
)
public class LivroController {

    @Autowired
    private LivroService livroService;

    // === LISTAR TODOS OS LIVROS ===
    @GetMapping("/listarLivros")
    public List<Livro> listarLivros() {
        return livroService.listarLivros();
    }

    // === CADASTRAR NOVO LIVRO ===
    @PostMapping("/cadastrarLivro")
    public ResponseEntity<Livro> salvarLivro(@RequestBody Livro livro) {
        Livro novoLivro = livroService.salvarLivro(livro);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoLivro);
    }

    // === DELETAR LIVRO POR ID ===
    @DeleteMapping("/deletarLivro/{id}")
    public ResponseEntity<Void> deletarLivro(@PathVariable int id) {
        livroService.deletarLivro(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    // === FILTRAR LIVROS ===
    @GetMapping("/filtrar")
    public List<Livro> filtrarLivros(
            @RequestParam(required = false) String autor,
            @RequestParam(required = false) String titulo,
            @RequestParam(required = false) Integer anoPublicacao,
            @RequestParam(required = false) Double preco,
            @RequestParam(required = false) String status) {

        return livroService.filtrarLivros(autor, titulo, anoPublicacao, preco, status);
    }

    // === ATUALIZAR LIVRO ===
    @PutMapping("/atualizarLivro/{id}")
    public ResponseEntity<Livro> atualizarLivro(
            @PathVariable int id,
            @RequestBody Livro livroAtualizado) {

        Livro atualizado = livroService.atualizarLivro(id, livroAtualizado);
        return ResponseEntity.ok(atualizado);
    }
}
