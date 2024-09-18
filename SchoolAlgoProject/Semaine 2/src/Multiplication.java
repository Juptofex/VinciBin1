public class Multiplication{

	public static java.util.Scanner scanner = new java.util.Scanner(System.in);

	public static void main(String[] args) {
	
		System.out.println("Entrainement aux multiplications. Voici un exercice :");
		
		int nombre1 = unEntierAuHasardEntre (0, 10);
		int nombre2 = unEntierAuHasardEntre (0, 10);
		System.out.println("Calculez : " + nombre1 + " x " + nombre2 + " = ");

		int reponse = scanner.nextInt();

		if(reponse == multiplication(nombre1, nombre2)){
			System.out.println("Bravo !");
		}
		else{
			System.out.println("Raté ! La réponse était : " + multiplication(nombre1, nombre2));
		}
	}

	public static int unEntierAuHasardEntre (int valeurMinimale, int valeurMaximale){
		return (int)((Math.random() * (valeurMaximale - valeurMinimale + 1)) + valeurMinimale);
	}

	public static double multiplication(int nbr1, int nbr2){
		return nbr1 * nbr2;
	}
}