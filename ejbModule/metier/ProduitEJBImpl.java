package metier;

import metier.entities.*;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class ProduitEJBImpl implements IProduitLocal, IProduitRemote {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void addProduit(Produit produit) {
        em.persist(produit);
    }

    @Override
    public void updateProduit(Produit produit) {
        em.merge(produit);
    }

    @Override
    public void removeProduit(Long id) {
        Produit produit = em.find(Produit.class, id);
        if (produit != null) {
            em.remove(produit);
        }
    }

    @Override
    public List<Produit> searchProduits(String keyword) {
        return em.createQuery("SELECT p FROM Produit p WHERE p.designation LIKE :keyword", Produit.class)
                 .setParameter("keyword", "%" + keyword + "%")
                 .getResultList();
    }

    @Override
    public void updateQuantite(Long produitId, int quantity) {
        Produit produit = em.find(Produit.class, produitId);
        if (produit != null) {
            produit.setQuantite(produit.getQuantite() + quantity);
            em.merge(produit);
        }
    }
    
    @Override
    public Produit findProduitById(Long produitId) {
        return em.find(Produit.class, produitId);  // Retrieve product by its ID
    }
}
