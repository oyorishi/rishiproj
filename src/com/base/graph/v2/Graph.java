package com.base.graph.v2;

import java.util.LinkedList;
import java.util.ListIterator;

public class Graph {
	int V;
	LinkedList<Integer> adjList[];

	@SuppressWarnings("unchecked")
	public Graph(int v) {
		V = v;
		adjList = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			adjList[i] = new LinkedList<>();
		}
	}

	public void addEdge(int v, int w) {
		adjList[v].add(w);
	}

	public static void bfs(Graph graph, int source) {
		boolean[] visited = new boolean[graph.V];
		LinkedList<Integer> queue = new LinkedList<>();
		queue.add(source);
		visited[source] = true;
		while (!queue.isEmpty()) {
			source = queue.poll();
			System.out.print(source + " ");
			ListIterator<Integer> it = graph.adjList[source].listIterator();
			while (it.hasNext()) {
				int v = it.next();
				if (visited[v] == false) {
					visited[v] = true;
					queue.add(v);
				}
			}
		}
	}

	public static void main(String[] args) {
		Graph graph = new Graph(4);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		graph.addEdge(3, 3);

		Graph.bfs(graph, 2);

	}

}
