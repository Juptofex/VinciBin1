
import java.util.Scanner;

public class Championnat {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int coteMax = 0;
        int coteMin = 10;
        int coteF = 0;

        for (int i = 1; i <= 8; i++) {
            System.out.println("Entrez la note n°: " + i);
            int cote = scanner.nextInt();
            if (cote > coteMax) {
                coteMax = cote;
            }
            if (cote < coteMin) {
                coteMin = cote;
            }
            coteF += cote;
        }
        coteF = (coteF - coteMax - coteMin) / 6;
        if (coteF >= 8) {
            System.out.println("Le candidat est séléctionné.");
        }
    }
}
