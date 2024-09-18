

public class ExerciceArithmetique {

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Entrainement à l'arithmétique. Voici un exercice :");

        int nombre1 = unEntierAuHasardEntre (0, 10);
        int nombre2 = unEntierAuHasardEntre (0, 10);

        UneOperationAuHasard operation = new UneOperationAuHasard(nombre1, nombre2);

        System.out.println(operation.op);

        int reponse = scanner.nextInt();

        if(reponse == operation.res){
            System.out.println("Bravo !");
        }
        else{
            System.out.println("Raté ! La réponse était : " + operation.res);
        }
    }



    public static int unEntierAuHasardEntre (int valeurMinimale, int valeurMaximale){
        return (int)((Math.random() * (valeurMaximale - valeurMinimale + 1)) + valeurMinimale);
    }
}
