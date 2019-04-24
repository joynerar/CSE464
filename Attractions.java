import java.util.ArrayList;

/**
 * @author Josh Overbeck
 */
public class Attractions {

	// Declaring instance variables
	private String	name;
	private int		waitTime;
	private int		rideTime;

	// private HashMap<Attractions, Integer> neighbors;
	private ArrayList<Neighbor> neighbors;

	// Default constructor
	public Attractions() {
		// Initializing instance variables
		this.name = "";
		this.waitTime = -99999; // Using negative to represent null;
		this.rideTime = -99999;
		neighbors = new ArrayList<Neighbor>();
	} // End of the default constructor

	/**
	 * @author Adam J
	 * @param name
	 *            Attraction Name
	 * @param waitTime
	 *            Wait time for a specific attraction
	 * @param rideTime
	 *            Duration a user is at a specific attraction
	 */
	public Attractions(String name, int waitTime, int rideTime) {
		this.name = name;
		this.waitTime = waitTime;
		this.rideTime = rideTime;
		neighbors = new ArrayList<Neighbor>();
	} // End of workhourse constructor

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
	 * This is the getter method for the neighbors of this instance of
	 * the Attractions class.
	 * 
	 * @return - The HashMap containing the neighbors.
	 */
	public ArrayList<Neighbor> getNeighbors() {
		return neighbors;
	} // End of the 'getNeighbors' method

	// ******************* Setters *********************************

	/**
	 * This is the method that will set the name of the Attractions
	 * object.
	 * 
	 * @param name
	 *            - Input for the name of the Attractions object.
	 */
	public void setName(String name) {
		this.name = name;
	} // End of the 'setName' method

	/**
	 * This is the method that will set the wait time of the
	 * Atractions object.
	 * 
	 * @param waitTime
	 *            - The wait time of the Attractions object.
	 */
	public void setWaitTime(int waitTime) {
		this.waitTime = waitTime;
	} // End of the 'setWaitTime' method

	/**
	 * This is the method that will set the ride time of the
	 * Attractions object.
	 * 
	 * @param rideTime
	 *            - The ride time of the Attractions object.
	 */
	public void setRideTime(int rideTime) {
		this.rideTime = rideTime;
	} // End of the 'setRideTime' method

	/**
	 * This is the method that will add a neighbor to the Attractions
	 * object.
	 * 
	 * @param neighbor
	 *            - The new Neighbor
	 * @param edgeWeight
	 *            - The edge weight between the two Attractions
	 *            objects.
	 */
	public void addNeighbor(Attractions neighbor, int edgeWeight) {
		Neighbor newNeighbor = new Neighbor();
		newNeighbor.setEdgeWeight(edgeWeight);
		newNeighbor.setNeighbor(neighbor);
		neighbors.add(newNeighbor);
	} // End of the 'addNeighbor' method

} // End of the 'Attractions' class
