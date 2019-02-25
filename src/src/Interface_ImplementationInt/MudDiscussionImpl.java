package Interface_ImplementationInt;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

import modele.User;

public class MudDiscussionImpl extends UnicastRemoteObject implements MudDiscussion {

	private HashMap<User, String> userMessageRecuDB; // stockage des utilisateurs qui vont recevoir les messages
	private MudJeuInterface MudJeu;
	String copyright = "\u00a9 2003-2008 My Company. All rights reserved.";
	public MudDiscussionImpl() throws RemoteException {
		userMessageRecuDB = new HashMap<>();
		connexionAuServeurDeJeu();
	}

	public void connexionAuServeurDeJeu() {
		try {
			MudJeu = (MudJeuInterface) Naming.lookup("//localhost/MUD");
			System.out.println(MudJeu.startGame());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String inscriptionNotification(String login, String msgRecu) throws RemoteException {
		for (User user : MudJeu.getUsersList()) {
			if (user.getLogin().equals(login)) {
				userMessageRecuDB.put(user, msgRecu);
				return "l'utilisateur de login" + login + "s'est inscrit au notification";
			}

		}
		return "Echec inscription";

	}

	public void sendMessage(String login, String msg) throws RemoteException {

		int casePersonnage = 0;/* la case du personnage du user */
		//MudDiscussion mudD;
		for (User user : MudJeu.getUsersList()) {
			if (user.getLogin().equals(login)) {
				casePersonnage = user.getUsersPerso().getPieceCourant().getNumP();
			}

		}
		for (HashMap.Entry<User, String> entry : userMessageRecuDB.entrySet()) { // on parcours le Map pour r�cup�rer le
			User user = entry.getKey(); // user pour ensuite le supprimer

			if (user.getProfil().equals("CONNECTE")
					&& user.getUsersPerso().getPieceCourant().getNumP() == casePersonnage)
				receiveMessage(login + " a envoy� : <<" + msg + " >>");

		}

	}

	public String receiveMessage(String msgRecu) throws RemoteException {
		System.out.println(msgRecu);
		return msgRecu;
	}

	public void exitDiscussion(String login) throws RemoteException {
		User user = null; // r�cup�re le user qui souhaite quitter la discussion
		for (HashMap.Entry<User, String> entry : userMessageRecuDB.entrySet()) { // on parcours le Map pour r�cup�rer le
																					// user pour ensuite le supprimer
			if (entry.getKey().getLogin().equals(login))
				user = entry.getKey();
		}
		userMessageRecuDB.remove(user);
	}

}
