import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * This is the class that will handle the Search algorithm.
 * 
 * @author Josh Overbeck
 */
public class Search {

	// Declaring instance variables
	public ArrayList<Attractions>	ridemap;
	private int						time;
	private boolean[]				visited;
	ArrayList<Attractions>			path;

	// Default Constructor
	public Search(ArrayList<Attractions> map) {
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
		// Set weight of starting point to zero
		currentPos.setVerticeWeight(0);

		PriorityQueue<Attractions> queue = new PriorityQueue<Attractions>();

		time = 0;
		path = new ArrayList<Attractions>();

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

			ArrayList<Neighbor> n = path.get(path.size() - 1)
					.getNeighbors();

			for (int i = 0; i < n.size(); i++) {
				int s = getStartingPointIndex(n.get(i).getNeighbor());
				if (visited[s] == false) {
					visited[s] = true;

					Collections.sort(n);

					// has neighbors
					queue.add(ridemap.get(s));

					if (ridemap.get(s).equals(target)) {
						path.add(ridemap.get(s));
						isDone = true;//
						break;
					}
				}
			}

			index++;
		}
		cleanPath();

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

	/**
	 * This is the method that will make a vertex as being visited.
	 * 
	 * @param current
	 *            - The current location that you would like to mark
	 *            as visited.
	 */
	private void markVisited(Attractions current) {

		for (int i = 0; i < ridemap.size(); i++) {
			if (ridemap.get(i).equals(current)) {
				visited[i] = true;
			}
		}
	} // End of the 'markVisited' method

	/**
	 * This is the method for getting the time. It must be called
	 * after running the 'getPath' method.
	 * 
	 * @return The time it takes to travel from the start point to the
	 *         end point.
	 */
	public int getTime() {

		time = 0;
		// loop path
		for (int i = 0; i < path.size(); i++) {

			ArrayList<Neighbor> nTmp = path.get(i).getNeighbors();
			Attractions next;

			if (i < path.size() - 1) {
				next = path.get(i + 1);
			} else {
				next = path.get(i);
			}

			// loop neighbors of current index in path
			for (int n = 0; n < nTmp.size(); n++) {
				if (next.equals(nTmp.get(n).getNeighbor())) {
					int adj = nTmp.get(n).getEdgeWeight();
					System.out.println(adj);
					time += adj;
				}
			}
		}

		return time;
	} // End of the 'getTime' method

	/**
	 * This method will remove any vertice that is not directly
	 * connected to the previous node in the path.
	 */
	private void cleanPath() {
		int count = path.size();
		int index = 0;
		for (int i = 0; i < count - 1; i++) {
			boolean connected = false;
			ArrayList<Neighbor> n = path.get(index).getNeighbors();
			for (int z = 0; z < n.size(); z++) {
				Attractions current = n.get(z).getNeighbor();
				if (current.equals(path.get(index + 1))) {
					connected = true;
					break;
				}
			}
			if (!connected) {
				path.remove(index);
				// index--;
			} else {
				index++;
			}

		}

	} // End of the 'cleanPath' method

} // End of the 'Search' class
