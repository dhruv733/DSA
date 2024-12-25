package graph;
import java.util.*;

class Graphs {
    private Integer vertices;
    private LinkedList<Integer>[] adjacencyList;

    // Constructor
    public Graphs(Integer vertices) {
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }
    // Add edge to the graph (Undirected)
    public void addEdge(int source, int destination) {
        adjacencyList[source].add(destination);
        adjacencyList[destination].add(source);
    }
    
    // Breadth-First Search (BFS)
    public void bfsShortestPath(int startVertex) {
        boolean[] visited = new boolean[vertices];
        int[] distance = new int[vertices];
        int[] parent = new int[vertices]; // To reconstruct the path

        // Initialize distances and parents
        Arrays.fill(distance, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);
        distance[startVertex] = 0;

        Queue<Integer> queue = new LinkedList<>();
        visited[startVertex] = true;
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            int vertex = queue.poll();

            for (int neighbor : adjacencyList[vertex]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);

                    // Update the distance and parent
                    distance[neighbor] = distance[vertex] + 1;
                    parent[neighbor] = vertex;
                }
            }
        }

        // Print shortest distances
        System.out.println("Shortest distances from vertex " + startVertex + ":");
        System.out.println(Arrays.toString(distance));

        // Optional: Reconstruct paths to all vertices
        System.out.println("Paths from vertex " + startVertex + ":");
        for (int i = 0; i < vertices; i++) {
            if (distance[i] != Integer.MAX_VALUE) {
                System.out.print("Path to " + i + ": ");
                printPath(i, parent);
                System.out.println(" (Distance: " + distance[i] + ")");
            }
        }
    }

    private void printPath(int vertex, int[] parent) {
        if (vertex == -1) return;
        printPath(parent[vertex], parent);
        System.out.print(vertex + " ");
    }


    // DFS Traversal and Shortest Distance
    public void dfs(int startVertex) {
        int[] distance = new int[vertices];
        Arrays.fill(distance, Integer.MAX_VALUE); // Initialize distances to infinity
        distance[startVertex] = 0; // Distance to the start vertex is 0
        int[] parent = new int[vertices];
        Arrays.fill(parent, -1); // Parent array for path reconstruction

        System.out.println("DFS Traversal:");
        dfsHelper(startVertex, distance, parent, 0);

        // Print shortest distances
        System.out.println("\n\nShortest distances from vertex " + startVertex + ":");
        System.out.println(Arrays.toString(distance));

        // Print paths
        System.out.println("\nPaths from vertex " + startVertex + ":");
        for (int i = 0; i < vertices; i++) {
            if (distance[i] != Integer.MAX_VALUE) {
                System.out.print("Path to " + i + ": ");
                printPath(i, parent);
                System.out.println(" (Distance: " + distance[i] + ")");
            }
        }
    }

    // DFS Helper function
    private void dfsHelper(int vertex, int[] distance, int[] parent, int currentDistance) {
        System.out.print(vertex + " "); // Print the vertex for traversal

        for (int neighbor : adjacencyList[vertex]) { // Iterate over neighbors
            // Relaxation step: Check if this path is shorter
            if (currentDistance + 1 < distance[neighbor]) {
                distance[neighbor] = currentDistance + 1;
                parent[neighbor] = vertex;
                // Recursive call for the neighbor
                dfsHelper(neighbor, distance, parent, currentDistance + 1);
            }
        }
    }
    
    // Dijkstra's Algorithm
    public void dijkstra(int startVertex) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(arr -> arr[1]));
        int[] distances = new int[vertices];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[startVertex] = 0;

        pq.add(new int[]{startVertex, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int vertex = current[0];
            int currentDistance = current[1];

            for (int neighbor : adjacencyList[vertex]) {
                int newDist = currentDistance + 1; // Assuming unit weights
                if (newDist < distances[neighbor]) {
                    distances[neighbor] = newDist;
                    pq.add(new int[]{neighbor, newDist});
                }
            }
        }

        System.out.println("Shortest distances from vertex " + startVertex + ":");
        System.out.println(Arrays.toString(distances));
    }

    // Cycle Detection (Undirected Graph)
    public boolean hasCycleUndirected() {
        boolean[] visited = new boolean[vertices];
        for (int vertex = 0; vertex < vertices; vertex++) {
            if (!visited[vertex]) {
                if (cycleDFS(vertex, visited, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean cycleDFS(int vertex, boolean[] visited, int parent) {
        visited[vertex] = true;

        for (int neighbor : adjacencyList[vertex]) {
            if (!visited[neighbor]) {
                if (cycleDFS(neighbor, visited, vertex)) {
                    return true;
                }
            } else if (neighbor != parent) {
                return true;
            }
        }

        return false;
    }
}

