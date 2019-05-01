import java.util.ArrayList;

public class TestBfs {
	////

	public static void main(String[] args) {

		ArrayList<Attractions> map = new ArrayList<Attractions>();

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

		// neighbors
		attraction1.addNeighbor(attraction2, 1);
		attraction1.addNeighbor(attraction3, 3);
		attraction1.addNeighbor(attraction4, 2);

		attraction2.addNeighbor(attraction1, 1);
		attraction2.addNeighbor(attraction5, 4);

		attraction5.addNeighbor(attraction2, 4);

		attraction3.addNeighbor(attraction1, 3);

		attraction4.addNeighbor(attraction1, 2);

		// map.add(attraction1);
		// map.add(attraction2);
		// map.add(attraction3);
		// map.add(attraction4);
		// map.add(attraction5);
		map.add(attraction5);
		map.add(attraction3);
		map.add(attraction1);
		map.add(attraction4);
		map.add(attraction2);

		// // Sanity check
		// for (int i = 0; i < map.size(); i++) {
		// String output = new String();
		// output = "";
		//
		// output += "name: " + map.get(i).getName();
		// output += "\twaitTime: " + map.get(i).getWaitTime();
		// output += "\trideTime: " + map.get(i).getRideTime();
		// output += "\nNeighbors: ";
		// ArrayList<Neighbor> neighbors = map.get(i).getNeighbors();
		// for (int n = 0; n < neighbors.size(); n++) {
		// output += "\t"
		// + neighbors.get(n).getNeighbor().getName();
		// }
		// output += "\n";
		// System.out.println(output);
		// }
		Search bfs = new Search(map);
		ArrayList<Attractions> one = bfs.getPath(attraction2,
				attraction4);

		for (int o = 0; o < one.size(); o++) {
			if (one.get(o) != null) {
				System.out.println(one.get(o).getName());
			}
		}

	}

	/////
}
