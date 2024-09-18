public class CalculMoyenne {

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        int nombreCotes = 0;
        double totalCotes = 0;
        char reponse;
        do {
            totalCotes += Utilitaires.lireReelComprisEntre(0,20);;
            nombreCotes++;
            System.out.println("Entrez o si vous avez d'autre cote a encoder : ");
            reponse = Utilitaires.lireOouN();
        } while (reponse == 'o');
        System.out.print("La moyenne des cotes : " + totalCotes/nombreCotes);
    }

}
