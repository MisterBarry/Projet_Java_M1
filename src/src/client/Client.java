package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.Naming;
import java.rmi.RemoteException;

import Interface_ImplementationInt.MudDiscussion;
import Interface_ImplementationInt.MudJeuInterface;

public class Client {

	String copyright = "\u00a9 2003-2008 My Company. All rights reserved.";
	public String choix; 
	private BufferedReader br;
	private String login;
	private String msgRecu;
	private MudJeuInterface mudJeuInterface;
	private MudDiscussion mudDiscussion;
	
	public Client() {		
		br = new BufferedReader (new InputStreamReader(System.in));
		choix = new String();
		login = new String();
        connexionAuServeurDeJeu();
		menuPrincipal();
		
	}
	
	
	public void menuPrincipal()
	{
		do
		{
			System.out.println("---------Welcom to our MUD game-------------\n\n choix 1 -> Connexion \n choix 2 -> Creer un nouveau compte\n\n");
			
			choix = saisie();
			
			if (choix.equals("1"))
				connexion();
			
			else if (choix.equals("2")) 
				creerCompte();
				
		} while (!choix.equals("1") && !choix.equals("2"));
		
	}
	
	public void connexionAuServeurDeJeu()
	{
		try {
			mudJeuInterface = (MudJeuInterface) Naming.lookup("//localhost/MUD");
			System.out.println(mudJeuInterface.startGame());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void connexionServeurDiscussion()
	{
		try {
			mudDiscussion = (MudDiscussion) Naming.lookup("//localhost/DiscussObject");
			System.out.println(mudDiscussion.inscriptionNotification(login, msgRecu));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void connexion()
	{
		String tab[] = new String[2];// on stocke le login et le mot de passe du user
		
		System.out.println("---------------------Entrer vos identifiants pour vous connecter----------------------\n\n");
		try {
			do
			{
				System.out.println("Entrez votre login : ");
				tab[0] = saisie();
				login = tab[0];
				System.out.println("Entrez votre password : ");
				tab[1] = saisie();
				
				if (!mudJeuInterface.sauthentifier(tab[0], tab[1]))
					System.out.println("Echec d'authentification, verifier votre login et votre mot de passe");
				
			}while(!mudJeuInterface.sauthentifier(tab[0], tab[1]));
		} catch (RemoteException e) {
			e.printStackTrace();
		}

		System.out.println("Vous �tes connect�!\n");
		
	}
	
	private void creerCompte() {
		System.out.println("-------------Creation de de compte------------------");
		String str[] = new String[3];
		
		try {
			do {
				System.out.println("entrer votre login");
				choix = saisie();
				
				if(mudJeuInterface.isUserExist(choix)) {
					System.out.println("Erreur -> ce login exite d�ja, veuillez vous connectez");
				}
				
			} while (mudJeuInterface.isUserExist(choix));
			
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		str[0] = choix;
		login = str[0];
		
		do {
			System.out.println("Entrer un mot de passe(au moins 4 caract�res): ");
			choix = saisie();
		} while (choix.length() < 4); // mot de passe d'au moins 4 caract�re
		
		str[1]=choix;
		
		try {
			do {
				System.out.println("Entrer le nom de votre personnage");
				choix = saisie();
				if(mudJeuInterface.isPersonnageExist(choix))
					System.out.println("Erreur -> ce nom de personnage a d�ja �t� choisi");
			} while (mudJeuInterface.isPersonnageExist(choix));
			
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		str[2] = choix;
		
		try {
			mudJeuInterface.createUserWithPerso(str[0], str[1], str[2]);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		System.out.println("F�licitation votre compte a �t� bien cr�er vous pouvez mintenant vous connecter!!!\n\n");
	}
	
	public void verifSaisieMessage() throws RemoteException
	{		
		if (choix.equals("\""))
		{
			do {
				System.out.println("Ecrivez votre message. Pour l'envoyer, entrez \" et appuyez sur la touche ENTREE");
				choix = saisie();
			}while (choix.charAt(choix.length()-1) != '\"');/*tant que le dernier caract�re n'est pas \"*/
			
			/*Suppression du dernier caract�re qui est le caract�re \" */
			StringBuilder msg = new StringBuilder(choix);
			msg.deleteCharAt(msg.length()-1);
			
			//System.out.println(username + " a ecrit : " + msg.toString());
			try {
				mudDiscussion.sendMessage(login, msg.toString());
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (choix.toUpperCase().equals("D"))
		{
			if (mudJeuInterface.doconnexion(login))
			{
				System.out.println("\nD�connexion effectu�e avec succ�s\n\n");
				menuPrincipal();
			}
			else
				System.out.println("La d�connexion a �chou�");
		}
	}
	
	private String saisie()
	{
		String str = new String();
		try {
			str = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return str;
	}

}
