import java.util.Scanner;

public class SommeNegatifsEtPositifs {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int sommePos = 0;
        int sommeNeg = 0;

        for (int i = 1; i <= 5; i++) {
            System.out.println("Entrez l'entier n°"+i+" : ");
            int entier = scanner.nextInt();
            if (entier > 0){
                sommePos += entier;
            }else {
                sommeNeg += entier;
            }
        }
        System.out.println("La somme des entiers positifs vaut : "+sommePos+"\n"+"La somme des entiers négtifs vaut : "+sommeNeg);
    }
}
