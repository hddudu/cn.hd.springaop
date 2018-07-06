package com.datastructure.tree.hdlist;


/**
 * @author dudu
 *
 * @param <T>
 */
public interface HdCollection<T> {
	
//	Collection<E>
	
	int size();//集合有大小
	
	boolean isEmpty();//判空的方法
	
	void clear();//清空的方法
	
	//增删改查
	boolean add(T t);
	
	boolean remove(Object o);
	
	boolean contains(Object o);
	
	//转数组处理的方法
	Object[] toArray();
	
	<T> T[] toArray(T[] a);
	
	//****比较****
	int hashCode();
	
	boolean equals(Object o);
}
