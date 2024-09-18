public class Patient {
    private String nom;
    private double poids;
    private double taille;

    public Patient(String nom, double poids, double taille) {
        this.nom = nom;
        this.poids = poids;
        this.taille = taille;
    }

    public double calculerBmi(){
        return poids/(taille*taille);
    }

    /**
     * renvoie sous forme d'une string, l'etat du patient
     * bmi < 20 : mince
     * [20,25] : normal
     * ]25,30] : en embonpoint
     * bmi > 30 : obese
     * @return l'etat du patient
     */
    public String donnerEtat(){
        double bmi = calculerBmi();
        if(bmi<20)
            return "mince";
        // bmi >= 20
        if(bmi<=25)
            return "normal";
        // bmi > 25
        if(bmi<=30)
            return "en embonpoint";
        return "obese";
    }
}


