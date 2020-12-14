//Item that implements Item Interface
public class Potion implements Item{
	//Private Variables
	private int healthGain;
	private int supply;
	
	//Default Constructor
	public Potion() {
		healthGain = 10;
		supply = 1;
	}
	
	/**
	 * Function that uses item, checks amount and sets health according to the parameters met.
	 * Prints out status of item and what action was performed. 
	 */
	@Override
	public void use(Pokemon p) {
		// TODO Auto-generated method stub
		if(p.getHealthCurrent() == p.getHealthMax()) {
			System.out.println("Already Full Health!");
		}
		else if(supply > 0) {
		
		p.setHealthCurrent(p.getHealthCurrent()+healthGain);
		if(p.getHealthCurrent() > p.getHealthMax()){
			p.setHealthCurrent(p.getHealthMax());
		}
		supply--;
		System.out.println("Potion was used!");
		}
		else {
			System.out.println("You do not have anymore Potions!");
		}
	}

}
