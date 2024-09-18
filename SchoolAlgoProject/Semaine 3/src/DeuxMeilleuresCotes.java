import java.util.Scanner;

public class DeuxMeilleuresCotes {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int n1 = 0;
        int n2 = 0;

        for (int i = 1; i <= 5; i++) {
            System.out.println("Entrez la note n°: "+i);
            int note = scanner.nextInt();
            if(note > n1){
                n2 = n1;
                n1 = note;
            }else if (note > n2){
                n2 = note;
            }
        }
        System.out.printf("Les deux meilleures notes sont : "+n1+" "+n2);
    }
}