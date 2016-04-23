import Dao.Exercice.DestinataireDao;
import Dao.Exercice.TransporteurDao;
import entities.Exercice.Destinataire;
import entities.Exercice.Transporteur;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Test {

    public static void main(String[] args) {

        Transporteur transporteur = new Transporteur(4,"t1karim","karim","userkarim","pass",1234352612);
        Transporteur transporteur2 = new Transporteur(4,"t2karim","karim","userkarim","pass",12444321);

        Destinataire des = new Destinataire(4,"karim","karim","userkarim","pass","asdfas",1234352612);


        try {
            TransporteurDao dao = new TransporteurDao();
            dao.addTransporteur(transporteur);
            dao.addTransporteur(transporteur2);


            DestinataireDao destdao = new DestinataireDao();
            destdao.addTransporteur(des);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
