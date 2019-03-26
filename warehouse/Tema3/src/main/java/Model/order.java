package Model;

public class order {
	private int quantity;
	private String nameCustomer;
	private String NameProduct;
	
	public order(int quantity, String nameCustomer, String nameProduct) {
		this.quantity=quantity;
		this.nameCustomer=nameCustomer;
		this.NameProduct=nameProduct;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getNameCustomer() {
		return nameCustomer;
	}

	public void setNameCustomer(String nameCustomer) {
		this.nameCustomer = nameCustomer;
	}

	public String getNameProduct() {
		return NameProduct;
	}

	public void setNameProduct(String nameProduct) {
		NameProduct = nameProduct;
	}

	@Override
	public String toString() {
		return "order [quantity=" + quantity + ", nameCustomer=" + nameCustomer + ", NameProduct=" + NameProduct + "]";
	}




}
