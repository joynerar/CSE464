import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * This is the class that will handle the BFS algorithm.
 * 
 * @author Josh Overbeck
 */
public class BFS {

	// Declaring instance variables
	public ArrayList<Attractions>	ridemap;
	private int						time;
	private boolean[]				visited;
	ArrayList<Attractions>			path;

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
		// Queue<Attractions> queue = new LinkedList<Attractions>();
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
			/*
			 * I bet, that this problem could be solved if I give the 
			 * attrations class an attribute  that would account for 
			 * initializing it to enfinity.  Then I could sort the 
			 * queue before pushing it to the path.  Or just change 
			 * it to a priority queue.  
			 */

			// Attractions next = queue.poll();
			//
			// if (path.size() > 1) {
			// ArrayList<Neighbor> prev = path.get(path.size() - 1)
			// .getNeighbors();
			// if (testNeighbors(prev, next) == false) {
			// // System.out.println("not Neighbors");
			// path.remove(path.size() - 1);
			// path.add(next);
			// } else {
			// path.add(next);
			// }
			// } else {
			// path.add(next);
			// }

			path.add(queue.poll());

			// ArrayList<Neighbor> n = path.get(index).getNeighbors();
			ArrayList<Neighbor> n = path.get(path.size() - 1)
					.getNeighbors();

			// sort n
			// Arrays.sort(n);
			// n.sort(n);
			Collections.sort(n);

			for (int i = 0; i < n.size(); i++) {
				int s = getStartingPointIndex(n.get(i).getNeighbor());
				if (visited[s] == false) {
					visited[s] = true;

					// has neighbors
					queue.add(ridemap.get(s));

					if (ridemap.get(s).equals(target)) {
						path.add(ridemap.get(s));
						isDone = true;//
						break;
					}
				}
			}
			// path.add(queue.poll()); // obsolete
			index++;
		}

		// getTime(); // obsolete
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
					time += nTmp.get(n).getEdgeWeight();
				}
			}
		}
		System.out.println("Net Time:\t" + time);
		return time;
	} // End of the 'getTime' method

	private Queue<Neighbor> sortQ(Queue<Neighbor> input) {
		Neighbor[] tmp = new Neighbor[input.size()];
		for (int f = 0; f < tmp.length; f++) {
			tmp[f] = input.poll();
		}

		Arrays.sort(tmp);

		Queue<Neighbor> result = (Queue<Neighbor>) Arrays.asList(tmp);
		return result;

	}

	private boolean neighborsConnected(ArrayList<Neighbor> neighbors,
			Attractions nextPath) {
		boolean result = false;
		for (int i = 0; i < neighbors.size(); i++) {
			if (neighbors.get(i).getNeighbor().equals(nextPath)) {
				result = true;
			}
		}
		return result;
	}

	// private void cleanPath() {
	// ArrayList<Attractions> result = new ArrayList<Attractions>();
	// for (int i = 1; i < path.size(); i++) {
	// ArrayList<Neighbor> currentN = path.get(i).getNeighbors();
	// if(neighborsConnected(currentN, ))
	// }
	// }
} // End of the 'BFS' class
