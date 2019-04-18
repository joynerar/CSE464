/**
 * @author Josh Overbeck
 */
public class FifoQueue {

	// Declaring instance variables
	private Node head;
	private Node tail;
	private int size;

	// Default constructor
	public FifoQueue() {
		// Initializing instance variables
		head = new Node();
		tail = head;
		size = 0;
	} // End of the Default Constructor

	/**
	 * This is the method that will add a new Attractions object to the queue.
	 * 
	 * @param input
	 *            - The Attractions object that you want to add to the end of the
	 *            queue.
	 */
	public void enqueue(Attractions input) {
		Node tmp = new Node(input);
		if (head.equals(tail)) {
			head.setRight(tmp);
			tail = head.getRight();
		} else {
			tail.setRight(tmp);
			tail = tail.getRight();
		}
		size++;
	} // End of the 'enqueue' method

	/**
	 * This is the method that will return the Attractions object at the front of
	 * the queue.
	 * 
	 * @return - The Attractions object at the front of the queue.
	 */
	public Attractions dequeue() {
		Node tmp = head;
		if (head.equals(tail)) {
			head = null;
		} else {
			head = head.getRight();
		}
		return tmp.getData();
	} // End of the 'dequeue' method

	/**
	 * This is the method that will allow you to peek at the first node in the
	 * queue.
	 * 
	 * @return - The Attractions object associated with the first Node in the queue.
	 */
	public Attractions peek() {
		return head.getData();
	} // End of the 'peek' method

	// ****************** Node Class *********************************

	/**
	 * A nested class to allow for node programming.
	 * 
	 * @author Josh Overbeck
	 */
	class Node {

		// Declaring instance variables
		Node left;
		Node right;
		Attractions data;

		// Default Constructor
		public Node() {
			// Initializing the instance variables
			this.left = null;
			this.right = null;
			this.data = new Attractions();
		} // End of the Default constructor

		// Overriding the Default Constructor
		public Node(Attractions input) {
			// Initializing the instance variables
			this.left = null;
			this.right = null;
			this.data = input;
		} // End of the Override Default constructor

		// *********************** Setters ***************************

		/**
		 * This is the method that will set the pointer of the node to the left node.
		 * 
		 * @param input
		 *            - The node on the left that will be pointed to by the 'left'
		 *            pointer.
		 */
		public void setLeft(Node input) {
			this.left = input;
		} // End of the 'setLeft' method

		/**
		 * This is the method that will set the pointer of the node to the right node.
		 * 
		 * @param input
		 *            - The node on the right that will be pointed to by the 'right'
		 *            pointer.
		 */
		public void setRight(Node input) {
			this.right = input;
		} // End of the 'setRight' method

		/**
		 * This is the method that will set the data associated with this node.
		 * 
		 * @param input
		 *            - The data that you want to associate with this node.
		 */
		public void setData(Attractions input) {
			this.data = input;
		} // End of the 'setData' method

		// *********************** Getters ***************************

		/**
		 * This is the method for retrieving the node to the left of this node.
		 * 
		 * @return - The node to the left.
		 */
		public Node getLeft() {
			return this.left;
		} // End of the 'getLeft' method

		/**
		 * This is the method for retrieving the node to the right of this node.
		 * 
		 * @return - The node to the right.
		 */
		public Node getRight() {
			return this.right;
		} // End of the 'getRight' method

		/**
		 * This is the method for retrieving the data associated with this node.
		 * 
		 * @return - The data associated with this node.
		 */
		public Attractions getData() {
			return this.data;
		} // End of the 'getData' method

	} // End of the 'Node' class

	public int getSize() {
		// TODO Auto-generated method stub
		return 0;
	}

} // End of the 'FifoQueue' class
