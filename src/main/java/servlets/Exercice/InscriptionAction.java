package servlets.Exercice;

import Dao.Exercice.AnnonceDao;
import Dao.Exercice.ArretDao;
import Dao.Exercice.DestinataireDao;
import Dao.Exercice.TransporteurDao;
import entities.Exercice.*;
import entities.Student;
import forms.Exercice.InscriptionFormBean;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@Deprecated
public class InscriptionAction extends Action{

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String nom = ((InscriptionFormBean)form).getNom();
        String prenom = ((InscriptionFormBean)form).getPrenom();
        String email = ((InscriptionFormBean)form).getEmail();
        String password = ((InscriptionFormBean)form).getPassword();
        String numPermis = ((InscriptionFormBean)form).getNumPermis();

        Transporteur transporteur = new Transporteur(1, nom, prenom, email, password, Long.parseLong(numPermis));
        Transporteur transporteur2 = new Transporteur(4,"hamid",prenom,"yass","oi", Long.parseLong(numPermis));

        Destinataire des = new Destinataire(4,"karim","karim","userkarim","pass","asdfas",99999999);


        TransporteurDao dao = new TransporteurDao();
//        dao.addTransporteur(transporteur);
//        dao.addTransporteur(transporteur2);


//        DestinataireDao destdao = new DestinataireDao();
//        destdao.addTransporteur(des);


        String depart = "rabat";
        String arrive = "tanger";

        Ville v1 = new Ville("casa",10000);
        Ville v2 = new Ville("rabat",20000);
        Ville v3 = new Ville("tanger",30000);

        Annonce annonce1 = new Annonce(12,"descr1",transporteur);
        Annonce annonce2 = new Annonce(12,"descr2",transporteur2);
        Annonce annonce3 = new Annonce(12,"descr3",transporteur);


        Arret arr1 = new Arret(new Date(2016,4,26,12,40),12,1,annonce1,v1);
        Arret arr2 = new Arret(new Date(2016,4,26,13,40),12,2,annonce1,v2);
        Arret arr3 = new Arret(new Date(2016,4,26,15,40),12,3,annonce1,v3);

        Arret arr4 = new Arret(new Date(2016,4,26,12,41),12,1,annonce2,v1);
        Arret arr5 = new Arret(new Date(2016,4,26,15,40),12,2,annonce2,v2);

        Arret arr6 = new Arret(new Date(2016,4,26,12,40),12,1,annonce3,v1);
        Arret arr7 = new Arret(new Date(2016,4,26,15,40),12,2,annonce3,v3);

        annonce1.getArretList().addAll(Arrays.asList(arr1,arr2,arr3));
        annonce2.getArretList().addAll(Arrays.asList(arr4,arr5));
        annonce3.getArretList().addAll(Arrays.asList(arr6,arr7));



        EntityManagerFactory emf;
        EntityManager em;

            emf = Persistence.createEntityManagerFactory("ensam");
            em = emf.createEntityManager();


        try {
            EntityTransaction tr =  em.getTransaction();
            tr.begin();
            em.persist(transporteur);
            em.persist(transporteur2);
            em.persist(v1);
            em.persist(v2);
            em.persist(v3);
            em.persist(arr1);
            em.persist(arr2);
            em.persist(arr3);
            em.persist(arr4);
            em.persist(arr5);
            em.persist(arr6);
            em.persist(arr7);
            em.persist(annonce1);
            em.persist(annonce2);
            em.persist(annonce3);

            tr.commit();
        } catch (Exception e) {
            throw e;
        }

        AnnonceDao annonceDao = new AnnonceDao();
//        annonceDao.addAnnonce(annonce1);

        ArretDao arretDao = new ArretDao();
        List<Arret> arrets = arretDao.findArrets(depart,new Date(2016,4,26,12,40));


        for(Arret arr : arrets){
            System.out.println("arret **************" + arr.getAnnonce().getId());
        }


        List<Annonce> annoncesList = new ArrayList<>();
        Arret ar1;
        for(Arret arrr : arrets){
            ar1 = null;
            ar1 = arretDao.findArretsByAnnonceID(arrr.getAnnonce().getId(),arrr.getOrdre(),arrive);
//            System.out.println("--------------" + ar1.getAnnonce().getId());
            if (ar1 != null){
                annoncesList.add(annonceDao.findAnnonceById(ar1.getAnnonce().getId()));
            }
        }


//        transporteur = dao.findByCredentials(email,password);

        for(Annonce ann:annoncesList ){
            System.out.println("*****************"+ann.getId());
        }

        request.getSession().setAttribute("ann",annoncesList);
        request.getSession().setAttribute("trs",transporteur);

        return mapping.findForward("succes");
    }
}
