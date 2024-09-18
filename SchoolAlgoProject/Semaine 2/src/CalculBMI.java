import java.util.Scanner;

public class CalculBMI {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Entrez votre poid (en Kg) : ");
        double poid = scanner.nextDouble();
        System.out.println("Entrez votre taille (en m) : ");
        double taille = scanner.nextDouble();

        double BMI = BMI(poid, taille);

        if(BMI > 30) {
            System.out.println("Selon votre indice de masse corporelle, vous étes en état d'obésité.");
        }else {
            if (BMI > 25) {
                System.out.println("Selon votre indice de masse corporelle, vous avez de l'embonpoint.");
            }else {
                if (BMI > 20) {
                    System.out.println("Selon votre indice de masse corporelle, vous étes normal.");
                }else {
                    System.out.println("Selon votre indice de masse corporelle, vous étes mince.");
                }
            }
        }
    }

    public static double BMI(double poid,double taille){
        return poid / Math.pow(taille, 2);
    }
}
