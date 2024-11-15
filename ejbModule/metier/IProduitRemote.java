package metier;
import java.util.List;
import javax.ejb.Remote;
import metier.entities.Produit;

@Remote
public interface IProduitRemote {
	public Produit addProduit(Produit pr);
	public Produit getProduit(Long code);
	public List<Produit> listProduits();
	public void ajouterQte(Long code, double qt);
	public void retirerQte(Long code, double qt);
}