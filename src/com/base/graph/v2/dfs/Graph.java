package com.base.graph.v2.dfs;

import java.util.LinkedList;
import java.util.ListIterator;

public class Graph {
	int V;
	LinkedList<Integer>[] adjList;

	@SuppressWarnings("unchecked")
	public Graph(int v) {
		this.V = v;
		adjList = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			adjList[i] = new LinkedList<>();
		}
	}

	public void addEdge(int v, int w) {
		adjList[v].add(w);
	}

	public void dfs(int source) {
		boolean[] visited = new boolean[V];
		dfsUtil(source, visited);
	}

	public void dfsUtil(int s, boolean[] visited) {
		System.out.print(s + " ");
		visited[s] = true;
		ListIterator<Integer> it = adjList[s].listIterator();
		while (it.hasNext()) {
			int n = it.next();
			if (visited[n] == false) {
				dfsUtil(n, visited);
			}
		}

	}

	void fun2(int arr[], int start_index, int end_index) {
		if (start_index >= end_index)
			return;
		int min_index;
		int temp;

		/*
		 * Assume that minIndex() returns index of minimum value in array
		 * arr[start_index...end_index]
		 */
		min_index = minIndex(arr, start_index, end_index);

		temp = arr[start_index];
		arr[start_index] = arr[min_index];
		arr[min_index] = temp;

		fun2(arr, start_index + 1, end_index);
	}

	private int minIndex(int[] arr, int start_index, int end_index) {

		return Math.min(arr[start_index], arr[end_index]);
	}

	public static void main(String[] args) {
		Graph g = new Graph(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
		g.dfs(2);
		int[] arr = {2,10,6,5,6,8};
		g.fun2(arr, 10, 5);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

}
