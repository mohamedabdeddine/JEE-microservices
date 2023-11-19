package factureservice.models;

import lombok.Data;

@Data
public class Produit {
   private Long id;
   private String name;
   private double prix;
}
