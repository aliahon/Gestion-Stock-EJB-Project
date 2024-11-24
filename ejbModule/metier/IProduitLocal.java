package metier;

import metier.entities.Produit;
import java.util.List;

import javax.ejb.Local;

@Local
public interface IProduitLocal {
    void addProduit(Produit produit);
    void updateProduit(Produit produit);
    void removeProduit(Long id);
    List<Produit> searchProduits(String keyword);
    void updateQuantite(Long produitId, int quantity);
    Produit findProduitById(Long produitId);
}
