public class Multiplication3Entiers {

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Entrainement aux multiplications. Voici un exercice :");

        int nombre1 = unEntierAuHasardEntre (0, 10);
        int nombre2 = unEntierAuHasardEntre (0, 10);
        int nombre3 = unEntierAuHasardEntre (0,10);
        System.out.println("Calculez : " + nombre1 + " x " + nombre2 +  " x " + nombre3 + " =");

        int reponse = scanner.nextInt();

        // A COMPLETER
        if(reponse == multiplication3(nombre1, nombre2, nombre3)){
            System.out.println("Bravo !");
        }
        else{
            System.out.println("Raté ! La réponse était : " + multiplication3(nombre1, nombre2, nombre3));
        }


    }

    public static int unEntierAuHasardEntre (int valeurMinimale, int valeurMaximale){
        return (int)((Math.random() * (valeurMaximale - valeurMinimale + 1)) + valeurMinimale);
    }

    public static double multiplication3(int nbr1, int nbr2, int nbr3){
        return nbr1 * nbr2 * nbr3;
    }

}
