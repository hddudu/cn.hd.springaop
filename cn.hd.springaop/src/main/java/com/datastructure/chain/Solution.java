package com.datastructure.chain;

import org.junit.Test;

/**
 * java的=号解析
 * http://www.cnblogs.com/focusChen/articles/2497768.html
 * @author dudu
 *
 */
public class Solution {
	
	public static class ListNode {
		    int val;
		    ListNode next;
		    ListNode(int x) { val = x; }
	}
	
	//链表遍历
	/**
	 * @param root
	 */
	public static void browserLinkTable(ListNode root) {
		StringBuilder sb = new StringBuilder();
		if(root == null) {
			throw new IllegalArgumentException("头结点为空1");
		}
//		System.out.println(root);
		while(root != null) {
//			System.out.print( root.val + "->" );
			sb.append(root.val).append("->");
			root = root.next;
		}
		String sbString = sb.substring(0, sb.length() - 2).toString();
		System.out.println(sbString);
	}
	
	/**
	 * @param l1
	 * @param l2
	 * @return
	 */
	public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
		ListNode listnode = new ListNode(0);
//		System.out.println(listnode);//com.datastructure.chain.Solution$ListNode@421faab1
		ListNode p = new ListNode(0);//==>说明这个对象已经被抛弃了==>留下两个引用指针
//		System.out.println(p);//com.datastructure.chain.Solution$ListNode@2b71fc7e
		p = listnode;
//		System.out.println("p2:" + p);//p2:com.datastructure.chain.Solution$ListNode@421faab1
		int sum = 0;
		while(l1 != null || l2 != null || sum != 0) {
			if(l1 != null){
				sum += l1.val;
				l1 = l1.next;
			}
			if(l2 != null){
				sum += l2.val;
				l2 = l2.next;
			}
			p.next = new ListNode(sum % 10);//将指针或者引用回归到具体的对象
			System.out.println("0"+p);//0com.datastructure.chain.Solution$ListNode@2b71fc7e
			sum /= 10;
			p = p.next;
			System.out.println("1"+p);//1com.datastructure.chain.Solution$ListNode@5ce65a89
		}
		return listnode.next;
	}
	/**
	 * @param l1
	 * @param l2
	 * @return
	 */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if(l1 == null && l2 == null)
			return null;
		if(l1 == null)
			return l2;
		if(l2 == null)
			return l1;
		ListNode p1 = l1;
		ListNode p2 = l2;
		ListNode root = new ListNode(0);//链表头
