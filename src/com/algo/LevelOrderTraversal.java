package com.algo;

import java.util.LinkedList;
import java.util.Queue;

import com.base.Tree;

public class LevelOrderTraversal {

	public static void levelOrder(Tree root) {
		Queue<Tree> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Tree node = queue.remove();
			System.out.print(node.getData() + " ");
			if (node.getLeft() != null) {
				queue.add(node.getLeft());
			}
			if (node.getRight() != null) {
				queue.add(node.getRight());
			}
		}
	}

	public static void levelOrderLevelWise(Tree root) {
		Queue<Tree> queue = new LinkedList<>();
		int prevLevel = 0;
		root.setLevel(1);
		queue.add(root);
		while (!queue.isEmpty()) {
			Tree node = queue.remove();
			int currLevel = node.getLevel();
			if (prevLevel < currLevel) {
				prevLevel = currLevel;
				System.out.println();
			}
			System.out.print(node.getData() + " ");
			if (node.getLeft() != null) {
				node.getLeft().setLevel(currLevel + 1);
				queue.add(node.getLeft());
			}
			if (node.getRight() != null) {
				node.getRight().setLevel(currLevel + 1);
				queue.add(node.getRight());
			}
		}
	}

	public static void main(String[] args) {
		Tree root = Tree.getBasicTree();
		LevelOrderTraversal.levelOrder(root);
		Tree root1 = Tree.getBasicTree();
		LevelOrderTraversal.levelOrderLevelWise(root1);

	}

}
