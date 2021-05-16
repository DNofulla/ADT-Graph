package daniel.nofulla.homework4;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the Graph Class
 * 
 * @author Daniel Nofulla
 * @version v1.0
 *
 */
public class Graph implements ADTGraph {

	/**
	 * This is the number of Vertices
	 */
	private int numberOfVertices;

	/**
	 * This is the number of Edges
	 */
	private int numberOfEdges;

	/**
	 * This is the Adjacency Matrix
	 */
	private Edge[][] adjacencyMatrix;

	/**
	 * This is the Vertex List
	 */
	private ArrayList<Vertex> vertexList;

	/**
	 * This is a temporary list used in the DFS Operation Only
	 */
	private List<Vertex> tempList;

	/**
	 * This is a List that stores sublists (or subsets) of Vertices. It is used in
	 * the DFS operation to display the subgraphs of the main graph as a disjoint
	 * set in list representation.
	 */
	private List<List<Vertex>> vertexDisjointSets;

	/**
	 * Constructs an empty Graph with size 5 (by default) as no other value is
	 * provided
	 * 
	 * @throws GraphException Throws the GraphException
	 * 
	 */
	public Graph() throws GraphException {
		setNumberOfEdges(0);
		setNumberOfVertices(5); // Default number of vertices is 5 if no value is provided
		setVertexList(new ArrayList<Vertex>());
		setTempList(new ArrayList<Vertex>());
		setVertexDisjointSets(new ArrayList<List<Vertex>>());
		this.adjacencyMatrix = new Edge[vertexCount()][vertexCount()];

		for (int i = 0; i < vertexCount(); i++) {
			for (int j = 0; j < vertexCount(); j++) {
				adjacencyMatrix[i][j] = new Edge(i, j, 0);
			}
			vertexList.add(new Vertex(i));
		}
	}

	/**
	 * Constructs an empty Graph with size n
	 * 
	 * @param n The number of vertices in the Graph
	 * @throws GraphException Throws the GraphException
	 */
	public Graph(int n) throws GraphException {
		setNumberOfEdges(0);
		setNumberOfVertices(n);
		setVertexList(new ArrayList<Vertex>());
		setTempList(new ArrayList<Vertex>());
		setVertexDisjointSets(new ArrayList<List<Vertex>>());
		adjacencyMatrix = new Edge[n][n];

		for (int i = 0; i < vertexCount(); i++) {
			for (int j = 0; j < vertexCount(); j++) {
				adjacencyMatrix[i][j] = new Edge(i, j, 0);
			}
			vertexList.add(new Vertex(i));
		}
	}

	/**
	 * The isEmpty method returns true if the Graph's
	 * 
	 * @return Returns true if the number of edges in the graph are zero
	 */
	public boolean isEmpty() {
		return edgeCount() == 0;
	}

	/**
	 * The vertexCount method returns the number of vertices
	 * 
	 * @return Returns the number of vertices in this Graph
	 */
	public int vertexCount() {
		return getNumberOfVertices();
	}

	/**
	 * The edgeCount method returns the number of edges on this Graph
	 * 
	 * @return Returns the number of edges with weight greater than zero in this
	 *         Graph
	 */
	public int edgeCount() {
		return getNumberOfEdges();
	}

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
	public int edgeExists(int vertex1, int vertex2) throws GraphException {
		if (vertex1 > vertexCount() || vertex2 > vertexCount()) {
			throw new GraphException(
					"Cannot return the weight of an edge if either of the vertices provided are greater than the total vertex count in the Graph!");
		} else {
			return getAdjacencyMatrix()[vertex1][vertex2].getWeight();
		}

	}

	/**
	 * The getEdgeWeight method returns the weight of an Edge in the Graph
	 * 
	 * @param vertex1 The value/index of the first vertex
	 * @param vertex2 The value/index of the second vertex
	 * @return Returns the weight of the edge between vertex1 and vertex2 indices.
	 * @throws GraphException Throws the GraphException
	 */
	public int getEdgeWeight(int vertex1, int vertex2) throws GraphException {
		if (vertex1 > vertexCount() || vertex2 > vertexCount()) {
			throw new GraphException(
					"Cannot return the weight of an edge if either of the vertices provided are greater than the total vertex count in the Graph!");
		} else {
			return getAdjacencyMatrix()[vertex1][vertex2].getWeight();
		}
	}

