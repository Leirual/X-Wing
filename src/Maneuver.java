
public class Maneuver {

	public int distance;
	public String direction;
	
	// Maneuver creator
	public Maneuver (int distance, String direction){
		this.distance = distance;
		this.direction = direction;
	}

	// getters and setters for other methods
	public int getDistance() {
		return distance;
	}
	public String getDirection() {
		return direction;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	
	
	
	
	
}
