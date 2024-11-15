package metier;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import metier.entities.Produit;

@Stateless(name="PROD")
public class ProduitEJBImpl implements IProduitLocal, IProduitRemote{
	
	@PersistenceContext(unitName = "ProduitEJB")
	private EntityManager em;
	
	@Override
	public Produit addProduit(Produit pr) {
		em.persist(pr);
		return pr;
	}
	
	@Override
	public Produit getProduit(Long code) {
		Produit pr=em.find(Produit.class, code);
		if (pr==null) throw new RuntimeException("Produit introuvable");
		return pr;
	}
	
	@Override
	public List<Produit> listProduits() {
		Query req=em.createQuery("select p from Produit p");
		return req.getResultList();
	}
	
	@Override
	public void ajouterQte(Long code, double qt) {
		Produit pr=em.find(Produit.class, code);
		pr.setQuantite(pr.getQuantite()+qt);
	}
	
	@Override
	public void retirerQte(Long code, double qt) {
		Produit pr=em.find(Produit.class, code);
		pr.setQuantite(pr.getQuantite()-qt);
	}
}
