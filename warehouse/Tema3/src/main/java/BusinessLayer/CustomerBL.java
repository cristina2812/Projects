package BusinessLayer;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import Model.customer;
import Model.product;

public class CustomerBL {
	public ArrayList<customer> getCustomerList() {
		ArrayList<customer> customerList = new ArrayList<customer>();
		final String DBURL = "jdbc:mysql://localhost:3306/tema3";
		final String USER = "root";
		final String PASS = "";
		Connection connection = null;
		String query = "SELECT *FROM tema3.customer;";
		try {
			connection = (Connection) DriverManager.getConnection(DBURL, USER, PASS);
		} catch (SQLException e) {
			String eroare = "Eroare conectare.";
			JOptionPane.showMessageDialog(new JFrame(), eroare, "Eroare", JOptionPane.ERROR_MESSAGE);
		}
		Statement stmt = null;
		ResultSet rs;
		try {
			stmt = (Statement) connection.createStatement();
			rs = stmt.executeQuery(query);
			customer pro;
			while (rs.next()) {
				pro = new customer(rs.getInt("idCustomer"), rs.getString("nameCustomer"),
						rs.getString("AddressCustomer"));
				customerList.add(pro);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			String eroare = "Eroare conectare.";
			JOptionPane.showMessageDialog(new JFrame(), eroare, "Eroare", JOptionPane.ERROR_MESSAGE);
		}
		return customerList;

	}
}
