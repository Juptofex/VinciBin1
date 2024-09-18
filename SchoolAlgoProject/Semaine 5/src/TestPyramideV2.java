import java.util.Scanner;

public class TestPyramideV2 {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Entrez la hauteur de la pyramide : ");
        int n = scanner.nextInt();

        for(int i=0; i < n; i++){
            for(int j=0; j < 2*n; j++){
                int abs = Math.abs(n-j);
                System.out.print(abs>i ? " " : i-abs+1);
            }
            System.out.println();
        }
    }
}
