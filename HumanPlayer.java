// Human Player extends Plater abstract Class
public class HumanPlayer extends Player {
	//Protected Name variable
	protected String name;

	//Parameterized Constructor
	public HumanPlayer(String n, Pokemon poke, Item i) {
		super(poke, i);
		name = n;
	}
	
	/**
	 * returns Pokemon
	 */
	@Override
	public Pokemon getPokemon() {
		// TODO Auto-generated method stub
		return this.poke;
	}
	
	/**
	 * return item
	 */
	@Override
	public Item getItem() {
		// TODO Auto-generated method stub
		return this.item;
	}
	
	/**
	 * Allows player to flee battle
	 * by using system.exit(1)
	 */
	@Override
	public void run() {
		System.out.print(this.name+ " has fled the battle!");
		System.exit(1);

	}
	/**
	 * Return name of Human Player
	 */
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}



}
