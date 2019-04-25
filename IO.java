import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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
	private ArrayList<String> userPrefKeys;
	private HashMap<String, Attractions> attractionList;
	private ArrayList<String> attractionKeys;
	private int timeAllotted;

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
		attractionKeys = new ArrayList<String>();
		userPrefKeys = new ArrayList<String>();
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
			attractionKeys.add(name);
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
			// Gets attractions from list
			Attractions a1 = attractionList.get(line[0]);
			Attractions a2 = attractionList.get(line[1]);
			int weight = Integer.parseInt(line[2]);
			// Wires in connections
			a1.addNeighbor(a2, weight);
			a2.addNeighbor(a1, weight);

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
		// Gets first line and set its to the totaltime
		timeAllotted = Integer.parseInt(user.nextLine());
		while (user.hasNextLine()) {
			line = user.nextLine();
			userPrefs.put(line, attractionList.get(line));
			userPrefKeys.add(line);
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

	/**
	 * @return the totalTime a user wants to spend in the park
	 */
	public int getTimeAllotted() {
		return timeAllotted;
	}

	/**
	 * 
	 * @return a list of the string keys of the map
	 */
	public ArrayList<String> getMapKeys() {
		return attractionKeys;
	}

	/**
	 * @return the userPrefKeys
	 */
	public ArrayList<String> getUserPrefKeys() {
		return userPrefKeys;
	}

	/**
	 * @return the attractionKeys
	 */
	public ArrayList<String> getAttractionKeys() {
		return attractionKeys;
	}

	// MAIN FOR TESTING
	public static void main(String[] args) {
		IO z = new IO("map2.txt", "user2.txt", "connect2.txt", "outputfile.txt");
		System.out.println(z.getTimeAllotted() / 60 + " hours");
		ArrayList<Neighbor> test = z.attractionList.get("Mad Tea Party").getNeighbors();
	}

}
