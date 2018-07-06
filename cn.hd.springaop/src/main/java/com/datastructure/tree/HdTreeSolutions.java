package com.datastructure.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.junit.Test;

/**
 * @author dudu
 *
 */
public class HdTreeSolutions {
	List<Integer> li = new ArrayList<Integer>();
	List<List<Integer>> allList = new ArrayList<List<Integer>>();
	/**
	 * 递归遍历
	 * @param root
	 * @return
	 */
	public List<Integer> preorderTraversal(HdTree root) {
		if(root != null) {
			li.add(root.val);
			preorderTraversal(root.left);
			preorderTraversal(root.right);
			
		}
        return li;
    }
	
	/**
	 * @param root
	 * @return
	 */
	public List<Integer> preorderTraversalCyclic(HdTree root) {
		Stack<HdTree> stack = new Stack<HdTree>();
		while(!stack.empty() || root != null) {
			//读取数据
			while(root != null) {
				li.add(root.val);
				stack.push(root);//放根结点入栈是为了下次继续入栈右边孩子结点
				root = root.left;
			}
			if(!stack.empty()) {
				root = stack.pop();
				root = root.right;
			}
		}
		return li;
	}
	
	/**
	 * @param root
	 * @return
	 */
	public List<Integer> inorderTraversal(HdTree root) {
		if(root != null) {
			inorderTraversal(root.left);
//			System.out.println(root.val);
			li.add(root.val);
			inorderTraversal(root.right);
		}
        return li;
    }
	
	/**
	 * 非递归遍历二叉树：
	 * 借助栈来实现:
	 * Stack:
	 * 中序： 左边压栈到最底，然后读取元素，接着将右边的压栈，再读取元素，
	 * 			再压栈右边元素
	 * @param root
	 * @return
	 */
	public List<Integer> midOrder(HdTree root) {
		//
		Stack<HdTree> stack = new Stack<HdTree>();
		while(root != null || !stack.empty()) {
			while(root != null) {
				stack.push(root);
				root = root.left;
			}
			if(!stack.empty()) {
				root = stack.pop();//读取当前元素
				li.add(root.val);
				root = root.right;
			}
		}
		return li;
	}
	
	/**
	 * @param root
	 */
	public void preOrder(HdTree root) {
		if(root != null) {
			System.out.println(root.val);
			preOrder(root.left);
			preOrder(root.right);
		}
	}
	/**
	 * @param root
	 * @return
	 */
	public List<Integer> preOrder2(HdTree root) {
		if(root != null) {
			li.add(root.val);
			preOrder2(root.left);
			preOrder2(root.right);
		}
		return li;
	}
	
	/**
	 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
	 * 给定二叉树: [3,9,20,null,null,15,7],
返回其层次遍历结果如下:
每一层也是一个list结构
 [
  [3],
  [9,20],
  [15,7]
]
借助队列来实现:
	根结点入队
	根的左孩子存在就入队,
	根的右孩子存在就入队,
	然后再出队,先进先出==》
	再次调用的时候就把根结点的左孩子置为根结点
	 * @param root
	 * @return
	 */
	public List<List<Integer>> levelOrder(HdTree root) {
		
	    return null;
	}

	
	@Test
	public void test01() {
		HdTree ht1 = new HdTree(3, null, null);
		HdTree ht = new HdTree(2, ht1, null);
		HdTree ht2 = new HdTree(1, null, ht);
		List<Integer> list = midOrder(ht2);
//		List<Integer> list = inorderTraversal(ht2);
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
