package Presentation;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import BusinessLayer.OrderBll;
import Model.customer;
import Model.order;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class InterfataOrder extends JFrame implements ActionListener {
	public InterfataProduct interfatap;
	public JFrame frame = new JFrame();
	public JPanel panel = new JPanel();
	JLabel order_NameCustomer = new JLabel("NameCustomer");
	JLabel order_NameProduct = new JLabel("NameProduct");
	JLabel order_Quantity = new JLabel("Quantity");
	JComboBox NameCustomer_order = new JComboBox();
	JComboBox NameProduct_order = new JComboBox();
	JButton AddOrder = new JButton("Add");
	JButton BackOrder = new JButton("Back");
	JScrollPane scrollPaneOrder = new JScrollPane();
	JTable tableOrder = new JTable();
	JButton View_order = new JButton("View");

	private static final String DBURL = "jdbc:mysql://localhost:3306/tema3";
	private static final String USER = "root";
	private static final String PASS = "";
	private final JTextField txt_quantity = new JTextField();

	OrderBll o =new OrderBll();
	public InterfataOrder() {
		txt_quantity.setBounds(151, 71, 186, 17);
		txt_quantity.setColumns(10);

		frame.setBounds(100, 100, 676, 404);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		panel.setBounds(0, 0, 660, 365);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		order_NameCustomer.setBounds(10, 11, 101, 14);
		panel.add(order_NameCustomer);

		order_NameProduct.setBounds(10, 40, 101, 14);
		panel.add(order_NameProduct);

		order_Quantity.setBounds(10, 74, 101, 14);
		panel.add(order_Quantity);

		NameCustomer_order.setBounds(151, 8, 186, 20);
		panel.add(NameCustomer_order);

		NameProduct_order.setBounds(151, 37, 186, 20);
		panel.add(NameProduct_order);

		AddOrder.setBounds(466, 36, 89, 23);
		panel.add(AddOrder);

		BackOrder.setBounds(466, 7, 89, 23);
		panel.add(BackOrder);

		scrollPaneOrder.setBounds(10, 120, 640, 234);
		panel.add(scrollPaneOrder);

		scrollPaneOrder.setViewportView(tableOrder);
		
		panel.add(txt_quantity);
		
		
		View_order.setBounds(466, 70, 89, 23);
		panel.add(View_order);

		AddOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent l) {
				
				Connection connection = null;
				try {
					connection = (Connection) DriverManager.getConnection(DBURL, USER, PASS);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				Statement stmt = null;
				try {
					stmt = (Statement) connection.createStatement();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
				
				String customer = (String) NameCustomer_order.getSelectedItem();
				String product = (String) NameProduct_order.getSelectedItem();
				
				String s2="SELECT quantity FROM tema3.product WHERE nameProduct ='" +product +"';";
				Integer cantitate = null;
				try {
					ResultSet resultProduct = stmt.executeQuery(s2);
					while (resultProduct.next()) {
						cantitate=resultProduct.getInt(1);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					String eroare = "Eroare conectare.";
					JOptionPane.showMessageDialog(new JFrame(), eroare, "Eroare", JOptionPane.ERROR_MESSAGE);
				}
				
				if(cantitate-Integer.parseInt(getTxt_quantity())>=0) {
				
					
				
				String  s="INSERT INTO tema3.order(quantity, nameCustomer, nameProduct) VALUES (";
				s=s.concat("'");
				s=s.concat(String.valueOf(getTxt_quantity()));
				s=s.concat("'");
				s=s.concat(",");
				s=s.concat("'");
				s=s.concat(customer);
				s=s.concat("'");
				s=s.concat(",");
				s=s.concat("'");
				s=s.concat(product);
				s=s.concat("');");
				
				String s1="SELECT pret FROM tema3.product WHERE nameProduct ='" +product +"';";
				
				Integer result = null;
				try {
					ResultSet resultProduct = stmt.executeQuery(s1);
					while (resultProduct.next()) {
						result=resultProduct.getInt(1);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					String eroare = "Eroare inserare.";
					JOptionPane.showMessageDialog(new JFrame(), eroare, "Eroare", JOptionPane.ERROR_MESSAGE);
				}
				
				 try {
						stmt.execute(s);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						//e.printStackTrace();
						String eroare = "Eroare conectare.";
						JOptionPane.showMessageDialog(new JFrame(), eroare, "Eroare", JOptionPane.ERROR_MESSAGE);
					}
			System.out.println(product);
			System.out.println(customer);
			BufferedWriter bon=null;
			try {
				bon =new BufferedWriter(new FileWriter("Bon.txt"));
				int total=Integer.parseInt(getTxt_quantity())*result;

				
				bon.write("Clientul :" +customer +"  ");
				bon.write("Produs:" +product+"  ");
				bon.write("Cantitate: " +Integer.parseInt(getTxt_quantity())+"  ");
				bon.write("Pret: " +total+"  ");
			} catch(IOException e) {
				System.out.println("Exceptie");
			} finally {
				if(bon != null)
					try {
						bon.close();
					} catch (IOException e) {
						//e.printStackTrace();
						String eroare = "Eroare creare bon.";
						JOptionPane.showMessageDialog(new JFrame(), eroare, "Eroare", JOptionPane.ERROR_MESSAGE);
					}
			}
			Integer cantitate1=cantitate-Integer.parseInt(getTxt_quantity());
			System.out.println(cantitate1);
			String up="UPDATE tema3.product SET quantity=' "+ cantitate1+ "' WHERE nameProduct = '" + product +"';";
			Integer cantitate2 = null;
			 try {
					stmt.execute(up);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					String eroare = "Eroare update product.";
					JOptionPane.showMessageDialog(new JFrame(), eroare, "Eroare", JOptionPane.ERROR_MESSAGE);
				}
			}
				
			
			else if(cantitate<Integer.parseInt(getTxt_quantity())){
				String eroare = "Nu exista suficienta cantitate.";
				JOptionPane.showMessageDialog(new JFrame(), eroare, "Eroare", JOptionPane.ERROR_MESSAGE);
			}
			}
		});
		BackOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent l) {
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frame.dispose();
			}

		});
		
		View_order.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent l) {
				String [] prod=new String[100];
				List<order> list=o.getOrderList();
				//customer cust=new customer();
				DefaultTableModel model=new DefaultTableModel();
				
				Object[] coloana=new Object[3];
				 coloana[0]="quantity";
				 coloana[1]="nameCustomer";
				 coloana[2]="nameProduct";
			
				 
				 model.setColumnIdentifiers(coloana);
				// model.addRow(coloana);
				 
				for(int i=0; i<list.size();i++) {
					prod[0]=new String(String.valueOf(list.get(i).getQuantity()));
					prod[1]=new String(String.valueOf(list.get(i).getNameCustomer()));
					prod[2]=new String(String.valueOf(list.get(i).getNameProduct()));
	
					
					model.addRow(prod);
				}
				tableOrder.setModel(model);
				tableOrder.repaint();
				tableOrder.revalidate();
			}

		});
		
	}

	public void comboCustomer() {
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

		NameCustomer_order.removeAllItems();
		try {
			ResultSet resultCustomer = stmt.executeQuery("SELECT * FROM tema3.customer");
			while (resultCustomer.next()) {
				NameCustomer_order.addItem(resultCustomer.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			String eroare = "Eroare conectare.";
			JOptionPane.showMessageDialog(new JFrame(), eroare, "Eroare", JOptionPane.ERROR_MESSAGE);
		}
		

	}
	
	public void comboProduct() {
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

		NameProduct_order.removeAllItems();
		try {
			ResultSet resultProduct = stmt.executeQuery("SELECT * FROM tema3.product");
			while (resultProduct.next()) {
				NameProduct_order.addItem(resultProduct.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			String eroare = "Eroare select.";
			JOptionPane.showMessageDialog(new JFrame(), eroare, "Eroare", JOptionPane.ERROR_MESSAGE);
		}

	}
	
	
	

	public String getTxt_quantity() {
		return txt_quantity.getText();
	}

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}
}
