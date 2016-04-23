package Dao.Exercice;

import entities.Exercice.Annonce;
import entities.Exercice.Destinataire;

import javax.persistence.*;
import java.util.Date;


public class AnnonceDao {

    private static final String JPQL = "SELECT a FROM Annonce a WHERE a.id=:id";

    private EntityManagerFactory emf;
    private EntityManager em;

    public AnnonceDao() {
        emf = Persistence.createEntityManagerFactory("ensam");
        em = emf.createEntityManager();
    }

    public void addAnnonce(Annonce annonce) throws Exception {
        try {
            EntityTransaction tr =  em.getTransaction();
            tr.begin();
            em.persist(annonce);
            tr.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Annonce findAnnonceById(long id) throws Exception {
        Annonce annonce = null;
        Query requete = em.createQuery(JPQL);
        requete.setParameter("id", id);

        try {
            annonce = (Annonce) requete.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return annonce;
    }
}


