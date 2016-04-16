
public class Ship extends Skills{

	public int power;
	public int agility;
	public int hull;
	public int shield;
	
	// Ship object creator
	public Ship (int power, int agility, int hull, int shield){
		this.power = power;
		this.agility = agility;
		this.hull = hull;
		this.shield = shield;
	}

	// getters and setters for other metods (abilities) to modify them during the game 
	public int getPower() {
		return power;
	}
	public int getAgility() {
		return agility;
	}
	public int getHull() {
		return hull;
	}
	public int getShield() {
		return shield;
	}

	public void setPower(int power) {
		this.power = power;
	}
	public void setAgility(int agility) {
		this.agility = agility;
	}
	public void setHull(int hull) {
		this.hull = hull;
	}
	public void setShield(int shield) {
		this.shield = shield;
	}
	
	
	
}
