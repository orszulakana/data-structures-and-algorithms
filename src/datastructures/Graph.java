package datastructures;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Graph {

    private Set<Vertex> vertices;
    private Set<Edge> edges;
    private Map<Vertex, Set<Edge>> adjacencyList;

    public Graph() {
        vertices = new HashSet<>();
        edges = new HashSet<>();
        adjacencyList = new HashMap<>();
    }

    //TODO: addVertex, addVertices, addEdge, removeVertex, removeVertices, removeEdge


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
