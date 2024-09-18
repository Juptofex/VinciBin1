import java.util.NoSuchElementException;

public class TableNegatifsPositifs {

    private int[] tableNP;
    private int nbNegatifs;
    private int nbPositifsEtNuls;
    private static final int MAX = 10; // taille physique

    // tableNP ne peut pas contenir plus de MAX entiers, mais pourrait en contenir moins
    // Les entiers occupent les (nbNegatifs + nbPositifsEtNuls) premieres cases du tableau!
    // On trouve d'abord les entiers < 0 ensuite les entiers >= 0
    // L'ordre des entiers parmi les entiers < 0 n'a pas d'importance
    // L'ordre des entiers parmi les entiers >= 0 n'a pas d'importance

    /**
     * ce constructeur construit une tableNP en y placant les entiers de la table recue en parametre
     * L'ordre des entiers < 0 dans tableNP doit correspondre a l'ordre des entiers < 0 de la table fournie
     * L'ordre des entiers >= 0 dans tableNP doit correspondre a l'ordre des entiers >= 0 de la table fournie
     * Ex :
     * tableFournie : -5 7 -8 1 0 2 -1 1
     * -->
     * tableNP : -5 -8 -1 7 1 0 2 1
     * @param tableFournie la table avec les entiers a placer dans tableNP
     * @throws IllegalArgumentException si la table fournie est null ou contient plus de MAX entiers
     */
    public TableNegatifsPositifs(int[] tableFournie) {
        if(tableFournie==null || tableFournie.length > MAX)
            throw new IllegalArgumentException();

        this.tableNP = new int[MAX];
        int index=0;
        for (int i = 0; i < tableFournie.length; i++) {
            if (tableFournie[i]<0) {
                tableNP[index]=tableFournie[i];
                nbNegatifs++;
                index++;
            }
        }
        for (int i = 0; i < tableFournie.length; i++) {
            if (tableFournie[i]>=0) {
                tableNP[index]=tableFournie[i];
                nbPositifsEtNuls++;
                index++;
            }
        }
        //Contrainte : pas plus de 2 parcours de la table fournie pour construire la tableNP
        //Lors du 1er parcours, on place les entiers < 0 et lors du 2eme parcours les entiers >= 0

    }

    public int getNbNegatifs() {
        return nbNegatifs;
    }

    public int getNbPositifsEtNuls() {
        return nbPositifsEtNuls;
    }

    /**
     * calcule la moyenne des entiers > 0 (pas les 0)
     * @return la moyenne des entiers > 0 ou 0 s'il n'y a pas d'entiers > 0
     */
    public double moyenneStrictementPositifs(){

        double somme=0;
        int index=0;
        double moyenne=0;
        for (int i = nbNegatifs; i < nbNegatifs+nbPositifsEtNuls; i++) {
            if (tableNP[i]>0) {
                somme += tableNP[i];
                index++;
            }
        }
        if (index==0) {
            moyenne = 0;
        } else {
            moyenne = somme/index;
        }

        //Pensez a optimiser votre methode !
        //Les entiers > 0 se trouvent parmi les entiers >= 0.

        return moyenne;
    }

    /**
     * verifie si tous les entiers de la table sont > entier passe en parametre
     * renvoie true si la table est vide
     * @param entier l'entier verifie
     * @return true si les entiers de la table sont tous > entier passe en parametre ou si la table est vide, false sinon
     */
    public boolean tousStrictementPlusGrands(int entier){

        for (int i = 0; i < nbNegatifs+nbPositifsEtNuls; i++) {
            if (tableNP[i]<=entier) return false;
        }
        return true;
        //Pensez a optimiser votre methode !
        //Par exemple, si entier < 0, tous les positifs et nuls sont forcement strictement plus grands que cet entier ...
    }


    /**
     * supprime de la tableNP le plus petit entier
     * en cas d'ex-aequo, c'est la premiere occurrence qui est supprimee
     * Attention, l'ordre des entiers de la table doit etre conserve
     * Ex :
     * tableNP avant suppression : -5 -7 -2 -1 -7 -3 0 0 8 1
     * -->
     * tableNP apres suppression min : -5 -2 -1 -7 -3 0 0 8 1
     * @return l'entier supprime
     * @throws NoSuchElementException si la tableNP est vide
     */
    public int supprimerMin(){
        if(nbNegatifs + nbPositifsEtNuls == 0)
            throw new NoSuchElementException();

        int supp;
        int temp=tableNP[0];
        int index=0;
        if (nbNegatifs>0) {
            for (int i = 0; i < nbNegatifs; i++) {
                if (tableNP[i]<temp) {
                    temp = tableNP[i];
                    index=i;
                }
            }
            supp = temp;
            for (int i = index; i < nbNegatifs+nbPositifsEtNuls-1; i++) {
                tableNP[i]=tableNP[i+1];
            }
            nbNegatifs--;
        } else {
            for (int i = 0; i < nbPositifsEtNuls; i++) {
                if (tableNP[i]<temp) {
                    temp = tableNP[i];
                    index=i;
                }
            }
            supp = temp;
            for (int i = index; i < nbNegatifs+nbPositifsEtNuls-1; i++) {
                tableNP[i]=tableNP[i+1];
            }
            nbPositifsEtNuls--;
        }
        //Pensez a optimiser votre methode !
        //Par exemple, le min se trouve forcement parmi les entiers < 0, s'il y en a
        return supp;
    }

    //A NE PAS MODIFIER
    //VA SERVIR POUR LES TESTS
    public int nbAjoutsPossible(){
        return tableNP.length-nbNegatifs-nbPositifsEtNuls;
    }

    //A NE PAS MODIFIER
    //VA SERVIR POUR LES TESTS
    public TableNegatifsPositifs(int[] tableARecopier, int nbNegatifs, int nbPositifsEtNuls) {
        tableNP = new int[MAX];
        for (int i = 0; i < tableARecopier.length; i++) {
            tableNP[i] = tableARecopier[i];
        }
        this.nbNegatifs = nbNegatifs;
        this.nbPositifsEtNuls = nbPositifsEtNuls;
    }

    @Override
    //A NE PAS MODIFIER
    //VA SERVIR POUR LES TESTS
    public String toString() {
        String aRenvoyer = "[";
        if(nbNegatifs+nbPositifsEtNuls!=0) {
            aRenvoyer += tableNP[0];
            for (int i = 1; i < nbNegatifs + nbPositifsEtNuls; i++) {
                aRenvoyer += ", " + tableNP[i];
            }
        }
        return aRenvoyer+"]";
    }
}