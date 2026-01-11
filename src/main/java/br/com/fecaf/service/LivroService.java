package br.com.fecaf.services;

import br.com.fecaf.model.Livro;
import br.com.fecaf.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    // === LISTAR LIVROS ===
    public List<Livro> listarLivros() {
        return livroRepository.findAll();
    }

    // === SALVAR NOVO LIVRO ===
    public Livro salvarLivro(Livro livro) {
        return livroRepository.save(livro);
    }

    // === DELETAR LIVRO ===
    public void deletarLivro(int id) {
        livroRepository.deleteById(id);
    }

    // === FILTRAR LIVROS ===
    public List<Livro> filtrarLivros(String autor, String titulo, Integer anoPublicacao, Double preco, String status) {
        return livroRepository.findByFiltros(autor, titulo, anoPublicacao, preco, status);
    }

    // === ATUALIZAR LIVRO ===
    public Livro atualizarLivro(int id, Livro livroAtualizado) {
        Livro livro = livroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado"));

        if (livroAtualizado.getPreco() != null && livroAtualizado.getPreco() > 0)
            livro.setPreco(livroAtualizado.getPreco());

        if (livroAtualizado.getPaginas() != null && livroAtualizado.getPaginas() > 0)
            livro.setPaginas(livroAtualizado.getPaginas());

        if (livroAtualizado.getStatus() != null && !livroAtualizado.getStatus().isBlank())
            livro.setStatus(livroAtualizado.getStatus());

        return livroRepository.save(livro);
    }
}
