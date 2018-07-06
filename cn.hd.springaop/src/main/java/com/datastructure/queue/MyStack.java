package com.datastructure.queue;

import java.util.LinkedList;

/**
 * @author dudu
 *
 */
public class MyStack {
	
	LinkedList<Integer> queueA;
	LinkedList<Integer> queueB;
	
	/** Initialize your data structure here. */
    public MyStack() {
        this.queueA = new LinkedList<Integer>();
        this.queueB = new LinkedList<Integer>();
        System.out.println("初始化queueB:" + queueB.size());
        System.out.println("初始化queueA:" + queueA.size());
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        if(queueA.size() == 0 && queueB.size() == 0) {
        	queueA.addLast(x);
        }else if(queueA.size() != 0) {
        	queueA.addLast(x);
        } else if(queueB.size() != 0) {
        	queueB.addLast(x);
        }
        System.out.println("push: queueB:" + queueB.size());
        System.out.println("push: queueA:" + queueA.size());
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int in = -1;
        if(queueA.size() == 0 && queueB.size() == 0) {
        	return -1;
        }
        System.out.println("queueB:" + queueB.size());
        System.out.println("queueA:" + queueA.size());
        if(queueB.size() == 0) {
        	while(queueA.size() > 0) {
        		in = queueA.removeFirst();
        		if(queueA.size() != 0) {
        			queueB.addLast(in);
        		}
        	}
        } else if(queueA.size() == 0){
        	while(queueB.size() > 0) {
        		in = queueB.removeFirst();
        		if(queueB.size() != 0) {
        			queueA.addLast(in);
        		}
        	}
        }
        return in;
    }
    
    /** Get the top element. */
    public int top() {
    	int in = -1;
        if(queueA.size() == 0 && queueB.size() == 0) {
        	return -1;
        }
        if(queueB.size() == 0) {
        	while(queueA.size() > 0) {
        		in = queueA.removeFirst();
        		queueB.addLast(in);
        	}
        } else if(queueA.size() == 0){
        	while(queueB.size() > 0) {
        		in = queueB.removeFirst();
        		queueA.addLast(in);
        	}
        }
        return in;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queueA.isEmpty() && queueB.isEmpty();
    }
    public static void main(String[] args) {
    	  MyStack obj = new MyStack();
    	  
    	  obj.push(1);
    	  int param_2 = obj.pop();
    	  System.out.println(param_2);
//    	  int param_3 = obj.top();
    	  boolean param_4 = obj.empty();
    	  System.out.println(param_4);
	}
}
