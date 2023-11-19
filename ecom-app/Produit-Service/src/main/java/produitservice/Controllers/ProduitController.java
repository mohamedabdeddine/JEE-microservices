package produitservice.Controllers;

import produitservice.entities.Produit;
import produitservice.repositories.ProduitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produits")
public class ProduitController {
    private final ProduitRepo produitRepo;

    @Autowired
    public ProduitController(ProduitRepo produitRepo) {
        this.produitRepo = produitRepo;
    }

    @GetMapping("/{produitId}")
    public Produit findProduitById(@PathVariable Long produitId) {
        return produitRepo.findById(produitId).orElse(null);
    }
}
