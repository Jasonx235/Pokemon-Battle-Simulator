//Import scanner utility to take input
import java.util.Scanner; 

//Concrete Class that extends Pokemon abstract class
public class Charmander extends Pokemon {
	
	//Default Constructor that initializes all attributes for pokemon
	public Charmander(){
		name = "Charmander";
		type = "Fire";
		healthCurrent = 100;
		healthMax = 100;
		isComputer = false; //Setting whether pokemon is being controlled by Computer
		attacks.add(new attack("Bodyslam", 15, 10, 10, "Normal")); //Adding attack into arrayList
		attacks.add(new attack("Scratch", 10, 15, 15, "Normal")); //Adding attack into arrayList
		attacks.add(new attack("Flamethrower", 25, 5, 5, "Fire")); //Adding attack into arrayList
		attacks.add(new attack("Fire Punch", 10, 10, 10, "Fire"));//Adding attack into arrayList
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
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Choose your attack!");
		for(attack a : attacks) {
			System.out.println(i+") "+ a.getName() + " Damage:" + a.getDamage() + " " +a.getCurrent()+ "/"+a.getTotal());
			i++;
		}
		System.out.print("Choice: ");
		
		
		int numAttack = input.nextInt();
		
		//Conditions to check if there is enough PP and to determine amount of damage taken
		if(attacks.get(numAttack-1).getCurrent() > 0) {
			System.out.print(name + " uses " + attacks.get(numAttack-1).getName() + "!\n");
			attacks.get(numAttack-1).setCurrent(attacks.get(numAttack-1).getCurrent()-1);
			if((attacks.get(numAttack-1).getType() == "Fire")&&(other.getType() == "Grass" || other.getType() == "Ice"|| other.getType() == "Bug")) { //Checks whether damage is super effective
				other.setHealthCurrent(other.getHealthCurrent() - 2*(attacks.get(numAttack-1).getDamage()));
				System.out.println("Super Effective!");
			}
			else if((attacks.get(numAttack-1).getType() == "Fire")&&(other.getType() == "Rock" || other.getType() == "Water")) {
				other.setHealthCurrent(other.getHealthCurrent() - (int)(0.5*(attacks.get(numAttack-1).getDamage()))); // Checks whether attack is not very effective
				System.out.println("Not Very Effective!");
			}
			else
				other.setHealthCurrent(other.getHealthCurrent() - (attacks.get(numAttack-1).getDamage())); //Base Damage
			
			if(other.getHealthCurrent() <= 0) {
				System.out.println(other.getName()+ " has fainted!"); //Checks Faint Condition
				System.exit(1);
			}
		}
		else {
			System.out.println(this.name + " does not have enough PP!"); //Let user know if not enough PP
		}
		}
		
		else if(isComputer) { //Computer Player that uses Random Integer to select action
			//Same processes is used to check like human player
			int i = 1;
			System.out.println("Choose your attack!");
			
			for(attack a : attacks) {
				System.out.println(i+") "+ a.getName() + " Damage:" + a.getDamage() + " " +a.getCurrent()+ "/"+a.getTotal());
				i++;
			}
			System.out.print("Choice: ");
			
			int numAttack = (int)(Math.random()*(4- 1 + 1)+1); //Random Integer
			System.out.print(numAttack + "\n");
			
			if(attacks.get(numAttack-1).getCurrent() > 0) {
				System.out.print(name + " uses " + attacks.get(numAttack-1).getName() + "!\n");
				attacks.get(numAttack-1).setCurrent(attacks.get(numAttack-1).getCurrent()-1);
				if((attacks.get(numAttack-1).getType() == "Fire")&&(other.getType() == "Grass" || other.getType() == "Ice"|| other.getType() == "Bug")) {
					other.setHealthCurrent(other.getHealthCurrent() - 2*(attacks.get(numAttack-1).getDamage()));
					System.out.println("Super Effective!");
				}
				else if((attacks.get(numAttack-1).getType() == "Fire")&&(other.getType() == "Rock" || other.getType() == "Water")) {
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
	 * Function allows Pokemon to speak its name
	 */
	@Override
	public void speak() {
		// TODO Auto-generated method stub
		System.out.print(this.name);

	}
	

}
