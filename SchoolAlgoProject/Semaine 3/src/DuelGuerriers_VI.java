public class DuelGuerriers_VI {

    public static void main(String[] args) {

        FenetreCombatGuerriers jeu = new FenetreCombatGuerriers();
        jeu.afficherInformation("A CogneDur");
        int pointsDeVieCogneDur = jeu.lancerDe();
        jeu.afficherPointsDeVie(1, pointsDeVieCogneDur);
        jeu.afficherInformation("A FrappeFort");
        int pointsDeVieFrappeFort = jeu.lancerDe();
        jeu.afficherPointsDeVie(2, pointsDeVieFrappeFort);

        jeu.afficherInformation("A CogneDur");
        jeu.afficherEpee(1);
        jeu.afficherBouclier(2);
        int forceCogneDur = jeu.lancerDe();
        pointsDeVieFrappeFort -= forceCogneDur;

        if (pointsDeVieFrappeFort <= 0){
            pointsDeVieFrappeFort = 0;
            jeu.afficherPointsDeVie(2, pointsDeVieFrappeFort);
            jeu.afficherCroix(2);
            jeu.afficherCoupeOr(1);
            jeu.afficherInformation("Fin du jeu");
        }else {
            jeu.afficherPointsDeVie(2, pointsDeVieFrappeFort);
        }

        if (pointsDeVieFrappeFort > 0) {
            jeu.afficherInformation("A FrappeFort");
            jeu.afficherEpee(2);
            jeu.afficherBouclier(1);
            int forceFrappeFort = jeu.lancerDe();
            pointsDeVieCogneDur -= forceFrappeFort;
            if (pointsDeVieCogneDur <= 0) {
                pointsDeVieCogneDur = 0;
                jeu.afficherPointsDeVie(1, pointsDeVieCogneDur);
                jeu.afficherCroix(1);
                jeu.afficherCoupeOr(2);
                jeu.afficherInformation("Fin du jeu");
            } else {
                jeu.afficherPointsDeVie(1, pointsDeVieCogneDur);
                if (pointsDeVieCogneDur > pointsDeVieFrappeFort) {
                    jeu.afficherCoupeOr(1);
                    jeu.afficherCoupeArgent(2);
                    jeu.afficherInformation("Fin du jeu");
                }
                if (pointsDeVieCogneDur == pointsDeVieFrappeFort) {
                    jeu.afficherCoupeOr(1);
                    jeu.afficherCoupeOr(2);
                    jeu.afficherInformation("Fin du jeu");
                }
                if (pointsDeVieCogneDur < pointsDeVieFrappeFort) {
                    jeu.afficherCoupeOr(2);
                    jeu.afficherCoupeArgent(1);
                    jeu.afficherInformation("Fin du jeu");
                }
            }
        }
    }
}
