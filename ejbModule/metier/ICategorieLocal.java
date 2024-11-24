package metier;

import metier.entities.Categorie;
import javax.ejb.Local;
import java.util.List;

@Local
public interface ICategorieLocal {
    void addCategorie(Categorie categorie);
    void updateCategorie(Categorie categorie);
    void removeCategorie(Long id);
    List<Categorie> searchCategories(String keyword);
}