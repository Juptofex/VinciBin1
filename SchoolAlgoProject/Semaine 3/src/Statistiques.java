
public class Statistiques {
	
	public static java.util.Scanner scanner = new java.util.Scanner(System.in);

	public static void main(String[] args) {
		System.out.print("Entrez le nombre de cotes : ");
		int nombreCotes = scanner.nextInt();
		double coteMax = 0;
		double coteMin = 20;
		double moyenne = 0;
		for (int i = 1; i <= nombreCotes ; i++) {
			System.out.print("Entrez la cote n°" + i + ": ");
			double cote = scanner.nextDouble();

			//Moyenne
			moyenne += cote;

			//CoteMax & CoteMin
			if (cote > coteMax) {
				coteMax = cote;
			}

			if (cote < coteMin) {
				coteMin = cote;
			}
		}
		moyenne = moyenne/nombreCotes;
		System.out.println("La cote la plus elevee est "+coteMax);
		System.out.println("La cote la plus basse est "+coteMin);
		System.out.println("La moyenne des cotes est "+moyenne);
	}
}
