public class Buzz {

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args){

        // creation des 2 equipes

        Equipe equipe1 = chargerEquipe1();
        Equipe equipe2 = chargerEquipe2();

        // creation du questionnaire

        Questionnaire questionnaire = chargerQuestions();

        System.out.println("Quizz - Capitales des pays de l'union europeenne");

       //TODO
        while (equipe1.getPoints()<3 && equipe2.getPoints()<3 && equipe1.getNombreCandidatsEnJeu()>0 && equipe2.getNombreCandidatsEnJeu()>0) {
            System.out.println("\nVoici les candidats en jeu de l'equipe 1 :");
            System.out.println(equipe1);
            System.out.println("Voici les candidats en jeu de l'equipe 2 :");
            System.out.println(equipe2);
            System.out.println("\nNouvelle question");
            System.out.println("Selectionnez les 2 candidats");
            String candidatEq1 = equipe1.selectionnerCandidat();
            String candidatEq2 = equipe2.selectionnerCandidat();
            System.out.println("Le candidat selectionne de l'equipe 1 est " + candidatEq1);
            System.out.println("Le candidat selectionne de l'equipe 2 est " + candidatEq2);

            if (questionnaire.getNombreQuestionsRestantes() == 0) {
                questionnaire.reinitialiser();
            }
            QuestionCM qcm = questionnaire.fournirQuestion();
            System.out.println("Voici la question : ");
            System.out.println(qcm);

            System.out.print("Entrez le numero de l'equipe qui a buzze (1 ou 2) : ");
            int choixEquipe = scanner.nextInt();
            Equipe equipe;
            Equipe equipeA;
            String candidatR;
            String candidatA;
            if (choixEquipe == 1) {
                equipe = equipe1;
                equipeA = equipe2;
                candidatR = candidatEq1;
                candidatA = candidatEq2;
            } else {
                equipe = equipe2;
                equipeA = equipe1;
                candidatR = candidatEq2;
                candidatA = candidatEq1;
            }
            System.out.print("Entrez son choix (1, 2 ou 3) : ");
            int choixReponse = scanner.nextInt();
            if (choixReponse == qcm.getNumeroChoixCorrect()) {
                System.out.println("Bravo! La reponse est bonne");
                equipe.remettreEnJeu(candidatR);
                equipeA.remettreEnJeu(candidatA);
                System.out.println("l'equipe " + choixEquipe + " a gagne 1 point");
                equipe.ajouter1Point();
            } else {
                System.out.println("La reponse n'est pas bonne");
                System.out.println("le candidat " + candidatR + " est elimine");
                equipeA.remettreEnJeu(candidatA);
            }
            System.out.println("l'equipe 1 a "+equipe1.getPoints()+" point(s)");
            System.out.println("l'equipe 2 a "+equipe2.getPoints()+" point(s)");
        }
        System.out.println("Le jeu est termine");
        if (equipe1.getPoints()==3) {
            System.out.println("l'equipe 1 a gagne !");
        }
        if (equipe2.getPoints()==3){
            System.out.println("l'equipe 2 a gagne !");
        }
        if (equipe1.getNombreCandidatsEnJeu()==0) {
            System.out.println("l'equipe 1 n'a plus de candidat");
        }
        if (equipe2.getNombreCandidatsEnJeu()==0) {
            System.out.println("l'equipe 2 n'a plus de candidat");
        }
    }

    public static Questionnaire chargerQuestions(){
        QuestionCM[] questions = new QuestionCM[5];
        questions[0]= new QuestionCM("Allemagne","Amsterdam","Dublin","Berlin",3);
        questions[1]= new QuestionCM("France","Paris","Prague", "Vilnius",1);
        questions[2]= new QuestionCM("Belgique","Amsterdam", "Bruxelles","Paris",2);
        questions[3]= new QuestionCM("Espagne"	,"Madrid","Budapest","Bucarest",1);
        questions[4]= new QuestionCM("Italie","Nicosie","Riga","Rome",3);
        return new Questionnaire(questions);
    }

    public static Equipe chargerEquipe1(){
        String[] candidats = new String[4];
        candidats[0] = "Lea";
        candidats[1] = "Marie";
        candidats[2] = "Chloe";
        candidats[3] = "Julie";
        return new Equipe(1,candidats);
    }

    public static Equipe chargerEquipe2(){
        String[] candidats = new String[4];
        candidats[0] = "Pierre";
        candidats[1] = "Sam";
        candidats[2] = "Tom";
        candidats[3] = "Hugo";
        return new Equipe(2,candidats);
    }

}


