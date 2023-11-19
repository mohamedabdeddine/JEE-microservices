package factureservice;

import factureservice.entities.ProduitArticle;
import factureservice.models.Client;
import factureservice.repositories.ProduitArticleRepo;
import factureservice.services.ClientService;
import factureservice.services.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import factureservice.entities.Facture;
import factureservice.repositories.FactureRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.hateoas.PagedModel;
import factureservice.models.Produit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;


@SpringBootApplication
@EnableFeignClients
public class FactureServiceApplication implements CommandLineRunner {

	@Autowired // Inject the FactureRepo bean
	private FactureRepo factureRepo;
	private ClientService clientService;
	private ProduitService produitService;
	private ProduitArticleRepo produitArticleRepo;

	public FactureServiceApplication(FactureRepo factureRepo, ClientService clientService, ProduitService produitService, ProduitArticleRepo produitArticleRepo) {
		this.factureRepo = factureRepo;
		this.clientService = clientService;
		this.produitService = produitService;
		this.produitArticleRepo = produitArticleRepo;
	}

	public static void main(String[] args) {
		SpringApplication.run(FactureServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Create and save some Facture records during application startup
		Client client = clientService.findById(Long.valueOf(1L));
		Facture facture1 = factureRepo.save(new Facture(null, new Date(), null, client.getId(), null));
	//	List<Produit> produits = new ArrayList<>();
		PagedModel<Produit> ListeProoduitDB = produitService.pageProduits(0, 3);
		ListeProoduitDB.forEach(p -> {
        ProduitArticle produit = new ProduitArticle();
					produit.setReference(p.getId());
					produit.setProduit(p);
					produit.setQuantite(1 + new Random().nextInt(10));
					produit.setFacture(facture1);
					produit.setPrix(produit.getQuantite() * p.getPrix());
					ProduitArticleRepo.save(produit);
				});
    }
}
