package com.datastructure.queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import org.junit.Test;

import com.datastructure.tree.HdTree;

/**
 * @author dudu
 *
 */
public class Solutions {
	
	/**
	 * 给定一个经过编码的字符串，返回它解码后的字符串。
编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
	 * @param s
	 * @return
	 */
	public String decodeString(String s) {
		//只解析一层中括号
		//这个中括号成对的和栈的应用挂钩
		//我应该写完栈的应用
		//递归栈
		//
		return null;
    }
	
	/**
	 * 将栈的栈底元素删除并返回
	 * @param stack
	 * @return
	 */
	public static int getAndRemoveLastElement(Stack<Integer> stack) {
		int result = stack.pop();
		System.out.println(result);
		if(stack.isEmpty()) {
			return result;
		} else {
			int last = getAndRemoveLastElement(stack);
			stack.push(result);
			return last;
		}
	}
	
	/**
	 * 逆序一个栈
	 * @param stack
	 */
	public static void reverse(Stack<Integer> stack) {
		if(stack.isEmpty()) {
			return;
		}
		int i=getAndRemoveLastElement(stack);
		reverse(stack);
		stack.push(i);
	}
	
	@Test
	public void test() {
		Stack<Integer> stack = new Stack<Integer>();
		stack.add(3);
		stack.add(2);
		stack.add(1);
		reverse(stack);
//		for(int i = 0, len = stack.size(); i < len; i++) {
//			System.out.print(stack.pop() + " ");//1 2 3 
//		}
		System.out.println("-----");
		while (!stack.empty()) {  
            System.out.println(stack.pop());  
        }  
	}
	
	 private int getAndRemoveBottom(Stack<Integer> stack) {  
	        int result = stack.pop();  
	        if (stack.empty()) {  
	            return result;  
	        } else {  
	            int bottom = getAndRemoveBottom(stack);  
	            stack.push(result);  
	            return bottom; // 第一轮时，返回栈底元素1  
	        }  
	    } 
	 /** 
	     * 每层递归取出栈底的元素并缓存到变量中，直到栈空； 
	     *  
	     * 然后逆向将每层变量压入栈，最后实现原栈数据的逆序。 
	     *  
	     * @param stack 
	     */  
	    public void reverse2(Stack<Integer> stack) {  
	        if (stack.empty()) {  
	            return;  
	        }  
	        int i = getAndRemoveBottom(stack); // 依次返回1、2、3  
	        reverse(stack);  
	        stack.push(i); // 依次压入3、2、1  
	    }  
	    
	    /**
	     * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组.
	     * @param root
	     * @return
	     */
	    public List<Double> averageOfLevels(HdTree root) {
	    	
	        return null;
	    }
	    
	    /**
	     * 给定一个二叉树，返回其节点值自底向上的层次遍历。 
	     * （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
	     * ①可以逆序遍历List<List<Integer>>
	     * Ⅱ 倒序输入，可以加入结点，最后翻转，
	     * 或者每次加入链表头部，建议使用双向链表，插入速度快
	     * @param root
	     * @return
	     */
	    public List<List<Integer>> levelOrderBottom(HdTree root) {
	    	List<List<Integer>> ret = new LinkedList<List<Integer>>();
	    	if(root == null)
	    		return ret;
	    	levelOrderCore(root, ret);
	    	return ret;
	    }
	    
	    public void levelOrderCore(HdTree root, List<List<Integer>> ret) {
//	    	int nextCount = 0;
//	    	int curCount = 1;
//	    	//队列，层次遍历
//	    	Queue<HdTree> queue = new LinkedList<HdTree>();
//	    	queue.offer(root);
//	    	List<Integer> temp = new LinkedList<Integer>();
//	    	while(!queue.isEmpty()) {
//	    		HdTree node = queue.poll();
//	    		temp.add(node.val);//3
//	    		curCount--;
//	    		if(node.left != null) {
//	    			queue.offer(node.left);//9
//	    		}
//	    		if(node.right != null) {
//	    			queue.offer(node.right);//20
//	    		}
//	    		if(curCount == 0) {
//	    			curCount = nextCount;//0=0
//	    			nextCount = 0;//0
//	    			//把结点添加到头部，使用双向链表LinkedList
//	    			ret.add(0, new LinkedList<Integer>(temp));
//	    			temp.clear();
//	    		}
//	    	}
	    	int nextCount = 0;  
	        int curCount = 1;  
	        // 队列，层次遍历  
	        Queue<HdTree> q = new LinkedList<HdTree>();  
	        q.offer(root);  
	        List<Integer> tmp = new LinkedList<Integer>();  
	        while (!q.isEmpty()) {  
	        	HdTree node = q.poll();  
	            tmp.add(node.val);  
	            curCount--;  
	            if (node.left != null) {  
	                q.offer(node.left);  
	                nextCount++;  
	            }  
	            if (node.right != null) {  
	                q.offer(node.right);  
	                nextCount++;  
	            }  
	            if (curCount == 0) {  
	                curCount = nextCount;  
	                nextCount = 0;  
	                // 把结点添加到头部，使用双向链表LinkedList  
	                ret.add(0, new LinkedList<Integer>(tmp));  
	                tmp.clear();  
	  
	            }  
	        }  
	    }
	    
