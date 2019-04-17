import static org.junit.jupiter.api.Assertions.assertNotNull;

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

} // End of the 'AttractionsTest' method
