import static org.junit.Assert.assertEquals;
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
	void testEnqueue04() {
		Attractions tmp = new Attractions();
		Attractions[] holder = new Attractions[50];

		for (int i = 0; i < 50; i++) {
			tmp.setName(Integer.toString(i));
			holder[i] = tmp;
			fifo.enqueue(tmp);
		}

		for (int j = 0; j < fifo.getSize(); j++) {
			Attractions result = fifo.dequeue();
			Attractions expected = holder[j];
			assertEquals(expected, result);
		}
	} // End of the 'testEnqueue04' method

	@Test
	void testDequeue() {
		Attractions expected = new Attractions();
		fifo.enqueue(expected);
		Attractions result = fifo.dequeue();
		assertSame(expected, result);
	} // End of the 'testDequeue' method

	@Test
	void testPeek01() {
		Attractions expected = new Attractions();
		fifo.enqueue(expected);
		assertSame(expected, fifo.peek());
	} // End of the 'testPeek01' method

	@Test
	void testPeek02() {
		Attractions expected = new Attractions();
		expected.setName("batman");
		fifo.enqueue(expected);

		Attractions two = new Attractions();
		two.setName("ironman");
		fifo.enqueue(two);

		Attractions three = new Attractions();
		three.setName("Spiderman");
		fifo.enqueue(three);

		Attractions result = fifo.peek();
		assertSame(expected, result);
	} // End of the 'testPeek02' method

	@Test
	void testGetSize01() {
		int expected = 0;
		int result = fifo.getSize();
		assertEquals(expected, result);
	} // End of the 'testGetSize01' method

	@Test
	void testGetSize02() {
		Attractions tmp = new Attractions();
		fifo.enqueue(tmp);

		int expected = 1;
		int result = fifo.getSize();

		assertEquals(expected, result);
	} // End of the 'testGetSize02' method

	@Test
	void testGetSize03() {
		Attractions tmp = new Attractions();
		fifo.enqueue(tmp);
		fifo.enqueue(tmp);

		int expected = 2;
		int result = fifo.getSize();

		assertEquals(expected, result);
	} // End of the 'testGetSize03' method

	@Test
	void testGetSize04() {
		Attractions tmp = new Attractions();
		fifo.enqueue(tmp);
		fifo.enqueue(tmp);
		fifo.enqueue(tmp);

		int expected = 3;
		int result = fifo.getSize();

		assertEquals(expected, result);
	} // End of the 'testGetSize04' method

	@Test
	void testGetSize05() {
		Attractions tmp = new Attractions();
		int expected = 0;

		for (int i = 0; i < 50; i++) {
			fifo.enqueue(tmp);
			expected++;
		}

		int result = fifo.getSize();
		assertEquals(expected, result);
	} // End of the 'testGetSize05' method

} // End of the 'FifoQueueTest' class
