public class CombatAMort {

    public static void main(String[] args) {
        /*

        System.out.println("CogneDur inflige ? points de degats a FrappeFort.");
        System.out.println("FrappeFort inflige ? points de degats a CogneDur.");

        System.out.println("Il reste ? points de vie a FrappeFort.");
        System.out.println("Il reste ? points de vie a CogneDur.");

        System.out.println("CogneDur est mort. Paix a son ame, il est mort en brave.");
        System.out.println("FrappeFort est mort. Paix a son ame, il est mort en brave.");

        System.out.println("CogneDur est victorieux.");
        System.out.println("FrappeFort est victorieux.");
        */

        System.out.println("Bienvenue au combat entre CogneDur et FrappeFort !");
        int pointsDeVieCogneDur = 9;
        int pointsDeVieFrappeFort = 12;
        while(pointsDeVieCogneDur > 0 && pointsDeVieFrappeFort > 0){
            int fCogneDur = lancerDe();
            System.out.println("CogneDur inflige "+fCogneDur+" points de degats a FrappeFort.");
            pointsDeVieFrappeFort -= fCogneDur;
            if (pointsDeVieFrappeFort > 0){
                System.out.println("Il reste "+pointsDeVieFrappeFort+" points de vie a FrappeFort.");
                int fFrappeFort = lancerDe();
                System.out.println("FrappeFort inflige "+fFrappeFort+" points de degats a CogneDur.");
                pointsDeVieCogneDur -= fFrappeFort;
                if (pointsDeVieCogneDur > 0){
                    System.out.println("Il reste "+pointsDeVieCogneDur+" points de vie a CogneDur.");
                }
            }
        }
        if (pointsDeVieFrappeFort <= 0){
            System.out.println("FrappeFort est mort. Paix a son ame, il est mort en brave.");
            System.out.println("CogneDur est victorieux.");
        }
        if (pointsDeVieCogneDur <= 0){
            System.out.println("CogneDur est mort. Paix a son ame, il est mort en brave.");
            System.out.println("FrappeFort est victorieux.");
        }

        // A COMPLETER



    }

    public static int lancerDe(){
        return (int)((Math.random() * 6) + 1);
    }
}
