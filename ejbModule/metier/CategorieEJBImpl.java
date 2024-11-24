package metier;

import metier.entities.Categorie;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class CategorieEJBImpl implements ICategorieLocal, ICategorieRemote {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void addCategorie(Categorie categorie) {
        em.persist(categorie);
    }

    @Override
    public void updateCategorie(Categorie categorie) {
        em.merge(categorie);
    }

    @Override
    public void removeCategorie(Long id) {
        Categorie categorie = em.find(Categorie.class, id);
        if (categorie != null) {
            em.remove(categorie);
        }
    }

    @Override
    public List<Categorie> searchCategories(String keyword) {
        return em.createQuery("SELECT c FROM Categorie c WHERE c.libelle LIKE :keyword", Categorie.class)
                 .setParameter("keyword", "%" + keyword + "%")
                 .getResultList();
    }
}
