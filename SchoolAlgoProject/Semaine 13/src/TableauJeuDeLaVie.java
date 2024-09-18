
public class TableauJeuDeLaVie {

	private boolean[][] table;
	private int nbLignes; 	// nb lignes
	private int nbColonnes; // nb colonnes

	/**
	 * Cree un tableau sans aucune cellule vivante.
	 * @param nbColonnes
	 * @param nbLignes
	 */
	public TableauJeuDeLaVie(int nbLignes, int nbColonnes) {
		table = new boolean[nbLignes][nbColonnes];
		this.nbLignes = nbLignes;
		this.nbColonnes = nbColonnes;
	}

	/**
	 * modifie la cellule x, y
	 * precondition (a ne pas verifier) x et y sont des coordonnees valides
	 * @param x l'indice de ligne
	 * @param y l'indice de colonne
	 * @param enVie la nouvelle valeur de la cellule x, y
	 */
	public void setXY(int x, int y, boolean enVie){
		table[x][y] = enVie;
	}

	/**
	 * renvoie la valeur de la cellule x, y
	 * precondition (a ne pas verifier) x et y sont des coordonnees valides
	 * @param x l'indice de ligne
	 * @param y l'indice de colonne
	 * @return la valeur de la cellule x, y
	 */
	public boolean getXY(int x, int y){
		return table[x][y];
	}

	/**
	 * Calcule le nombre de voisines vivantes de la cellule x, y
	 * precondition (a ne pas verifier) x et y sont des coordonnees valides
	 * @param x l'indice de ligne
	 * @param y l'indice de colonne
	 * @return Le nombre de voisines vivantes
	 */
	public int nbVoisines(int x, int y){
		int n=0;
		for (int i = x-1; i <= x+1; i++) {
			for (int j = y-1; j <= y+1; j++) {
				if (i >= 0 && i < table.length && j >= 0 && j < table[0].length && !(i == x && j == y) && table[i][j]) n++;
			}
		}
		return n;
	}

	/**
	 * Calcule l'etat d'une cellule a la generation suivante.
	 * Les regles suivantes sont appliquees:
	 * - Une cellule morte possedant exactement trois voisines vivantes devient vivante (elle nait).
	 * - Une cellule vivante possedant deux ou trois voisines vivantes le reste, sinon elle meurt.
         * precondition (a ne pas verifier) x et y sont des coordonnees valides
 	 * @param x l'indice de ligne
	 * @param y l'indice de colonne
	 * @return true si la cellule en x, y sera en vie a la generation suivante
	 */
	private boolean enVieGenerationSuivante(int x, int y) {
		int index = nbVoisines(x, y);
		if (index == 2 && table[x][y]) return true;
		if (index == 3) return true;
		return false;
	}


	/**
	 * Calcule le tableau de jeu a la generation suivante
	 * en faisant vivre, mourir et naitre des cellules.
	 */
	public void generationSuivante(){
		// TODO
		// Il est indispensable de travailler avec une table intermediaire
		boolean[][] temp = new boolean[table.length][table[0].length];
		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table[0].length; j++) {
				if (enVieGenerationSuivante(i,j)) {
					temp[i][j] = true;
				}
			}
		}
		table = temp;
	}
	
}