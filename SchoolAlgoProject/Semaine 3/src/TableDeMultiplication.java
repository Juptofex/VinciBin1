import java.util.Scanner;

public class TableDeMultiplication {

     public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Entrez le chiffre dont vous voulez voir la table de mulitplication :");
        int entier = scanner.nextInt();

        for (int i = 1; i <= 10; i++) {
            int r = entier*i;
            System.out.println(i+"x"+entier+"="+r);
        }
    }
}
