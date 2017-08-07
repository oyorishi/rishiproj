package com.base.graph;

public class Utility {
	public static AdjListNode newAdjListNode(int dest) {
		AdjListNode newNode = new AdjListNode();
		newNode.dest = dest;
		newNode.next = null;
		return newNode;
	}

	public static Graph createGraph(int v) {
		Graph graph = new Graph();
		graph.V = v;
		graph.arr = new AdjList[v];
		for (int i = 0; i < v; i++) {
			graph.arr[i] = new AdjList();
			graph.arr[i].head = null;
		}
		return graph;
	}

	public static void addEdges(Graph graph, int src, int dest) {
		AdjListNode newNode = newAdjListNode(dest);
		newNode.next = graph.arr[src].head;
		graph.arr[src].head = newNode;

		newNode = newAdjListNode(src);
		newNode.next = graph.arr[dest].head;
		graph.arr[dest].head = newNode;
	}

	public static void printGraph(Graph graph) {
		for (int i = 0; i < graph.V; i++) {
			AdjListNode pCrawl = graph.arr[i].head;
			while (pCrawl != null) {
				System.out.print(pCrawl.dest + " ");
				pCrawl = pCrawl.next;
			}
			System.out.println();
		}
	}

}