	/**
	 * The insertEdge method inserts an Edge into the Graph
	 * 
	 * @param edge The Edge to be inserted into the Graph
	 * @throws GraphException Throws the GraphException
	 */
	public void insertEdge(Edge edge) throws GraphException {
		if (edge.getWeight() > 0) {
			this.adjacencyMatrix[edge.getVertex1()][edge.getVertex2()] = edge;
			this.adjacencyMatrix[edge.getVertex2()][edge.getVertex1()] = new Edge(edge.getVertex2(), edge.getVertex1(),
					edge.getWeight());
		} else if (edge.getVertex1() > vertexCount() || edge.getVertex2() > vertexCount()) {
			throw new GraphException(
					"Cannot insert this edge with either of the vertex values being greater than the total vertex count in the Graph!");
		} else {
			throw new GraphException("Cannot insert an edge with weight less than 0!");
		}
		setNumberOfEdges(getNumberOfEdges() + 1);
	}

	/**
	 * The deleteEdge method deletes an Edge from the Graph
	 * 
	 * @param edge The Edge to be deleted from the Graph
	 * @throws GraphException Throws the GraphException
	 */
	public void deleteEdge(Edge edge) throws GraphException {

		if (edge.getWeight() > 0) {
			this.adjacencyMatrix[edge.getVertex1()][edge.getVertex2()] = new Edge(edge.getVertex1(), edge.getVertex2(),
					0);
			this.adjacencyMatrix[edge.getVertex2()][edge.getVertex1()] = new Edge(edge.getVertex2(), edge.getVertex1(),
					0);
		} else if (edge.getVertex1() > vertexCount() || edge.getVertex2() > vertexCount()) {
			throw new GraphException(
					"Cannot delete this edge with either of the vertex values being greater than the total vertex count in the Graph!");
		} else {
			throw new GraphException("Cannot delete an edge with weight less than 0!");
		}
		setNumberOfEdges(getNumberOfEdges() - 1);
	}

	/**
	 * The findEdge method finds and returns the Edge between two provided vertices
	 * 
	 * @param vertex1 The value/index of the first vertex
	 * @param vertex2 The value/index of the second vertex
	 * @return Returns the Edge found between the two vertices
	 * @throws GraphException Throws the GraphException
	 */
	public Edge findEdge(int vertex1, int vertex2) throws GraphException {
		if (vertex1 > vertexCount() || vertex2 > vertexCount()) {
			throw new GraphException("Cannot find Edge if either of the vertex indices provided are out of bounds!");
		} else {
			return getAdjacencyMatrix()[vertex1][vertex2];
		}

	}

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
	public void traverseDepthFirstSearch() throws GraphException {

		/*
		 * Initializing every vertex to WHITE status
		 */
		for (int i = 0; i < vertexCount(); i++) {
			this.vertexList.set(vertexList.get(i).getValue(), new Vertex(i, Color.WHITE));
		}
		this.vertexDisjointSets.clear();

		System.out.println("Performing DEPTH-FIRST-SEARCH on every Vertex!\n");
		for (Vertex vtx : this.vertexList) {
			if (vtx.getColor() == Color.WHITE || vtx.getColor() == Color.GRAY) {

				depthFirstSearchVisit(vtx); // Visit vertex

				/*
				 * Adding subgraph list to the main List of Subgraphs
				 */
				List<Vertex> temp = new ArrayList<Vertex>();
				temp.addAll(tempList);
				this.vertexDisjointSets.add(temp);
				this.tempList.clear();
				System.out.println(
						"----------------------------------------------------------------------------------------------------------");
			}
		}

		/*
		 * Displaying the Disjoint Set Forest (Sub-Graphs)
		 */
		String str = "RESULT DISJOINT SET FOREST (Displaying all Sub-Graphs): \n" + "{ ";
		for (List<Vertex> disjointSet : this.vertexDisjointSets) {
			str += " {";
			for (Vertex vertex : disjointSet) {
				str += " " + vertex.getValue() + " ";
			}
			str += "} ";
		}
		str += " }\n";
		System.out.println(str);
	}

	/**
	 * The depthFirstSearchVisit method visits the referenced vertex and recursively
	 * visits every other adjacent vertex of the current vertex to explore the depth
	 * of each vertex it visits.
	 * 
	 * @param vertex The vertex to be discovered and visited
	 */
	public void depthFirstSearchVisit(Vertex vertex) {

		/* Label the Vertex as Discovered */
		System.out.println("Discovered Vertex " + vertex.getValue());
		this.vertexList.set(vertex.getValue(), new Vertex(vertex.getValue(), Color.GRAY));
		this.tempList.add(vertex);

		/* Explore every adjacent vertex to the current vertex */
		for (int i = 0; i < vertexCount(); i++) {
			if (getAdjacencyMatrix()[vertex.getValue()][i].getWeight() > 0
					&& getAdjacencyMatrix()[i][vertex.getValue()].getWeight() > 0) {
				if (this.vertexList.get(i).getColor() == Color.WHITE) {
					depthFirstSearchVisit(this.vertexList.get(i));
				}
			}
		}
		/* Label the Vertex as Fully Explored/Visited */
		System.out.println("Fully Explored Vertex " + vertex.getValue());
		this.vertexList.set(vertex.getValue(), new Vertex(vertex.getValue(), Color.BLACK));
	}

