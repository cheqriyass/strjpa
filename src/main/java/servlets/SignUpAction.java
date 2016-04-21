package servlets;

import Dao.StudentDao;
import Dao.UserDao;
import entities.Car;
import entities.Student;
import entities.User;
import forms.SignUpForm;
import forms.loginForm;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignUpAction extends Action {

    @Override
    public ActionForward execute(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest req,
                                 HttpServletResponse res) throws Exception {

        String result = null;
        String username = ((SignUpForm)form).getUsername();
        String password = ((SignUpForm)form).getPassword();
        String password1 = ((SignUpForm)form).getPasswordConfirmation();
        String firstname = ((SignUpForm)form).getFirstname();
        String lastname = ((SignUpForm)form).getLastname();
        String sex = ((SignUpForm)form).getSex();
        String field = ((SignUpForm)form).getField();

        Student student = new Student(firstname,lastname,username,password,password1,field,sex);
        StudentDao dao = new StudentDao();

        dao.addStudent(student);

        req.setAttribute("student",student);

        return mapping.findForward("succes");
    }



}