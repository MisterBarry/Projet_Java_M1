package Interface_ImplementationInt;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

import modele.Option;
import modele.Participant;
import modele.Piece;

public class MudCombatImpl extends UnicastRemoteObject implements MudCombat{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected MudCombatImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	private static Option option;
	private MudJeuImplementation mudJeuImplementation;
	private Piece piece;

	public void doBattleRound(Participant personnage, Participant monstre) {
		    Scanner read = new Scanner(System.in);
		    int option;
		    
		    System.out.println("Que vous voulez attaqer?");
		    System.out.println("1. Monstre");
		    System.out.println("2. Personnage\n");
		    option = read.nextInt();
			
		    if(option == 1){
		    	doAttack(personnage, monstre);
		    	
			}
		    else if(option == 2){
		    	doAttack(monstre, personnage);
		    }else
		    {
		    	System.out.println("Veuillez entrer 1 ou 2!");
		    }
		
            
        } 
    
	

    public void doAttack(Participant attacker, Participant defender) {
    		boolean deadA = attacker.dead();
    		boolean deadD = defender.dead();
    		
            defender.perdrePV_tour();
            System.out.printf("%s hit %s for 1 damage!", attacker.getNom(), defender.getNom());
          
            if(deadA = true)
            	defender.gagnerPV_tour();
    		
            if(deadD = true)
            	attacker.gagnerPV_tour();
        }



	@Override
	public boolean isCombat(int numP){
		// TODO Auto-generated method stub
		return false;
	} 
	
	//si sans combat, completer le PV
	/*public boolean isCombat(int numP){
	
		boolean isPieceVide = piece.isPieceVide(numP);
		if(isPieceVide = false){
			
		}
		return true;
		
	} */
	
}
