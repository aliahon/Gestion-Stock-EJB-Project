package metier;

import metier.entities.Categorie;
import javax.ejb.Remote;
import java.util.List;

@Remote
public interface ICategorieRemote {
    void addCategorie(Categorie categorie);
    void updateCategorie(Categorie categorie);
    void removeCategorie(Long id);
    List<Categorie> searchCategories(String keyword);
}
