package forms.Exercice;

import org.apache.struts.action.ActionForm;

public class InscriptionFormBean extends ActionForm{
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private String numPermis;

    public InscriptionFormBean() {
    }

    public InscriptionFormBean(String nom, String prenom, String email, String password, String numPermis) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
        this.numPermis = numPermis;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNumPermis() {
        return numPermis;
    }

    public void setNumPermis(String numPermis) {
        this.numPermis = numPermis;
    }
}
