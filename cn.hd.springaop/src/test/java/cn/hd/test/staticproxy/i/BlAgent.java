package cn.hd.test.staticproxy.i;

public class BlAgent implements Sell {

	private Vendor vendor;
	public BlAgent(Vendor vendor) {
		this.vendor = vendor;
	}
	
	public void sell() {
		//在这个的前面我们可以添加部分逻辑：
		//如果我们只卖货给小孩子呢？
		//我们直接可以在这个位置添加处理逻辑，而不用修改原来的Vendor的sell代码
		this.vendor.sell();
	}

	public void advise() {
		this.vendor.advise();
	}

}
