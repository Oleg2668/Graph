package app;

import java.util.*;

import java.util.*;

public class Graph {
    private Map<Integer, List<Integer>> adjacencyList;

    public Graph() {
        adjacencyList = new HashMap<>();
    }

    // a. Метод addVertex(int vertex), що додає вершину до графу.
    public void addVertex(int vertex) {
        adjacencyList.putIfAbsent(vertex, new ArrayList<>());
    }

    // b. Метод addEdge(int source, int destination), що додає ребро між двома вершинами.
    public void addEdge(int source, int destination) {
        if (!adjacencyList.containsKey(source)) {
            addVertex(source);
        }
        if (!adjacencyList.containsKey(destination)) {
            addVertex(destination);
        }
        adjacencyList.get(source).add(destination);
        adjacencyList.get(destination).add(source); // Для ненаправленого графа
    }

    // c. Метод removeVertex(int vertex), що видаляє вершину з графу.
    public void removeVertex(int vertex) {
        if (!adjacencyList.containsKey(vertex)) {
            return;
        }
        adjacencyList.values().forEach(e -> e.remove((Integer) vertex));
        adjacencyList.remove(vertex);
    }

    // d. Метод removeEdge(int source, int destination), що видаляє ребро між двома вершинами.
    public void removeEdge(int source, int destination) {
        List<Integer> sourceList = adjacencyList.get(source);
        List<Integer> destList = adjacencyList.get(destination);
        if (sourceList != null) {
            sourceList.remove((Integer) destination);
        }
        if (destList != null) {
            destList.remove((Integer) source);
        }
    }

    // e. Метод hasVertex(int vertex), що перевіряє чи існує вершина у графі.
    public boolean hasVertex(int vertex) {
        return adjacencyList.containsKey(vertex);
    }

    // f. Метод hasEdge(int source, int destination), що перевіряє чи існує ребро між двома вершинами у графі.
    public boolean hasEdge(int source, int destination) {
        return adjacencyList.getOrDefault(source, Collections.emptyList()).contains(destination);
    }

    // Метод для друку графа
    public void printGraph() {
        for (var entry : adjacencyList.entrySet()) {
            System.out.println("Vertex " + entry.getKey() + " is connected to " + entry.getValue());
        }
    }
}