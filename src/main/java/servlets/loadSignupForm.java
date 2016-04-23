package servlets;

import Dao.UserDao;
import entities.Car;
import entities.User;
import forms.loginForm;
import entities.Field;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

public class loadSignupForm extends Action {

    @Override
    public ActionForward execute(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest req,
                                 HttpServletResponse res) throws Exception {

        Collection fields = new ArrayList<Field>();
        fields.add(new Field("Genie Info","GI"));
        fields.add(new Field("Genie Reseau","GRT"));
        fields.add(new Field("Genie Electrique","GE"));

        req.getSession().setAttribute("fields",fields);
        req.getSession().setAttribute("mess","hello !");
        return mapping.findForward("succes");
    }



}