package entities.Exercice;


import javax.persistence.*;
import java.util.Date;

@Entity
public class Arret {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date date;
    private int attente;
    private int ordre;
    @ManyToOne
    private Annonce annonce;
    @ManyToOne
    private Ville ville;


    public Arret() {
    }

    public Arret(Date date, int attente, int ordre, Annonce annonce, Ville ville) {
        this.date = date;
        this.attente = attente;
        this.ordre = ordre;
        this.annonce = annonce;
        this.ville = ville;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getAttente() {
        return attente;
    }

    public void setAttente(int attente) {
        this.attente = attente;
    }

    public int getOrdre() {
        return ordre;
    }

    public void setOrdre(int order) {
        this.ordre = order;
    }

    public Ville getVille() {
        return ville;
    }

    public void setVille(Ville ville) {
        this.ville = ville;
    }

    public Annonce getAnnonce() {
        return annonce;
    }

    public void setAnnonce(Annonce annonce) {
        this.annonce = annonce;
    }
}
