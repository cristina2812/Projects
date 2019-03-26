package Model;

public class order_product {
	private int quantity;
	private int quantity_order;
	private String nameProduct;
	private String nameCustomer;
	
	public order_product() {
		super();
	}
	public order_product(int quantity, int quantity_order, String nameProduct, String NameCustomer) {
		this.quantity=quantity;
		this.quantity_order=quantity_order;
		this.nameProduct=nameProduct;
		this.nameCustomer=nameCustomer;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getQuantity_order() {
		return quantity_order;
	}
	public void setQuantity_order(int quantity_order) {
		this.quantity_order = quantity_order;
	}
	public String getNameProduct() {
		return nameProduct;
	}
	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}
	public String getNameCustomer() {
		return nameCustomer;
	}
	public void setNameCustomer(String nameCustomer) {
		this.nameCustomer = nameCustomer;
	}
	@Override
	public String toString() {
		return "order_product [quantity=" + quantity + ", quantity_order=" + quantity_order + ", nameProduct="
				+ nameProduct + ", nameCustomer=" + nameCustomer + "]";
	}
}
