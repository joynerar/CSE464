import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * This is the class that will handle the Path algorithm.
 * 
 * @author Josh Overbeck
 */
public class Path {

	// Declaring instance variables
	public ArrayList<Attractions>	ridemap;
	private int						time;
	private boolean[]				visited;
	ArrayList<Attractions>			path;

	// Default Constructor
	public Path(ArrayList<Attractions> map) {
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
		// Queue<Attractions> queue = new LinkedList<Attractions>();
		PriorityQueue<Attractions> queue = new PriorityQueue<Attractions>();

		path = new ArrayList<Attractions>();

		queue.add(currentPos);
		markVisited(currentPos);

		boolean isDone = false;
		time = 0; // reset time

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
		}
		// cleanPath();

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
	 * This is a method that will clean up the global path variable.
	 * It will iterate through the path. It will make sure that all of
	 * the Attractions objects in the path are connected. When there
	 * is one that is not connected, it will be removed from the path.
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

			} else {
				index++;
			}

		}

	} // End of the 'cleanPath' method

} // End of the 'Path' class
