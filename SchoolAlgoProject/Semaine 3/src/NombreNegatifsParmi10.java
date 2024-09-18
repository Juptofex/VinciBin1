import java.util.Scanner;

public class NombreNegatifsParmi10 {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int r = 0;

        for (int i = 1; i <= 10; i++) {
            System.out.println("Entrez l'entier n°"+i+" : ");
            int entier = scanner.nextInt();
            if (entier < 0){
                r++;
            }
        }
        System.out.println("Il y a "+r+" entier négatifs dans la liste.");
    }

}
