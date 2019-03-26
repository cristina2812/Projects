package Model;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class product {
	private int idProduct;
	private String nameProduct;
	private int quantity;
	private int pret;
	

	
	public  product(int idProduct, String nameProduct, int quantity,int pret) {
		this.idProduct=idProduct;
		this.nameProduct=nameProduct;
		this.quantity=quantity;
		this.pret=pret;
	}

	public int getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPret() {
		return pret;
	}

	public void setPret(int pret) {
		this.pret = pret;
	}
	
	
	

	@Override
	public String toString() {
		return "product [idProduct=" + idProduct + ", nameProduct=" + nameProduct + ", quantity=" + quantity + ", pret="
				+ pret + "]";
	}


}
