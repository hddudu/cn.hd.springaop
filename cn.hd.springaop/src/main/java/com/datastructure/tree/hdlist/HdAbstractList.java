package com.datastructure.tree.hdlist;

import java.util.ListIterator;

public abstract class HdAbstractList<T>
	extends HdAbstractCollection<T>
	implements HdList<T> {
	
	/**
	 * 默认初始化空构造
	 */
	protected HdAbstractList() {
		
    }

	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

//	public int size() {
//		// TODO Auto-generated method stub
//		return 0;
//	}

	public boolean isEmpty() {
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

	public boolean add(T t) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean containsAll(HdCollection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean addAll(HdCollection<? extends T> c) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean addAll(int index, HdCollection<? extends T> c) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean removeAll(HdCollection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean retainAll(HdCollection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	public void clear() {
		// TODO Auto-generated method stub

	}

	public T get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	public T set(int index, T element) {
		// TODO Auto-generated method stub
		return null;
	}

	public void add(int index, T element) {
		// TODO Auto-generated method stub

	}

	public boolean remove(int index) {
		// TODO Auto-generated method stub
		return false;
	}

	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public ListIterator<T> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}
	 /**
     * The number of times this list has been <i>structurally modified</i>.
     * Structural modifications are those that change the size of the
     * list, or otherwise perturb it in such a fashion that iterations in
     * progress may yield incorrect results.
     *
     * <p>This field is used by the iterator and list iterator implementation
     * returned by the {@code iterator} and {@code listIterator} methods.
     * If the value of this field changes unexpectedly, the iterator (or list
     * iterator) will throw a {@code ConcurrentModificationException} in
     * response to the {@code next}, {@code remove}, {@code previous},
     * {@code set} or {@code add} operations.  This provides
     * <i>fail-fast</i> behavior, rather than non-deterministic behavior in
     * the face of concurrent modification during iteration.
     *
     * <p><b>Use of this field by subclasses is optional.</b> If a subclass
     * wishes to provide fail-fast iterators (and list iterators), then it
     * merely has to increment this field in its {@code add(int, E)} and
     * {@code remove(int)} methods (and any other methods that it overrides
     * that result in structural modifications to the list).  A single call to
     * {@code add(int, E)} or {@code remove(int)} must add no more than
     * one to this field, or the iterators (and list iterators) will throw
     * bogus {@code ConcurrentModificationExceptions}.  If an implementation
     * does not wish to provide fail-fast iterators, this field may be
     * ignored.
     */
	protected transient int modCount = 0;
	//检查索引
	private void rangeCheckForAdd(int index) {
		if(index < 0 || size() < index) {//size在collection已经实现,所以不用在当前里面实现
			 throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
		}
	}
	private String outOfBoundsMsg(int index) {
        return "Index: "+index+", Size: "+size();
    }

}
