package app;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();

        // Додавання вершин
        graph.addVertex(0);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);

        // Додавання ребер
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 0);

        // Виведення графа
        graph.printGraph();

        // Перевірка методів
        System.out.println("Has vertex 1: " + graph.hasVertex(1)); // true
        System.out.println("Has edge between 0 and 1: " + graph.hasEdge(0, 1)); // true

        // Видалення ребра
        graph.removeEdge(0, 1);
        System.out.println("Has edge between 0 and 1 after removal: " + graph.hasEdge(0, 1)); // false

        // Видалення вершини
        graph.removeVertex(2);
        graph.printGraph();
    }
}