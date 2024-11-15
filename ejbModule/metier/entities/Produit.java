package metier.entities;
import java.io.Serializable;
import javax.persistence.*;

@Table(name="PRODUITS")
public class Produit implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long code;
	private String libelle;
	private double quantite;
	private static final long serialVersionUID = 1L;
	
	public Produit() {
		super();
	}
	
	public Produit(String libelle, double quantite) {
		super();
		this.libelle = libelle;
		this.quantite = quantite;
	}
//Getter and Setters
}