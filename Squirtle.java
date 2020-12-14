//Import scanner utility to take input
import java.util.Scanner; 

//Concrete Class that extends Pokemon abstract class
public class Squirtle extends Pokemon {

	//Default Constructor that initializes all attributes for pokemon
	public Squirtle(){
		name = "Squirtle";
		type = "Water";
		healthCurrent = 100;
		healthMax  = 100;
		isComputer = true; //Setting whether pokemon is being controlled by Computer
		attacks.add(new attack("Bodyslam", 15, 10, 10, "Normal")); //Adding attack into arrayList
		attacks.add(new attack("Water Gun", 10, 15, 15, "Water"));//Adding attack into arrayList
		attacks.add(new attack("Hydro Cannon", 20, 5, 5, "Water"));//Adding attack into arrayList
		attacks.add(new attack("Surf", 15, 10, 10, "Water"));//Adding attack into arrayList
	}
	
	
	/**
	 * Takes in other Pokemon to be attacked
	 * 
	 * Checks whether Pokemon is being controlled by Computer
	 * Prints out all possible attacks and PP remaining
	 * Human Player can  select attack
	 * Checks whether there is STAB boost to attack
	 * 
	 * If Computer is true random integer will be used to select attack 
	 * return how effective the attack was and decreases PP
	 * Checks is Pokemon has Fainted and ends game.
	 */
	@Override
	public void attack(Pokemon other) {
		if(!isComputer) {
		// TODO Auto-generated method stub
		int i = 1;
		
		Scanner input = new Scanner(System.in); //Take in user input
		
		System.out.println("Choose your attack!");
		for(attack a : attacks) {
			System.out.println(i+") "+ a.getName() + " Damage:" + a.getDamage() + " " +a.getCurrent()+ "/"+a.getTotal()); //Prints out list of attacks
			i++;
		}
		System.out.print("Choice: ");
		int numAttack = input.nextInt();
		//Conditions to check if there is enough PP and to determine amount of damage taken
		if(attacks.get(numAttack-1).getCurrent() > 0) {
			System.out.println(name + " uses " + attacks.get(numAttack-1).getName() + "!\n");
			attacks.get(numAttack-1).setCurrent(attacks.get(numAttack-1).getCurrent()-1);
			if((attacks.get(numAttack-1).getType() == "Water")&&(other.getType() == "Fire" || other.getType() == "Ground" || other.getType() == "Rock")) { //Checks for Super effective
				other.setHealthCurrent(other.getHealthCurrent() - 2*(attacks.get(numAttack-1).getDamage()));
				System.out.println("Super Effective!");
			}
			else if((attacks.get(numAttack-1).getType() =="Water")&&(other.getType() == "Grass" || other.getType() == "Ice")) {
				other.setHealthCurrent(other.getHealthCurrent() - (int)(0.5*(attacks.get(numAttack-1).getDamage()))); //Checks for not very effective
				System.out.println("Not Very Effective!");
			}
			else
				other.setHealthCurrent(other.getHealthCurrent() - (attacks.get(numAttack-1).getDamage())); //Base Damage
			
			if(other.getHealthCurrent() <= 0) {
				System.out.println(other.getName()+ " has fainted!"); //Checks if Pokemon has fainted
				System.exit(1);
			}
		}
		else {
			System.out.println(this.name + " does not have enough PP!"); // lets user know if PP is sufficient
		}
		}
		
		else if(isComputer) { //Computer that uses Random integer to select attacks
			//Same processes is used to check like human player
			int i = 1;
			System.out.println("Choose your attack!");
			
			for(attack a : attacks) {
				System.out.println(i+") "+ a.getName() + " Damage:" + a.getDamage() + " " +a.getCurrent()+ "/"+a.getTotal());
				i++;
			}
			System.out.print("Choice: ");
			
			int numAttack = (int)(Math.random()*(4- 1 + 1)+1); //Random integer generated
			System.out.print(numAttack + "\n");
			
			if(attacks.get(numAttack-1).getCurrent() > 0) {
				System.out.print(name + " uses " + attacks.get(numAttack-1).getName() + "!\n");
				attacks.get(numAttack-1).setCurrent(attacks.get(numAttack-1).getCurrent()-1);
				if((attacks.get(numAttack-1).getType() == "Water")&&(other.getType() == "Fire" || other.getType() == "Ground" || other.getType() == "Rock")) {
					other.setHealthCurrent(other.getHealthCurrent() - 2*(attacks.get(numAttack-1).getDamage()));
					System.out.println("Super Effective!");
				}
				else if((attacks.get(numAttack-1).getType() =="Water")&&(other.getType() == "Grass" || other.getType() == "Ice")) {
					other.setHealthCurrent(other.getHealthCurrent() - (int)(0.5*(attacks.get(numAttack-1).getDamage())));
					System.out.println("Not Very Effective!");
				}
				else
					other.setHealthCurrent(other.getHealthCurrent() - (attacks.get(numAttack-1).getDamage()));
				if(other.getHealthCurrent() <= 0) {
					System.out.println(other.getName()+ " has fainted!");
					System.exit(1);
				}
			}
			else {
				System.out.println(this.name + " does not have enough PP!");
		}
		
		}		
	}
	
	/**
	 * Prints out name of Pokemon
	 */
	@Override
	public void speak() {
		// TODO Auto-generated method stub
		System.out.print(this.name);

	}


}
