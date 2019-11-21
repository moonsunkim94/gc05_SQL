public class ordersInfo {
	private String orderdate;
	private int orderid, ordercount, custid, proid;
	
	public ordersInfo() {

	}
	
	public String getOrderdate() {
		return orderdate;
	}
	
	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}
	
	public int getOrderid() {
		return orderid;
	}
	
	public void setOrderid (int orderid) {
		this.orderid = orderid;
	}
	
	public int getOrdercount() {
		return ordercount;
	}
	
	public void setOrdercount (int ordercount) {
		this.ordercount = ordercount;
	}

	public int getCustid() {
		return custid;
	}
	
	public void setCustid (int custid) {
		this.custid = custid;
	}
	
	public int getProid() {
		return proid;
	}
	
	public void setProid(int proid) {
		this.proid = proid;
	}
}
