package datastructures;

import java.util.*;
import java.util.stream.Collectors;

public class Graph {

    private Set<Vertex> vertices;
    private Set<Edge> edges;
    private Map<Vertex, Set<Edge>> adjacencyList;

    public Graph() {
        vertices = new HashSet<>();
        edges = new HashSet<>();
        adjacencyList = new HashMap<>();
    }

    public boolean addVertex(Vertex vertex) {
        return vertices.add(vertex);
    }

    public boolean addVertices(Collection<Vertex> vertices) {
        return this.vertices.addAll(vertices);
    }

    public boolean removeVertex(Vertex vertex) {
        return vertices.remove(vertex);
    }

    public boolean addEdge(Edge edge) {
        if (!edges.add(edge)) return false;

        adjacencyList.putIfAbsent(edge.vertex1, new HashSet<>());
        adjacencyList.putIfAbsent(edge.vertex2, new HashSet<>());

        adjacencyList.get(edge.vertex1).add(edge);
        adjacencyList.get(edge.vertex2).add(edge);

        return true;
    }

    public boolean removeEdge(Edge edge) {
        if (!edges.remove(edge)) return false;
        
        Set<Edge> edgesOfVertex1 = adjacencyList.get(edge.vertex1);
        Set<Edge> edgesOfVertex2 = adjacencyList.get(edge.vertex2);

        if (edgesOfVertex1 != null) edgesOfVertex1.remove(edge);
        if (edgesOfVertex2 != null) edgesOfVertex2.remove(edge);

        return true;
    }

    public Set<Vertex> getAdjacencyVertices(Vertex vertex) {
        return adjacencyList.get(vertex).stream()
                .map(edge -> edge.vertex1.equals(vertex) ? edge.vertex2 : edge.vertex1)
                .collect(Collectors.toSet());
    }

    public Set<Vertex> getVertices() {
        return Collections.unmodifiableSet(vertices);
    }

    public Set<Edge> getEdges() {
        return Collections.unmodifiableSet(edges);
    }

    public Map<Vertex, Set<Edge>> getAdjList() {
        return Collections.unmodifiableMap(adjacencyList);
    }

    private class Vertex {

        private int label;

        public Vertex(int label) {
            this.label = label;
        }

        public int getLabel() {
            return label;
        }

        public void setLabel(int label) {
            this.label = label;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Vertex vertex = (Vertex) o;

            return label == vertex.label;
        }

        @Override
        public int hashCode() {
            return label;
        }
    }

    private class Edge {

        private Vertex vertex1, vertex2;
        private int weight;

        public Edge(Vertex vertex1, Vertex vertex2, int weight) {
            this.vertex1 = vertex1;
            this.vertex2 = vertex2;
            this.weight = weight;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Edge edge = (Edge) o;

            if (weight != edge.weight) return false;
            if (!vertex1.equals(edge.vertex1)) return false;
            return vertex2.equals(edge.vertex2);
        }

        @Override
        public int hashCode() {
            int result = vertex1.hashCode();
            result = 31 * result + vertex2.hashCode();
            result = 31 * result + weight;
            return result;
        }
    }
}
