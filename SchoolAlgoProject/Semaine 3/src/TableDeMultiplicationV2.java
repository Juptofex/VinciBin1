import java.util.Scanner;

public class TableDeMultiplicationV2 {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int r = 0;
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                r = i*j;
                if (r <= 9){
                    System.out.print(r+"    ");
                }else {
                    System.out.print(r+"   ");
                }

            }
            System.out.println();
        }
    }
}