package servlets;

import entities.Command;
import entities.Customer;
import entities.Product;
import entities.Student;
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
import java.util.Arrays;

public class clientAction extends Action {

    @Override
    public ActionForward execute(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest req,
                                 HttpServletResponse res) throws Exception {


        Product p1 = new Product(1,"p1","descp1",1);
        Product p2 = new Product(2,"p2","descp2",2);
        Product p3 = new Product(3,"p3","descp3",3);

        Customer c1 = new Customer(1,"c1");
        Customer c2 = new Customer(2,"c2");
        Customer c3 = new Customer(3,"c3");

        Command cmd1 = new Command(1,123);
        cmd1.getProductList().addAll(Arrays.asList(p1,p2));
        cmd1.calcTotal();

        Command cmd2 = new Command(2,123);
        cmd2.getProductList().addAll(Arrays.asList(p2,p3));
        cmd2.calcTotal();

        Command cmd3 = new Command(3,123);
        cmd3.getProductList().addAll(Arrays.asList(p1,p2,p3));
        cmd3.calcTotal();

        c1.getCommandList().add(cmd1);
        c1.getCommandList().add(cmd2);

        c2.getCommandList().add(cmd3);

        p1.getCommandList().add(cmd1);
        p1.getCommandList().add(cmd3);


        p2.getCommandList().add(cmd1);
        p2.getCommandList().add(cmd2);
        p2.getCommandList().add(cmd3);

        p3.getCommandList().add(cmd2);
        p3.getCommandList().add(cmd3);

        EntityManagerFactory emf;
        EntityManager em;

        emf = Persistence.createEntityManagerFactory("ensam");
        em = emf.createEntityManager();

        try {
            EntityTransaction tr =  em.getTransaction();
            tr.begin();

            em.persist(p1);
            em.persist(p2);
            em.persist(p3);

            em.persist(c1);
            em.persist(c2);
            em.persist(c3);

            em.persist(cmd1);
            em.persist(cmd2);
            em.persist(cmd3);

            tr.commit();
        } catch (Exception e) {
            throw e;
        }

        return mapping.findForward("succes");
    }



}