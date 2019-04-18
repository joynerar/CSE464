import java.util.ArrayList;
import java.util.HashMap;

public class Driver {

	private static boolean hasTime() {

		return false;
	}

	private static Attractions getSmallestNeighbor() {
		return null;
	}

	public static void main(String[] args) {
		IO inout = new IO("map1.txt", "user1.txt", "connect1.txt", "outputfile.txt");
		// Walking directions though the park
		FifoQueue route = new FifoQueue();
		// Total time a user wants to stay at park
		int timeAllotted = inout.getTimeAllotted();
		// Running total of time as the schedule is built
		int totalTime = 0;
		// list of attractions visited
		ArrayList<Attractions> visitedAttractions;
		// The map
		HashMap<String, Attractions> parkMap = inout.getAttractionList();
		HashMap<String, Attractions> userDestinations = inout.getUserPrefs();
		ArrayList<String> mapKeys = inout.getMapKeys();
		ArrayList<String> userDestinationKeys = inout.getUserPrefKeys();
		// Current position for creating schedule
		Attractions currentPosition = parkMap.get("ENTRANCE");
		int rideCounter = 0; // L
		BFS bfs = new BFS();
		Attractions dest = null;
		while (!currentPosition.getName().equals("ENTRANCE")) {
			// Checks if all user prefs have been done yet and theres enough time
			if (bfs.checkTime(timeAllotted - totalTime)) {
				if (rideCounter < userDestinations.size())
					dest = parkMap.get(userDestinations.get(mapKeys.get(rideCounter)));
				else
					dest = getSmallestNeighbor();
			} else {
				dest = parkMap.get("ENTRANCE");
			}

			FifoQueue tmp = bfs.getPath(dest);
			while (tmp.getSize() > 0) {
				route.enqueue(tmp.dequeue());
			}
			currentPosition = dest;
			rideCounter++;
		}
	}
}
