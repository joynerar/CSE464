import java.util.HashMap;

/**
 * @author Josh Overbeck
 */
public class Attractions {

	// Declaring instance variables
	private String name;
	private int waitTime;
	private int rideTime;

	private HashMap<Attractions, Integer> neighbors;

	// Default constructor
	public Attractions() {
		// Initializing instance variables
		this.name = "";
		this.waitTime = -99999; // Using negative to represent null;
		this.rideTime = -99999;
		neighbors = new HashMap<Attractions, Integer>();
	} // End of the default constructor

	public Attractions(String name) {
		new Attractions(name, -99999, -99999);
	}

	public Attractions(String name, int waitTime, int rideTime) {
		this.name = name;
		this.waitTime = waitTime;
		this.rideTime = rideTime;
		neighbors = new HashMap<Attractions, Integer>();
	}

	// ******************* Getters **********************************

	/**
	 * This is the getter method for the name of the attraction.
	 * 
	 * @return - the name of the attraction.
	 */
	public String getName() {
		return name;
	} // End of the 'getName' method

	/**
	 * This is the getter method for the wait time of the attraction.
	 * 
	 * @return - The wait time of the attraction.
	 */
	public int getWaitTime() {
		return waitTime;
	} // End of the 'getWaitTime' method

	/**
	 * This is the getter method for the ride time of the attraction.
	 * 
	 * @return - The ride time of the attraction.
	 */
	public int getRideTime() {
		return rideTime;
	} // End of the 'getRideTime' method

	/**
	 * This is the getter method for the neighbors of this instance of the
	 * Attractions class.
	 * 
	 * @return - The HashMap containing the neighbors.
	 */
	public HashMap<Attractions, Integer> getNeighbors() {
		return neighbors;
	} // End of the 'getNeighbors' method

	// ******************* Setters *********************************

	public void setName(String name) {
		this.name = name;
	} // End of the 'setName' method

	public void setWaitTime(int waitTime) {
		this.waitTime = waitTime;
	} // End of the 'setWaitTime' method

	public void setRideTime(int rideTime) {
		this.rideTime = rideTime;
	} // End of the 'setRideTime' method

	public void addNeighbor(Attractions neighbor, int edgeWeight) {
		neighbors.put(neighbor, edgeWeight);
	} // End of the 'addNeighbor' method

} // End of the 'Attractions' class
