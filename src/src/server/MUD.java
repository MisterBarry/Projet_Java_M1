package server;

import java.rmi.Remote;
import java.rmi.RemoteException;

import javax.management.relation.RelationException;

public interface MUD extends Remote {
			
	/*localisation d'un participant
	 * 
	 * 
	 * 
	 * */
	String copyright = "\u00a9 2003-2008 My Company. All rights reserved.";
	public String localiserPlayer() throws RemoteException;
	
	/*Ajouter un monster � la localisation
	 * 
	 * @param loc : ou ajouter le monster
	 * @@param mons : le monstre � ajouter
	 * 
	 */
	
	public void addMonster(String loc, Monstre mons) throws RemoteException;
	
	/*Ajouter un jour dans une localisation pr�cise
	 * 
	 * @param loc l� ou il faudrai placer le joueur
	 * @param nom : nom du joueur � ajouter
	 * @return true si joueur ajout� et False autrement
	 * */
	public boolean addJoueur(String loc, String nom) throws RemoteException;
	
	/*Supprimer monstre � une localisation
	 * 
	 * 
	 * @param loc : ou trouver le monstre
	 * @param monst : le monstre � �liminer
	 * */
	public void delMonstre(String loc, String monst) throws RemoteException;
	
	/*Supprimer joueur du jeu
	 * 
	 * 
	 * */
	public void delJoueur(String loc, String joueur) throws RelationException;
	
	/* deplacer un participant dans le MUD
	 * 
	 * @param
	 * 		loc: location courant
	 * 		dir: direction � prendre (nord, sud, ouest; est)
	 * 		participant: � deplacer
	 * @return loc si aucun mouvement n'est possible
	 * */
	public String deplacer(String loc, String dir, String participant) throws RemoteException;
}
