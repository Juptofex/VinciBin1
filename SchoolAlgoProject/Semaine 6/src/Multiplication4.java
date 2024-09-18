
public class Multiplication4 {
	
	public static java.util.Scanner scanner = new java.util.Scanner(System.in);

	public static void main(String[] args) {
		
		System.out.println("Tu vas faire des multiplications de nombres compris entre 0 et 10");
		System.out.println("Tu peux choisir le nombre d'essais que tu auras pour chaque multiplication");
		System.out.println("Ce nombre sera le meme pour toutes les multiplications");
		System.out.println("Tu recevras la reponse, si tu ne l'as toujours pas trouvee au terme du nombre d'essais accorde");
		System.out.println("Apres chaque multiplication, le programme te demandera si tu en veux une autre");
	
		//A NE PAS COMPLETER
		faireUneMultiplication(4);
	}


	/**
	 * fait faire des multiplications jusqu'a ce que l'utilisateur décide d'arreter, le nombre d'essais par multiplication
	 * @param nbrEssais nombre d'essais autorisé pour trouver la réponse
	 */
	public static void faireUneMultiplication(int nbrEssais) {
		int res = 0, borneMinNbr = 0, borneMaxNbr = 10, i = 0, e = 1, reponseUtilisateur = 99999;
		char rep = 'o';
		while (rep == 'o') {
			i++;
			int premierNombre = Utilitaires.unEntierAuHasardEntre(borneMinNbr, borneMaxNbr);
			int secondNombre = Utilitaires.unEntierAuHasardEntre(borneMinNbr, borneMaxNbr);
			System.out.println("Multiplication n°" + i);
			System.out.println("Calculez : " + premierNombre + " x " + secondNombre + " = ");
			while (e <= 5 && res != reponseUtilisateur) {
				e++;
				reponseUtilisateur = scanner.nextInt();
				res = premierNombre * secondNombre;
				if (reponseUtilisateur == res) {
					System.out.println("Bonne reponse !");
				}
				else {
					System.out.println("Raté !");
				}
			}
			if (e > 5){
				System.out.println("La bonne reponse est : " + (premierNombre * secondNombre));
			}
			e = 1;
			System.out.println("Voulez-vous continuer ?");
			rep = Utilitaires.lireOouN();
		}
	}

	public static int unEntierAuHasardEntre (int valeurMinimale, int valeurMaximale){
		double nombreReel;
		int resultat;
		nombreReel = Math.random();
		resultat = (int) (nombreReel * (valeurMaximale - valeurMinimale + 1)) + valeurMinimale;
		return resultat;
	}
}
