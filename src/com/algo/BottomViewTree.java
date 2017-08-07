package com.algo;

import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.TreeMap;

import com.base.Tree;

public class BottomViewTree {
	static TreeMap<Integer, Integer> map = new TreeMap<>();

	public static void bottomView(Tree root) {
		Queue<Tree> queue = new LinkedList<>();
		root.setLevel(0);
		queue.add(root);

		while (!queue.isEmpty()) {
			Tree node = queue.remove();
			int currDis = node.getLevel();
			map.put(currDis, node.getData());
			if (node.getLeft() != null) {
				node.getLeft().setLevel(currDis - 1);
				queue.add(node.getLeft());
			}
			if (node.getRight() != null) {
				node.getRight().setLevel(currDis + 1);
				queue.add(node.getRight());
			}
		}

		for (Entry<Integer, Integer> entry : map.entrySet()) {
			System.out.println(entry.getValue());
		}
	}

	public static void main(String[] args) {
		Tree tree = Tree.getBasicTree();
		BottomViewTree.bottomView(tree);

	}

}
