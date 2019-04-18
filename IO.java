import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Adam Joyner
 * @version 1.0
 * @since 4/18/2019
 */

public class IO {
	// ========================================================= Properties
	private HashMap<String, Attractions> userPrefs;
	private HashMap<String, Attractions> attractionList;

	// ========================================================= Constructors

	/**
	 * Creates an IO which contains user preference list and attraction list
	 * 
	 * @param attractionSRC
	 *            the Source Path of Attraction List
	 * @param userSRC
	 *            the Source Path of the user preference List
	 * @param connectionSRC
	 *            the Source Path of the list of connections
	 * @param outSRC
	 *            the path for the output file
	 * 
	 */
	public IO(String attractionSRC, String userSRC, String connectionSRC, String outSRC) {
		userPrefs = new HashMap<String, Attractions>();
		attractionList = new HashMap<String, Attractions>();
		createRideMap(attractionSRC, connectionSRC, userSRC);
	} // end Constructor

	// ========================================================= Methods

	/**
	 * Helper function for creating ride map
	 * 
	 * @author Adam J
	 * 
	 * @param attractionSRC
	 *            the Source Path of Attraction List
	 * @param userSRC
	 *            the Source Path of the user preference List
	 * @param connectionSRC
	 *            the Source Path of the list of connections
	 * @return void
	 */
	private void createRideMap(String attractionSRC, String connectionSRC, String userSRC) {
		try {
			loadRides(attractionSRC);
			loadConnections(connectionSRC);
			getUserPrefs(userSRC);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	} // end createRideMap

	/**
	 * Loads list of rides from attractionSRC file into attraction list.
	 * 
	 * @author Adam J
	 * 
	 * @param attractionSRC
	 * @throws FileNotFoundException
	 *             on file not found
	 * @return void
	 */
	private void loadRides(String attractionSRC) throws FileNotFoundException {
		String[] line;
		Scanner map = new Scanner(new File(attractionSRC));
		// skips first line
		map.nextLine();
		while (map.hasNextLine()) {

			// Gets line and splits on tabs
			line = map.nextLine().split("\t");

			// Pulls data from line
			String name = line[0];
			int waitTime = Integer.parseInt(line[1]);
			int rideTime = Integer.parseInt(line[2]);

			// Adds Attraction to IO list
			attractionList.put(name, new Attractions(name, waitTime, rideTime));
		}
		map.close(); // Closes Scanner
	} // end loadRides

	/**
	 * Wires connections between attractions
	 * 
	 * @author Adam J
	 * 
	 * @param connectionSRC
	 * @throws FileNotFoundException
	 *             on file not found
	 * @return void
	 */
	private void loadConnections(String connectionSRC) throws FileNotFoundException {
		String[] line;
		Scanner connect = new Scanner(new File(connectionSRC));

		// Skips first line
		connect.nextLine();

		while (connect.hasNextLine()) {
			// Gets line and splits on tabs
			line = connect.nextLine().split("\t");
			// Gets attraction from list
			Attractions a = attractionList.get(line[0]);
			// Wires in connections
			for (int i = 1; i < line.length; i++) {
				a.addNeighbor(attractionList.get(line[i]), Integer.parseInt(line[++i]));
			}
		}
		connect.close(); // Closes Scanner
	} // end loadConnection

	/**
	 * Loads user preferences from userSRC file and stores them in userPers
	 * 
	 * @author Adam J
	 * 
	 * @param userSRC
	 * @throws FileNotFoundException
	 *             on file not found
	 * @return void
	 */
	private void getUserPrefs(String userSRC) throws FileNotFoundException {
		Scanner user = new Scanner(new File(userSRC));
		String line = "";

		while (user.hasNextLine()) {
			line = user.nextLine();
			userPrefs.put(line, attractionList.get(line));
		}
		user.close();
	} // end getUserPrefs

	// ======================================================== Getters

	/**
	 * Gets the list of user preferences list
	 * 
	 * @return the user preferences list
	 */
	public HashMap<String, Attractions> getUserPrefs() {
		return userPrefs;
	}

	/**
	 * @return the list of attractions
	 */
	public HashMap<String, Attractions> getAttractionList() {
		return attractionList;
	}

	// MAIN FOR TESTING
	public static void main(String[] args) {
		IO z = new IO("map1.txt", "user1.txt", "connect1.txt", "outputfile.txt");
	}
}
