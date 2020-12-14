import java.util.Scanner;

//Abstract Player Class
public abstract class Player {
	
	//Private Variables
	protected Pokemon poke;
	protected Item item;
	
	//Abstract functions to be defined
	public abstract Pokemon getPokemon();
	public abstract Item getItem();
	public abstract void run();
	public abstract String getName(); //Get name of player - Specifies if Human or Computer

	//Parameterized Constructor
	public Player(Pokemon p, Item t) {
		poke = p;
		item =t;
	}
	
	/**
	 * Prints out menu for user to select action
	 * 
	 * @return String which displays possible actions for user to select
	 */
	public String printMenu() {
		String s = "";
		s+= this.getName() + " Choose your action:" + "\n" + "1)Attack" +"\n" +"2)Use Item" + "\n" + "3)Flee" + "\n" + "choice: ";
		return s;
	}
    
	/**
	 * Prints out current health of Pokemon after action is performed
	 * 
	 * @return String that can be used to display current health of Pokemon for a player
	 */
    public String toString() {
        String s = "Health: " + this.getPokemon().getHealthCurrent() + "\n";  
        return s;
    }
	
    
    /**
     *Function initiates fight and continues fight between 2 players
     *Allows player to chose action and computer chooses random action based on random int
     *Displays menu shows current status of battle  
     * @param player2
     */
    public void fight(Player player2) {
    	Scanner input = new Scanner(System.in);
		int choice = -1;
		//Take in user input as what the action will be
		System.out.print(this.printMenu());
    	choice = input.nextInt();
    	System.out.print("\n");
    	switch(choice) {
    	case 1:
    		this.getPokemon().attack(player2.getPokemon());
    		break;
    	case 2:
    		this.getItem().use(this.getPokemon());;
    		break;
    	case 3:
    		this.run();
    		break;
    	default:
    		System.out.println("Invalid choice!");
    	}
    	//Print our status of pokemon after action
    	System.out.print(this.getPokemon().getName()+" "+this.toString());
    	System.out.println(player2.getPokemon().getName()+" "+player2.toString());
    	
    	
    	System.out.println("------------------------------------------");
    	
    	//Computer Actions using random Integer
    	System.out.print(player2.printMenu());
    	int randomInt = (int) (Math.random()*(2 - 1 + 1)+1);
    	System.out.println(randomInt+"\n");
    	switch(randomInt) {
    	case 1:
    		player2.getPokemon().attack(this.getPokemon());
    		break;
    	case 2:
    		player2.getItem().use(player2.getPokemon());;
    		break;

    	default:
    		System.out.println("Invalid choice!");
    	}
    	//Print out status after computer action
    	System.out.print(this.getPokemon().getName()+" "+this.toString());
    	System.out.println(player2.getPokemon().getName()+" "+player2.toString());
    	System.out.println("------------------------------------------");
    }
}
