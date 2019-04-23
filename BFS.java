import java.util.ArrayList;

/**
 * This is the class that will handle the BFS algorithm.
 * 
 * @author Josh Overbeck
 */
public class BFS {

	// Declaring instance variables
	private ArrayList<Attractions>	ridemap;
	private Attractions				target;						// obsolete
	private FifoQueue				queue;
	private final String			ENTRANCE	= "ENTRANCE";	// obsolete
	private double					time;
	private boolean[]				visited;

	// Default Constructor
	public BFS() {
		// Initializing the instance variables
		this.ridemap = new ArrayList<Attractions>();
		this.target = new Attractions();
		this.time = 0;
		initVisitedList();
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
		// Initializing the queue and the time variables
		queue = new FifoQueue();
		time = 0;
		int startingPoint = getStartingPointIndex(currentPos);
		Attractions[] path = new Attractions[ridemap.size()];

		// for (int i = 0; i < ridemap.size(); i++) {
		//
		// int index = (startingPoint + i) % ridemap.size();
		// if (!ridemap.get(index).isVisited()) {
		//
		// }
		// }

		queue.enqueue(target);
		markVisited(target);

		int index = 0;

		while (queue.getSize() > 0) {
			path[index] = queue.dequeue();
			for (int i = 0; i < ridemap.get(index).getNeighbors()
					.size(); i++) {
				if (!ridemap.get(i + index).isVisited()) {
					ridemap.get(i + index).setVisited(true);
					queue.enqueue(ridemap.get(index + i));
				}
			}

			index++;
		}

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
	public boolean checkTime(int remainingTime) {////////// incomplete
		boolean result = false;
		return result;
	} // End of the 'checkTime' method

	/**
	 * A private helper method to initialize the visited list. They
	 * are all initialized to false by default.
	 */
	private void initVisitedList() {
		for (int i = 0; i < visited.length; i++) {
			ridemap.get(i).resetVisited();
		}
	} // End of the 'initVisitedList' method

	/**
	 * This is the method that will return the index of the neighbor
	 * with the lowest edge weight.
	 * 
	 * @param neighbors
	 *            - The list of neighbors.
	 * @return - The index of the neighbor with the lowest edge
	 *         weight.
	 */
	private int extractMin(ArrayList<Neighbor> neighbors) {
		int index = 0;
		int min = neighbors.get(index).getEdgeWeight();

		for (int i = 1; i < neighbors.size(); i++) {
			if (!(neighbors.get(i).getNeighbor().isVisited())) {
				if (neighbors.get(i).getEdgeWeight() < min) {
					min = neighbors.get(i).getEdgeWeight();
					index = i;
				}
			}
		}
		return index;
	} // End of the 'extractMin' method

	/**
	 * This is a private helper method that will find the index of the
	 * current position from the ridemap list.
	 * 
	 * @param root
	 *            - The Attractions object that represents the
	 *            starting point from within the map.
	 * @return - The index of the starting point from within the
	 *         ridemap list.
	 */
	private int getStartingPointIndex(Attractions root) {
		int result = -99999;
		for (int i = 0; i < ridemap.size(); i++) {
			if (ridemap.get(i).equals(root)) {
				result = i;
			}
		}
		return result;
	} // End of the 'getStartingPointIndex'method

	private void markVisited(Attractions current) {
		for (int i = 0; i < ridemap.size(); i++) {
			if (ridemap.get(i).equals(current)) {
				ridemap.get(i).setVisited(true);
			}
		}
	}

} // End of the 'BFS' class
