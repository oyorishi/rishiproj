package com.base.graph;

public class Graph {
	int V;
	AdjList[] arr;

	public static void main(String[] args) {
		Graph graph = Utility.createGraph(5);
		Utility.addEdges(graph, 0, 1);
		Utility.addEdges(graph, 0, 4);
		Utility.addEdges(graph, 1, 2);
		Utility.addEdges(graph, 1, 3);
		Utility.addEdges(graph, 1, 4);
		Utility.addEdges(graph, 2, 3);
		Utility.addEdges(graph, 3, 4);
		Utility.printGraph(graph);
	}

}
