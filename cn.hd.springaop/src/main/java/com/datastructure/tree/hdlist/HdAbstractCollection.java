package com.datastructure.tree.hdlist;

/**
 * @author dudu
 * 抽象集合实现接口
 * @param <T>
 * This class provides a skeletal implementation of the <tt>Collection</tt>
 * interface, to minimize the effort required to implement this interface. <p>
 *
 */
public abstract class HdAbstractCollection<T> implements HdCollection<T> {

	/* (non-Javadoc)
	 * @see com.datastructure.tree.hdlist.HdCollection#size()
	 */
	public abstract int size();

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	public void clear() {
		// TODO Auto-generated method stub

	}

	public boolean add(T t) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
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

}
