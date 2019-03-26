package Presentation;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Interfata extends JFrame implements ActionListener {
	
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton btnCustomer = new JButton("Customer");
	JButton btnProduct = new JButton("Product");
	JButton btnOrder = new JButton("Order");
	
	public InterfataCustomer interfata=new InterfataCustomer();
	public InterfataOrder interfata1= new InterfataOrder();
	public InterfataProduct interfata2= new InterfataProduct();

	
	public Interfata() {
		
		frame.setBounds(100, 100, 454, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		
		panel.setBounds(0, 0, 489, 324);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		panel.setVisible(true);
		
		btnCustomer.setBounds(146, 44, 128, 35);
		panel.add(btnCustomer);
		
		
		btnProduct.setBounds(146, 118, 128, 35);
		panel.add(btnProduct);
		
	
		btnOrder.setBounds(146, 187, 128, 35);
		panel.add(btnOrder);
		
		btnCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent l) {
				interfata.frame.setVisible(true);
				interfata.panel.setVisible(true);
				
				interfata2.frame.setVisible(false);
				interfata2.panel.setVisible(false);
				interfata1.frame.setVisible(false);
				interfata1.panel.setVisible(false);
			
			}
			
		});
		btnProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent l) {
				interfata.frame.setVisible(false);
				interfata.panel.setVisible(false);
				
				interfata2.frame.setVisible(true);
				interfata2.panel.setVisible(true);
				interfata1.frame.setVisible(false);
				interfata1.panel.setVisible(false);
			
			}
			
		});
		btnOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent l) {
				interfata.frame.setVisible(false);
				interfata.panel.setVisible(false);
				
				interfata2.frame.setVisible(false);
				interfata2.panel.setVisible(false);
				interfata1.frame.setVisible(true);
				interfata1.panel.setVisible(true);
				interfata1.comboCustomer();
				interfata1.comboProduct();
			}
			
		});
		
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void actionAddCustomer(ActionListener l) {
		this.btnCustomer.addActionListener(l);
	}
	
	public void actionAddProduct(ActionListener l) {
		this.btnProduct.addActionListener(l);
	}
	public void actionAddOrder(ActionListener l) {
		this.btnOrder.addActionListener(l);
	}
}
