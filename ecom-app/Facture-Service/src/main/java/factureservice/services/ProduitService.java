package factureservice.services;

import factureservice.models.Produit;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@FeignClient(name = "PRODUIT-SERVICE")
public interface ProduitService {
    @GetMapping("/produits/{produitId}")
    Produit findById(@PathVariable Long produitId);

    @GetMapping("/produits")
    PagedModel<Produit> pageProduits(
            @PathVariable(value = "page") Integer page,
            @PathVariable(value = "size") Integer taille);
}