//		ListNode r = root;//接受两个数的和
//		root.next = l1;//空节点0 指向l1 ==》 连接两个结点
		ListNode r = new ListNode(0);
		root.next = r;//连接两个结点
		
		//进位
		//头结点
		//链表长度不一致
		int sum;
		int carry = 0;//进位值: 保存下一次相加时候需要加的进位值
		while(p1 != null && p2 != null){
			sum = p1.val + p2.val + carry;
			p1.val = sum % 10;//本位 ==> 进到p1结点
			carry = sum / 10;//进位
			
			//下一次相加： 加了一位后指向下一个
			r.next = p1;
			r = p1;//赋值当前值 : 7 4 3
			
			p1 = p1.next;
			p2 = p2.next;
		}
		if(p1 == null){
			r.next = p2;
		}
		if(p2 == null){
			r.next = p1;
		}
		//最后一次相加 : 就是有一个长度长了多位
		if(carry == 1){
			//第一次相加时,r.next是第一个要相加的结点
			while(r.next != null){
				sum = r.next.val + carry;
				r.next.val = sum % 10;
				carry = sum / 10;
				r = r.next;
			}
			//都加完了还有进位
			if(carry == 1) {
				r.next = new ListNode(1);
			}
		}
        return root.next.next;
    }
	
	
	//链表反转
	/**
	 * 反转链表 : 失败的案例==》没有思路
	 * @param listnode
	 * @return
	 */
	public ListNode reverseListNode(ListNode listnode) {
		if(listnode == null)
			return null;
		if(listnode.next == null)
			return listnode;
		System.out.println(listnode.val);//5
		ListNode newListNode = new ListNode(listnode.val);
		//头插入法反转
		listnode = listnode.next;
		System.out.println(listnode + " : " +listnode.val);//4
		//每次要保存下头引用指向
		ListNode temp;//保证头引用
		while(listnode != null) {//cur(当前节点) pre（下一jiedian ） temp(保存当前节点给下次使用)
			temp = listnode;
			System.out.println("t"+temp.val);///5 4
//			System.out.println(temp.val);//5 4 5 4 5 4 5 4
			temp.next = newListNode;//4-->5
			newListNode = listnode;//头引用指向:==>其实就是这个
			//newListNode-->4
			System.out.println("0"+listnode.val);//5 4
			listnode = listnode.next;
			System.out.println("1"+listnode.val);//4 5
		}
		//插入最后一个节点 : listnode 是3 , 插入到头部
//		System.out.println(listnode.val);
//		while(listnode != null ) {
//			ListNode tempList = listnode.next;
//			tempList.next = listnode;
//			listnode = listnode.next;
//		}
//		System.out.println(newListNode);
		browserLinkTable(newListNode);
		return newListNode;
	}
	
	/**
	 * 递归： 从后往前进行反转==>递归压到栈底==》然后出栈
	 * @param listnode
	 * @return
	 */
	public ListNode reverseListNodeByDigui(ListNode listnode) {
		return null;
	}
	
	/**
	 * @param listnode 链表头节点
	 * @param n 删除的位置
	 * @return
	 */
	public int remove(ListNode listnode, int n) {
		if(listnode.next == null) return 1;
		int level = remove(listnode.next, n) + 1;
//		System.out.println("rank递归:" + level);
		if(level == n + 1) {
			listnode.next = listnode.next.next;//删除操作
			return Integer.MIN_VALUE;
		}
		return level;
	}
	
	/**
	 * 遍历： 从前往后进行反转：
	 * 	引用(指针)的指向改变==》那么原来的指向元素就不能再寻找了，所以需要临时节点进行保存下一指针(引用)
	 * @param listnode
	 * @return
	 */
	public ListNode reverseListNodeByBianli(ListNode listnode) {
		if(listnode == null)
			return null;
		if(listnode.next == null)
			return listnode;
		ListNode cur = listnode.next;//当前指针(引用)
		ListNode pre = listnode;//前一指针
		ListNode temp = null;
		while(cur != null){
			temp = cur.next;//保存下一引用(指针)
			
			//反转
			cur.next = pre;
			//指针后移
			pre = cur;
			cur = temp;
		}
		//原链表的头节点的指针域设为null:  没有加这句的话,就是原节点的下一个指向不为null,在无限循环的遍历中
		listnode.next = null;
		return pre;
	}
	
	/**
	 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
	 * 倒序 的 第n个结点
	 * 你能尝试使用一趟扫描实现吗？
	 * 双指针法
	 * @param head
	 * @param n
	 * @return
	 */
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		if(null == head || n <= 0) {
			return head;
		}
		ListNode first = head;
		ListNode second = head;
		//移动第一个指针
		while(n-- > 0) {
			first = first.next;
//			n--;
		}
		if(first == null) {//删除的是倒数第n - 1 个
			return head.next;
		}
		while(first.next != null) {
			first = first.next;
			second = second.next;
		}
		//删除
		second.next = second.next.next;
        return head;
    }
	
	 /**
	  * nums 是以“引用”方式传递的。也就是说，不对实参作任何拷贝
	 * @param nums
	 * @param val
	 * @return
	 */
	public static int removeElement(int[] nums, int val) {
		int[] copy = new int[nums.length];
		int j = 0;
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] == val) {
				continue;
			}
			copy[j++] = nums[i];
		}
	    return j;    
	 }
	
	/**
	 * 不使用数据拷贝
	 * @param nums
	 * @param val
	 * @return
	 */
	public static int removeElement2(int[] nums, int val) {
		int res = 0;
		for(int i = 0, len = nums.length; i < len; i++) {
			if(nums[i] != val) 
				nums[res++] = nums[i];
			
		}
	    return res;
	 }
	
	 /**
	  * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，
	  * 同时保持非零元素的相对顺序。
	  * 必须在原数组上操作，不能拷贝额外的数组。
	  *尽量减少操作次数
	  * @param nums
	 */
	public static void moveZeroes(int[] nums) {
//	   一个是0指针
//		一个是遍历指针
//		int[] nums = {0,1,0,3,12};
		int len = nums.length;
		int zeroIndex = 0;
		for(int i = zeroIndex; i < len; i++){
			if(nums[i] != 0) {
//				Swap(nums,i,zeroIndex);
				int temp = nums[i];//1 2 
				nums[i] = nums[zeroIndex];//0 
				nums[zeroIndex] = temp;
				zeroIndex++;
				System.out.println("zeroIndex: " + zeroIndex);
			}
		}
		for(int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
	}
	
	/**
	 * 删除链表中等于给定值 val 的所有节点。
	 * @param head
	 * @param val
	 * @return
	 */
	public static ListNode removeElements(ListNode head, int val) {
		//记录前一个节点
		//当前节点
		//删除操作
		if(head == null) {
			return null;
		}
		//只有一个节点的处理
		if(head.next == null && head.val == val) {
			head = null;
			return head;
		}
		ListNode cur = head.next;//当前
		ListNode pre = head;//前一个结点
		ListNode temp;
		while(cur.next != null) {
			temp = cur.next;
			//判断头结点
			if(pre.val == val) {
				//删除头结点
				head = head.next;
				cur = head.next;//下一个节点
				pre = head;//上一个
				continue;
			}
			//删除一个元素,移动一个指针
			if(cur.val ==  val) {
				pre.next = cur.next;//删除节点
				cur = temp;
//				cur = temp;11
				//删除了cur
//				cur = head;
//				pre = head;
//				pre.next = cur.next;
//				pre = pre.next;//后移一位
//				cur = temp;
			}else {//未删除元素,移动两个指针
//				pre = pre.next;
//				cur = temp;
				cur = temp;
				pre = cur;
				System.out.println(pre.val);//2
				System.out.println(cur.val);//3
				System.out.println(temp.val);//2
//				pre = head.next;
			}
		}
		//再比较最后一个元素
		if(cur != null && cur.val == val) {
			//删除最后一个元素
			pre.next = null;
		}
        return head;
    }
	
	/**
	 * 加入哑结点做法:
	 * @param head
	 * @param val
	 * @return
	 */
	public static ListNode removeElements2(ListNode head, int val) {
		ListNode yum = new ListNode(-1);
		ListNode pre = yum;
		yum.next = head;
		while(pre.next != null) {
			if(pre.next.val == val) {
				//删除结点
				ListNode temp = pre.next;//保存下一个节点
				pre.next = temp.next;//删除
				pre = temp;
			} else {
				pre = pre.next;//后移动
			}
		}
		return yum.next;
	}
	
	/**
	 * @param head
	 * @param val
	 * @return
	 */
	public static ListNode removeElements3(ListNode head, int val) {
		if(head == null) {
			return null;
		}
		while(head != null && head.val == val) {
			head = head.next;//全部都是一样的值
		}
		if(head == null) {
			return null;
		}
		ListNode node = head;
		while(node.next != null) {
			if(node.next.val == val) {
				node.next = node.next.next;
			} else {
				node = node.next;
			}
		}
		return head;
	}
	
	/**
	 * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，
	 * 你将只被给定要求被删除的节点
	 * @param node
	 */
	/*
这个题乍一看给的题头，立马呆住了，这玩意怎么做啊。就给个节点，没有前驱，
那我怎么连？没有链表，我怎么查？？？
但是巧妙的地方也在这里。
可以把要删除的节点，用该节点的后面节点进行覆盖，然后删掉后面那个节点就好了。
举个栗子：ABCDE，删除C，我们就先用D占C的位置，变成ABDDE，
然后把后面那个D删除，就可以得到ABDE~ 
	 */
	public static void deleteNode(ListNode node) {
        node.val = node.next.val;//先用后面的结点占用前面的位置
        node.next = node.next.next;
    }
	
	/*
(1) 我们需要先将链表的头结点保存下来，但是有一种情况需要注意：
头节点的值也要被删除的时候(head.val == val)，我们不能简单的直接将head保存起来
要把链表前面连续的需要删除的节点  从链表移除出去，得到一个头节点不需要被删除的
新链表(head.val != val)。
也就是第1个循环所做的事情。
这里需要再做一次非空校验，例如输入[1,1,1] ，1； 链表全是1，执行过(1)后，
新链表为空，直接返回null即可。
(2) node 的初始值是头节点（不等于val），循环遍历链表的时候，
每次执行的操作是 判断下一个节点 是否要删除，即 比较node.next.val 和 val，
如果相等，将 判断的节点（node.next）移出链表，
node.next  = node.next.next
如果不相等，继续往后遍历，node = node.next

(3) 最后返回head
	 */
	@Test
	public void test(){
		int[] nums = {0,1,0,3,12};
		moveZeroes(nums);
		System.out.println();
		ListNode h1 = new ListNode(5);
		ListNode h2 = new ListNode(3);
		ListNode h3 = new ListNode(2);
		ListNode h4 = new ListNode(2);
		ListNode h5 = new ListNode(2);
		ListNode h6 = new ListNode(4);
		h1.next = h2;
		h2.next = h3;
		h3.next = h4;
		h4.next = h5;
		h5.next = h6;
		browserLinkTable(h1);
		ListNode ttt = removeElements2(h1, 2);
		browserLinkTable(ttt);
		
		int[] a = {3,2,3,2};
		int len = removeElement(a, 3);
		System.out.println("len:"+len);
		ListNode l1 = new ListNode(5);
		ListNode l2 = new ListNode(4);
		ListNode l3 = new ListNode(3);
		l1.next = l2;
		l2.next = l3;
		
		ListNode l4 = new ListNode(5);
		ListNode l5 = new ListNode(7);
		ListNode l6 = new ListNode(6);
		l4.next = l5;
		l5.next = l6;
//		System.out.println(l1.val);
		browserLinkTable(l1);
//		browserLinkTable(l2);
//		browserLinkTable(l3);
//		ListNode temp = reverseListNode(l1);
		ListNode temp = reverseListNodeByBianli(l1);
		System.out.println("反转后:\n");
		browserLinkTable(temp);
		
		browserLinkTable(l4);
		ListNode temp2 = reverseListNodeByBianli(l4);
		System.out.println("反转后:\n");
		browserLinkTable(temp2);
//		browserLinkTable(l5);
//		browserLinkTable(l6);
		
//		ListNode node = addTwoNumbers(l1, l4);
		ListNode node = addTwoNumbers2(l1, l4);
		browserLinkTable(node);
	}
}
