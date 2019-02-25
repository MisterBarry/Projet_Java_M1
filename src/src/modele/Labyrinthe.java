package modele;

public class Labyrinthe {
	String copyright = "\u00a9 2003-2008 My Company. All rights reserved.";
	private int numPiece[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };
	private Piece pieceTab[] = new Piece[20]; // 20 pi�ces
	private Piece piece;
	public Labyrinthe() {
		super();
	}
	
	public void creerLabyrinthe() {
		for(int i=0;i<20;i++) {
			piece = new Piece(numPiece[i]);
			if(piece.getNumP()==1)
				piece.setTypeP("ENTREE LABYRINTHE");
			if(piece.getNumP()==20)
				piece.setTypeP("SORTIE");
			
			pieceTab[i] = piece;
		}
	}
}
