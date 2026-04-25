package ShopingPackage;

public class Product {
	int pid;
	String pname;
	int qty;
	double price;
	
	Product(){
		
	}

	public Product(int pid, String pname, int qty, double price) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.qty = qty;
		this.price = price;
	}

	
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", qty=" + qty + ", price=" + price + "]";
	}
	

}
