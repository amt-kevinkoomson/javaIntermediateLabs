package WeekOne.Algorithms.Dijkstra;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private List<Vertex> vertices;
    private List<List<Integer>> adjacencyMatrix;
    public Graph() {
        vertices = new ArrayList<Vertex>();
        adjacencyMatrix = new ArrayList<>();
    }

    public void addVertex(String value) {
        // add new vertex to record
        vertices.add(new Vertex(value));
        // create new edge list to be appended to graph
        List<Integer> edges = new ArrayList<>();
        for(int i = 0; i < vertices.size(); i++){
            edges.add(0);
        }
        // update edges of existing vertices on graph
        for(List<Integer> edge : adjacencyMatrix){
            edge.add(0);
        }
        adjacencyMatrix.add(edges);
        System.out.println("Vertex " + value + " added");
    }
    public Vertex getVertex(int index){
        return vertices.get(index);
    }
    public void addEdge(int startVertex, int endVertex, int weight){
        adjacencyMatrix.get(startVertex).set(endVertex, weight);
        System.out.println("Edge " + startVertex + " to " + endVertex + " added");
    }

    public List<List<Integer>> getAdjacencyMatrix(){
        System.out.println("graph adjacency matrix");
        for(List<Integer> list : adjacencyMatrix){
            System.out.println(list);
        }
        System.out.println(" ");
        return adjacencyMatrix;
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        System.out.println("New graph created");
        graph.getAdjacencyMatrix();
        // Add vertices
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.getAdjacencyMatrix();
        // Add edges
        graph.addEdge(0,1,6);
        graph.addEdge(0,3,1);
        graph.addEdge(1,2,5);
        graph.addEdge(1,3,2);
        graph.addEdge(1,4,2);
        graph.addEdge(2,1,5);
        graph.addEdge(2,4,5);
        graph.addEdge(3,0,1);
        graph.addEdge(3,1,2);
        graph.addEdge(3,4,1);
        graph.addEdge(4,1,4);
        graph.addEdge(4,2,5);
        graph.addEdge(4,3,1);
        // graph populates
        graph.getAdjacencyMatrix();
        Dijkstra dijkstra = new Dijkstra(graph.getAdjacencyMatrix(), graph.vertices.size());
        System.out.println(dijkstra.getPreviousVertices() + " previous vertices");
        System.out.println(dijkstra.getShortestDistances() + " shortest distances");
        System.out.println(dijkstra.getUnvisitedVertices() + " unvisited vertices");
    }
}
