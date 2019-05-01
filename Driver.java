import java.util.ArrayList;
import java.util.HashMap;

public class Driver {
	// Instance variables
	static BFS							bfs;
	static IO							io;
	static HashMap<String, Attractions>	parkMap;
	static HashMap<String, Attractions>	userDestinations;
	static ArrayList<Attractions>		map;
	static ArrayList<Attractions>		usrPref;

	static ArrayList<Attractions> path;

	// main method
	public static void main(String[] args) {
		// Initialize instance variables
		io = new IO("map2.txt", "user2.txt", "connect2.txt",
				"outputfile.txt");
		parkMap = io.getAttractionList();
		userDestinations = io.getUserPrefs();
		map = new ArrayList<Attractions>(parkMap.values());
		usrPref = new ArrayList<Attractions>(
				userDestinations.values());
		bfs = new BFS(map);

		path = new ArrayList<Attractions>();

		/////////////////////
		buildPath();

	} // End of the 'main' method

	/**
	 * Method used for building the path for the user to follow.
	 */
	private static void buildPath() {
		Attractions origin = new Attractions();
		Attractions dest = new Attractions();

		// loop through user preferences
		for (int i = 0; i < usrPref.size(); i++) {

			// initialize origin and dest
			if (i == 0) {
				origin = parkMap.get("ENTRANCE");
				dest = usrPref.get(i);
			} else {
				origin = dest;
				dest = usrPref.get(i);
			}

			// get the path
			ArrayList<Attractions> returnedPath = bfs.getPath(dest,
					origin);

			// remove first Attractions object from path on every
			// iteration ACCEPT for the first iteration
			if (i > 0) {
				returnedPath.remove(0);
			}

			// Concatenate the path to the global path
			path.addAll(returnedPath);
		} // End loop

		// Print for testing
		for (Attractions a : path) {
			System.out.println(a.toString());
		}

	} // End of the 'buildPath' method

} // End of the 'Driver' class
