package entities.Exercice;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@DiscriminatorValue(value = "DS")
public class Destinataire extends Personne{
    private int phone;
    private String adresse;

    public Destinataire() {
    }

    public Destinataire(long id, String nom, String prenom, String email, String password, String adresse, int phone) {
        super(id, nom, prenom, email, password);
        this.adresse = adresse;
        this.phone = phone;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}
