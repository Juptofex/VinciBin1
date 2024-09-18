import java.util.Scanner;

public class NombrePosNegParmi10 {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int rN = 0;
        int rP = 0;

        for (int i = 1; i <= 10; i++) {
            System.out.println("Entrez l'entier n°"+i+" : ");
            int entier = scanner.nextInt();
            if (entier < 0){
                rN++;
            }
            if (entier > 0){
                rP++;
            }
        }
        System.out.println("Il y a "+rN+" entier négatifs et "+rP+" entier positifs dans la liste.");
    }

}

