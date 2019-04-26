import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Driver {
	static BFS bfs;

	private static ArrayList<Attractions> checkRouteToDest(
			Attractions current, Attractions destination,
			int timeRemaining, BFS bfs) {
		ArrayList<Attractions> routeToNext = bfs.getPath(destination,
				current);
		int routeToNextTime = bfs.getTime();

		if (routeToNextTime < timeRemaining) {
			bfs.getPath(destination, bfs.ridemap.get(0));
			int timeToExit = bfs.getTime();
			if (routeToNextTime + timeToExit < timeRemaining) {
				return routeToNext;
			}
		}
		return new ArrayList<Attractions>();
	}

	private static Attractions getSmallestNeighbor(
			Queue<Attractions> route, Attractions currentPosition,
			int timeRemaining) {
		ArrayList<Neighbor> currentNeighbors = currentPosition
				.getNeighbors();
		ArrayList<Attractions> restOfMap = bfs.ridemap;

		// Gets intersection of path and map
		for (Attractions a : route)
			if (restOfMap.contains(a))
				restOfMap.remove(a);

		// Sort remaining attractions by waitTime
		restOfMap
				.sort(Comparator.comparing(Attractions::getWaitTime));

		return restOfMap.get(0);
	}

	public static void main(String[] args) {
		IO inout = new IO("map2.txt", "user2.txt", "connect2.txt",
				"outputfile.txt");
		// Walking directions though the park
		Queue<Attractions> route = new LinkedList<Attractions>();
		// Total time a user wants to stay at park
		int timeAllotted = inout.getTimeAllotted();
		// Running total of time as the schedule is built
		int totalTime = 0;
		// list of attractions visited
		ArrayList<Attractions> visitedAttractions = null;
		// The map
		HashMap<String, Attractions> parkMap = inout
				.getAttractionList();
		HashMap<String, Attractions> userDestinations = inout
				.getUserPrefs();
		ArrayList<String> mapKeys = inout.getMapKeys();
		ArrayList<String> userDestinationKeys = inout
				.getUserPrefKeys();
		// Current position for creating schedule
		Attractions currentPosition = parkMap.get("ENTRANCE");
		int rideCounter = 0; // L
		bfs = new BFS(new ArrayList<Attractions>(parkMap.values()));
		Attractions dest = null;
		int remainingTime = 0;

		ArrayList<Attractions> map = new ArrayList<Attractions>(
				parkMap.values());
		map.sort(Comparator.comparing(Attractions::getName));

		for (int i = 0; i < map.size(); i++) {
			String output = new String();
			output = "";

			output += "name: " + map.get(i).getName();
			output += "\twaitTime: " + map.get(i).getWaitTime();
			output += "\trideTime: " + map.get(i).getRideTime();
			output += "\nNeighbors: ";
			ArrayList<Neighbor> neighbors = map.get(i).getNeighbors();
			for (int n = 0; n < neighbors.size(); n++) {
				output += "\t"
						+ neighbors.get(n).getNeighbor().getName();
				//
				output += "\t" + neighbors.get(n).getEdgeWeight()
						+ "\n";
			}
			output += "\n";
			System.out.println(output);

		}

		/////

		ArrayList<Attractions> one = bfs.getPath(
				parkMap.get("Mad Tea Party"),
				parkMap.get("ENTRANCE"));

		for (int o = 0; o < one.size(); o++) {
			if (one.get(o) != null) {
				System.out.println(one.get(o).getName());

			}
		}
		////

		while (!currentPosition.getName().equals("ENTRANCE")) {

			remainingTime = timeAllotted - totalTime;

			// Checks if all user prefs have been done yet and theres
			// enough time
			/*
			 * if (hasTime()) { if (rideCounter < userDestinations.size()) dest =
			 * parkMap.get(userDestinations.get(mapKeys.get(rideCounter))); else dest =
			 * getSmallestNeighbor(); } else { dest = parkMap.get("ENTRANCE"); }
			 */

			if (rideCounter < userDestinations.size()) {
				dest = parkMap.get(userDestinations
						.get(mapKeys.get(rideCounter)));
			} else {
				dest = getSmallestNeighbor(route, dest,
						remainingTime);
			}
			ArrayList<Attractions> routeToDest = checkRouteToDest(
					currentPosition, dest, remainingTime, bfs);
			if (routeToDest.size() == 0) {
				dest = parkMap.get("ENTRANCE");
				bfs.getPath(currentPosition, bfs.ridemap.get(0));
			}

			for (int i = 1; i < routeToDest.size(); i++)
				route.add(routeToDest.get(i));

			totalTime += bfs.getTime();
			currentPosition = dest;
			rideCounter++;
		}

	}
}
