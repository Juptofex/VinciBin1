
public class Multiplication2 {
	
	public static java.util.Scanner scanner = new java.util.Scanner(System.in);

	public static void main(String[] args) {
		
		System.out.println("Tu vas faire des multiplications.");
		System.out.println("La valeur minimale des 2 nombres a multiplier est 0.");
		System.out.println("Tu peux choisir la valeur maximale de ces 2 nombres.");
		System.out.println("Cette valeur sera la meme pour tous les exercices");
		System.out.println("Pour chaque multiplication, tant que tu n'auras pas donne la bonne reponse, tu devras la recommencer");
		System.out.println("Le programme termine lorsque tu auras reussi 3 multiplications du premier coup");
	
		// A NE PAS COMPLETER
		System.out.println("Choisis la borne maximale pour les nombres à multiplier : ");
		int bM = scanner.nextInt();

	}


	/**
	 * fait résoudre des multiplications jusqu'à avoir trois réussites sans fautes à la suites
	 * @param borneMaxNbr valeur max des nombres générés
	 * @param nbrMultiplication nombre de multiplication réussies de suite nécessaire
	 */
	public static void faireUneMultiplication(int borneMaxNbr, int nbrMultiplication) {
		int res = 0, reponseUtilisateur = 1, rep = 1;
		while(rep <= nbrMultiplication){
			int premierNombre = Utilitaires.unEntierAuHasardEntre(0, borneMaxNbr);
			int secondNombre = Utilitaires.unEntierAuHasardEntre(0, borneMaxNbr);
			System.out.println("Multiplication n°" + rep);
			System.out.println("Calculez : " + premierNombre + " x " + secondNombre + " = ");
			while(res != reponseUtilisateur){
				reponseUtilisateur = scanner.nextInt();
				res = premierNombre * secondNombre;
				if (reponseUtilisateur == res) {
					System.out.println("Bonne reponse !");
					rep++;
				}else {
					System.out.println("Raté, réessaye");
					rep = 1;
				}
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
