
public class JeuDuPendu {

	public static java.util.Scanner scanner = new java.util.Scanner(System.in);

	public static void main(String[] args) {

		System.out.print("Entrez le mot a trouver : ");

		String motATrouver = scanner.next().toUpperCase();

		FenetrePendu fenetrePendu = new FenetrePendu();

		MotACompleter mot = new MotACompleter(motATrouver);

		//Pour amelioration 1 :
		//LettresLues lettreslues = new LettresLues();

		fenetrePendu.afficherMot(mot.toString());

		char lettre = Character.toUpperCase(fenetrePendu.lireLettre());
		int i = 0;

		while (i < 6){
			if(mot.contientLettre(lettre)) {
				mot.ajouterLettre(lettre);
				fenetrePendu.afficherMot(mot.toString());
				if (mot.estComplet()) break;
			} else {
				i++;
				fenetrePendu.afficherPendu(i);
			}
			lettre = Character.toUpperCase(fenetrePendu.lireLettre());
		}

		if (mot.estComplet()) {
			fenetrePendu.afficherInformation("Bravo");
		} else {
			fenetrePendu.afficherInformation("Tu as perdu !");
		}
	}

}
