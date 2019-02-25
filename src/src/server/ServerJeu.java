package server;

import java.net.MalformedURLException;
import java.nio.channels.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.logging.Level;
import java.util.logging.Logger;

import Interface_ImplementationInt.MudJeuImplementation;

public class ServerJeu {
	
	MudJeuImplementation mudJeu;
    String copyright = "\u00a9 2003-2008 My Company. All rights reserved.";
	public ServerJeu() {
			
		try {
            LocateRegistry.createRegistry(1099); //port du serveur RMI qui donnera au client l'adresse IP du serveur � contacter
            mudJeu = new MudJeuImplementation();
            Naming.bind("MUD", mudJeu);//naming permet d'utiliser des noms plutot que des num�ros de ports
        } 
        catch (RemoteException | AlreadyBoundException | MalformedURLException | java.rmi.AlreadyBoundException ex) {
            Logger.getLogger(ServerJeu.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
	
	public static void main(String[] args) {
		
		new ServerJeu();
		
	}
}


