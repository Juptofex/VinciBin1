import java.util.Scanner;

public class Deliberation {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int nbrEtudiants = 25;
        double totalMoyenne = 0;
        for (int i = 1; i <= nbrEtudiants; i++) {
            totalMoyenne += moyenneEtudiant(10, i,0,20);
        }
        System.out.println("La moyenne de la classe est de : "+totalMoyenne/nbrEtudiants);
    }

    /**
     * Lis les cotes d'un etudiant et effectue la moyenne.
     * @param maxCote nombre total de cote a encoder
     * @param nEtudiant numéro de l'etudiant traite
     * @param borneCoteMin borne minimum des cotes encodee
     * @param borneCoteMax borne maximum des cotes encodee
     * @return la moyenne de l'etudiant
     */
    public static double moyenneEtudiant(int maxCote,int nEtudiant, int borneCoteMin, int borneCoteMax){
        double totalCote = 0;
        int nbrCote = 0;
        for (int i = 0; i < maxCote; i++) {
            System.out.println("Entrez la cote de "+nEtudiant+" : ");
            double cote = Utilitaires.lireReelComprisEntre(borneCoteMin,borneCoteMax);
            totalCote += cote;
            nbrCote++;
        }
        return totalCote/nbrCote;
    }
}
