public class ClassementDesFinalistes {
	private String[] finalistes; // tableau contenant le nom des participants
	private int[] points; // tableau contentant les points des participants (points[i] : points de finalistes[i])
	private int nombreDeFinalistes;
	private int placesDeFinaliste;

	public ClassementDesFinalistes(int placesDeFinaliste) {
		this.placesDeFinaliste = placesDeFinaliste;
		finalistes = new String[placesDeFinaliste];
		points = new int[placesDeFinaliste];
		this.nombreDeFinalistes = 0;
	}

	/*
	 * Ajoute pts points a participant si celui-ci est un finaliste ou l'ajoute aux finalistes 
	 * s'il reste une place de finaliste. En cas d�ajout, la methode fait en sorte que 
	 * la table points reste triee par ordre decroissant tout en maintenant le nom du 
	 * finaliste au meme indice que ses points. 
	 * De plus la m�thode va renvoyer true si l'ajout a pu se faire et false sinon.
	 * 
	 * @param pts points a ajouter (avec pts>0)
	 * @param participant qui est ou qui veut devenir finaliste et auquel on va 
	 *         essayer d'ajouter pts points
	 * 
	 * @return true si on a pu ajouter les points au participant 
	 *         false sinon
	 */

	public boolean ajouter(int pts, String participant) {
		for (int i = 0; i < finalistes.length; i++) {
			if (finalistes[i]==null) {
				finalistes[i] = participant;
				points[i] += pts;
				nombreDeFinalistes++;
				break;
			} else if (finalistes[i].equals(participant)) {
				points[i] += pts;
				break;
			} else if (i==finalistes.length-1) {
				return false;
			}
		}
		for (int i = nombreDeFinalistes-1; i > 0; i--) {
			if (points[i]>points[i-1]) {
				String tempF = finalistes[i];
				int tempP = points[i];
				finalistes[i]=finalistes[i-1];
				points[i]=points[i-1];
				finalistes[i-1]=tempF;
				points[i-1]=tempP;
			}
		}
		return true;
	}

	/*
	 * Renvoie une table contenant le(s) nom(s) du ou des premiers (en cas d'exaequo) 
	 * dans l'ordre ou il(s) se trouve(nt) dans la table finalistes.
	 * 
	 * @return une table contenant le ou le(s) premier(s)
	 *         une table vide s'il n'y a pas de finaliste
	 */

	public String[] premiers() {
		String[] premier;
		int n = 0;
		for (int i = 0; i < nombreDeFinalistes; i++) {
			if (points[i]==points[0]) n++;
		}
		premier = new String[n];
		for (int i = 0; i <= n-1; i++) {
			premier[i]=finalistes[i];
		}
		return premier;
	
	}

	/*
	 * Calcule le plus grand ecart de points entre 2 finalistes qui se suivent 
	 * dans le classement.
	 * 
	 * @return l'ecart de point maximum entre 2 finalistes qui se suivent au
	 *         classement
	 *         0 s'il n'y a pas de finaliste
	 */
	
	public int ecartMaximum() {
		int MaxEcart=0;
		for (int i = 0; i < nombreDeFinalistes-1; i++) {
			if (MaxEcart<(points[i]-points[i+1])) MaxEcart=(points[i]-points[i+1]);
		}
		return MaxEcart;
		
	}
	
	/*
	 * Retire participant des finalistes et renvoie si celui fait partie des participants
	 * Sinon ne fait rien et renvoie false
	 * @param participant : le participant a disqualifier
	 * @return true si participant a pu �tre retirer des finalistes
	 *         false sinon
	 */
	public boolean disqualifier(String participant) {
		for (int i = 0; i < nombreDeFinalistes; i++) {
			if (finalistes[i]==null) break;
			if (finalistes[i].equals(participant)) {
				for (int j = i; j < nombreDeFinalistes-1; j++) {
					finalistes[j]=finalistes[j+1];
					points[j]=points[j+1];
				}
				nombreDeFinalistes--;
				return true;
			}
		}
		return false;
	}
	

	/*
	 * Renvoie un String representant le tableau des finalistes et le
	 * tableau de leurs points respectifs
	 * 
	 * @return un String representant le tableau des finalistes et le tableau de
	 *         leurs points respectifs
	 */

	public String toString() {
		// NE PAS MODIFIER !!!
		int tailleString = tailleMaxNom();
		String st = ligne(nombreDeFinalistes, tailleString) + '\n' + "|";
		for (int i = 0; i < nombreDeFinalistes; i++) {
			st = st + format(finalistes[i], tailleString) + "|";
		}
		st = st + '\n' + ligne2(nombreDeFinalistes, tailleString) + '\n' + '|';
		for (int i = 0; i < nombreDeFinalistes; i++) {
			st = st + format("" + points[i], tailleString) + "|";
		}
		st = st + '\n' + ligne(nombreDeFinalistes, tailleString);
		return st;
	}

	private int tailleMaxNom() {
		// NE PAS MODIFIER !!!
		int tailleMax = 0;
		for (int i = 0; i < nombreDeFinalistes; i++) {
			if (finalistes[i]==null) {
				if (tailleMax<4) {
					tailleMax=4 ;
				}
			} else if (finalistes[i].length() > tailleMax) {
				tailleMax = finalistes[i].length();
			}
		}
		return tailleMax;
	}

	private String format(String nom, int taille) {
		// NE PAS MODIFIER !!!
		int nbBlancs = taille-4;
		if (nom!=null) {
			nbBlancs = taille - nom.length();
		}
		int nbBlancsGauche = nbBlancs / 2;
		int nbBlancsDroit = nbBlancs - nbBlancsGauche;
		String nomFormate = nom;
		for (int i = 0; i < nbBlancsGauche; i++) {
			nomFormate = " " + nomFormate;
		}
		for (int i = 0; i < nbBlancsDroit; i++) {
			nomFormate = nomFormate + " ";
		}
		return nomFormate;
	}

	private String ligne(int nbNoms, int tailleNom) {
		// NE PAS MODIFIER !!!
		String st = "";
		for (int i = 0; i < nbNoms; i++) {
			st = st + " ";
			for (int j = 0; j < tailleNom; j++) {
				st = st + '-';
			}
		}
		return st;
	}

	private String ligne2(int nbNoms, int tailleNom) {
		// NE PAS MODIFIER !!!
		String st = "|";
		for (int i = 0; i < nbNoms; i++) {
			for (int j = 0; j < tailleNom; j++) {
				st = st + '-';
			}
			st = st + "|";
		}
		return st;
	}

}
