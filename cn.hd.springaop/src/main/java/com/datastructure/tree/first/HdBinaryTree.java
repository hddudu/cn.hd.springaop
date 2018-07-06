package com.datastructure.tree.first;

import java.util.List;

/**
 * @author dudu
 * 二叉树类，实现BinaryTree<T>接口，泛型T指定结点的元素类型
 * @param <T>
 */
public class HdBinaryTree<T> implements IHdBinaryTreeNode<T> {

	private HdBinaryTreeNode<T> root;//根节点,结点结构为二叉链表
	
	private int i;//作为 create(T[] prelist)方法的成员变量使用
	
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int height() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void preOrder() {
		// TODO Auto-generated method stub
		
	}

	public void inOrder() {
		// TODO Auto-generated method stub
		
	}

	public void postOrder() {
		// TODO Auto-generated method stub
		
	}

	public void levelOrder() {
		// TODO Auto-generated method stub
		
	}

	public List<T> preOrderResult() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<T> inOrderResult() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<T> postOrderResult() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<T> levelOrderResult() {
		// TODO Auto-generated method stub
		return null;
	}

	public HdBinaryTreeNode<T> search(T key) {
		// TODO Auto-generated method stub
		return null;
	}

	public HdBinaryTreeNode<T> getParent(HdBinaryTreeNode<T> node) {
		// TODO Auto-generated method stub
		return null;
	}

	public void insertRoot(T x) {
		// TODO Auto-generated method stub
		
	}

	public HdBinaryTreeNode<T> insertChild(HdBinaryTreeNode<T> node, T x,
			boolean leftChild) {
		// TODO Auto-generated method stub
		return null;
	}

	public void removeChild(HdBinaryTreeNode<T> p, boolean leftChild) {
		// TODO Auto-generated method stub
		
	}

	public void removeAll() {
		// TODO Auto-generated method stub
		
	}

}
