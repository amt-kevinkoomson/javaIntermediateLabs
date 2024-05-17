package WeekOne.Algorithms.Dijkstra;

import java.util.ArrayList;
import java.util.List;

// class for Dijkstra's algorithm
public class Dijkstra {
    // List for storing the shortest distances of each vertex from starting vertex
    private List<Integer> shortestDistances = new ArrayList<>();
    // List for storing the previous vertex from starting vertex
    private List<Integer> previousVertices = new ArrayList<>();
    // List to keep track of unvisited vertices
    private List<Integer> unvisitedVertices = new ArrayList<>();

    public Dijkstra(List<List<Integer>> graph, Integer totalVertices) {
        // initialize parameters
        for(int i = 0; i < totalVertices; i++) {
            shortestDistances.add(Integer.MAX_VALUE);
            unvisitedVertices.add(i);
            previousVertices.add(0);
        }
        // set 0 as the starting vertex. To be changed later to a provided variable.
        shortestDistances.set(0, 0);
        // generate information about the shortest distance and paths
        while(!unvisitedVertices.isEmpty()) {
            Integer currentVertex = getNextVertex();
            // get all neighbouring vertices and their distances from current vertex
                // scan the current vertex for neighbours
            for(int i = 0; i < totalVertices; i++) {
                int edge = graph.get(currentVertex).get(i);
                // if there is an edge with the current vertex
                if(edge > 0) {
                    // if the recorded shortest distance to found neighbour is larger than the added distance from the current vertex
                    if(shortestDistances.get(i) > shortestDistances.get(currentVertex) + edge) {
                        // update the shortest distance to vertex with new smaller distance
                        shortestDistances.set(i, shortestDistances.get(currentVertex) + edge);
                        // update the previous vertex of found neighbour, which is the current vertex
                        previousVertices.set(i, currentVertex);
                    }

                }
            }

        }
    }

    private Integer getNextVertex() {
        Integer smallestDistance = Integer.MAX_VALUE;
        Integer vertex = -1;
        for(int v : unvisitedVertices) {
            if(shortestDistances.get(v) < smallestDistance) {
                smallestDistance = shortestDistances.get(v);
                vertex = v;
            }
        }
        unvisitedVertices.remove(vertex);
        return vertex;
    }

    public List<Integer> getShortestDistances() {
        return shortestDistances;
    }
    public List<Integer> getPreviousVertices() {
        return previousVertices;
    }

    public List<Integer> getUnvisitedVertices() {
        return unvisitedVertices;
    }
}
