import java.util.Arrays;
import java.util.NoSuchElementException;

public class EquipeGuerriers {

	private Guerrier[] tableGuerriers;
	private int nombreGuerriersEnVie;

	/**
	 * construit l'equipe 
	 * @param nombreGuerriers nombre de guerriers en vie au debut du jeu
	 * @param pointsDeVieDeDepart nombre de points de vie attribue a chaque guerrier au debut du jeu
	 * @throws IllegalArgumentException il faut au moins 1 guerrier vivant pour combattre la creature du mal
	 */
	public EquipeGuerriers(int nombreGuerriers, int pointsDeVieDeDepart){
		if(nombreGuerriers<=0||pointsDeVieDeDepart<=0) 
			throw new IllegalArgumentException("jeu impossible!");
		int numero = nombreGuerriers;
		tableGuerriers = new Guerrier[nombreGuerriers];
		nombreGuerriersEnVie = nombreGuerriers;
		for (int i = 0; i < nombreGuerriers; i++) {
			tableGuerriers[i] = new Guerrier(numero, pointsDeVieDeDepart);
			numero--;
		}
	}

	// Attention : seul interet de ce constructeur : les tests!!!
	// A NE PAS MODIFIER
	public EquipeGuerriers(Guerrier[] tableARecopier, int nombreGuerriersEnVie) {
		tableGuerriers = new Guerrier[tableARecopier.length];
		for (int i = 0; i < tableGuerriers.length; i++) {
			tableGuerriers[i]=tableARecopier[i];
		}
		this.nombreGuerriersEnVie = nombreGuerriersEnVie;
	}

	/**
	 * renvoie le nombre de guerriers encore en vie
	 * @return le nombre de guerriers encore en vie
	 */
	public int nombreGuerriersEnVie(){
		return nombreGuerriersEnVie;
	}


	/**
	 * renvoie le numero du guerrier qui doit combattre
	 * @return le numero du guerrier qui doit combattre
	 * @throws NoSuchElementException si tous les guerriers sont morts
	 */
	public int donnerNumeroProchainGuerrier() {
		if (nombreGuerriersEnVie==0)
			throw new NoSuchElementException("Tous les guerriers sont morts");
		int index=0;
		for (int i = 0; i < nombreGuerriersEnVie; i++) {
			if (tableGuerriers[i].getPointsDeVie()>=index) index=tableGuerriers[i].getNumero();
		}
		return index;
	}

	/**
	 * diminue le nombre de points de vie du guerrier qui doit combattre
	 * reorganise la table en tenant compte de ces nouveaux points de vie
	 * @param pointsDeViePerdus le nombre de points de vie perdu par le guerrier au combat
	 * @return les nouveaux points de vie du guerrier
	 * @throws NoSuchElementException si tous les guerriers sont morts
	 * @throws IllegalArgumentException si le nombre de points de vie perdus est negatif
	 */
	public int recevoirDegats(int pointsDeViePerdus){
		int index=donnerNumeroProchainGuerrier();
		Guerrier guerrierActuel=null;
        for (Guerrier tableGuerrier : tableGuerriers) {
			if (tableGuerrier.getNumero() == index) {
				guerrierActuel = tableGuerrier;
			}
        }
		if (nombreGuerriersEnVie==0)
			throw new NoSuchElementException("Tous les guerriers sont morts");
		if (pointsDeViePerdus<0)
			throw new IllegalArgumentException();
		guerrierActuel.retirerPointsDeVie(pointsDeViePerdus);
		if (guerrierActuel.getPointsDeVie()<=0) {
			int n = guerrierActuel.getPointsDeVie();
			guerrierActuel.retirerPointsDeVie(n);
			nombreGuerriersEnVie--;
			for (int i = 0; i < tableGuerriers.length; i++) {
				if (guerrierActuel.getPointsDeVie() == tableGuerriers[i].getNumero()) {
					Guerrier g = tableGuerriers[i];
					tableGuerriers[i] = guerrierActuel;
					guerrierActuel = g;
				}
			}
		} else {
			Guerrier temp = guerrierActuel;
			for (int i = 0; i < tableGuerriers.length; i++) {
				if (guerrierActuel.getPointsDeVie() <= tableGuerriers[i].getPointsDeVie()) {
					Guerrier g = tableGuerriers[i];
					tableGuerriers[i] = temp;
					temp = g;
				}
			}
		}
		return guerrierActuel.getPointsDeVie();
	}

	/**
	 * construit une table avec les guerriers en vie
	 * La taille logique de cette table doit etre egale a la taille physique
	 * @return la table avec les guerriers en vie
	 */
	public Guerrier[] tableGuerriersEnVie(){
		//TODO
		return null;
	}

	/**
	 * construit une table avec les guerriers morts
	 * La taille logique de cette table doit etre egale a la taille physique
	 * @return la table avec les guerriers morts
	 */
	public Guerrier[] tableGuerriersMorts(){
		//TODO
		return null;
	}

	/**
	 * A NE PAS MODIFIER
	 * VA SERVIR POUR LES TESTS
	 * @return le contenu de la table des guerriers
	 */
	public String toString(){
		return Arrays.toString(tableGuerriers);
	}

}
