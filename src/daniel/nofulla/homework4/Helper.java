package daniel.nofulla.homework4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This is the Helper Class. This is where all the test cases are written and
 * executed
 * 
 * @author Daniel Nofulla
 * @version v1.0
 *
 */
public class Helper {

	/**
	 * The start method runs all the test cases. We first create a new Graph. Then
	 * we Display it, and then we traverse using DFS. We then remove two Edges,
	 * print and traverse the Graph with DFS again. Then we insert two different
	 * Edges and print and traverse the Graph with DFS again. This should be able to
	 * test every important function for this graph, including finding the weight,
	 * if an edge exists, etc.
	 * 
	 * @throws GraphException        Throws the GraphException
	 * @throws FileNotFoundException Throws the FileNotFoundException
	 */
	public static void start() throws GraphException, FileNotFoundException {
		System.out.println("CREATING INITIAL GRAPH FROM FILE:");
		Graph testGraph = create();
		display(testGraph);
		System.out.println("TRAVERSING GRAPH USING DFS:");
		testGraph.traverseDepthFirstSearch();

		System.out.println();
		System.out.println();

		System.out.println("REMOVING EDGES 4,9 AND 1,5 FROM GRAPH:");
		testGraph.deleteEdge(testGraph.getAdjacencyMatrix()[4][9]);
		testGraph.deleteEdge(testGraph.getAdjacencyMatrix()[1][5]);
		display(testGraph);
		System.out.println("TRAVERSING GRAPH USING DFS:");
		testGraph.traverseDepthFirstSearch();

		System.out.println();
		System.out.println();

		System.out.println("INSERTING EDGES 3,2 and 8,2 TO GRAPH (with weights of 32 on both):");
		testGraph.insertEdge(new Edge(3, 2, 32));
		testGraph.insertEdge(new Edge(8, 2, 32));
		display(testGraph);
		System.out.println("TRAVERSING GRAPH USING DFS:");
		testGraph.traverseDepthFirstSearch();
	}

	/**
	 * The create method simply creates a Graph from data in the edges.txt text file
	 * and returns that Graph
	 * 
	 * @return Returns the Graph after data has been added to it from the text file
	 * @throws FileNotFoundException Throws the FileNotFoundException
	 * @throws GraphException        Throws the GraphException
	 */
	public static Graph create() throws FileNotFoundException, GraphException {
		Scanner sc = new Scanner(new File("edges.txt"));
		sc.useDelimiter(",");
		Graph graph = new Graph(Integer.parseInt(sc.nextLine()));
		while (sc.hasNextLine()) {
			String[] x = sc.nextLine().split(",");
			graph.insertEdge(new Edge(Integer.parseInt(x[0]), Integer.parseInt(x[1]), Integer.parseInt(x[2])));
		}

		return graph;
	}

	/**
	 * The display method simply prints out the Graph we pass in as a parameter
	 * 
	 * @param graph Graph to be printed
	 */
	public static void display(Graph graph) {
		graph.printGraph();
	}

}
