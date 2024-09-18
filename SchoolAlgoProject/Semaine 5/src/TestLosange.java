import java.util.Scanner;

public class TestLosange {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Entrez la hauteur de la pyramide : ");
        int n = scanner.nextInt();
        for (int i = 1; i <= n/2; i++) {
            for (int j = i; j <= n/2; j++) {
                System.out.print('X');
            }
            for (int j = 0; j < 2; j++) {
                for (int k = n-i+1; k < n; k++) {
                    System.out.print(' ');
                }
            }
            for (int j = i; j <= n/2; j++) {
                System.out.print('X');
            }
            System.out.println();
        }
        for (int i = 1; i <= n/2; i++) {
            for (int j = n-i; j < n; j++) {
                System.out.print('X');
            }
            for (int j = 0; j < 2; j++) {
                for (int k = i+1; k <= n/2; k++) {
                    System.out.print(' ');
                }
            }
            for (int j = n-i; j < n; j++) {
                System.out.print('X');
            }
            System.out.println();
        }
    }
}
