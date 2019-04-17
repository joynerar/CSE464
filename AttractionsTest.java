import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.HashMap;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Josh Overbeck
 */
class AttractionsTest {

	// Declaring instance variables
	Attractions destination;

	@BeforeEach
	void setUp() throws Exception {
		destination = new Attractions();
	} // End of the 'setUp' method

	@AfterEach
	void tearDown() throws Exception {
		destination = null;
	} // End of the 'tearDown' method

	@Test
	void basicTest() {
		destination = new Attractions();
		assertNotNull(destination);
	} // End of the 'basicTest' method

	@Test
	void getNameTest() {
		String name = "beast";
		destination.setName(name);
		assertEquals(name, destination.getName());
	} // End of the 'getNameTest' method

	@Test
	void getWaitTimeTest() {
		int expectedWaitTime = 15;
		destination.setWaitTime(expectedWaitTime);
		assertEquals(expectedWaitTime, destination.getWaitTime());
	} // End of the 'getWaitTimeTest' method

	@Test
	void getRideTimeTest() {
		int expectedRideTime = 15;
		destination.setWaitTime(expectedRideTime);
		assertEquals(expectedRideTime, destination.getRideTime());
	} // End of the 'expectedRideTime' method

	@Test
	void getNeighborsTest() {

		// Creating a HashMap of neighbors
		HashMap<Attractions, Integer> expectedNeighbors = new HashMap();

		// Creating a neighbor
		Attractions neighbor = new Attractions();
		neighbor.setName("ironMan");
		neighbor.setRideTime(15);
		neighbor.setWaitTime(25);

		// Adding the neighbor to 'expectedNeighbors'
		expectedNeighbors.put(neighbor, 5);
		// Adding the neighbor to 'destination'
		destination.addNeighbor(neighbor, 5);

		assertEquals(expectedNeighbors, destination.getNeighbors());
	} // End of the 'getNeighborsTest' method

} // End of the 'AttractionsTest' method
