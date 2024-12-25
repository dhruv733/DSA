package graph;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//
//        // Input the number of vertices and edges
//        System.out.println("Enter the number of vertices:");
//        int vertices = scanner.nextInt();
//        System.out.println("Enter the number of edges:");
//        int edges = scanner.nextInt();
//
//        Graphs graph = new Graphs(vertices);
//
//        // Input edges
//        System.out.println("Enter the edges (source destination):");
//        for (int i = 0; i < edges; i++) {
//            int source = scanner.nextInt();
//            int destination = scanner.nextInt();
//            graph.addEdge(source, destination);
//        }
//
//        // Input the start vertex for BFS and DFS
//        System.out.println("Enter the start vertex for BFS and DFS:");
//        int startVertex = scanner.nextInt();
//
//        // Perform BFS
//        graph.bfs(startVertex);
//
//        // Perform DFS
//        graph.dfs(startVertex);
//
//        // Check for Cycle
//        System.out.println("Cycle Detection:");
//        boolean hasCycle = graph.hasCycleUndirected();
//        System.out.println(hasCycle ? "Cycle Detected" : "No Cycle Detected");
//
//        // Input the start vertex for Dijkstra's Algorithm
//        System.out.println("Enter the start vertex for Dijkstra's Algorithm:");
//        int dijkstraStart = scanner.nextInt();
//
//        // Perform Dijkstra's Algorithm
//        graph.dijkstra(dijkstraStart);
//
//        scanner.close();

		Graphs graph = new Graphs(6);

		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 3);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);
		graph.addEdge(4, 5);
		graph.addEdge(5, 0);

		System.out.println("BFS Traversal:");
		graph.bfsShortestPath(0);

		System.out.println("\nDFS Traversal:");
		graph.dfs(0);

		System.out.println("\nCycle Detection:");
		System.out.println(graph.hasCycleUndirected() ? "Cycle Detected" : "No Cycle");

		System.out.println("\nShortest Path (Dijkstra from 0):");
		graph.dijkstra(0);
	}

}
