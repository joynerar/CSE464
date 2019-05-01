import java.util.ArrayList;
import java.util.HashMap;

public class Dr2 {
	// Instance variables
	static BFS							bfs;
	static IO							io;
	static HashMap<String, Attractions>	parkMap;
	static HashMap<String, Attractions>	userDestinations;
	static ArrayList<Attractions>		map;

	// main method
	public static void main(String[] args) {
		// Initialize instance variables
		io = new IO("map2.txt", "user2.txt", "connect2.txt",
				"outputfile.txt");
		parkMap = io.getAttractionList();
		userDestinations = io.getUserPrefs();
		map = new ArrayList<Attractions>(parkMap.values());
		bfs = new BFS(map);

		System.out.println("So far so good");

	} // End of the 'main' method

} // End of the 'Dr2' class
