import java.util.*;

public class CalendrierMois {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Veuillez entrer la longueur du mois voulu : ");
        int longMois = scanner.nextInt();
        System.out.println("Veuillez indiquer quel jour de la semaine tombe le premier du mois (chiffre entre 1 & 7) : ");
        int premJour = scanner.nextInt();

        String[] jourSem = {"Lu", "Ma", "Me", "Je", "Ve", "Sa", "Di"};
        Set<String> listeJ = new HashSet<>(Arrays.asList(jourSem));

        for (int i = 0; i < 7; i++) {
            System.out.print(jourSem[i]+"    ");
        }
        System.out.println();
        int j = 0;
        if (premJour > 1) {
            for (int k = 0; k < premJour - 1; k++) {
                System.out.print("      ");
            }
            for (int i = 0; i < 8-premJour; i++) {
                j++;
                System.out.print(j+"     ");
            }
            System.out.println();
        }
        while(j <= longMois) {
            for (int i = 0; i < 7; i++) {
                j++;
                if(j > longMois){
                    break;
                }
                if(j <= 9){
                    System.out.print(j+"     ");
                }else {
                    System.out.print(j+"    ");
                }
            }
            System.out.println();
        }
    }
}
