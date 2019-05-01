import java.util.ArrayList;
import java.util.HashMap;

public class Dr2 {
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

		for (int i = 0; i < usrPref.size(); i++) {

			if (i == 0) {
				origin = parkMap.get("ENTRANCE");
				dest = usrPref.get(i);
			} else {
				origin = dest;
				dest = usrPref.get(i);
			}

			path.addAll(bfs.getPath(dest, origin));
		} // End loop

		for (Attractions a : path) {
			System.out.println(a.toString());
		}

	} // End of the 'buildPath' method

} // End of the 'Dr2' class
