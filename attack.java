//Attack Class to handle variables for each attack
public class attack {
	
	//Private Variables used to describe attack
	private String name, type;
	private int damage;
	private int totalPP, currentPP;
	
	//Default Constructor
	public attack() {
		name = "N/A";
		damage = 0;
		totalPP = 0;
		currentPP = 0;
		type ="N/A";
	}
	
	//Parameterized Constructor
	public attack(String n, int d, int p, int t, String ty) {
		name = n;
		damage = d;
		currentPP = p;
		totalPP = t;
		type = ty;
		
	}
	
	//Mutator Methods
	public void setName(String n) {
		name = n;
	}
	public void setDamage(int d) {
		damage =d;
	}
	public void setTotal(int t) {
		totalPP = t;
	}
	public void setCurrent(int c) {
		currentPP = c;
	}
	public void setType(String ty) {
		type = ty;
	}
	
	//Accessor Methods
	public String getName() {
		return name;
	}
	public int getDamage() {
		return damage;
	}
	public int getTotal() {
		return totalPP;
	}
	public int getCurrent() {
		return currentPP;
	}
	public String getType() {
		return type;
	}
}
