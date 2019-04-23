/**
 * This is the class that will handle the BFS algorithm.
 * 
 * @author Josh Overbeck
 */
public class BFS {

	// Declaring instance variables
	private Attractions[][]	ridemap;
	private Attractions		target;						// obsolete
	private FifoQueue		queue;
	private final String	ENTRANCE	= "ENTRANCE";
	private double			time;

	// Default Constructor
	public BFS() {
		// Initializing the instance variables
		this.ridemap = new Attractions[10][10];
		this.target = new Attractions();
		this.time = 0;
	} // End of the Default Constructor

	/**
	 * This is the method that will find the path to the supplied
	 * target. It will perform a breadth first search. The wait time
	 * and ride time of each of the vertices along the path will be
	 * ignored. Only the edge weights will be considered along the
	 * path.
	 * 
	 * @param target
	 *            - The Attraction that you are looking for.
	 * @param currentPos
	 *            - The Attractions that you are currently at.
	 * @param remainingTime
	 *            - The amount of time that you have remaining.
	 * @return - The fifo queue containing the path to the target
	 *         Attraction.
	 */
	public FifoQueue getPath(Attractions target,
			Attractions currentPos, double remainingTime) {
		// Initializing the queue
		queue = new FifoQueue();

		return queue;
	} // End of the 'getPath' method

	/**
	 * This is the method that will check to see if there is enough
	 * time left to go to the next Destination. It will return true if
	 * and only if there is enough time to visit the next destination
	 * and make it to the exit. Otherwise, it will return false.
	 * 
	 * @param remainingTime
	 *            - Input of the the amount of time remaining.
	 * @return - True if and only if the amount of remaining time is
	 *         greater than or equal to the amount of time that it
	 *         would take to get from the current Attractions object,
	 *         to the exit. Otherwise it will return false.
	 */
	public boolean checkTime(int remainingTime) {
		boolean result = false;
		return result;
	} // End of the 'checkTime' method

} // End of the 'BFS' class
