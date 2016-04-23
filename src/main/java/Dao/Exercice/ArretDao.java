package Dao.Exercice;

import entities.Exercice.Annonce;
import entities.Exercice.Arret;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


public class ArretDao {

    private static final String JPQL = "SELECT a FROM Arret a WHERE a.ville.nom=:ville AND a.date>=:date";
    private static final String JPQL2 = "SELECT a FROM Arret a WHERE a.annonce.id=:annonceId AND a.ville.nom=:ville And a.ordre>:ordre";

    private EntityManagerFactory emf;
    private EntityManager em;

    public ArretDao() {
        emf = Persistence.createEntityManagerFactory("ensam");
        em = emf.createEntityManager();
    }

    public void addArret(Arret arret) throws Exception {
        try {
            EntityTransaction tr =  em.getTransaction();
            tr.begin();
            em.persist(arret);
            tr.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Arret> findArrets(String ville, Date date) throws Exception {
        List<Arret> list=null;
        Query requete = em.createQuery(JPQL);
        requete.setParameter("ville", ville);
        requete.setParameter("date", date);

        try {
            list = (List<Arret>)requete.getResultList();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


    public Arret findArretsByAnnonceID(long annonceId, int ordre, String ville) throws Exception {
        Arret arret = null;
        Query requete = em.createQuery(JPQL2);
        requete.setParameter("ville", ville);
        requete.setParameter("ordre", ordre);
        requete.setParameter("annonceId", annonceId);

        try {
            arret = (Arret)requete.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arret;
    }
}


