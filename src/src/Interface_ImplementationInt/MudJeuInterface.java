package Interface_ImplementationInt;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import modele.Piece;
import modele.User;


public interface MudJeuInterface extends Remote {
	String copyright = "\u00a9 2003-2008 My Company. All rights reserved.";

	public boolean sauthentifier(String login, String passwd) throws RemoteException; // connexion de l'utilisateur grace �
																					// son login et son mot de passe

	public boolean isUserExist(String login) throws RemoteException; // on verifie que l'utilisateur s'est d�ja registr�

	public boolean isPersonnageExist(String nomP) throws RemoteException; // le personnage choisi existe t-il

	public void createUserWithPerso(String login, String passwd, String nomP) throws RemoteException;// cr�er un user et
																										// lui associ�
																										// un personnage

	public String startGame() throws RemoteException; // d�marrer le jeu

	public void deplacerPerso(String nomP, String sens) throws RemoteException; // d�placer le personnage suivant un
																				// sens(E,W,N,S)

	public Piece getPiecePersonnage(String nomP) throws RemoteException; // r�cup�rer la pice dans laquelle le
																			// personnage se trouve

	public ArrayList<User> getUsersList() throws RemoteException; // liste des utilisateurs pr�sents

	public User getUserProfil(String login) throws RemoteException;

	public boolean doconnexion(String user) throws RemoteException;

	public boolean isPersonnageAlone(String nomP) throws RemoteException; // si l'utilisateur est seul dans la pi�ce
																			// pour lancer la discussion

	public void updatePVPerso(ArrayList<User> userList) throws RemoteException;// mis � jour des points de vie plus+
																				// users

}
