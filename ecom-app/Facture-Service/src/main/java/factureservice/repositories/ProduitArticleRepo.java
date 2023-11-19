package factureservice.repositories;

import factureservice.entities.ProduitArticle;
import factureservice.models.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;


@RepositoryRestResource
public interface  ProduitArticleRepo extends JpaRepository<Long, ProduitArticle> {
    static void save(ProduitArticle produit) {
    }

    Optional<Produit> findUsingId(Long id);


}
