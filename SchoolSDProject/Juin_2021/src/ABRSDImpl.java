import java.util.ArrayList;

public class ABRSDImpl<E> implements ABRSD<E>{

	private Noeud racine;
	private int taille;
	
	public ABRSDImpl(){
		racine = null;
		taille = 0;
	}

	public boolean estVide() {
		return racine==null;
	}
	
	public int taille() {
		return taille;
	}
		

	public E elementLePlusPetit() {
		//TODO		
		//Lisez bien les explications pour l'utilisation de la methode compareTo() dans l'enonce
		if (racine==null)
			return null;
		return elementLePlusPetitRecursif(racine);
	}

	private E elementLePlusPetitRecursif(Noeud noeud) {
		if (noeud.gauche==null)
			return noeud.element;
		return elementLePlusPetitRecursif(noeud.gauche);
	}
	
	public boolean insere(E element) {
		//TODO		
		//Lisez bien les explications pour l'utilisation de la methode compareTo() dans l'enonce
		if (element==null)
			throw new IllegalArgumentException(	);
		if (racine==null) {
			racine = new Noeud(element);
			return true;
		}
		return insereRecursif(racine, element);
	}

	private boolean insereRecursif(Noeud noeud, E e) {
		if (((Comparable<E>)noeud.element).compareTo(e)==0)
			return false;
		if (((Comparable<E>)noeud.element).compareTo(e)<0) {
			 if (noeud.droit==null) {
				 noeud.droit=new Noeud(e);
				 return true;
			 } else {
				 return insereRecursif(noeud.droit, e);
			 }
		} else {
			if (noeud.gauche==null) {
				noeud.gauche=new Noeud(e);
				return true;
			} else {
				return insereRecursif(noeud.gauche, e);
			}
		}
	}
	

	public E elementPrecedent(E element) {
		//TODO
		// Suggestion :
		// remplir une "arrayList" via un parcours en in-ordre
		// l'element precedent est l'element qui se trouve juste avant lui dans l'arrayList !
		// cette methode peut donc appeler la methode "private" remplirArrayList() qui suit
		ArrayList<E> l = new ArrayList<>();
		remplirArrayList(racine, l);
		int index = l.indexOf(element);
		if (index<=0)
			return null;
		return l.get(index-1);
	}
	
	private void remplirArrayList(Noeud noeud,ArrayList<E> liste) {
		// suggestion de methode a appeler par la methode elementPrecedent()
		if (noeud!=null) {
			remplirArrayList(noeud.gauche, liste);
			liste.add(noeud.element);
			remplirArrayList(noeud.droit, liste);
		}
	}
	

	

	// A NE PAS MODIFIER!!!
	// VA SERVIR POUR LES TESTS!!!
	public String toString () {
		return "[ "+toString(racine)+" ]";
	}

	private String toString (Noeud n) {
		if (n==null) 
			return "";
		if (n.gauche == null && n.droit == null) 
			return ""+n.element;
		if (n.gauche == null) 
			return " [ ] "+n.element+" [ "+toString(n.droit)+" ] ";
		if (n.droit == null) 
			return " [ "+toString(n.gauche)+" ] "+n.element+ " [ ] ";
		return " [ "+toString(n.gauche)+" ] "+n.element+" [ "+toString(n.droit)+" ] ";	
	}

	// A NE PAS MODIFIER! VA SERVIR POUR LES TESTS
	// permet de construire l'ABRSD de l'enonce

	public ABRSDImpl(E e1, E e2, E e3, E e4, E e5, E e6, E e7){
		Noeud nG = new Noeud(null,e2,new Noeud(e5));
		Noeud nG1 = new Noeud(new Noeud(e7),e4,new Noeud(e6));
		Noeud nD = new Noeud(nG1,e3, null);
		racine = new Noeud(nG,e1,nD);
		taille=7;
	}


	public class Noeud{

		private E element; 
		private Noeud gauche;
		private Noeud droit;

		private Noeud(E element){
			this.element = element;
			this.gauche = null;
			this.droit = null;
		}

		private Noeud (Noeud gauche, E element, Noeud droit){
			this.element = element;
			this.gauche = gauche;
			this.droit = droit;
		}
	}

}
