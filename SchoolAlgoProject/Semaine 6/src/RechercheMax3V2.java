public class RechercheMax3V2 {

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Entrez l'entier 1 : ");
        int entier1 = scanner.nextInt();
        System.out.println("Entrez l'entier 2 : ");
        int entier2 = scanner.nextInt();
        System.out.println("Entrez l'entier 3 : ");
        int entier3 = scanner.nextInt();
        System.out.println(max3(entier1, entier2, entier3));
    }

    /**
     * Determine le maximum entre 3 nombres donne
     * @param x
     * @param y
     * @param z
     * @return
     */
    public static String max3(int x, int y, int z){
        if(x>y && x>z) return "Le plus grand entier est "+x;
        if(y>z) return "Le plus grand entier est "+y;
        return "Le plus grand entier est "+z;
    }
}
