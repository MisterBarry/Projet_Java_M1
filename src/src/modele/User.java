package modele;

import java.io.Serializable;

public class User implements Serializable {
	String copyright = "\u00a9 2003-2008 My Company. All rights reserved.";
	private String login;
	private String passwd;
	private Personnage usersPerso; // le personnage de l'utilisateur
	private String profil; // il est connect� ou non



	public User(String login, String passwd, Personnage usersPerso) {
		super();
		this.login = login;
		this.passwd = passwd;
		this.usersPerso = usersPerso;
		this.setProfil("Log out");
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public Personnage getUsersPerso() { // on r�cup�re le personnage du user 
		return usersPerso;
	}

	public void setUsersPerso(Personnage usersPerso) {
		this.usersPerso = usersPerso;
	}

	public String getProfil() {
		return profil;
	}

	public void setProfil(String profil) {
		this.profil = profil;
	}

}
