package servlets;

import Dao.UserDao;
import entities.Car;
import entities.User;
import forms.loginForm;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class loginAction extends Action {

    @Override
    public ActionForward execute(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest req,
                                 HttpServletResponse res) throws Exception {

        String result = null;
        String username = ((loginForm)form).getUsername();
        String password = ((loginForm)form).getPassword();

        User user = new User(username,password);
        UserDao dao = new UserDao();
        Car car = new Car("Forrrd","Fieeesta");
        user.setCar(car);

//        dao.addUser(user);

        User use = dao.findUserByUsername(user.getUsername());

        if (use != null && use.getUsername().equals(username) && use.getPassword().equals(password))
            result = "succes";
        else
            result = "error";

//        result = "succes";
        req.getSession().setAttribute("mess","\"/> hey ");
        req.getSession().setAttribute("user",user);

        return mapping.findForward(result);
    }



}