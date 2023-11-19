package factureservice.entities;

import factureservice.models.Client;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Facture {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date date;
    @OneToMany(mappedBy = "facture")
    private Collection<ProduitArticle> listProduits;
    private Long idClient;
    @Transient
    private Client client;

}
