package modele;

public class Participant {
	
	private int pVieActuel;
	private int pVieMax;
	private String nom;
	
	public Participant(int pVieActuel, int pVieMax) {
		super();
		this.pVieActuel = pVieActuel;
		this.pVieMax = pVieMax;
	}
	
	public int getpVieActuel() {
		return pVieActuel;
	}

	public void setpVieActuel(int pVieActuel) {
		this.pVieActuel = pVieActuel;
	}

	public int getpVieMax() {
		return pVieMax;
	}

	public void setpVieMax(int pVieMax) {
		this.pVieMax = pVieMax;
	}
	
	public String getNom() {
		return nom;
	}
    
	public void setNom(String nom) {
		this.nom = nom;
	}

	public boolean dead() {
		if(pVieActuel==0)
			return true;
		
		return false;
	}
	
	public void perdrePV_tour() 
	{
		if(!dead()) {
			this.setpVieActuel(this.getpVieActuel() - 1); 
		}
		else
			this.setpVieActuel(0);
		
	}
	
	public void gagnerPV_tour() // on incremente son point de vie s'il n'est pas d�ja mort
	{
		if(!dead()) {
			this.setpVieActuel(this.getpVieActuel() + 1);
		}
	}
	public void completerPV(){
		pVieActuel = pVieMax;
	}
	
}
