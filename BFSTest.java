import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This is the class that will test the BFS class.
 * 
 * @author Josh Overbeck
 */
class BFSTest {

	ArrayList<Attractions>	map;
	BFS						bfs;

	@BeforeAll
	void init() {
		// This map will be global and will only be initialized once
		new ArrayList<Attractions>();
		initMap();
	} // End of the 'init' method

	@BeforeEach
	void setUp() throws Exception {
		bfs = new BFS();

	} // End of the 'setUp' method

	@AfterEach
	void tearDown() throws Exception {
		bfs = null;
	} // End of the 'tearDown' method

	@Test
	void testBFS() {
		System.out.println("first");
		new ArrayList<Attractions>();
		initMap();
		// fail("Not yet implemented");
	} // End of the 'testBFS' method

	@Test
	void testGetPath() {
		fail("Not yet implemented");
	} // End of the 'testGetPath' method

	@Test
	void testCheckTime() {
		fail("Not yet implemented");
	} // End of the 'testCheckTime' method

	/**
	 * This method will only be run once. It will populate the map
	 * with data.
	 */
	public void initMap() {

		System.out.println("why");
		Attractions attraction1 = new Attractions();
		Attractions attraction2 = new Attractions();
		Attractions attraction3 = new Attractions();
		Attractions attraction4 = new Attractions();
		Attractions attraction5 = new Attractions();

		attraction1.setName("1");
		attraction1.setWaitTime(5);
		attraction1.setRideTime(8);

		attraction2.setName("2");
		attraction2.setWaitTime(4);
		attraction2.setRideTime(3);

		attraction3.setName("3");
		attraction3.setWaitTime(10);
		attraction3.setRideTime(2);

		attraction4.setName("4");
		attraction4.setWaitTime(20);
		attraction4.setRideTime(1);

		attraction5.setName("5");
		attraction5.setWaitTime(45);
		attraction5.setRideTime(2);

		attraction1.addNeighbor(attraction2, 1);
		attraction1.addNeighbor(attraction3, 2);
		attraction1.addNeighbor(attraction4, 3);

		map.add(attraction1);
		map.add(attraction2);
		map.add(attraction3);
		map.add(attraction4);
		map.add(attraction5);

		// Sanity check
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
			}
			output += "\n";
			System.out.println(output);
		}

	} // End of the 'initMap' method

} // End of the 'BFSTest' class
