package entities.Exercice;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Ville {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nom;
    private int zip;
    @OneToMany(mappedBy = "ville")
    private List<Arret> arretList = new ArrayList<>();

    public Ville() {
    }

    public Ville(String nom, int zip) {
        this.nom = nom;
        this.zip = zip;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public List<Arret> getArretList() {
        return arretList;
    }

    public void setArretList(List<Arret> arretList) {
        this.arretList = arretList;
    }
}
