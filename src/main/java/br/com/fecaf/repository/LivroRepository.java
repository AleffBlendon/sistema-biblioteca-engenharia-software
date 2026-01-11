package br.com.fecaf.repository;

import br.com.fecaf.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer> {

    @Query("SELECT l FROM Livro l WHERE " +
            "(:autor IS NULL OR l.autor LIKE %:autor%) AND " +
            "(:titulo IS NULL OR l.titulo LIKE %:titulo%) AND " +
            "(:anoPublicacao IS NULL OR l.anoPublicacao = :anoPublicacao) AND " +
            "(:preco IS NULL OR l.preco <= :preco) AND " +
            "(:status IS NULL OR l.status = :status)")
    List<Livro> findByFiltros(
            @Param("autor") String autor,
            @Param("titulo") String titulo,
            @Param("anoPublicacao") Integer anoPublicacao,
            @Param("preco") Double preco,
            @Param("status") String status
    );
}
