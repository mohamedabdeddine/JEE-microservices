package produitservice.repositories;

import produitservice.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepo extends JpaRepository<Produit, Long>
{
}
