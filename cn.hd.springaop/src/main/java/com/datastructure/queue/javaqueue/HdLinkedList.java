package com.datastructure.queue.javaqueue;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Iterator;

import com.datastructure.tree.hdlist.HdCollection;
import com.datastructure.tree.hdlist.HdList;

/**
 * @author dudu
 * 直接要实现的太多,中间加入抽象类解决冗余的问题
 * 继承这个：HdAbstractSequentialList,是方便集成集合数组ArrayList的相关方法Api
 * @param <T>
 * 实现Cloneable接口: 是为了能够克隆: 参考如下:
 * https://segmentfault.com/a/1190000011421580
 * 标识接口：没有任何方法定义，只是一个空接口的声明。
 */
/**
 * LinkedList 是一个继承于AbstractSequentialList的双向链表。
 * 它也可以被当作堆栈、队列或双端队列进行操作
 * ①双向链表
 * Ⅱ堆栈
 * 🌂队列
 * ④双端队列==》
 *  
 *  1：LinkedList 是一个继承于AbstractSequentialList的双向链表。
 *  	它也可以被当作堆栈、队列或双端队列进行操作
 *  2：LinkedList 实现 List 接口，能对它进行队列操作
 *  3：LinkedList 实现 Deque 接口，即能将LinkedList当作双端队列使用。
 *  4：LinkedList 实现了Cloneable接口，即覆盖了函数clone()，能克隆
 *  5：LinkedList 实现java.io.Serializable接口，
 *  	这意味着LinkedList支持序列化，能通过序列化去传输
 * 	6：LinkedList 是非同步的。
 * 
 * @author dudu
 *
 * @param <T>
 */
public class HdLinkedList<T>
	extends HdAbstractSequentialList<T>
	implements HdList<T>,HdDeque<T>,Serializable,Cloneable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5881152047367892069L;

	transient int size = 0;//transient==>阻止序列化,如果一定要序列化也是可以的
	//size==》
	transient Node<T> first;//队头地址引用指针==》header
	transient Node<T> last;//队尾地址引用指针
	
	/**
     * Constructs an empty list.
     */
    public HdLinkedList() {
    }
    
    public HdLinkedList(HdCollection<? extends T> c) {
    	this();
    	addAll(c);
    }
	
    public boolean addAll(HdCollection<? extends T> c) {
    	return addAll(size, c);
    }
    
	//	此类的对象可以被克隆: 实现了Cloneable接口表示这个类的对象可以被克隆
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	public void clear() {
		// TODO Auto-generated method stub

	}

	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	public void addFirst(T t) {
		// TODO Auto-generated method stub

	}

	public void addLast(T t) {
		// TODO Auto-generated method stub

	}

	public boolean offerFirst(T t) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean offerLast(T t) {
		// TODO Auto-generated method stub
		return false;
	}

	public T removeFirst() {
		// TODO Auto-generated method stub
		return null;
	}

	public T removeLast() {
		// TODO Auto-generated method stub
		return null;
	}

	public T pollFirst() {
		// TODO Auto-generated method stub
		return null;
	}

	public T pollLast() {
		// TODO Auto-generated method stub
		return null;
	}

	public T getFirst() {
		// TODO Auto-generated method stub
		return null;
	}

	public T getLast() {
		// TODO Auto-generated method stub
		return null;
	}

	public T peekFirst() {
		// TODO Auto-generated method stub
		return null;
	}

	public T peekLast() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean removeFirstOccurrence(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean removeLastOccurrence(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean add(T t) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean offer(T t) {
		// TODO Auto-generated method stub
		return false;
	}

	public T remove() {
		// TODO Auto-generated method stub
		return null;
	}

	public T poll() {
		// TODO Auto-generated method stub
		return null;
	}

	public T element() {
		// TODO Auto-generated method stub
		return null;
	}

	public T peek() {
		// TODO Auto-generated method stub
		return null;
	}

	public void push(T t) {
		// TODO Auto-generated method stub

	}

	public T pop() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean addAll(int index, HdCollection<? extends T> c) {
		//检查index的有效性
//		checkIndexPosition(index);
		//TODO:待完成
		Object[] a = c.toArray();
		int numNew = a.length;
		if(numNew == 0)
			return false;
		Node<T> prevd, succ;//前一个、后一个
		if(index == size) {
			succ = null;
			prevd = last;
		} else {
			succ = node(index);
			prevd = succ.prev;
		}
//		AbstractList<E>
		//开始copy
		for(Object o : a) {
			T t = (T) o;
			//TODO:待写复制
//			String
//			Node<T> newNode = new Node<T>(item, next, prev)
		}
		return super.addAll(index, c);
	}

	/**
	 * 如果要取元素的位置是整个list一半的左半边，那么从list的头开始向后遍历，遍历至要取元素的位置
	 * 否则从list一半的右半边开始寻找，也就是从尾部开始向前遍历，遍历至要取元素的位置
	 * @param index
	 * @return
	 */
	private Node<T> node(int index) {
		if(index < (size >> 1)) {
			//从左边开始找
			Node<T> x = first;
			for(int i = 0; i < index; i++)
				x = x.next;
			return x;
		} else {
			Node<T> x = last;
			for(int j = 0; j < index; j++) {
				x = x.prev;
			}
			return x;
		}
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}



	/**
	 * 内部数据结构: 队列内部类
	 * 静态内部类: 可以访问外部类
https://blog.csdn.net/hivon/article/details/606312
场景一：当某个类除了它的外部类，不再被其他的类使用时	
	可以说这个类只有在连接池这个类里有用，其他地方用不
	数据库连接池类
场景二：解决一些非面向对象的语句块
	我们也通过这个模板类将catch…finally…两段代码提出来了
	我们可以看到，正是这个实现了DataManager接口得匿名内部类的使用，
	才使得我们解决了对try…catch…finally…语句的改造
	我们现在来回想一下Spring框架的数据层，是不是正是使用了这种方法呢？
场景三：一些多算法场合
场景四：适当使用内部类，使得代码更加灵活和富有扩展性
	 * ***/
	private static class Node<T>{
		T item;
		Node<T> next;
		Node<T> prev;
		public Node(T item, Node<T> next, Node<T> prev) {
			super();
			this.item = item;
			this.next = next;
			this.prev = prev;
		}
	}
	/**
	 * 基于双向循环链表
	 * 	
	 */
	
}
