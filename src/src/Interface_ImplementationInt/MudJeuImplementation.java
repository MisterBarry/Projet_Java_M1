package Interface_ImplementationInt;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import modele.Labyrinthe;
import modele.Personnage;
import modele.Piece;
import modele.User;

public class MudJeuImplementation extends UnicastRemoteObject implements MudJeuInterface {
	String copyright = "\u00a9 2003-2008 My Company. All rights reserved.";
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<User> listUser;
	private Labyrinthe labyrinthe;
	private Piece pieces[] = new Piece[20]; // 20 pi�ces
	private MudDiscussion md;

	public MudJeuImplementation() throws RemoteException {
		super();
		listUser = new ArrayList<>();
		labyrinthe = new Labyrinthe();

	}

	public boolean sauthentifier(String login, String passwd) throws RemoteException {

		if (listUser.isEmpty())
			return false;

		for (User u : listUser) {
			if (!(u.getLogin().equals(login)) && !(u.getPasswd().equals(passwd))) {
				u.setProfil("DECONNECTE");
				return false;
			}
		}
		return true;
	}

	public boolean isUserExist(String login)
			throws RemoteException /* indique si le nom d'utilisateur existe d�ja ou non */
	{
		if (listUser.isEmpty())
			return false;

		for (User user : listUser) {
			if (user.getLogin().equals(login)) {
				return true;
			}
		}
		return false;
	}

	public boolean isPersonnageExist(String nomP) throws RemoteException {
		if (listUser.isEmpty())
			return false;

		for (User user : listUser) {
			if (user.getUsersPerso().getNomP().equals(nomP)) {
				return true;
			}
		}
		return false;
	}

	public String startGame() throws RemoteException {
		String str = "le serveur est lanc� vous pouvez d�marrer le jeu";
		return str;
	}

	public void createUserWithPerso(String login, String passwd, String nomP) throws RemoteException {
		Personnage personnage = new Personnage(nomP, pieces[1]);
		User user = new User(login, passwd, personnage);
		user.setProfil("CONNECTE");
		listUser.add(user);
	}

	public Personnage getPersoUser(String login) // on recupere le nom du personnage � l'aide du nom du user
	{
		for (User user : listUser) {
			if (user.getLogin().equals(login)) // on verifie deja que le user existe bien
				return user.getUsersPerso();
		}
		return null;
	}

	public void deplacerPerso(String nomP, String sens) throws RemoteException {
		getPersoUser(nomP).deplacerPerso(sens);

	}

	public void setListUser(ArrayList<User> listUser) {
		this.listUser = listUser;
	}

	public Piece getPiecePersonnage(String nomP) throws RemoteException {

		return null;
	}

	public ArrayList<User> getUsersList() throws RemoteException {

		return listUser;
	}

	public User getUserProfil(String login) throws RemoteException {

		return null;
	}

	public boolean doconnexion(String login) throws RemoteException {


		for (User user : listUser) {
			
			if (user.getLogin().equals(login))
			{
				
				md.exitDiscussion(login);
				user.setProfil("DECCONCTE");
				return true;
			}
		}
		
		return false;
	}

	public boolean isPersonnageAlone(String nomP) throws RemoteException {

		return false;
	}

	public void updatePVPerso(ArrayList<User> userList) throws RemoteException {

	}

	
}
