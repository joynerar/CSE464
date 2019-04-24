
public class Queue {

	private Node	head;
	private int		size;

	public Queue() {
		head = null;
		size = 0;
	}

	public void enqueue(Attractions input) {
		if (size == 0) {
			head = new Node();
			head.data = input;
		} else {
			Node tmp = head;
			for (int i = 0; i < size; i++) {
				tmp = tmp.next;
			}
			tmp.next = new Node();
			tmp.next.data = input;
		}
	}

	public Attractions dequeue() {
		Attractions result = head.data;
		head = head.next;
		return result;
	}

	class Node {

		Attractions		data;
		private Node	next;

		public Node() {
			data = null;
			next = null;
		}

	} // End of 'Node' class
}
