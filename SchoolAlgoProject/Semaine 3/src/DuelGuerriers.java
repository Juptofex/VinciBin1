public class DuelGuerriers {

	public static void main(String[] args) {

		int pointsDeVieCogneDur = lancerDe();
		System.out.println("CogneDur a "+pointsDeVieCogneDur+" points de vie");
		int forceCogneDur = lancerDe();

		int pointsDeVieFrappeFort = lancerDe();
		System.out.println("FrappeFort a "+pointsDeVieFrappeFort+" points de vie");
		int forceFrappeFort = lancerDe();

		pointsDeVieFrappeFort -= forceCogneDur;
		System.out.println("CogneDur inflige "+forceCogneDur+" dégats à FrappeFort");
		if (pointsDeVieFrappeFort <= 0){
			System.out.println("FrappeFort est mort. Paix à son âme, il est mort en brave.");
		}else {
			System.out.println("FrappeFort a "+pointsDeVieFrappeFort+" points de vie");
		}
		if (pointsDeVieFrappeFort > 0){
			pointsDeVieCogneDur -= forceFrappeFort;
			System.out.println("FrappeFort inflige "+forceFrappeFort+" dégats à CogneDur");
			if (pointsDeVieCogneDur <= 0){
				System.out.println("CogneDur est mort. Paix à son âme, il est mort en brave.");
			}else{
				System.out.println("CogneDur a "+pointsDeVieCogneDur+" points de vie");
			}
		}
		if (pointsDeVieCogneDur > pointsDeVieFrappeFort){
			System.out.println("CogneDur remporte une coupe d'or !");
		}
		if (pointsDeVieCogneDur == pointsDeVieFrappeFort){
			System.out.println("CogneDur et FrappeFort remporte une coupe d'or !");
		}
		if (pointsDeVieCogneDur < pointsDeVieFrappeFort){
			System.out.println("FrappeFort remporte une coupe d'or !");
		}
	}


	public static int lancerDe(){
		return (int)((Math.random() * 6) + 1);
	}
}
