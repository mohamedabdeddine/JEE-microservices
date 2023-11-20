package factureservice.repositories;

import factureservice.entities.ProduitArticle;
import factureservice.models.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.List;


@RepositoryRestResource
public interface  ProduitArticleRepo extends JpaRepository<ProduitArticle,Long> {

    List<Produit> findByFactureId(Long id);
}
