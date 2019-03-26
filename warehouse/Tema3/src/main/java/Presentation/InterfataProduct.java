package Presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import BusinessLayer.ProductBll;
import Model.customer;
import Model.product;

public class InterfataProduct extends JFrame implements ActionListener {
	public JFrame frame = new JFrame();
	public JPanel panel = new JPanel();
	JLabel lbl_IdProduct = new JLabel("IdProduct");
	JLabel lbl_NameProduct = new JLabel("NameProduct");
	JLabel lbl_Quantity = new JLabel("Quantity");
	JTextField txt_IdProduct = new JTextField();
	JTextField txt_NameProduct = new JTextField();
	JTextField txt_Quantity = new JTextField();
	JButton BackProduct = new JButton("Back");
	JButton AddProduct = new JButton("Add");
	JButton DeleteProduct = new JButton("Delete");
	JButton ViewProduct = new JButton("View");
	JButton EditProduct = new JButton("Edit");
	JScrollPane scrollPaneProduct = new JScrollPane();
	JTable tableProduct = new JTable();
	JTextField txt_pret = new JTextField();
	JLabel lbl_pret = new JLabel("Price");
	ProductBll p=new ProductBll();
	private static final String DBURL = "jdbc:mysql://localhost:3306/tema3";
	private static final String USER = "root";
	private static final String PASS = "";
	
	
	
