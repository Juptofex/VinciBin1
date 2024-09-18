import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Saison {

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("Entrez le jour : ");
        double jour = scanner.nextDouble();
        System.out.print("Entrez le mois : ");
        String mois = scanner.next();

        //Create some sets of strings
        String[] moisP = {"mars", "avril", "mai", "juin"};
        String[] moisE = {"juin", "juillet", "août", "septembre"};
        String[] moisA = {"septembre", "octobre", "novembre", "décembre"};
        String[] moisH = {"décembre", "janvier", "février", "mars"};
        //
        Set<String> listeP = new HashSet<String>(Arrays.asList(moisP));
        Set<String> listeE = new HashSet<String>(Arrays.asList(moisE));
        Set<String> listeA = new HashSet<String>(Arrays.asList(moisA));
        Set<String> listeH = new HashSet<String>(Arrays.asList(moisH));

        if (listeP.contains(mois)) {
            if ((jour >= 21 && !mois.equals("juin")) || (jour <= 20 && mois.equals("juin"))){
                System.out.println("C'est au Printemps");
            } else{
                System.out.println("C'est en Eté");
            }

        } else if (listeE.contains(mois)) {
            if ((jour >= 21 && !mois.equals("septembre")) || (jour <= 20 && mois.equals("septembre"))){
                System.out.println("C'est en Eté");
            } else{
                System.out.println("C'est en Automne");
            }

        } else if (listeA.contains(mois)) {
            if ((jour >= 21 && !mois.equals("décembre")) || (jour <= 20 && mois.equals("décembre"))){
                System.out.println("C'est en Automne");
            } else{
                System.out.println("C'est en Hiver");
            }

        } else if (listeH.contains(mois)) {
            if ((jour >= 21 && !mois.equals("mars")) || (jour <= 20 && mois.equals("mars"))){
                System.out.println("C'est en Hiver");
            } else{
                System.out.println("C'est au Printemps");
            }
        }
    }
}
