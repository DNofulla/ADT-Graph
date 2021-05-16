package daniel.nofulla.homework4;

/**
 * This is the ADTGraph Interface
 * 
 * @author Daniel Nofulla
 * @version v1.0
 *
 */
public interface ADTGraph {
	
	/**
	 * The isEmpty method returns true if the Graph's
	 * 
	 * @return Returns true if the number of edges in the graph are zero
	 */
	public boolean isEmpty();

	/**
	 * The vertexCount method returns the number of vertices
	 * 
	 * @return Returns the number of vertices in this Graph
	 */
	public int vertexCount();

	/**
	 * The edgeCount method returns the number of edges on this Graph
	 * 
	 * @return Returns the number of edges with weight greater than zero in this
	 *         Graph
	 */
	public int edgeCount();

	/**
	 * The edgeExists method returns the weight of an Edge in the Graph. This
	 * operation only returns 0 if the Edge doesn't exist
	 * 
	 * @param vertex1 The value/index of the first vertex
	 * @param vertex2 The value/index of the second vertex
	 * @return Returns the weight of the edge between vertex1 and vertex2 indices.
	 *         The edge only exists if the weight is greater than zero.
	 * @throws GraphException Throws the GraphException
	 */
	public int edgeExists(int vertex1, int vertex2) throws GraphException;

	/**
	 * The getEdgeWeight method returns the weight of an Edge in the Graph
	 * 
	 * @param vertex1 The value/index of the first vertex
	 * @param vertex2 The value/index of the second vertex
	 * @return Returns the weight of the edge between vertex1 and vertex2 indices.
	 * @throws GraphException Throws the GraphException
	 */
	public int getEdgeWeight(int vertex1, int vertex2) throws GraphException;

	/**
	 * The insertEdge method inserts an Edge into the Graph
	 * 
	 * @param edge The Edge to be inserted into the Graph
	 * @throws GraphException Throws the GraphException
	 */
	public void insertEdge(Edge edge) throws GraphException;

	/**
	 * The deleteEdge method deletes an Edge from the Graph
	 * 
	 * @param edge The Edge to be deleted from the Graph
	 * @throws GraphException Throws the GraphException
	 */
	public void deleteEdge(Edge edge) throws GraphException;

	/**
	 * The findEdge method finds and returns the Edge between two provided vertices
	 * 
	 * @param vertex1 The value/index of the first vertex
	 * @param vertex2 The value/index of the second vertex
	 * @return Returns the Edge found between the two vertices
	 * @throws GraphException Throws the GraphException
	 */
	public Edge findEdge(int vertex1, int vertex2) throws GraphException;

	/**
	 * The traverseDepthFirstSearch method traverses through the Graph and visits
	 * every vertex using the Depth First Search Algorithm. It also produces a List
	 * of connected subgraphs as this algorithm repeats for every vertex to look for
	 * all the connected subgraphs. The process is thoroughly printed out. Nodes are
	 * marked as WHITE if Not Discovered, GRAY if Discovered but not fully explored
	 * and BLACK if fully Explored/Visited. Vertices are only Explored onlt if not
	 * fully explored to avoid errors or unintended results.
	 * 
	 * @throws GraphException Throws the GraphException
	 */
	public void traverseDepthFirstSearch() throws GraphException;

	/**
	 * The depthFirstSearchVisit method visits the referenced vertex and recursively
	 * visits every other adjacent vertex of the current vertex to explore the depth
	 * of each vertex it visits.
	 * 
	 * @param vertex The vertex to be discovered and visited
	 */
	public void depthFirstSearchVisit(Vertex vertex);

	/**
	 * The printGraph method prints the Graph
	 */
	public void printGraph();

	/**
	 * The toString method returns the Graph's Vertices and Edges formatted as a
	 * String.
	 * 
	 * @return Returns the Graph's Vertices and Edges formatted as a String
	 */
	public String toString();
}
