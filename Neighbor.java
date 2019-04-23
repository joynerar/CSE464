/**
 * This is the class that will be used for the neighbors objects. It
 * will have an Attractions object and an edge weight.
 * 
 * @author Josh Overbeck
 */
public class Neighbor {

	private Attractions	neighbor;
	private int			edgeWeight;

	// Default Constructor
	public Neighbor() {
		this.neighbor = new Attractions();
		this.edgeWeight = 0;
	} // End of the Default Constructor

	/**
	 * This is the method for setting the Attractions object.
	 * 
	 * @param inNeighbor
	 *            - The Attractions object that you would like to set
	 *            as the neighbor.
	 */
	public void setNeighbor(Attractions inNeighbor) {
		this.neighbor = inNeighbor;
	} // End of the 'setNeighbor' method

	/**
	 * This is the method that will set the edge weight.
	 * 
	 * @param inWeight
	 *            - The amount of time that you would like to set as
	 *            the edge weight.
	 */
	public void setEdgeWeight(int inWeight) {
		this.edgeWeight = inWeight;
	} // End of the 'setEdgeWeight' method

	/**
	 * This is the method for accessing the Attractions object.
	 * 
	 * @return - The Attractions object stored as the neighbor.
	 */
	public Attractions getNeighbor() {
		return this.neighbor;
	} // End of the 'getNeighbor' method

	/**
	 * This is the method for accessing the edge weight of this
	 * neighbor.
	 * 
	 * @return - The amount of time set as the edge weight.
	 */
	public int getEdgeWeight() {
		return this.edgeWeight;
	} // End of the 'getEdgeWeight' method

} // End of the 'Neighbor' class
