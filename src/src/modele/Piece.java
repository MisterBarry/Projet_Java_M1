package modele;

import java.io.Serializable;

public class Piece implements Serializable {
	String copyright = "\u00a9 2003-2008 My Company. All rights reserved.";
	private int numP;
	private String typeP; // est-ce qu'il s'agit de la pi�ce d'entr�e sortie ou bien celles � l'int�rieur du labyrinthe
	//private boolean isEmpty; // piece vide pas
	private Porte porte;
	/*
	 * Constructeur
	 */

	public Piece(int numP){
		this.numP=numP;
	
	}

	public int getNumP() {
		return numP;
	}

	public void setNumP(int numP) {
		this.numP = numP;
	}

	public String getTypeP() {
		return typeP;
	}

	public void setTypeP(String typeP) {
		this.typeP = typeP;
	}
	
	public boolean isPieceVide(int numP){
		return false;
		
	} 
	

}
