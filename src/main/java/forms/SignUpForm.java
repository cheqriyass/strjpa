package forms;


import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import javax.servlet.http.HttpServletRequest;

import static org.apache.commons.lang.StringUtils.isBlank;

public class SignUpForm extends ActionForm {
    String firstname;
    String lastname;
    String username;
    String password;
    String passwordConfirmation;
    String field;
    String sex;

    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }

    public void setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }


    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();

        if (isBlank(username)) {
            errors.add("username",new ActionMessage("errors.user.required"));
        }

//        if (!username.isEmpty() && !EmailValidator.getInstance().isValid(username)) {
//            errors.add("username",new ActionMessage("errors.user.invalide",username));
//        }

        if (isBlank(password)) {
            errors.add("password",new ActionMessage("errors.pass.required"));
        }

//        if (!username.isEmpty() && EmailValidator.getInstance().isValid(username)) {
//            UserDao uDao = new UserDao();
//            User u = uDao.findUserByEmail(username);
//            System.out.println("u = " + u);
//            if (u == null) {
//                errors.add("2", new ActionMessage("errors.user.ncorrect"));
//            }
//
//            if (u!=null && username.equals(u.getEmail()) && !password.equals(u.getPassword())){
//                errors.add("3", new ActionMessage("errors.user.mdpincor"));
//            }
//        }

        return errors;
    }


}
