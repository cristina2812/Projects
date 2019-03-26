package BusinessLayer;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import Model.product;

public class ProductBll {
	public ArrayList<product> getProductList(){
		ArrayList<product> productList=new ArrayList<product>();
		final String DBURL = "jdbc:mysql://localhost:3306/tema3";
		final String USER = "root";
		final String PASS = "";
		Connection connection = null;
		String query ="SELECT *FROM tema3.product;";
		try {
			connection = (Connection) DriverManager.getConnection(DBURL, USER, PASS);
		} catch (SQLException e) {
			//e.printStackTrace();
			String eroare = "Eroare conectare.";
			JOptionPane.showMessageDialog(new JFrame(), eroare, "Eroare", JOptionPane.ERROR_MESSAGE);
		}
		Statement stmt = null;
		ResultSet rs;
		try {
			stmt = (Statement) connection.createStatement();
			rs=stmt.executeQuery(query);
			product pro;
			while(rs.next()) {
				pro=new product(rs.getInt("idProduct"),rs.getString("nameProduct"),rs.getInt("quantity"), rs.getInt("pret"));
				productList.add(pro);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			String eroare = "Eroare conectare.";
			JOptionPane.showMessageDialog(new JFrame(), eroare, "Eroare", JOptionPane.ERROR_MESSAGE);
		}
		return productList;
		
	}
}
