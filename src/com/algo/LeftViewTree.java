package com.algo;

import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.TreeMap;

import com.base.Tree;

public class LeftViewTree {
	static int maxLevel = 0;
	static Map<Integer, Tree> map = new TreeMap<>();

	public static void leftView(Tree root) {
		int level = 1;
		leftViewUtil(root, level);
	}

	private static void leftViewUtil(Tree root, int level) {
		if (root == null) {
			return;
		}
		if (level > maxLevel) {
			System.out.println(root.getData());
			maxLevel = level;
		}
		if (root.getLeft() != null) {
			leftViewUtil(root.getLeft(), level + 1);
		}
		if (root.getRight() != null) {
			leftViewUtil(root.getRight(), level + 1);
		}

	}

	public static void leftViewMap(Tree root) {
		Queue<Tree> queue = new LinkedList<>();
		root.setLevel(1);
		queue.add(root);
		while (!queue.isEmpty()) {
			Tree node = queue.remove();
			int level = node.getLevel();
			if (!map.containsKey(level)) {
				map.put(level, node);
			}
			if (node.getLeft() != null) {
				node.getLeft().setLevel(level + 1);
				queue.add(node.getLeft());
			}
			if (node.getRight() != null) {
				node.getRight().setLevel(level + 1);
				queue.add(node.getRight());
			}
		}
		System.out.println("using map:");
		for (Entry<Integer, Tree> entry : map.entrySet()) {
			System.out.println(entry.getValue().getData());
		}
	}

	public static void main(String[] args) {
		Tree tree = Tree.getBasicTree();
		LeftViewTree.leftView(tree);
		LeftViewTree.leftViewMap(tree);

	}

}
