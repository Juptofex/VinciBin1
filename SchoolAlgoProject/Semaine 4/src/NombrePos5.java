import java.util.Scanner;

public class NombrePos5 {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int i=0;
        while (i < 5){
            System.out.println("Entrez un nombre : ");
            int n = scanner.nextInt();
            if(n>0){
                i++;
            }
        }
        System.out.println("Vous avez entrez 5 nombres positifs.");
    }
}
