package br.com.fecaf;

import br.com.fecaf.model.Livro;
import br.com.fecaf.repository.LivroRepository;
import br.com.fecaf.services.LivroService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class LivroServiceTest {

    @Autowired
    private LivroService livroService;

    @MockBean
    private LivroRepository livroRepository;

    @Test
    void deveSalvarLivroComSucesso() {
        Livro livro = new Livro();
        livro.setTitulo("Engenharia de Software");
        livro.setAutor("Ian Sommerville");

        when(livroRepository.save(livro)).thenReturn(livro);

        Livro livroSalvo = livroService.salvarLivro(livro);

        assertNotNull(livroSalvo);
        assertEquals("Engenharia de Software", livroSalvo.getTitulo());
        assertEquals("Ian Sommerville", livroSalvo.getAutor());
    }
}
