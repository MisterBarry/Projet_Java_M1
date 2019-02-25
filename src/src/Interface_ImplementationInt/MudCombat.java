package Interface_ImplementationInt;

import java.rmi.Remote;
import java.rmi.RemoteException;

import modele.Participant;

public interface MudCombat extends Remote{
	public void doBattleRound(Participant personnage, Participant monstre) throws RemoteException;
	public void doAttack(Participant attacker, Participant defender) throws RemoteException;
	public boolean isCombat(int numP) throws RemoteException; //Si ya un combat dans ce piece
}
