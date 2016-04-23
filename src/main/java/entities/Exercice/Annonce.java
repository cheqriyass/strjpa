package entities.Exercice;

import javax.annotation.Generated;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Annonce {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String description;

    @ManyToOne
    private Transporteur transporteur;

    @OneToMany(mappedBy = "annonce")
    private List<Arret> arretList = new ArrayList<>();

    public Annonce() {
    }

    public Annonce(long id, String description, Transporteur transporteur) {
        this.id = id;
        this.description = description;
        this.transporteur = transporteur;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Transporteur getTransporteur() {
        return transporteur;
    }

    public void setTransporteur(Transporteur transporteur) {
        this.transporteur = transporteur;
    }

    public List<Arret> getArretList() {
        return arretList;
    }

    public void setArretList(List<Arret> arretList) {
        this.arretList = arretList;
    }
}
