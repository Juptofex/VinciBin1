public class JeuChatSouris {

    public static void main(String[] args){

        int positionSouris = 3;
        int positionChat = 1;
        PlateauJeuChatSouris jeu = new PlateauJeuChatSouris();
        jeu.placerSouris(positionSouris);
        jeu.placerChat(positionChat);
        while (positionSouris > positionChat) {
            jeu.afficherInformation("A la souris");
            positionSouris += jeu.lancerDe();
            if (positionSouris >= 16){
                positionSouris = 16;
                jeu.supprimerSouris();
                jeu.placerSouris(positionSouris);
                jeu.afficherInformation("La souris a gagne !");
                break;
            }
            jeu.supprimerSouris();
            jeu.placerSouris(positionSouris);

            jeu.afficherInformation("Au chat");
            positionChat += jeu.lancerDe();
            jeu.supprimerChat();
            jeu.placerChat(positionChat);
            if (positionChat >= positionSouris){
                jeu.supprimerSouris();
                jeu.afficherInformation("Le chat a gagne !");
                break;
            }
        }

    }


}
