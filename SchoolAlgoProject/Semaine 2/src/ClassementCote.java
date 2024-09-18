import java.util.Scanner;

public class ClassementCote {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Entrez la cote obtenue pour Algo : ");
        int coteAlgo = scanner.nextInt();
        System.out.println("Entrez la cote obtenue pour APOO : ");
        int coteAPOO = scanner.nextInt();

        if (coteAlgo > coteAPOO){
            System.out.println("Le cours le mieux réussi est Algo.");
        } else if (coteAlgo == coteAPOO) {
            System.out.println("Les deux cours sont aussi bien réussis l'un que l'autre.");
        }else{
            System.out.println("Le cours le mieux réussi est APOO.");
        }
    }
}
