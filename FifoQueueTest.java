import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

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
		fifo = new FifoQueue();
		assertNotNull(fifo);
	} // End of the 'testFifoQueue' method

	@Test
	void testEnqueue() {
		Attractions expected = new Attractions();
		fifo.enqueue(expected);
		assertSame(expected, fifo.peek());
	} // End of the 'testEnqueue' method

	@Test
	void testDequeue() {
		Attractions expected = new Attractions();
		fifo.enqueue(expected);
		Attractions result = fifo.dequeue();
		assertSame(expected, result);
	} // End of the 'testDequeue' method

	@Test
	void testPeek() {
		Attractions expected = new Attractions();
		fifo.enqueue(expected);
		assertSame(expected, fifo.peek());
	} // End of the 'testPeek' method

} // End of the 'FifoQueueTest' class
