import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class IO {
	HashMap<String, Attractions> userPrefs;
	// ArrayList<Attractions> attractionList;
	HashMap<String, Attractions> attractionList;

	public IO(String mapSRC, String userSRC, String connectionSRC, String outSRC) {
		userPrefs = new HashMap<String, Attractions>();
		attractionList = new HashMap<String, Attractions>();
		createRideMap(mapSRC, connectionSRC, userSRC);

	}

	private void createRideMap(String mapSRC, String connectionSRC, String userSRC) {
		try {
			loadRides(mapSRC);
			loadConnections(connectionSRC);
			getUserPrefs(userSRC);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void loadRides(String mapSRC) throws FileNotFoundException {
		String[] line;

		Scanner map = new Scanner(new File(mapSRC));
		map.nextLine();
		while (map.hasNextLine()) {
			// Gets line and splits on tabs
			line = map.nextLine().split("\t");

			// parses first part of line
			String name = line[0];
			int waitTime = Integer.parseInt(line[1]);
			int rideTime = Integer.parseInt(line[2]);

			// Adds Attraction to IO list
			attractionList.put(name, new Attractions(name, waitTime, rideTime));
		}
		map.close();
	}

	// Adds connections
	private void loadConnections(String connectionSRC) throws FileNotFoundException {
		String[] line;

		Scanner connect = new Scanner(new File(connectionSRC));
		connect.nextLine();
		while (connect.hasNextLine()) {
			// Gets line and splits on tabs
			line = connect.nextLine().split("\t");
			Attractions a = attractionList.get(line[0]);
			for (int i = 2; i < line.length; i++) {
				a.addNeighbor(attractionList.get(line[i]), Integer.parseInt(line[++i]));
			}
		}
		connect.close();
	}

	private void getUserPrefs(String userSRC) throws FileNotFoundException {
		Scanner user = new Scanner(new File(userSRC));
		String line = "";
		while (user.hasNextLine()) {
			line = user.nextLine();
			userPrefs.put(line, attractionList.get(line));
		}
		user.close();
	}

	public static void main(String[] args) {
		IO z = new IO("map1.txt", "user1.txt", "connect1.txt", "outputfile.txt");
	}
}
