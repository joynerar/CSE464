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
	void testEnqueue01() {
		// Test 01
		Attractions expected = new Attractions();
		fifo.enqueue(expected);
		assertSame(expected, fifo.peek());
	} // End of the 'testEnqueue01' method

	@Test
	void testEnqueue02() {
		Attractions one = new Attractions();
		one.setName("batman");
		fifo.enqueue(one);

		Attractions two = new Attractions();
		two.setName("ironman");
		fifo.enqueue(two);

		Attractions expected = new Attractions();
		expected.setName("Spiderman");
		fifo.enqueue(expected);

		Attractions result = fifo.dequeue();
		result = fifo.dequeue();
		result = fifo.dequeue();

		assertSame(expected, result);
	} // End of the 'testEnqueue02' method

	@Test
	void testEnqueue03() {
		Attractions one = new Attractions();
		one.setName("batman");
		fifo.enqueue(one);

		Attractions expected = new Attractions();
		expected.setName("Spiderman");
		fifo.enqueue(expected);

		Attractions tmp = fifo.dequeue();
		Attractions result = fifo.dequeue();

		assertSame(expected, result);
	} // End of the 'testEnqueue 03' method

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
