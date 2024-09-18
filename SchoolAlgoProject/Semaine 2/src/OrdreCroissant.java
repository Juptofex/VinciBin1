import java.util.Scanner;

public class OrdreCroissant {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Entrez l'entier 1 : ");
        int entier1 = scanner.nextInt();
        System.out.println("Entrez l'entier 2 : ");
        int entier2 = scanner.nextInt();

        if (entier1 > entier2){
            System.out.println(entier1 + "\n" + entier2);
        }else {
            System.out.println(entier2 + "\n" + entier1);
        }
    }
}
