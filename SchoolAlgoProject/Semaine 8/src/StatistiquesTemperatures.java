import java.util.Arrays;

public class StatistiquesTemperatures {
	
	public static java.util.Scanner scanner = new java.util.Scanner(System.in);
	public static Temperatures temperatures;
	
	public static void main(String[] args) {
		
		chargerTemperatures();
		System.out.println(temperatures.toString());
		
		System.out.println("*****************************");
		System.out.println("Temperatures : statistiques :");
		System.out.println("*****************************");
		int choix;
		do{
			System.out.println();
			System.out.println("1 -> afficher toutes les temperatures");	
			System.out.println("2 -> calculer la moyenne");
			System.out.println("3 -> afficher le minima");
			System.out.println("4 -> afficher le nombre de jours de gel");
			System.out.println("5 -> afficher si oui ou non toutes les températures sont positives");
			System.out.println("6 -> afficher si il y a au moins une température négative");
			System.out.println();
			System.out.print("Entrez votre choix : ");	
			choix=scanner.nextInt();
			switch(choix){	
			case 1: afficherTout();   
			break;
			case 2: afficherMoyenne();   
			break;
			case 3: afficherMin();
			break;
			case 4: afficherJDG();
			break;
			case 5: afficherToutePositives();
			break;
			case 6: afficherAuMoins1Neg();
			break;
			}
		}while(choix >=1 && choix<=2);
	}
	
	private static void afficherTout() {
		System.out.println(temperatures.toString());
	}

	private static void afficherMoyenne() {
		System.out.println("Moyenne = "+temperatures.moyenne());
	}

	private static void afficherMin() {
		System.out.println("Min = "+temperatures.temperatureMin());
	}

	private static void afficherJDG() {
		System.out.println("Jours de gel : "+temperatures.nombreJoursDeGel());
	}

	private static void afficherToutePositives() {
		System.out.println("Toutes positives : "+temperatures.toutesPositives());
	}
	private static void afficherAuMoins1Neg() {
		System.out.println("Au moins une négative : "+temperatures.contientAuMoinsUnJourDeGel());
	}

	public static void chargerTemperatures(){
		double[]tableTemperatures = {-1,1,0,1,-1,-3,-3,-2,0,-1,0,1,1,3,5,4,2,0,1,1,5,3,2,0,-1,0,1,1,3,4,5};
		temperatures = new Temperatures("janvier",tableTemperatures);
	}
	
	public static void afficherTable(int[]table){
		System.out.println(Arrays.toString(table));
	}
	
}
