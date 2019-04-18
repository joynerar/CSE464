/**
 * @author Josh Overbeck
 */
public class FifoQueue {

	// Default constructor
	public FifoQueue() {

	} // End of the Default Constructor

	/**
	 * A nested class to allow for node programming.
	 * 
	 * @author Josh Overbeck
	 */
	class Node {

		// Declaring instance variables
		Node		left;
		Node		right;
		Attractions	data;

		// Default Constructor
		public Node() {
			// Initializing the instance variables
			left = null;
			right = null;
			data = new Attractions();
		} // End of the Default constructor

		// Overriding the Default Constructor
		public Node(Attractions input) {
			// Initializing the instance variables
			left = null;
			right = null;
			data = input;
		} // End of the Override Default constructor

	} // End of the 'Node' class

} // End of the 'FifoQueue' class
