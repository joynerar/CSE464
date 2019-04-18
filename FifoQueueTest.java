import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This is the Junit test class for the FifoQueue class file.
 * 
 * @author Josh Overbeck
 */
class FifoQueueTest {

	// Declaring an instance variable
	FifoQueue fifo;

	@BeforeEach
	void setUp() throws Exception {
		fifo = new FifoQueue();
	} // End of the 'setUp' method

	@AfterEach
	void tearDown() throws Exception {
		fifo = null;
	} // End of the 'tearDown' method

	@Test
	void testFifoQueue() {
		fail("Not yet implemented");
	} // End of the 'testFifoQueue' method

	@Test
	void testEnqueue() {
		fail("Not yet implemented");
	} // End of the 'testEnqueue' method

	@Test
	void testDequeue() {
		fail("Not yet implemented");
	} // End of the 'testDequeue' method

	@Test
	void testPeek() {
		fail("Not yet implemented");
	} // End of the 'testPeek' method

} // End of the 'FifoQueueTest' class
