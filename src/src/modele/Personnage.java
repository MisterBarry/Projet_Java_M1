package modele;

public class Personnage extends Participant {
	private String nomP; // nom du personnage
	private Piece pieceCourant;// pi�ce dans laquelle le personnage est situ� � un instant T

	String copyright = "\u00a9 2003-2008 My Company. All rights reserved.";
	public Personnage(String nomP, Piece pieceCourant) {
		super(10, 10); // la valeur de points de vie actuel du personnage et le nombre de points de vie
						// max du personnage
		this.nomP = nomP;
		this.pieceCourant = pieceCourant;

	}

	public String getNomP() {
		return nomP;
	}

	public Piece getPieceCourant() {
		return pieceCourant;
	}

	public void setPieceCourant(Piece pieceCourant) {
		this.pieceCourant = pieceCourant;
	}

	public void setNomP(String nomP) {
		this.nomP = nomP;
	}

	public Piece getPiece(int numPiece) // on r�cup�re une pi�ce � partir de son numero
	{
		Piece laby[] = new Piece[20]; //
		for (Piece p : laby) {
			if (p.getNumP() == numPiece)
				return p;
		}
		return null;
	}

	public void deplacerPerso(String sens) {
		Piece newPiece;
		int nbrAleatoire = 1 + (int) (Math.random() * 20);
		switch (sens) {
		case "N":// la nouvelle piece sera � un num�ro aleatoire
			newPiece = getPiece(pieceCourant.getNumP() - nbrAleatoire);
			pieceCourant = newPiece;
			break;
		case "S": // num�ro al�atoire + 1
			newPiece = getPiece(pieceCourant.getNumP() - nbrAleatoire + 1);
			pieceCourant = newPiece;
			break;
		case "E": // num�ro al�atoire + 2
			newPiece = getPiece(pieceCourant.getNumP() - nbrAleatoire + 2);
			pieceCourant = newPiece;
			break;
		case "O": // num�ro al�atoire + 3
			newPiece = getPiece(pieceCourant.getNumP() - nbrAleatoire + 3);
			pieceCourant = newPiece;
			break;
		default:
			break;
		}
	}

}
