import java.util.Scanner;

public class RecitationTableMultiplication {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int premierNombre = unEntierAuHasardEntre (0, 10);
        int i = 0;
        int res = 0;
        int rep = 0;
        System.out.println("Tu va donner la table de multiplication par "+premierNombre);
        while (i <=10 && res == rep){
            i++;
            res = premierNombre * i;
            System.out.println(i+" * "+premierNombre+" = ");
            rep = scanner.nextInt();
        }
        if (res == rep){
            System.out.println("Felicitation !");
        }else {
            System.out.println("Non c'est faux, la bonne réponse est "+res);
        }
    }
    public static int unEntierAuHasardEntre (int valeurMinimale, int valeurMaximale){
        return (int) (Math.random() * (valeurMaximale - valeurMinimale + 1)) + valeurMinimale;
    }
}
