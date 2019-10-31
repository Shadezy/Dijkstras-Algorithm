
public class Vertex implements Comparable<Vertex> {

	int vert;
	int dist;
	
	public Vertex(int vert, int dist) {
		this.vert = vert;
		this.dist = dist;
	}

	@Override
	public int compareTo(Vertex that) {
		if (this.dist > that.dist)
			return 1;
		if (this.dist < that.dist)
			return -1;
		return 0;
	}
}
