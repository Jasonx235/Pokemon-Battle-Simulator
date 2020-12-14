//Item that implements Item interface
public class fullRestore implements Item {
	
	//Private Variables
	private int supply;
	
	//Default Constructor
	public fullRestore() {
		supply = 1;
	}
	
	/**
	 * Function that uses item, checks amount and sets health according to the parameters met.
	 * Prints out status of item and what action was performed. 
	 */
	@Override
	public void use(Pokemon p) {
		if(p.getHealthCurrent() == p.getHealthMax()) {
			System.out.println("Already Full Health!");
		}
		else if(supply > 0) {
		p.setHealthCurrent(p.getHealthMax());
		supply--;
		System.out.println("Full Restore was used!");
	}
	else {
		System.out.println("You do not have anymore Full Restores!");
	}
	}

}
