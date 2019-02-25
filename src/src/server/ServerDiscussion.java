package server;

import java.rmi.Naming;
import java.util.logging.Level;
import java.util.logging.Logger;

import Interface_ImplementationInt.MudDiscussionImpl;

public class ServerDiscussion {

	public ServerDiscussion() {
		try {

			MudDiscussionImpl mudDI = new MudDiscussionImpl();
			Naming.bind("DiscussObject", mudDI);
		} catch (Exception ex) {
			Logger.getLogger(ServerJeu.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public static void main(String[] args) {

		new ServerDiscussion();

	}

}
