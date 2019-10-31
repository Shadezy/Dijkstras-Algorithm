import java.util.LinkedList;

public class Graph {
	private LinkedList<Edge> adjacencyList[];
	private int edgeNum = 0;
	private Edge[] edges;
	private int verts;
	
	public Graph(int numOfVerts) {
		adjacencyList = new LinkedList[numOfVerts];
		verts = numOfVerts;
		
		for (int i = 0; i < numOfVerts; i++) {
			adjacencyList[i] = new LinkedList<Edge>();
		}
	}
	
	public void setEdge(int from, int to, int wt) {
		Edge edge = new Edge(from, to, wt);
		adjacencyList[from-1].add(edge);
		edges[edgeNum] = edge;
		edgeNum++;
	}
	
	public Edge[] edges() {
		return edges;
	}
	
	public int getVerts() {
		return verts;
	}
	
	public int getWeight(int from, int to) {
		for (int i = 0; i < edges.length; i++) {
			if (from == edges[i].v && to == edges[i].w)
				return edges[i].weight;
		}
		return 0;
	}
	
	public void howManyEdges(int count) {
		edges = new Edge[count];
	}
	
	public int neighbor(int v) {
		if (adjacencyList[v-1].isEmpty())
			return 0;
		return adjacencyList[v-1].remove().w;
	}
}
