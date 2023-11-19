package factureservice.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import factureservice.models.Produit;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class ProduitArticle {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long reference;
    private double prix;
    private int quantite;
    @ManyToOne @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Facture facture;
    @Transient
    private Produit produit;
}
