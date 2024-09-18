import java.util.Scanner;

public class NombreMystereInverse {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int nbr = unEntierAuHasardEntre (50, 50);
        System.out.println("Le nombre deviné est plus grand ou plus petit que "+nbr+" ?");
        char rep = scanner.next().charAt(0);
        int x = 0;
        int y = 0;
        if (rep == '+'){
            x = 75;
            y = 75;
            nbr = unEntierAuHasardEntre(x, y);
            System.out.println("Le nombre deviné est plus grand ou plus petit que "+nbr+" ?");
            rep = scanner.next().charAt(0);
            if (rep == '+'){
                x = 75;
                y = 100;
            }else{
                x = 51;
                y = 75;
            }
        } else if (rep == '-') {
            x = 25;
            y = 25;
            nbr = unEntierAuHasardEntre(x, y);
            System.out.println("Le nombre deviné est plus grand ou plus petit que "+nbr+" ?");
            rep = scanner.next().charAt(0);
            if (rep == '-'){
                x = 0;
                y = 25;
            }else{
                x = 25;
                y = 49;
            }
        }
        while(rep!='='){
            if (rep == '+'){
                x = nbr+1;
                nbr = unEntierAuHasardEntre(x, y);
            }
            if (rep == '-'){
                y = nbr - 1;
                nbr = unEntierAuHasardEntre(x, y);
            }
            System.out.println("Le nombre deviné est plus grand ou plus petit que "+nbr+" ?");
            rep = scanner.next().charAt(0);
        }
        if (rep == '='){
            System.out.println("Le nombre a deviné était "+nbr);
        }else {
            System.out.println("Vous vous êtes trompé");
        }
    }
    public static int unEntierAuHasardEntre (int valeurMinimale, int valeurMaximale){
        return (int) (Math.random() * (valeurMaximale - valeurMinimale + 1)) + valeurMinimale;
    }
}

