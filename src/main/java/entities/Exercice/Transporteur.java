package entities.Exercice;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue(value = "TR")
public class Transporteur extends Personne{
    private long numPermis;
    @OneToMany(mappedBy = "transporteur")
    private List<Annonce> annonceList = new ArrayList<>();

    public Transporteur() {
    }

    public Transporteur(long id, String nom, String prenom, String email, String password, long numPermis) {
        super(id, nom, prenom, email, password);
        this.numPermis = numPermis;
    }

    public long getNumPermis() {
        return numPermis;
    }

    public void setNumPermis(long numPermis) {
        this.numPermis = numPermis;
    }

    public List<Annonce> getAnnonceList() {
        return annonceList;
    }

    public void setAnnonceList(List<Annonce> annonceList) {
        this.annonceList = annonceList;
    }
}
