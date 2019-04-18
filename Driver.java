import java.util.ArrayList;

public class Driver {
	public static void main(String[] args) {
		IO inout = new IO("map1.txt", "user1.txt", "connect1.txt", "outputfile.txt");
		//
		FifoQueue route = new FifoQueue();
		// Total time a user wants to stay at park
		int timeAllotted = inout.getTimeAllotted();

		// Running total of time as the schedule is built
		int totalTime = 0;
		// list of attractions visited
		ArrayList<Attractions> visitedAttractions;

	}

}