	/**
	 * The printGraph method prints the Graph
	 */
	public void printGraph() {
		System.out.println("Printing Graph Vertices & Edges: \n");
		System.out.println(toString());
	}

	/**
	 * The toString method returns the Graph's Vertices and Edges formatted as a
	 * String.
	 * 
	 * @return Returns the Graph's Vertices and Edges formatted as a String
	 */
	public String toString() {

		String str = "";

		for (int i = 0; i < vertexCount(); i++) {
			str += "Vertex {" + i + "}: ";
			String x = "";
			for (int j = 0; j < vertexCount(); j++) {
				if (getAdjacencyMatrix()[i][j].getWeight() > 0) {
					x += "(" + i + ", " + j + ")-W" + getAdjacencyMatrix()[i][j].getWeight() + "  ";
				}
			}
			if (x.equals("")) {
				str += "(NO EDGES)";
			} else {
				str += x;
			}
			str += "\n";
		}

		return str;
	}

	/**
	 * Getter method for the number of vertices in the Graph
	 * 
	 * @return Returns the number of vertices in the Graph
	 */
	public int getNumberOfVertices() {
		return this.numberOfVertices;
	}

	/**
	 * Setter method for the number of vertices in the Graph
	 * 
	 * @param numberOfVertices The number to be set as the number of vertices
	 */
	public void setNumberOfVertices(int numberOfVertices) {
		this.numberOfVertices = numberOfVertices;
	}

	/**
	 * Getter method for the number of edges in the Graph
	 * 
	 * @return Returns the number of edges in the Graph
	 */
	public int getNumberOfEdges() {
		return this.numberOfEdges;
	}

	/**
	 * Setter method for the number of edges in the Graph
	 * 
	 * @param numberOfEdges The number to be set as the number of edges
	 */
	public void setNumberOfEdges(int numberOfEdges) {
		this.numberOfEdges = numberOfEdges;
	}

	/**
	 * Getter method for the adjacency matrix of the Graph
	 * 
	 * @return Returns the adjacency matrix of the Graph
	 */
	public Edge[][] getAdjacencyMatrix() {
		return this.adjacencyMatrix;
	}

	/**
	 * Setter method for the adjacency matrix of the Graph. The algorithm also
	 * alters the edge and vertex counts accordingly.
	 * 
	 * @param adjacencyMatrix The matrix to be set as the adjacency matrix
	 */
	public void setAdjacencyMatrix(Edge[][] adjacencyMatrix) {
		setNumberOfVertices(adjacencyMatrix[0].length);
		this.adjacencyMatrix = adjacencyMatrix;

		setNumberOfEdges(0);
		for (int i = 0; i < numberOfVertices; i++) {
			for (int j = 0; j < numberOfVertices; j++) {
				if (getAdjacencyMatrix()[i][j].getWeight() > 0) {
					setNumberOfEdges(getNumberOfEdges() + 1);
				}
			}
		}

	}

	/**
	 * Getter method for the vertex list of the Graph
	 * 
	 * @return Returns the vertex list of the Graph
	 */
	public ArrayList<Vertex> getVertexList() {
		return vertexList;
	}

	/**
	 * Setter method for the vertex list of the Graph.
	 * 
	 * @param vertexList The list of vertices to be set as the vertex list of the
	 *                   Graph
	 */
	public void setVertexList(ArrayList<Vertex> vertexList) {
		this.vertexList = vertexList;
	}

	/**
	 * Getter method for the temporary subgraph list of the Graph
	 * 
	 * @return Returns the temporary subgraph list of the Graph
	 */
	public List<Vertex> getTempList() {
		return tempList;
	}

	/**
	 * Setter method for the temporary subgraph list of the Graph.
	 * 
	 * @param tempList The list of vertices to be set as the temporary subgraph list
	 *                 of the Graph
	 */
	public void setTempList(ArrayList<Vertex> tempList) {
		this.tempList = tempList;
	}

	/**
	 * Getter method for the List of Disjoint Sets/Subgraphs of the Graph
	 * 
	 * @return Returns the List of Disjoint Sets/Subgraphs of the Graph
	 */
	public List<List<Vertex>> getVertexDisjointSets() {
		return vertexDisjointSets;
	}

	/**
	 * Setter method for the List of Disjoint Sets/Subgraphs of the Graph.
	 * 
	 * @param vertexDisjointSets The list of lists of vertices to be set as the List
	 *                           of Disjoint Sets/Subgraphs of the Graph
	 */
	public void setVertexDisjointSets(List<List<Vertex>> vertexDisjointSets) {
		this.vertexDisjointSets = vertexDisjointSets;
	}

}
