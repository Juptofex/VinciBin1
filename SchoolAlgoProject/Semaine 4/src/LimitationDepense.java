import java.util.Scanner;

public class LimitationDepense {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Quel montant maximum souhaitez-vous dépenser ?");
        int n = scanner.nextInt();
        int achat = 0;
        while(n > 0){
            System.out.println("Entrez le montant de votre achat : ");
            achat = scanner.nextInt();
            n -= achat;
        }
        if (n < 0){
            n += achat;
        }
        System.out.println("Il vous reste : "+n);
    }
}
