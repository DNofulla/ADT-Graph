package daniel.nofulla.homework4;

/**
 * This is the Edge Class
 * 
 * @author Daniel Nofulla
 * @version v1.0
 *
 */
public class Edge {

	/**
	 * The First Vertex of the Edge
	 */
	private int vertex1;

	/**
	 * The Second Vertex of the Edge
	 */
	private int vertex2;

	/**
	 * The Weight of the Edge
	 */
	private int weight;

	/**
	 * Constructs a new Edge from two vertices and an assigned weight
	 * 
	 * @param vertex1 First Vertex Value to be assigned to the Edge
	 * @param vertex2 Second Vertex Value to be assigned to the Edge
	 * @param weight  Weight to be assigned to the Edge
	 * @throws GraphException Throws GraphException
	 */
	public Edge(int vertex1, int vertex2, int weight) throws GraphException {
		setVertex1(vertex1);
		setVertex2(vertex2);
		setWeight(weight);
	}

	/**
	 * Getter method for the first vertex value
	 * 
	 * @return Returns the first vertex value
	 */
	public int getVertex1() {
		return this.vertex1;
	}

	/**
	 * Setter method for the first vertex value
	 * 
	 * @param vertex Value to be assigned to the first vertex
	 */
	public void setVertex1(int vertex) {
		this.vertex1 = vertex;
	}

	/**
	 * Getter method for the second vertex value
	 * 
	 * @return Returns the second vertex value
	 */
	public int getVertex2() {
		return this.vertex2;
	}

	/**
	 * Setter method for the second vertex value
	 * 
	 * @param vertex Value to be assigned to the second vertex
	 */
	public void setVertex2(int vertex) {
		this.vertex2 = vertex;
	}

	/**
	 * Getter method for the weight of the Edge
	 * 
	 * @return Returns the weight of the Edge
	 */
	public int getWeight() {
		return this.weight;
	}

	/**
	 * Setter method for the weight of the edge
	 * 
	 * @param weight Weight to be assigned to the Edge
	 * @throws GraphException Throws GraphException
	 */
	public void setWeight(int weight) throws GraphException {
		if (getWeight() < 0) {
			throw new GraphException("Edge Weight cannot be negative!");
		}
		this.weight = weight;
	}

}
