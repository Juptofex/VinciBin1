
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;

public class Exposant {
    private String nom;
    private String email;

    private LinkedList<Emplacement> listeEmplacements;

    public Exposant(String nom, String email) {
        this.nom = nom;
        this.email = email;
        listeEmplacements = new LinkedList<>();
    }

    public String getNom() {
        return nom;
    }

    public String getEmail() {
        return email;
    }

    public Iterator<Emplacement> tousLesEmplacements() {
        return listeEmplacements.iterator();
    }

    public void ajoutEmplacement(Emplacement emplacement) {
        if (listeEmplacements.contains(emplacement))
            throw new IllegalArgumentException();
        listeEmplacements.add(emplacement);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exposant exposant = (Exposant) o;
        return nom.equals(exposant.nom) && email.equals(exposant.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, email);
    }


    @Override
    public String toString() {
        return "{" +
                "nom='" + nom + '\'' +
                ", email='" + email + '\'' +
                ", emplacements='" + listeEmplacements + '\'' +
                '}';
    }
}
