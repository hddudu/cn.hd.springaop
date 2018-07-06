package com.datastructure.last;

/**
 * synchronized可以保证方法或者代码块在运行时，
 * 同一时刻只有一个方法可以进入到临界区，
 * 同时它还可以保证共享变量的内存可见性==>保证内存可见性
 * @author dudu
 *	Java中每一个对象都可以作为锁，这是synchronized实现同步的基础： 
 * ①普通同步方法，锁是当前实例对象
 * Ⅱ静态同步方法，锁匙当前类的class对象
 * 🌂同步方法块，锁是括号里面的对象
 * 	反编译：
 * 		monitorenter:监视器进入，获取锁
 * 			
 * 		monitorexit:监视器退出，释放锁
 * 同步代码块是使用monitorenter和monitorexit指令实现的.
 * 同步方法（在这看不出来需要看JVM底层实现）
 * 	依靠的是方法修饰符上的ACC_SYNCHRONIZED实现。 
 * 
 */
public class SynchronizedTest {
	
	
}
