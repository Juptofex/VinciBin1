import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Utilitaires {

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    /**
     * genere un entier compris entre les 2 valeurs passees en parametre
     *
     * @param valeurMinimale la valeur minimale de l'entier genere
     * @param valeurMaximale la valeur maximale de l'entier genere
     * @return l'entier genere
     */
    public static int unEntierAuHasardEntre(int valeurMinimale, int valeurMaximale) {
        return (int) (Math.random() * (valeurMaximale - valeurMinimale + 1)) + valeurMinimale;
    }


    /**
     * lit un nombre reel positif ou nul
     *
     * @return un nombre reel positif
     */
    public static double lireReelPositif() {
        double x = scanner.nextDouble();
        while (x < 0) {
            System.out.println("Attention le reel doit etre positif");
            System.out.print("Recommencez : ");
            x = scanner.nextDouble();
        }
        return x;
    }


    /**
     * lit un nombre entier non nul
     *
     * @return un entier non nul
     */
    public static int lireEntierNonNul() {
        int x = scanner.nextInt();
        while (x == 0) {
            System.out.println("Attention, l'entier ne peut pas etre egal a 0");
            System.out.println("Recommencez : ");
            x = scanner.nextInt();
        }
        return x;
    }


    /**
     * lit un nombre entier positif, non nul
     *
     * @return un entier positif non nul
     */
    public static int lireEntierPositifNonNul() {
        int x = scanner.nextInt();
        while (x <= 0) {
            System.out.println("Attention, l'entier ne peut pas etre egal a 0, ni etre negatif");
            System.out.println("Recommencez : ");
            x = scanner.nextInt();
        }
        return x;
    }


    /**
     * lit un nombre reel compris entre les 2 valeurs passees en parametre
     *
     * @param min le plus petit reel accepte
     * @param max le plus grand reel accepte
     * @return un nombre reel compris entre 2 bornes
     */
    public static double lireReelComprisEntre(double min, double max) {
        double x = scanner.nextDouble();
        while (x > max || x < min) {
            System.out.println("Attention la cote doit etre entre " + min + " et " + max + ".");
            System.out.print("Recommencez : ");
            x = scanner.nextDouble();
        }
        return x;
        // TODO
        //il faut placer une boucle dans cette methode !
        //procedez comme pour la methode lireReelEntierPositif() donnee ci-dessus
    }


    /**
     * lit le caractere o ou n
     *
     * @return le caractere o un n
     */
    public static char lireOouN() {
        char x = scanner.next().charAt(0);
        while (x != 'o' && x != 'n') {
            System.out.println("Entrez o ou n : ");
            x = scanner.next().charAt(0);
        }
        return x;
        // TODO
        //il faut placer une boucle dans cette methode !
    }


    /**
     * lis un charactere et verifie si il se trouve dans une suite de charactere donnés
     * @param characteresPermis suite des charactere permis
     * @return le charactere compris dans le parametre characteresPermis
     */
    public static String lireCharPermis(String characteresPermis){
        String str[] = characteresPermis.split("");
        List<String> l = new ArrayList<String>();
        l = Arrays.asList(str);
        String charactere = "";
        do {
            System.out.println("Entrez un caractere : ");
            charactere = scanner.nextLine();
        }while (!l.contains(charactere));
        return charactere;
    }
}
