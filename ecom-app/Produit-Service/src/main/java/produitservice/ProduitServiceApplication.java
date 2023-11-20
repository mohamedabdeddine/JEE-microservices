package produitservice;

import produitservice.entities.Produit;
import produitservice.repositories.ProduitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProduitServiceApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ProduitServiceApplication.class, args);
    }

     @Autowired // Inject the ProduitRepo bean
    ProduitRepo produitRepo;

    public void run(String... args) throws Exception {
        produitRepo.save(new Produit(null, "produit1", 100));
        produitRepo.save(new Produit(null, "produit2", 200));
        produitRepo.save(new Produit(null, "produit3", 300));
        produitRepo.save(new Produit(null, "produit4", 500));
        produitRepo.save(new Produit(null, "produit5", 600));
        produitRepo.save(new Produit(null, "produit6", 700));
    }
}
