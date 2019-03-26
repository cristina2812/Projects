package Presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.SQLException;
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

import BusinessLayer.CustomerBL;
import Model.customer;
import Model.product;


public class InterfataCustomer extends JFrame implements ActionListener{
	
	public JFrame frame = new JFrame();
	public JPanel panel = new JPanel();
	JLabel lbl_IdCustomer = new JLabel("IdCustomer");
	JLabel lbl_NameCustomer = new JLabel("NameCustomer");
	JLabel lbl_Address = new JLabel("Address");
	JTextField txt_IdCustomer = new JTextField();
	JTextField txt_NameCustomer = new JTextField();
	JTextField txt_Address = new JTextField();
	JButton BackCustomer = new JButton("Back");
	JButton AddCustomer = new JButton("Add");
	JButton DeleteCustomer = new JButton("Delete");
	JButton ViewCustomer = new JButton("View");
	JButton EditCustomer = new JButton("Edit");
	JScrollPane scrollPaneCustomer = new JScrollPane();
	JTable tableCustomer = new JTable();
	
	private customer cust=new customer();
	CustomerBL c=new CustomerBL();
	
	private static final String DBURL = "jdbc:mysql://localhost:3306/tema3";
	private static final String USER = "root";
	private static final String PASS = "";

	public InterfataCustomer() {
	
		frame.setBounds(100, 100, 621, 439);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		panel.setBounds(0, 0, 605, 400);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		
		lbl_IdCustomer.setBounds(10, 11, 107, 14);
		panel.add(lbl_IdCustomer);
		
		lbl_NameCustomer.setBounds(10, 39, 107, 14);
		panel.add(lbl_NameCustomer);
		
		lbl_Address.setBounds(10, 64, 107, 14);
		panel.add(lbl_Address);
		
		txt_IdCustomer.setBounds(127, 8, 210, 20);
		panel.add(txt_IdCustomer);
		txt_IdCustomer.setColumns(10);
		
		txt_NameCustomer.setColumns(10);
		txt_NameCustomer.setBounds(127, 36, 210, 20);
		panel.add(txt_NameCustomer);
	
		txt_Address.setColumns(10);
		txt_Address.setBounds(127, 61, 210, 20);
		panel.add(txt_Address);
	
		BackCustomer.setBounds(444, 35, 89, 23);
		panel.add(BackCustomer);
		
		AddCustomer.setBounds(28, 122, 89, 23);
		panel.add(AddCustomer);
	
		DeleteCustomer.setBounds(164, 122, 89, 23);
		panel.add(DeleteCustomer);
	
		ViewCustomer.setBounds(299, 122, 89, 23);
		panel.add(ViewCustomer);
		
		EditCustomer.setBounds(444, 122, 89, 23);
		panel.add(EditCustomer);
	
		scrollPaneCustomer.setBounds(10, 175, 585, 214);
		panel.add(scrollPaneCustomer);
	
		scrollPaneCustomer.setRowHeaderView(tableCustomer);
		
		BackCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent l) {
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frame.dispose();
			}
			
		});
		AddCustomer.addActionListener(new ActionListener() {
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
				
			String  s="INSERT INTO tema3.customer(idCustomer, nameCustomer, AddressCustomer) VALUES (";
			s=s.concat("'");
			s=s.concat(String.valueOf(getTxt_IdCustomer()));
			s=s.concat("'");
			s=s.concat(",");
			s=s.concat("'");
			s=s.concat(String.valueOf(getTxt_NameCustomer()));
			s=s.concat("'");
			s=s.concat(",");
			s=s.concat("'");
			s=s.concat(String.valueOf(getTxt_Address()));
			s=s.concat("');");
			 try {
					stmt.execute(s);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					String eroare = "Nu s-a putut insera un Customer.";
					JOptionPane.showMessageDialog(new JFrame(), eroare, "Eroare", JOptionPane.ERROR_MESSAGE);
				}
			System.out.println(String.valueOf(getTxt_IdCustomer()));
			System.out.println(String.valueOf(getTxt_NameCustomer()));
			System.out.println(String.valueOf(getTxt_Address()));
			}
			
		});
		DeleteCustomer.addActionListener(new ActionListener() {
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
				
			String  s="DELETE FROM tema3.customer WHERE ";
			s=s.concat("idCustomer='");
			s=s.concat(String.valueOf(getTxt_IdCustomer()));
			s=s.concat("';");
			 try {
					stmt.execute(s);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					String eroare = "Nu s-a putut realiza stergerea unui Customer.";
					JOptionPane.showMessageDialog(new JFrame(), eroare, "Eroare", JOptionPane.ERROR_MESSAGE);
				}
			System.out.println(String.valueOf(getTxt_IdCustomer()));
			System.out.println(String.valueOf(getTxt_NameCustomer()));
			System.out.println(String.valueOf(getTxt_Address()));
			}
				
			
		});
		ViewCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent l) {
				String [] prod=new String[100];
				List<customer> list=c.getCustomerList();
				DefaultTableModel model=new DefaultTableModel();
				
				Object[] coloana=new Object[3];
				 coloana[0]="idCustomer";
				 coloana[1]="nameCustomer";
				 coloana[2]="AddressCustomer";
			
				 
				 model.setColumnIdentifiers(coloana);
				 model.addRow(coloana);
				 
				for(int i=0; i<list.size();i++) {
					prod[0]=new String(String.valueOf(list.get(i).getIdCustomer()));
					prod[1]=new String(String.valueOf(list.get(i).getNameCustomer()));
					prod[2]=new String(String.valueOf(list.get(i).getAdrressCustomer()));
	
					
					model.addRow(prod);
				}
				tableCustomer.setModel(model);
				tableCustomer.repaint();
				tableCustomer.revalidate();
				
			}
			
		});
		EditCustomer.addActionListener(new ActionListener() {
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
				
			String  s="UPDATE tema3.customer SET ";
			s=s.concat("nameCustomer= '");
			s=s.concat(String.valueOf(getTxt_NameCustomer()));
			s=s.concat("'");
			s=s.concat(",");
			s=s.concat("AddressCustomer= ");
			s=s.concat("'");
			s=s.concat(String.valueOf(getTxt_Address()));
			s=s.concat("' WHERE idCustomer = ");
			s=s.concat(String.valueOf(getTxt_IdCustomer()));
			s=s.concat(";");
			 try {
				stmt.execute(s);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				String eroare = "Eroare update Customer.";
				JOptionPane.showMessageDialog(new JFrame(), eroare, "Eroare", JOptionPane.ERROR_MESSAGE);
			}
			System.out.println(String.valueOf(getTxt_IdCustomer()));
			System.out.println(String.valueOf(getTxt_NameCustomer()));
			System.out.println(String.valueOf(getTxt_Address()));
			}
			
		});
	}

	public String getTxt_IdCustomer() {
		return txt_IdCustomer.getText();
	}

	public void setTxt_IdCustomer(JTextField txt_IdCustomer) {
		this.txt_IdCustomer = txt_IdCustomer;
	}

	public String getTxt_NameCustomer() {
		return txt_NameCustomer.getText();
	}

	public void setTxt_NameCustomer(JTextField txt_NameCustomer) {
		this.txt_NameCustomer = txt_NameCustomer;
	}

	public String getTxt_Address() {
		return txt_Address.getText();
	}

	public void setTxt_Address(JTextField txt_Address) {
		this.txt_Address = txt_Address;
	}

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
