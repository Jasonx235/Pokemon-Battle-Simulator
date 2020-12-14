//Import to get input from user
//Pokemon Runner Class
public class PokemonRunner {

	public static void main(String[] args) {
		//Initialize Pokemon and Item Objects
		// TODO Auto-generated method stub
		Pokemon Char = new Charmander();
		Pokemon Squi = new Squirtle();
		Item HPpot = new Potion();
		Item fullRestore = new fullRestore();
	
		//Initialize Human and Computer Player
		Player player1 = new HumanPlayer("Jason", Char, fullRestore);
		Player player2 = new ComputerPlayer(Squi, HPpot);
		
		
	System.out.println("Welcome to the Pokemon Battle Simulator!" +"\n");
	
	//Display whos Pokemon is whos
    System.out.println(player1.getName()+" sent out " + player1.getPokemon().getName() + "!");
    System.out.println(player2.getName()+" sent out " + player2.getPokemon().getName() + "!");
	System.out.println("\n");
	System.out.println("------------------------------------------");
	//Loops condition until one Pokemon has fainted
	while(player1.getPokemon().getHealthCurrent() > 0 && player2.getPokemon().getHealthCurrent() > 0){
		
		player1.fight(player2);
    		
	}

	
	
	
}
}