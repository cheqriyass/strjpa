package Dao.Exercice;

import entities.Exercice.Transporteur;

import javax.persistence.*;


public class TransporteurDao {

    private static final String JPQL = "SELECT t FROM Transporteur t WHERE t.email=:email AND t.password=:password";

    private EntityManagerFactory emf;
    private EntityManager em;

    public TransporteurDao() {
        emf = Persistence.createEntityManagerFactory("ensam");
        em = emf.createEntityManager();
    }

    public void addTransporteur(Transporteur transporteur) throws Exception {
        try {
            EntityTransaction tr =  em.getTransaction();
            tr.begin();
            em.persist(transporteur);
            tr.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Transporteur findByCredentials(String email, String password) throws Exception {
        if (email == null) return null;
        Transporteur transporteur = null;
        Query requete = em.createQuery(JPQL);
        requete.setParameter("email", email);
        requete.setParameter("password", password);

        try {
            transporteur = (Transporteur) requete.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return transporteur;
    }
}


