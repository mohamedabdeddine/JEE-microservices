package factureservice.controllers;

import factureservice.entities.Facture;
import factureservice.models.Produit;
import factureservice.repositories.FactureRepo;
import factureservice.repositories.ProduitArticleRepo;
import factureservice.services.ClientService;
import factureservice.services.ProduitService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FactureController {

    FactureRepo factureRepo;
    ClientService clientService;
    ProduitService produitService;
    ProduitArticleRepo produitArticleRepo;


    public FactureController(FactureRepo factureRepo, ClientService clientService, ProduitService produitService, ProduitArticleRepo produitArticleRepo) {
        this.factureRepo = factureRepo;
        this.clientService = clientService;
        this.produitService = produitService;
        this.produitArticleRepo = produitArticleRepo;
    }

    @GetMapping("/factures")
    public List<Facture> getAll() {return  factureRepo.findAll();}


    @GetMapping("/factures/{id}")
    public Facture getFacture(@PathVariable Long id) {
        Facture facture = factureRepo.findById(id).get();
        facture.setClient(clientService.findById(facture.getIdClient()));
        facture.getListProduits().forEach(produitArticle -> {
            Produit p = produitService.findById(produitArticle.getReference());
            produitArticle.setProduit(p);
        });
    return facture;
    }
}