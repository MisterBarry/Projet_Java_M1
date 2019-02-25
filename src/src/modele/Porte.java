package modele;

public class Porte {
	public String position;
	public boolean isOpen;
	
	public Porte() {
		super();
		this.isOpen = false;
	}
	
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public boolean isOpen() {
		return isOpen;
	}
	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}
	
	
	

}
