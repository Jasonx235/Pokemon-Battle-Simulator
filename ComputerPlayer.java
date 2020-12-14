//Computer Player extends abstract player class
public class ComputerPlayer extends Player {
	//Protected Name variable
	protected String name;
	
	//Parameterized Constructor
	public ComputerPlayer(Pokemon p, Item t) {
		super(p, t);
		name = "Computer";
	}

	/**
	 * Return name of Computer player
	 */
	@Override
	public String getName() {
		return name;
	}
	 
	/**
	 * return pokemon object
	 */
	@Override
	public Pokemon getPokemon() {
		// TODO Auto-generated method stub
		return poke;
	}

	/**
	 * Return item object
	 */
	@Override
	public Item getItem() {
		// TODO Auto-generated method stub
		return item;
	}

	/**
	 * Allow Computer player to run from battle
	 */
	@Override
	public void run() {
		System.out.print(this.name+ " has fled the battle!");
		System.exit(1);
	}


}
