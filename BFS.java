/**
 * This is the class that will handle the BFS algorithm.
 * 
 * @author Josh Overbeck
 */
public class BFS {

	// Declaring instance variables
	Attractions[][]	ridemap;
	Attractions		target;	// obsolete

	boolean[] visited;

	// Default Constructor
	public BFS() {

	} // End of the Default Constructor

	public Queue getPath(Attractions target) {
		// FifoQueue que = new FifoQueue();
		Queue que = new Queue();
		///////
		// Initializing the queue and the time variables

		time = 0;
		// int startingPoint = getStartingPointIndex(currentPos);
		// int index = getStartingPointIndex(currentPos);
		Attractions[] path = new Attractions[ridemap.size()];

		que.enqueue(target);
		markVisited(target);

		int index = 0;

		while (que.getSize() > 0) {
			path[index] = que.dequeue();
			for (int i = 0; i < ridemap.get(index).getNeighbors()
					.size(); i++) {
				if (!ridemap.get(i + index).isVisited()) {
					ridemap.get(i + index).setVisited(true);
					queue.enqueue(ridemap.get(index + i));
					if (ridemap.get(index + i).equals(target)) {
						break;
					}
				}
			}

			index++;
		}

		// return queue;
		return path;

		///////
		return que;
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
