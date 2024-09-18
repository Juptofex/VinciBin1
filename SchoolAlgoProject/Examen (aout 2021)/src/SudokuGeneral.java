
/**
 * Représente une grille de Sudoku d'une taille (presque) quelconque
 * 
 * @author gregory.seront
 *
 */
public class SudokuGeneral {
	
	private int tailleCote;
	private int tailleRegion;
	private int [] [] grille; // Les case non remplies sont représentées par des 0
	
	/**
	 * Constructeur par copie. 
	 * Crée un nouvel objet en faisant une copie profonde de la grille
	 * passée en paramètre.
	 * Il déduit égalementla taille des côtés du carré ainsi que la
	 * taille des côtés des régions.
	 * Notez que la taille des côtés corresponds au nombre de symboles
	 * différents que l'on utilise dans la grille
	 * 
	 * NE PAS MODIFIER, utilisé pour les tests
	 * 
	 * @param grille grille qui sera recopiée.
	 * 
	 * Préconditions: le tableau grille dans être un carré et la racine carré
	 * de la taille du coté doit être un nombre entier (ex: 9, 16, 25, 36, ...)
	 * Ce constructeur ne vérifie pas ces préconditions, on suppose qu'elles sont correctes.
	 */
	public SudokuGeneral(int[][] grille) {
		this.tailleCote = grille.length; 
		this.tailleRegion = (int)Math.sqrt(tailleCote);
		this.grille = new int [tailleCote][tailleCote];
		for (int i=0; i<tailleCote; i++) {
			for (int j=0; j<tailleCote; j++) {
				this.grille[i][j] = grille[i][j];
			}
		}
	}
	
	/**
	 * Vérifie que si l'on mets le nombre 'nombre' à la position i, j
	 * La grille de sudoku reste légale. 
	 * Cela doit se faire sans parcourir toute la grille!
	 * 
	 * @param i ligne du coup. Les lignes sont numérotées à partir de 0
	 * @param j colonne du coup. Les colonnes sont numérotées à partir de 0
	 * @param nombre nombre que l'on veut placer dans la grille
	 * @return true si le coup est légal (voir énoncé), false sinon
	 */
	public boolean isCoupLegal(int i, int j, int nombre) {
		for (int k = 0; k < tailleCote; k++) {
			if (grille[k][j]==nombre || grille[i][k]==nombre)
				return false;
		}
		for (int k = i; k < tailleRegion; k++) {
			for (int l = j; l < tailleRegion; l++) {
				if (grille[k][l]==nombre)
					return false;
			}
		}
		return true;
	}
	
	/**
	 * Vérifie que la ligne contient au plus une fois chaque
	 * symbole, à l'exception du 0.
	 * On ne vérifie pas qu'il existe des symboles non attendus
	 * ( <0 ou >tailleCote)
	 * @param i numéro de la ligne
	 * @return true si la ligne est légale, false sinon
	 */
	boolean isLigneLegale(int i) {
		int[] temp = new int[10];
		for (int j = 0; j < tailleCote; j++) {
			temp[grille[i][j]]++;
		}
		for (int j = 1; j < temp.length; j++) {
			if (temp[j]>1)
				return false;
		}
		return true;
	}

	/**
	 * Vérifie que la colonne contient au plus une fois chaque
	 * symbole, à l'exception du 0.
	 * On ne vérifie pas qu'il existe des symboles non attendus
	 * ( <0 ou >tailleCote)
	 * @param j numéro de la colonne
	 * @return true si la colonne est légale, false sinon
	 */	
	boolean isColonneLegale(int j) {
		int[] temp = new int[10];
		for (int i = 0; i < tailleCote; i++) {
			temp[grille[i][j]]++;
		}
		for (int i = 1; i < temp.length; i++) {
			if (temp[i]>1)
				return false;
		}
		return true;
	}
	
	
	/**
	 * Vérifie que la région contient au plus une fois chaque
	 * symbole, à l'exception du 0.
	 * On ne vérifie pas qu'il existe des symboles non attendus
	 * ( <0 ou >tailleCote)
	 *
	 * @param i numéro de ligne du coin supérieur gauche de la région
	 * @param j numéro de colonne du coin supérieur gauche de la région
	 * @return true si la région est légale, false sinon
	 */
	boolean isRegionLegale(int i, int j) {
		int[] temp = new int[10];
		for (int k = i; k < tailleRegion; k++) {
			for (int l = j; l < tailleRegion; l++) {
				temp[grille[k][l]]++;
			}
		}
		for (int k = 1; k < temp.length; k++) {
			if (temp[k]>1)
				return false;
		}
		return true;
	}
	
	/**
	 * Vérifie que toutes les lignes, colonnes et régions
	 * de la grille sont légales
	 * @return true si la grille est légale
	 */
	boolean isGrilleLegale() {
		for (int i = 0; i < tailleCote; i++) {
			if (!isLigneLegale(i)) return false;
		}
		for (int i = 0; i < tailleCote; i++) {
			if (!isColonneLegale(i)) return false;
		}
		return true;
	}
	
	
}
