import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * This is the class that will handle the BFS algorithm.
 * 
 * @author Josh Overbeck
 */
public class BFS {

	// Declaring instance variables
	private ArrayList<Attractions> ridemap;
	// private Attractions target; // obsolete
	// private FifoQueue queue; // obsolete
	// private final String ENTRANCE = "ENTRANCE"; // obsolete
	private int			time;
	private boolean[]	visited;

	// Default Constructor
	public BFS(ArrayList<Attractions> map) {
		// Initializing the instance variables
		this.ridemap = map;
		this.time = 0;
		initVisitedList();
	} // End of the Default Constructor

	/**
	 * This is the method that will get the path to the desired
	 * Attraction. It requires the target and the starting point.
	 * 
	 * @param target
	 *            - The desired ride that the user would like to visit
	 *            next.
	 * @param currentPos
	 *            - The starting point of where the user is at
	 *            currently.
	 * @return - The path to the target in the form of an array list
	 *         of Attractions.
	 */
	public ArrayList<Attractions> getPath(Attractions target,
			Attractions currentPos) {
		// Initializing the queue and the time variables
		initVisitedList();
		Queue<Attractions> queue = new LinkedList<Attractions>();

		time = 0;

		// Attractions[] path = new Attractions[ridemap.size()];
		ArrayList<Attractions> path = new ArrayList<Attractions>();

		queue.add(currentPos);
		markVisited(currentPos);

		boolean isDone = false;
		time = 0; // reset time
		int index = 0;

		while (!queue.isEmpty()) {
			if (isDone) {
				break;
			}
			path.add(queue.poll());
			ArrayList<Neighbor> n = ridemap.get(index).getNeighbors();
			for (int i = 0; i < n.size(); i++) {
				int s = getStartingPointIndex(n.get(i).getNeighbor());
				if (visited[s] == false) {
					visited[s] = true;
					if (!ridemap.get(s).getNeighbors().isEmpty()) {
						// has neighbors
						queue.add(ridemap.get(s));
						// concat time
						time += n.get(i).getEdgeWeight();
						System.out.println("Tiem:\t" + time);
					}
					if (ridemap.get(s).equals(target)) {
						System.out.println("made it here");
						path.add(ridemap.get(s));
						isDone = true;//
						// concat time
						time += n.get(i).getEdgeWeight();
						System.out.println("Tiem:\t" + time);
						break;
					}
				}
			}
			index++;
		}
		return path;
	} // End of the 'getPath' method

	/**
	 * A private helper method to initialize the visited list. They
	 * are all initialized to false by default.
	 */
	private void initVisitedList() {
		visited = new boolean[ridemap.size()];
		for (int i = 0; i < visited.length; i++) {
			visited[i] = false;
		}
	} // End of the 'initVisitedList' method

	/**
	 * This is the method that will reset the states of all the items
	 * in the visited array.
	 */
	private void resetVisitedList() {
		initVisitedList();
	} // End of the 'resetVisitedList' method

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
				visited[i] = true;
			}
		}
	}

	private boolean isVisited(int index) {
		return visited[index];
	}

	/**
	 * This is the method for getting the time. It must be called
	 * after running the 'getPath' method.
	 * 
	 * @return The time it takes to travel from the start point to the
	 *         end point.
	 */
	public int getTime() {
		return time;
	} // End of the 'getTime' method

} // End of the 'BFS' class
