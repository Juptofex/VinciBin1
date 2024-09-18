public class CalculMoyenne {

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        char reponse = 'Y';
        double moyenne = 0;
        int n = 0;
        do{
            n++;
            System.out.println("Entrez la côte : ");
            moyenne += scanner.nextDouble();
            System.out.println("Répondez Y/O si il faut encoder une autre cote : ");
            reponse = scanner.next().charAt(0);
        }while (reponse == 'Y' || reponse == 'y' || reponse == 'O' || reponse == 'o');
        moyenne = moyenne/n;
        System.out.println("La moyenne des côte est : "+moyenne);
    }
}
