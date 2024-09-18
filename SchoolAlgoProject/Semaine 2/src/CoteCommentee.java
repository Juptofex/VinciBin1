import java.util.Scanner;

public class CoteCommentee {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Entrez votre cote : ");
        double cote = scanner.nextDouble();

        if(cote >= 16){
            System.out.println("l'étudiant a validé l'UE avec une très belle cote");
        } else {
            if (cote >= 14) {
                System.out.println("l'étudiant a validé l'UE avec une belle cote");
            }else {
                if (cote >= 10) {
                    System.out.println("l'étudiant a validé l'UE");
                }else {
                    System.out.println("l'étudiant n'a pas validé l'UE");
                }
            }

        }
    }
}
