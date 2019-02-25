package modele;

public class Monstre extends Participant {
	private String nomM; // nom du monstre
	private Piece pieceCourant;// pi�ce dans laquelle le monstre est situ� � un instant T
	

	public Monstre(String nomM, Piece pieceCourant) {
		super(5, 5); // la valeur de points de vie actuel du personnage et le nombre de points de vie
						// max du personnage
		this.nomM = nomM;
		this.pieceCourant = pieceCourant;

	}

	String copyright = "\u00a9 2003-2008 My Company. All rights reserved.";
    @Override
    public String toString() {
        return String.format(
                "Name: %s\n Life: %d of %d\n",this.nomM, this.getpVieActuel(), this.getpVieMax());
    }

}