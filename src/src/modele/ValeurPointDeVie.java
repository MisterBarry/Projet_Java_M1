package modele;

public class ValeurPointDeVie {
	private int pVieActuel;
	private int pVieMax;
	
	public ValeurPointDeVie(int pVieActuel, int pVieMax) {
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
	
	public boolean dead() {
		if(pVieActuel==0)
			return true;
		
		return false;
	}

}
