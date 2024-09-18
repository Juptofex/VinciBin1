import java.util.Scanner;

public class TestPyramide {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Entrez la hauteur de la pyramide : ");
        int n = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = i; j < n; j++) {
                System.out.print(' ');
            }
            for (int j = n-i; j < n; j++) {
                System.out.print('X');
            }
            for (int j = n-i+1; j < n; j++) {
                System.out.print('X');
            }
            System.out.println();
        }
    }
}
