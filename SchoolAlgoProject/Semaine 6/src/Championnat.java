
/**
 * Championnat.java
 * @author 
 * 
 */
public class Championnat {

	public static java.util.Scanner scanner = new java.util.Scanner(System.in);

	
	public static void main(String[] args) {
			// Completez ici
		char rep;
		int nbrConcurents = 0;
		do{
			if (resultatUnConcurrent() >= 8){nbrConcurents++;}
			rep = Utilitaires.lireOouN();
		}while (rep == 'O');
		System.out.println("Il y a "+nbrConcurents+" qui va/vont en finale.");
	
	}

	/**
	 * lit les cotes, calcule et renvoie le resultat d'un concurrent.
	 * Chaque concurrent est cote pour la presentation de son exercice, sur 10 points, par 8 membres du jury.
     * On elimine de ces cotes la plus haute et la plus basse. Le resultat d un concurrent est egal a la moyenne des 6 cotes restantes.
	 * @return le resultat du concurrent
	*/
	public static double resultatUnConcurrent() {
		double coteMax = 0;
		double coteMin = 10;
		double coteF = 0;
		for (int i = 1; i <= 8; i++) {
			System.out.println("Entrez la note n°: " + i);
			double cote = Utilitaires.lireReelComprisEntre(0,10);
			if (cote > coteMax) {
				coteMax = cote;
			}
			if (cote < coteMin) {
				coteMin = cote;
			}
			coteF += cote;
		}
		return coteF = (coteF - coteMax - coteMin) / 6;
	}
}
