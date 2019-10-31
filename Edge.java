public class Edge implements Comparable<Edge> {
	
	public int v, w, weight;
	public Edge(int v, int w, int weight)
	{
		this.v = v;
		this.w = w;
		this.weight = weight;
	}
	
	public int either() {
		return v;
	}
	
	public int other(int vertex) {      
		if (vertex == v) 
	           return w;      
		else
	           return v;
	}

	public int weight() {
		return weight;
	}

	public int compare(Edge e, Edge f) {		
		if (e.weight < f.weight)
			return -1;		
		if (e.weight > f.weight)
			return +1;		
		
		return 0;
	}
		
	public int compareTo(Edge that) {		
		if (this.weight < that.weight)
			return -1;		
		if (this.weight > that.weight)
			return +1;
		
		return  0;
	}
}