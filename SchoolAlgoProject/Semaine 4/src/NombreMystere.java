import java.util.Scanner;

public class NombreMystere {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int nbr = unEntierAuHasardEntre (0, 100);
        System.out.println("Devinez le nombre tiré au hasard !");
        int rep = scanner.nextInt();
        while(rep!=nbr){

            if (rep<nbr){
                System.out.println("Plus grand...");
            }
            if (rep>nbr){
                System.out.println("Plus petit...");
            }
            rep = scanner.nextInt();
        }
        System.out.println("Bravo ! Le nombre était bien : "+nbr);
    }
    public static int unEntierAuHasardEntre (int valeurMinimale, int valeurMaximale){
        return (int) (Math.random() * (valeurMaximale - valeurMinimale + 1)) + valeurMinimale;
    }
}