	    /**
	     * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
	     * @param root
	     * @return
	     */
	    public List<List<Integer>> levelOrder(HdTree root) {
	    	//判断不为空
	    	//左孩子不为空，入队
	    	//右孩子不为空，入队
	    	//出队，然后遍历当前队列
//	    	Queue<HdTree> que = new LinkedList<HdTree>();//队列里面存放结点
//	    	List<List<Integer>> result = new ArrayList<List<Integer>>();//返回值
//	    	//如果空
//	    	if(root == null){
//	    		return null;//或者直接返回null
//	    	}
//	    	que.offer(root);//根结点入队==>表示第一个入队,所以队列size只有一个!
//	    	while(!que.isEmpty()) {
//	    		int levelNum = que.size();//获取当前结点的层数
//	    		System.out.println("levelNum: " + levelNum);
//	    		List<Integer> subList = new ArrayList<Integer>();
//	    		//遍历当前层结点
//	    		for(int i = 0; i < levelNum; i++) {
//	    			//队首出队，并将value加入子list
//	    			HdTree node = que.poll();
//	    			subList.add(node.val);
//	    			//将非空左右子树加入que
//	    			if(node.left != null) {
//	    				que.offer(node.left);
//	    			}
//	    			if(node.right != null) {
//	    				que.offer(node.right);
//	    			}
//	    		}
//	    		result.add(subList);
//	    	}
//	        return result;
	    	
	    	Queue<HdTree> queue = new LinkedList<HdTree>();
	        List<List<Integer>> result = new ArrayList<List<Integer>>();
	        //如果空
	        if(root == null)
	            return null;
	        queue.offer(root);//入队头结点，siez为1，当前层为1
	        while(!queue.isEmpty()){
	            int levelNum = queue.size();
	            List<Integer> subList = new ArrayList<Integer>();
	            //遍历每个结点
	            for(int i = 0; i < levelNum; i++){
	            	HdTree node = queue.poll();
	                subList.add(node.val);
	                //将左右子树加入queue
	                if(node.left != null) {
	                    queue.offer(node.left);
	                } 
	                if(node.right != null) {
	                    queue.offer(node.right);
	                }
	            }
	        result.add(subList);
	        }
//	    }
	    return result;
	   }
	    
	    @Test  
	    public void test02() {  
	    	HdTree root = new HdTree(3);
	        root.left = new HdTree(9);
	        root.right = new HdTree(20);
	        root.right.left = new HdTree(15);
	        root.right.right = new HdTree(7);

	        List<List<Integer>> res = levelOrder(root);

	        for(List<Integer> is : res){
	            for(Integer i : is){
	                System.out.print(i + ", ");
	            }
	            System.out.println();
	        }
	    }
	    
	    public static void main(String[] args) {
	        Solutions solu = new Solutions();
	        HdTree root = new HdTree(3);
	        root.left = new HdTree(9);
	        root.right = new HdTree(20);
	        root.right.left = new HdTree(15);
	        root.right.right = new HdTree(7);
	
//	        List<List<Integer>> res = solu.levelOrder(root);
//	        //反转List
//	        solu.reverseListList(res);
//	        List<List<Integer>> res = solu.levelOrder(root);
	        List<List<Integer>> res = solu.levelOrderBottom(root);
//	        List<List<Integer>> res = solu.reverseListList(solu.levelOrder(root));;
	        //反转List
	        
//	        for(int i = res.size() - 1; i >= 0; i--) {
//	        	List<Integer> temp = res.get(i);
//	        	System.out.println("temp: "+temp);
//	        	for(Integer t : temp) {
//	        		System.out.print(t + ", ");
//	        	}
//	        	System.out.println();
//	        }
	        
	        for(List<Integer> is : res){
	            for(Integer i : is){
	                System.out.print(i + ", ");
	            }
	            System.out.println();
	        }
				
		}
	    
	    /**
	     * @param srcList
	     * @return
	     */
	    public List<List<Integer>> reverseListList(List<List<Integer>> srcList) {
	    	List<List<Integer>> lastList = new ArrayList<List<Integer>>();
//	    	System.arraycopy(src, srcPos, dest, destPos, length);
	    	for(int len = srcList.size() - 1; len >= 0; len--) {
	    		List<Integer> temp = srcList.get(len);
//	    		for(int lenTwo = temp.size() - 1; lenTwo >= 0 ; lenTwo--) {
//	    			List<Integer> tempList = new ArrayList<Integer>();
//	    			System.out.println(temp.get(lenTwo));
//	    			tempList.add(temp.get(lenTwo));
//	    		}
	    		for(int i = 0, len2 = temp.size(); i < len2; i++) {
	    			List<Integer> tempList = new ArrayList<Integer>();
	    			tempList.add(temp.get(i));
	    		}
	    		lastList.add(temp);
	    	}
	    	return lastList;
	    }
	    
	    
	    @Test  
	    public void test01() {  
	        Stack stack = new Stack(); // Stack继承Vector，默认容量是10  
	        stack.push(1);  
	        stack.push(2);  
	        stack.push(3);  
	        Solutions rStack = new Solutions();  
	        rStack.reverse2(stack);  
	        System.out.println("----");
	        while (!stack.empty()) {  
	            System.out.println(stack.pop());  
	        }  
	    }  
}
