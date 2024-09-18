public class UneOperationAuHasard {

    public UneOperationAuHasard(int nombre1, int nombre2) {
    }

    public double res;
    public static String op;

    public static void uneOperationAuHasard(double nbr1, double nbr2){
        double a = (Math.random() * (100 + 1));
        double b = (Math.random() * (100 + 1));

        double c = a + b;

        if (c >= 75){

            op = "Calculez : " + nbr1 + " + " + nbr2 + " = ";
            double res = nbr1 + nbr2;
        }else {
            if (c >= 50){
                op = "Calculez : " + nbr1 + " - " + nbr2 + " = ";
                double res = nbr1 - nbr2;
            }else {
                if(c >= 25){
                    op = "Calculez : " + nbr1 + " * " + nbr2 + " = ";
                    double res = nbr1 * nbr2;
                }else{
                    op = "Calculez : " + nbr1 + " / " + nbr2 + " = ";
                    double res = nbr1 / nbr2;
                }
            }
        }
    }
}
