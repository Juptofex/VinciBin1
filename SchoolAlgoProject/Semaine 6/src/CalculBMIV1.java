public class CalculBMIV1 {

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Entrez votre poids : ");
        double poids = scanner.nextDouble();
        System.out.print(("Entrez votre taille : "));
        double taille = scanner.nextDouble();
        double bmi = poids/(taille*taille);
        System.out.print("Votre bmi : "+ bmi);
    }

}
