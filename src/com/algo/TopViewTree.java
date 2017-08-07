package com.algo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;
import java.util.Map.Entry;

import com.base.Tree;

public class TopViewTree {
	static TreeMap<Integer, Integer> map = new TreeMap<>();

	public static void topView(Tree root) {
		if (root == null) {
			return;
		}
		Queue<Tree> queue = new LinkedList<>();
		root.setLevel(0);
		queue.add(root);
		while (!queue.isEmpty()) {
			Tree node = queue.remove();
			int dis = node.getLevel();
			if (!map.containsKey(dis)) {
				map.put(dis, node.getData());
			}
			if (node.getLeft() != null) {
				node.getLeft().setLevel(dis - 1);
				queue.add(node.getLeft());
			}
			if (node.getRight() != null) {
				node.getRight().setLevel(dis + 1);
				queue.add(node.getRight());
			}
		}
		for (Entry<Integer, Integer> entry : map.entrySet()) {
			System.out.println(entry.getValue());
		}
	}

	public static void main(String[] args) {
		Tree root = Tree.getBasicTree();
		TopViewTree.topView(root);
	}

}
