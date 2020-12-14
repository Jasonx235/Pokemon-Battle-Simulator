import java.util.ArrayList;
import java.util.Scanner;

//Abstract Pokemon Class
public abstract class Pokemon {
	
	//Variables initialized 
	protected String name, type;
	protected int healthCurrent, healthMax; 
	protected boolean isComputer = false;
	protected ArrayList<attack> attacks =  new ArrayList<attack>();
	
	//Abstract Methods to be defined
	public abstract void attack(Pokemon other);
	public abstract void speak();
	
	//Mutator Methods
	public void setName(String n) {
		name = n;
	}
	public void setType(String t) {
		type =t;
	}
	public void setHealthCurrent(int h) {
		healthCurrent = h;
	}
	public void setHealthMax(int h) {
		healthMax = h;
	}
	
	//Accessor Methods
	public String getName() {
		return name;
	}
	public String getType() {
		return type;
	}
	public int getHealthCurrent() {
		return healthCurrent;
	}
	public int getHealthMax() {
		return healthMax;
	}
	

}
