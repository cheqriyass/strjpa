package Dao;


import entities.User;

import javax.persistence.*;

public class UserDao {

    private static final String JPQL_SELECT_PAR_USERNAME = "SELECT u FROM User u WHERE u.username=:username";

    private EntityManagerFactory emf;
    private EntityManager em;

    public UserDao() {
        emf = Persistence.createEntityManagerFactory("ensam");
        em = emf.createEntityManager();
    }

    public void addUser(User user) throws Exception {
        try {
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw e;
        }
    }

    public User findUserByUsername(String username) throws Exception {
        if (username == null) return null;
        User user = null;
        Query requete = em.createQuery(JPQL_SELECT_PAR_USERNAME);
        requete.setParameter("username", username);
        try {
            user = (User) requete.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            throw e;
        }
        return user;
    }
}



//
//import entities.User;
//
//import javax.ejb.Stateless;
//import javax.persistence.EntityManager;
//import javax.persistence.NoResultException;
//import javax.persistence.PersistenceContext;
//import javax.persistence.Query;
//
//@Stateless
//public class UserDao {
//    private static final String JPQL_SELECT_PAR_EMAIL = "SELECT u FROM User u WHERE u.email=:email";
//    private static final String PARAM_EMAIL           = "email";
//
//    // Injection du manager, qui s'occupe de la connexion avec la BDD
//    @PersistenceContext( unitName = "ensam_PU" )
//    private EntityManager em;
//
//    // Enregistrement d'un nouvel utilisateur
//    public void creer( User utilisateur ) throws Exception {
//        try {
//        	em.getTransaction().begin();
//            em.persist( utilisateur );
//            em.getTransaction().commit();
//        } catch ( Exception e ) {
//            throw e;
//        }
//    }
//
////    // Recherche d'un utilisateur à partir de son adresse email
////    public User findUserByUsername(String email ) throws Exception {
////        if (email==null) return null;
////        User utilisateur = null;
////        Query requete = em.createQuery( JPQL_SELECT_PAR_EMAIL );
////        requete.setParameter( PARAM_EMAIL, email );
////        try {
////            utilisateur = (User) requete.getSingleResult();
////        } catch ( NoResultException e ) {
////            return null;
////        } catch ( Exception e ) {
////            throw e;
////        }
////        return utilisateur;
////    }
//}


