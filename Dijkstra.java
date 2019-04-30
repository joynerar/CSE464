import java.util.ArrayList;
import java.util.PriorityQueue;

public class Dijkstra {
	private ArrayList<Attractions>		map;
	private PriorityQueue<Attractions>	q;
	private ArrayList<Attractions>		path;
	private final int					INF	= 99999;

	public Dijkstra(ArrayList<Attractions> map) {
		this.map = map;
		this.q = new PriorityQueue<Attractions>();
		this.path = new ArrayList<Attractions>();
	} // End of constructor

	public ArrayList<Attractions> getPath(Attractions target,
			Attractions currentPos) {

		currentPos.setVerticeWeight(0);
		q.add(currentPos);

		boolean isDone = false;

		while (!q.isEmpty()) {

			Attractions processedNode = q.poll();
			ArrayList<Neighbor> neighbors = processedNode
					.getNeighbors();
			for (int n = 0; n < neighbors.size(); n++) {

				// Test if done
				if (neighbors.get(n).getNeighbor().equals(target)) {
					path.add(neighbors.get(n).getNeighbor());
					isDone = true;
					break;
				}

				int netCost = -1;
				if (path.size() == 0) {
					netCost = 0;
				} else {
					netCost = path.get(path.size() - 1)
							.getVerticeWeight();
				}

				int edgeWeight = neighbors.get(n).getEdgeWeight();
				int adjustedCost = netCost + edgeWeight;
				Attractions current = neighbors.get(n).getNeighbor();
				if (!path.contains(current)) {
					if (adjustedCost < current.getVerticeWeight()) {
						current.setVerticeWeight(adjustedCost);
						q.add(current);
					}
				}
			} // inner loop

			// Test if done
			if (isDone) {
				break;
			}

			path.add(processedNode);

		} // outer loop

		//
		return path;
	} // End of the 'getPath' method

} // end of the 'Dijkstra' class
