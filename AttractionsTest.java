import static org.junit.jupiter.api.Assertions.fail;

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
	void test() {
		fail("Not yet implemented");
	} // End of the 'test' method

} // End of the 'AttractionsTest' method
