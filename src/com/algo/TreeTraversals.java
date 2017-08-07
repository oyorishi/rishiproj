package com.algo;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;

import com.base.Tree;

public class TreeTraversals {
	public void inOrder(Tree root) {
		if (root == null) {
			return;
		}
		inOrder(root.getLeft());
		System.out.print(root.getData() + " ");
		inOrder(root.getRight());
	}

	public void preOrder(Tree root) {
		if (root == null) {
			return;
		}
		System.out.print(root.getData() + " ");
		preOrder(root.getLeft());
		preOrder(root.getRight());
	}

	public void postOrder(Tree root) {
		if (root == null) {
			return;
		}
		postOrder(root.getLeft());
		postOrder(root.getRight());
		System.out.print(root.getData() + " ");
	}

	public void levelOrder(Tree root) {
		if (root == null) {
			return;
		}
		Queue<Tree> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Tree node = queue.remove();
			if (node != null) {
				System.out.print(node.getData() + " ");
			}
			if (node.getLeft() != null)
				queue.add(node.getLeft());
			if (node.getRight() != null)
				queue.add(node.getRight());
		}
	}

	public void levelOrderInline(Tree root) {
		if (root == null) {
			return;
		}
		Queue<Tree> queue = new LinkedList<>();
		queue.add(root);
		while (true) {
			int nodeCount = queue.size();
			if (nodeCount == 0) {
				break;
			}
			while (nodeCount > 0) {
				Tree node = queue.remove();
				System.out.print(node.getData() + " ");
				if (node.getLeft() != null) {
					queue.add(node.getLeft());
				}
				if (node.getRight() != null) {
					queue.add(node.getRight());
				}
				--nodeCount;
			}
			System.out.println();
		}
	}

	public int size(Tree root) {
		if (root == null) {
			return 0;
		}
		int lcount = size(root.getLeft());
		int rcount = size(root.getRight());
		return (lcount + 1 + rcount);
	}

	public boolean rootToLeafSum(Tree root, int sum) {
		if (root == null && sum != 0) {
			return false;
		}
		if (root == null && sum == 0) {
			return true;
		}
		boolean lsum = rootToLeafSum(root.getLeft(), sum - root.getData());
		boolean rsum = rootToLeafSum(root.getRight(), sum - root.getData());
		return lsum || rsum;
	}

	public boolean isSumExists(Tree root, int sum) {
		if (root != null && sum == 0) {
			return false;
		}
		if (root == null && sum == 0) {
			return true;
		}
		return sumExists(root, sum);
	}

	private boolean sumExists(Tree root, int sum) {
		if (sum == 0) {
			return true;
		}
		boolean b1 = false;

		if (root.getLeft() != null)
			b1 = sumExists(root.getLeft(), sum - root.getData());
		if (root.getRight() != null)
			b1 = sumExists(root.getRight(), sum - root.getData());
		return b1;
	}

	public boolean sumSubTree(Tree root, int sum) {
		if (root == null && sum != 0) {
			return false;
		}
		return sumSubTreeUtil(root, 0, sum);
	}

	private boolean sumSubTreeUtil(Tree root, int currentSum, int sum) {
		if (root == null) {
			currentSum = 0;
			return false;
		}
		int lsum = 0;
		int rsum = 0;
		return (sumSubTreeUtil(root.getLeft(), lsum, sum)) || (sumSubTreeUtil(root.getRight(), rsum, sum)) || ((lsum + rsum + root.getData()) == sum);
	}

	// Left view using level order
	// Left view using max level

	// Right view using level order last element
	// Right view using max level track and visiting right node first

	public void topView(Tree root) {
		Map<Integer, Integer> map = new HashMap<>();
		int horizontalDis = 0;
		topViewUtil(root, horizontalDis, map);
		for (Entry<Integer, Integer> entry : map.entrySet()) {
			System.out.print(entry.getValue() + " ");
		}
	}

	private void topViewUtil(Tree root, int horizontalDis, Map<Integer, Integer> map) {
		if (root == null) {
			return;
		}
		if (!map.containsKey(horizontalDis)) {
			map.put(horizontalDis, root.getData());
		}
		topViewUtil(root.getLeft(), horizontalDis - 1, map);
		topViewUtil(root.getRight(), horizontalDis + 1, map);
	}

	public void bottomView(Tree root) {
		int horDistance = 0;
		Map<Integer, Integer> map = new HashMap<>();
		bottomViewUtil(root, horDistance, map);
		for (Entry<Integer, Integer> entry : map.entrySet()) {
			System.out.print(entry.getValue() + " ");
		}
	}

	private void bottomViewUtil(Tree root, int horDistance, Map<Integer, Integer> map) {
		if (root == null) {
			return;
		}
		map.put(horDistance, root.getData());
		bottomViewUtil(root.getLeft(), horDistance - 1, map);
		bottomViewUtil(root.getRight(), horDistance + 1, map);
	}

	public static void main(String[] args) {
		Tree tree = new Tree();
		TreeTraversals treeTraversals = new TreeTraversals();
		System.out.println("in order:");
		treeTraversals.inOrder(tree.getBasicTree());
		System.out.println();
		System.out.println("pre order:");
		treeTraversals.preOrder(tree.getBasicTree());
		System.out.println();
		System.out.println("post order:");
		treeTraversals.postOrder(tree.getBasicTree());
		System.out.println();
		System.out.println("level order:");
		treeTraversals.levelOrder(tree.getBasicTree());
		System.out.println();
		System.out.println("level order inline:");
		treeTraversals.levelOrderInline(tree.getBasicTree());
		System.out.println();
		System.out.println("size:");
		System.out.println(treeTraversals.size(tree.getBasicTree()));
		System.out.println();
		System.out.println("root to leaf:");
		System.out.println(treeTraversals.rootToLeafSum(tree.getBasicTree(), 12));

		// System.out.println();
		// System.out.println("sum exists:");
		// System.out.println(treeTraversals.isSumExists(tree.getBasicTree(),
		// 6));

		System.out.println();
		System.out.println("sum subtree:");
		System.out.println(treeTraversals.sumSubTree(tree.getBasicTree(), 12));

		System.out.println();
		System.out.println("top view:");
		treeTraversals.topView(tree.getBasicTree());

		System.out.println();
		System.out.println("bottom view:");
		treeTraversals.bottomView(tree.getBasicTree());
	}

}