	public InterfataProduct() {

		frame.setBounds(100, 100, 621, 439);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		panel.setBounds(0, 0, 605, 400);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		lbl_IdProduct.setBounds(10, 11, 107, 14);
		panel.add(lbl_IdProduct);

		lbl_NameProduct.setBounds(10, 39, 107, 14);
		panel.add(lbl_NameProduct);

		lbl_Quantity.setBounds(10, 64, 107, 14);
		panel.add(lbl_Quantity);

		txt_IdProduct.setBounds(127, 8, 210, 20);
		panel.add(txt_IdProduct);
		txt_IdProduct.setColumns(10);

		txt_NameProduct.setColumns(10);
		txt_NameProduct.setBounds(127, 36, 210, 20);
		panel.add(txt_NameProduct);

		txt_Quantity.setColumns(10);
		txt_Quantity.setBounds(127, 61, 210, 20);
		panel.add(txt_Quantity);

		BackProduct.setBounds(444, 35, 89, 23);
		panel.add(BackProduct);

		AddProduct.setBounds(28, 122, 89, 23);
		panel.add(AddProduct);

		DeleteProduct.setBounds(164, 122, 89, 23);
		panel.add(DeleteProduct);

		ViewProduct.setBounds(299, 122, 89, 23);
		panel.add(ViewProduct);

		EditProduct.setBounds(444, 122, 89, 23);
		panel.add(EditProduct);

		scrollPaneProduct.setBounds(10, 175, 585, 214);
		panel.add(scrollPaneProduct);
		
		lbl_pret.setBounds(10, 97, 107, 14);
		panel.add(lbl_pret);

		txt_pret.setColumns(10);
		txt_pret.setBounds(127, 91, 210, 20);
		panel.add(txt_pret);


		scrollPaneProduct.setRowHeaderView(tableProduct);

		
		BackProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent l) {
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frame.dispose();
			}

		});
		AddProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent l) {
				Connection connection = null;
				try {
					connection = (Connection) DriverManager.getConnection(DBURL, USER, PASS);
				} catch (SQLException e) {
					//e.printStackTrace();
					String eroare = "Eroare conectare.";
					JOptionPane.showMessageDialog(new JFrame(), eroare, "Eroare", JOptionPane.ERROR_MESSAGE);
				}
				Statement stmt = null;
				try {
					stmt = (Statement) connection.createStatement();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					String eroare = "Eroare conectare.";
					JOptionPane.showMessageDialog(new JFrame(), eroare, "Eroare", JOptionPane.ERROR_MESSAGE);
				}

				String s = "INSERT INTO tema3.product(idProduct, nameProduct, quantity, pret) VALUES (";
				s = s.concat("'");
				s = s.concat(String.valueOf(getTxt_IdProduct()));
				s = s.concat("'");
				s = s.concat(",");
				s = s.concat("'");
				s = s.concat(String.valueOf(getTxt_NameProduct()));
				s = s.concat("'");
				s = s.concat(",");
				s = s.concat("'");
				s = s.concat(String.valueOf(getTxt_Quantity()));
				s = s.concat("'");
				s = s.concat(",");
				s = s.concat("'");
				s = s.concat(String.valueOf(getTxt_pret()));
				s = s.concat("');");
				try {
					stmt.execute(s);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					String eroare = "Eroare conectare.";
					JOptionPane.showMessageDialog(new JFrame(), eroare, "Eroare", JOptionPane.ERROR_MESSAGE);
				}
				System.out.println(String.valueOf(getTxt_IdProduct()));
				System.out.println(String.valueOf(getTxt_NameProduct()));
				System.out.println(String.valueOf(getTxt_Quantity()));
				System.out.println(String.valueOf(getTxt_pret()));
			}

		});

		DeleteProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent l) {

				Connection connection = null;
				try {
					connection = (Connection) DriverManager.getConnection(DBURL, USER, PASS);
				} catch (SQLException e) {
					//e.printStackTrace();
					String eroare = "Eroare conectare.";
					JOptionPane.showMessageDialog(new JFrame(), eroare, "Eroare", JOptionPane.ERROR_MESSAGE);
				}
				Statement stmt = null;
				try {
					stmt = (Statement) connection.createStatement();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					String eroare = "Eroare conectare.";
					JOptionPane.showMessageDialog(new JFrame(), eroare, "Eroare", JOptionPane.ERROR_MESSAGE);
				}

				String s = "DELETE FROM tema3.product WHERE ";
				s = s.concat("idProduct='");
				s = s.concat(String.valueOf(getTxt_IdProduct()));

				s = s.concat("';");
				try {
					stmt.execute(s);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					String eroare = "Eroare conectare.";
					JOptionPane.showMessageDialog(new JFrame(), eroare, "Eroare", JOptionPane.ERROR_MESSAGE);
				}
				System.out.println(String.valueOf(getTxt_IdProduct()));

			}

		});
		ViewProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent l) {
				String [] prod=new String[100];
				List<product> list=p.getProductList();
				DefaultTableModel model=new DefaultTableModel();
				
				Object[] coloana=new Object[4];
				 coloana[0]="idProduct";
				 coloana[1]="nameProduct";
				 coloana[2]="quantity";
				 coloana[3]="pret";
				 
				 model.setColumnIdentifiers(coloana);
				 model.addRow(coloana);
				 
				for(int i=0; i<list.size();i++) {
					prod[0]=new String(String.valueOf(list.get(i).getIdProduct()));
					prod[1]=new String(String.valueOf(list.get(i).getNameProduct()));
					prod[2]=new String(String.valueOf(list.get(i).getQuantity()));
					prod[3]=new String(String.valueOf(list.get(i).getPret()));
					
					model.addRow(prod);
				}
				tableProduct.setModel(model);
				tableProduct.repaint();
				tableProduct.revalidate();
			}

		});
		EditProduct.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent l) {
				Connection connection = null;
				try {
					connection = (Connection) DriverManager.getConnection(DBURL, USER, PASS);
				} catch (SQLException e) {
					//e.printStackTrace();
					String eroare = "Eroare conectare.";
					JOptionPane.showMessageDialog(new JFrame(), eroare, "Eroare", JOptionPane.ERROR_MESSAGE);
				}
				Statement stmt = null;
				try {
					stmt = (Statement) connection.createStatement();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					String eroare = "Eroare conectare.";
					JOptionPane.showMessageDialog(new JFrame(), eroare, "Eroare", JOptionPane.ERROR_MESSAGE);
				}

				String s = "UPDATE tema3.product SET ";
				s = s.concat("nameProduct= '");
				s = s.concat(String.valueOf(getTxt_NameProduct()));
				s = s.concat("'");
				s = s.concat(",");
				s = s.concat("quantity= ");
				s = s.concat("'");
				s = s.concat(String.valueOf(getTxt_Quantity()));
				s = s.concat("',");
				s = s.concat("pret= ");
				s = s.concat("'");
				s = s.concat(String.valueOf(getTxt_pret()));
				s = s.concat("' WHERE idProduct = ");
				s = s.concat(String.valueOf(getTxt_IdProduct()));
				s = s.concat(";");
				try {
					stmt.execute(s);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					String eroare = "Eroare update product.";
					JOptionPane.showMessageDialog(new JFrame(), eroare, "Eroare", JOptionPane.ERROR_MESSAGE);
				}
				System.out.println(String.valueOf(getTxt_IdProduct()));
				System.out.println(String.valueOf(getTxt_NameProduct()));
				System.out.println(String.valueOf(getTxt_Quantity()));
				System.out.println(String.valueOf(getTxt_pret()));
			}

		});
	}

	public JTable getTableProduct() {
		return tableProduct;
	}

	public void setTableProduct(JTable tableProduct) {
		this.tableProduct =tableProduct;
	}

	public String getTxt_IdProduct() {
		return txt_IdProduct.getText();
	}

	public void setTxt_IdProduct(JTextField txt_IdProduct) {
		this.txt_IdProduct = txt_IdProduct;
	}

	public String getTxt_NameProduct() {
		return txt_NameProduct.getText();
	}

	public void setTxt_NameProduct(JTextField txt_NameProduct) {
		this.txt_NameProduct = txt_NameProduct;
	}

	public String getTxt_pret() {
		return txt_pret.getText();
	}

	public void setTxt_pret(JTextField txt_pret) {
		this.txt_pret = txt_pret;
	}

	public String getTxt_Quantity() {
		return txt_Quantity.getText();
	}

	public void setTxt_Quantity(JTextField txt_Quantity) {
		this.txt_Quantity = txt_Quantity;
	}

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}
}
