package Interface_ImplementationInt;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MudDiscussion extends Remote {

	public String inscriptionNotification(String login, String msgRecu) throws RemoteException;/*on s'inscrit pour pouvoir recevoir les notifications des envois des autres joeurs*/
	public void sendMessage(String username, String msg) throws RemoteException;/*permet � un utilisateur d'envoyer un message aux autres users pr�sents dans la case*/
	public String receiveMessage(String msgRecu) throws RemoteException; /* le message re�u par l'utilisateur */	
	public void exitDiscussion(String username) throws RemoteException; /*d�connexion du user sur le serveur de gestion de la discussion*/
}
