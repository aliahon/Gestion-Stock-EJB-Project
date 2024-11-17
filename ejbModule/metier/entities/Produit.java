package metier.entities;
import java.io.Serializable;
import javax.persistence.*;

@Entity
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
		this.setLibelle(libelle);
		this.setQuantite(quantite);
	}
//Getter and Setters

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}
	
	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public double getQuantite() {
		return quantite;
	}

	public void setQuantite(double quantite) {
		this.quantite = quantite;
	}
	
}