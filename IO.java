import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class IO {
	ArrayList<String> userPrefs;
	ArrayList<Attractions> attractionList;

	public IO(String mapSRC, String userSRC, String outSRC) {
		userPrefs = new ArrayList<String>();
		attractionList = new ArrayList<Attractions>();
		try {
			createRideMap(mapSRC);
			getUserPrefs(userSRC);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void getUserPrefs(String userSRC) throws FileNotFoundException {
		Scanner user = new Scanner(new File(userSRC));
		while (user.hasNextLine())
			userPrefs.add(user.nextLine());
		user.close();
	}

	private void createRideMap(String mapSRC) throws FileNotFoundException {
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

			// Creates new Attractions object
			Attractions a = new Attractions(name, waitTime, rideTime);

			// Adds Attractions to neighbors list
			for (int i = 3; i < line.length; i++) {
				a.addNeighbor(new Attractions(line[i]), Integer.parseInt(line[++i]));
			}

			// Adds Attraction to IO list
			attractionList.add(a);
		}
		map.close();
	}

	public static void main(String[] args) {
		IO z = new IO("map1.txt", "user1.txt", "w");
	}
}
