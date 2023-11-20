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
		// Get a list of all clients
		List<Client> clients = clientService.findAllClients();
		clients.forEach(client -> {
			Facture facture = factureRepo.save(new Facture(null, new Date(), new ArrayList<>(), client.getId(), null));
			PagedModel<Produit> productList = produitService.pageProduits(0, 2);
			productList.forEach(produit -> {
				ProduitArticle produitArticle = new ProduitArticle();
				produitArticle.setReference(produit.getId());
				produitArticle.setProduit(produit);
				produitArticle.setQuantite(1 + new Random().nextInt(10));
				produitArticle.setFacture(facture);
				produitArticle.setPrix(produitArticle.getQuantite() * produit.getPrix());
				produitArticleRepo.save(produitArticle);
				facture.getListProduits().add(produitArticle);
			});
			factureRepo.save(facture);
		});
	}
}
