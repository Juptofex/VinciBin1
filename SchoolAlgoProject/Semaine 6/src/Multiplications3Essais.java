public class Multiplications3Essais {

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Entrainement aux multiplications");
        System.out.println("Pour chaque mutiplication, tu as droit a 3 essais");
        char reponse;
        int nombreMultiplications = 0;
        int nombreMultiplicationsReussies = 0;
        do{
            nombreMultiplications++;
            nombreMultiplicationsReussies+=faireUneMultiplication();
            System.out.println("Encore une multiplication (o/n)");
            reponse = scanner.next().charAt(0);
        }while(reponse=='o');
        System.out.println("% multiplications reussies : "+nombreMultiplicationsReussies*100/nombreMultiplications);
    }

    /**
     * propose une multiplication de 2 entiers compris entre 0 et 10
     * l'utilisateur a droit a 3 essais
     * @return 1 si l'utilisateur a trouve la bonne reponse, 0 sinon
     */
    public static int faireUneMultiplication() {
        int premierNombre = Utilitaires.unEntierAuHasardEntre(0, 10);
        int secondNombre = Utilitaires.unEntierAuHasardEntre(0, 10);
        System.out.println("Calculez : " + premierNombre + " x " + secondNombre + " = ");
        for (int i = 1; i <= 3; i++) {
            System.out.println("Essai n°" + i + " : ");
            int reponseUtilisateur = scanner.nextInt();
            if (reponseUtilisateur == premierNombre * secondNombre) {
                System.out.println("Bonne reponse !");
                return 1;
            }
        }
        System.out.println("La bonne reponse est : "+(premierNombre*secondNombre));
        return 0;
    }


}
