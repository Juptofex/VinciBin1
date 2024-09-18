
public class Multiplication3Essais {

	public static java.util.Scanner scanner = new java.util.Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Entrainement aux multiplications. Voici une multiplication :");
		System.out.println("Tu as droit a 3 essais");
		int premierNombre = unEntierAuHasardEntre (0, 10);
		int secondNombre = unEntierAuHasardEntre (0, 10);
		System.out.println("Calculez : " + premierNombre + " x " + secondNombre + " = ");
		int solution = premierNombre * secondNombre;
		int reponse = scanner.nextInt();
		int n = 2;
		while(reponse!=solution && n > 0){
			System.out.println("C'est faux, recommence.(Il te reste "+n+" essais)");
			System.out.println("Calculez : " + premierNombre + " x " + secondNombre + " = ");
			reponse = scanner.nextInt();
			n--;
		}
		if(reponse==solution){
			System.out.println("Bravo !");
		}else{
			System.out.println("C'est faux et tu as épuisé tous tes essais.");
		}
	}

	// A NE PAS MODIFIER
	public static int unEntierAuHasardEntre (int valeurMinimale, int valeurMaximale){
		return (int) (Math.random() * (valeurMaximale - valeurMinimale + 1)) + valeurMinimale;
	}
	
}
