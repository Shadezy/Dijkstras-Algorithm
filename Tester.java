import java.util.LinkedList;
import java.util.PriorityQueue;

public class Tester {

	public static void main(String[] args) {
		System.out.println("I DID THE PRIORITY QUEUE EXTRA CREDIT\n");
		Graph g = new Graph(8);
		g.howManyEdges(15);
		
		//1
		g.setEdge(1, 2, 9);
		g.setEdge(1, 6, 14);
		g.setEdge(1, 7, 15);
		
		//2
		g.setEdge(2, 3, 24);
		
		//3
		g.setEdge(3, 5, 2);
		g.setEdge(3, 8, 19);
		
		//4
		g.setEdge(4, 3, 6);
		g.setEdge(4, 8, 6);
		
		//5
		g.setEdge(5, 4, 11);
		g.setEdge(5, 8, 16);
		
		//6
		g.setEdge(6, 3, 18);
		g.setEdge(6, 5, 30);
		g.setEdge(6, 7, 5);
		
		//7
		g.setEdge(7, 5, 20);
		g.setEdge(7, 8, 44);
		
		dijkstra(g);
	}
	
	public static void dijkstra(Graph g) {
		int[] dist = new int[8];
		String[] path = new String[8];
		int u, v;
		dist[0] = 0;
		
		for (int i = 1; i < 8; i++)
			dist[i] = 9999;
		for (int i = 0; i < path.length; i++)
			path[i] = "1";
		
		LinkedList<Integer> s = new LinkedList<Integer>();
		PriorityQueue<Vertex> Q = new PriorityQueue<Vertex>();
		
		for (int i = 1; i < 9; i++) {
			Vertex vert = new Vertex(i, dist[i-1]);
			Q.add(vert);
		}
		
		while (!Q.isEmpty()) {
			u = Q.remove().vert;
			s.add(u);
			
			while ((v = g.neighbor(u)) != 0)
				if (dist[v-1] > dist[u-1] + g.getWeight(u, v)) {
					dist[v-1] = dist[u-1] + g.getWeight(u, v);
					path[v-1] = path[u-1] + "->" + Integer.toString(v);
				}
		}
		
		for (int i = 1; i <= path.length; i++) {
			if (i == 1)
				System.out.println("Path " + i +"): " + "vertex 1 " + "to vertex " + i + ", " + "1->" + path[i-1] + ", length " + dist[i-1]);
			else
				System.out.println("Path " + i +"): " + "vertex 1 " + "to vertex " + i + ", " + path[i-1] + ", length " + dist[i-1]);
		}
	}
}
