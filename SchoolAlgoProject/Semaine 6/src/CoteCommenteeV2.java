public class CoteCommenteeV2 {

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main (String[] args) {

        System.out.print("Veuillez entrer la cote : ");
        double cote = Utilitaires.lireReelComprisEntre(0, 20);
        System.out.println(donnerCommentaire(cote));
    }

    /**
     * Commente la cote donnee
     * @param cote cote de l'etudiant
     * @return un commentaire sur la cote donnee
     */
    public static String donnerCommentaire(double cote){
        if (cote <10) return "L'etudiant n'a pas valide l'UE.";
        if (cote < 14) return "L'etudiant a valide l'UE.";
        if (cote < 16) return "L'etudiant a valide l'UE avec une belle cote.";
        return "L'etudiant a valide l'UE avec une tres belle cote.";
    }
}
