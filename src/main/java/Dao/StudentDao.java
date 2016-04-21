package Dao;

import entities.Student;
import javax.persistence.*;


public class StudentDao {

    private static final String JPQL_SELECT_PAR_USERNAME = "SELECT s FROM Student s WHERE s.username=:username";

    private EntityManagerFactory emf;
    private EntityManager em;

    public StudentDao() {
        emf = Persistence.createEntityManagerFactory("ensam");
        em = emf.createEntityManager();
    }

    public void addStudent(Student student) throws Exception {
        try {
            EntityTransaction tr =  em.getTransaction();
            tr.begin();
            em.persist(student);
            tr.commit();
        } catch (Exception e) {
            throw e;
        }
    }

    public Student finStudentByUsername(String username) throws Exception {
        if (username == null) return null;
        Student student = null;
        Query requete = em.createQuery(JPQL_SELECT_PAR_USERNAME);
        requete.setParameter("username", username);
        try {
            student = (Student) requete.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            throw e;
        }
        return student;
    }
}


