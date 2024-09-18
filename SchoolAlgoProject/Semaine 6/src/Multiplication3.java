
public class Multiplication3 {
	
	public static java.util.Scanner scanner = new java.util.Scanner(System.in);

	public static void main(String[] args) {
		
		System.out.println("Tu vas faire 5 multiplications");
		System.out.println("Au depart la valeur minimale des nombres a multiplier est 1 et la valeur maximale est 10");
		System.out.println("Ces 2 bornes augmenteront de 10 a chaque multiplication reussie");
		System.out.println("Pour chaque multiplication, tu as droit a 1 essai");
		System.out.println("Tu recevras la reponse, si tu la rate");
		// A NE PAS COMPLETER
		faireUneMultiplication();
	}


	/**
	 * fait résoudre une multiplication 5 fois et augmente les borne maximales des nombres généré à chaque réussite
	 */
	public static void faireUneMultiplication() {
		int res, borneMinNbr = 1, borneMaxNbr = 10;
		for (int i = 1; i <= 5; i++) {
			int premierNombre = Utilitaires.unEntierAuHasardEntre(borneMinNbr, borneMaxNbr);
			int secondNombre = Utilitaires.unEntierAuHasardEntre(borneMinNbr, borneMaxNbr);
			System.out.println("Multiplication n°" + i);
			System.out.println("Calculez : " + premierNombre + " x " + secondNombre + " = ");
			int reponseUtilisateur = scanner.nextInt();
			res = premierNombre * secondNombre;
			if (reponseUtilisateur == res) {
				System.out.println("Bonne reponse !");
				borneMinNbr += 10;
				borneMaxNbr += 10;
			}
			else {
				System.out.println("Raté !");
				System.out.println("La bonne reponse est : " + (premierNombre * secondNombre));
			}

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
