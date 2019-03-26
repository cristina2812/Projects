package View;

import java.awt.ScrollPane;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



public class InterfaceAccount extends JFrame implements ActionListener {
	
	JFrame frame = new JFrame();
	JComboBox comboBox = new JComboBox();
	JButton btnBack = new JButton("Back");
	JButton btnSave = new JButton("Save");
	JLabel lbl_currency = new JLabel("Currency");
	JTextField txt_money = new JTextField();
	JTextField txt_idAccount = new JTextField();
	JTextField txt_Name = new JTextField();
	JLabel lbl_money = new JLabel("Money");
	JLabel lbl_id = new JLabel("IdAccount");
	JLabel lbl_Name = new JLabel("Name");
	JPanel panel = new JPanel();
	JComboBox combo_type = new JComboBox();
	JLabel lbl_type = new JLabel("Type Account");
	
	JTable table = new JTable();
	JScrollPane scrollPane = new JScrollPane();
	
	Object[] row = new Object[7];
	DefaultTableModel model = new DefaultTableModel();
	private JTextField txt_deposit;
	private JTextField txt_witdraw;
	
	public InterfaceAccount(){
	frame.setBounds(100, 100, 770, 553);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setLayout(null);
	
	panel.setBounds(0, 0, 754, 514);
	frame.getContentPane().add(panel);
	panel.setLayout(null);
	
	lbl_Name.setBounds(10, 11, 116, 21);
	panel.add(lbl_Name);
	
	lbl_id.setBounds(10, 43, 116, 21);
	panel.add(lbl_id);
	
	lbl_money.setBounds(10, 75, 116, 21);
	panel.add(lbl_money);

	txt_Name.setBounds(152, 11, 252, 20);
	panel.add(txt_Name);
	txt_Name.setColumns(10);
	
	txt_idAccount.setColumns(10);
	txt_idAccount.setBounds(152, 43, 252, 20);
	panel.add(txt_idAccount);
	
	txt_money.setColumns(10);
	txt_money.setBounds(152, 75, 252, 20);
	panel.add(txt_money);
	
	comboBox.addItem("RON");
	comboBox.addItem("$");
	comboBox.addItem("€");
	
	lbl_currency.setBounds(10, 233, 98, 17);
	panel.add(lbl_currency);
	
	btnSave.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			
			row[0] = getTxt_Name();
			row[1] = getTxt_idAccount();
			row[2] = getTxt_money();
			row[3]=combo_type.getSelectedItem().toString();
			row[4]=comboBox.getSelectedItem().toString();
			row[5]=getTxt_deposit();
			row[6]=getTxt_witdraw();
			
			
			model.addRow(row);
			//table.setModel(model);
			scrollPane.setViewportView(table);
			Object[] columns = { "Name", "IdAccout", "Money","Deposit","Withdraw", "TypeAccount", "Currency"};

			model.setColumnIdentifiers(columns);

			table.setModel(model);
			table.setVisible(true);
			table.repaint();
			table.revalidate();
		}
	});
	btnSave.setBounds(557, 177, 125, 31);
	panel.add(btnSave);
	

	btnBack.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
	});
	btnBack.setBounds(557, 226, 125, 31);
	panel.add(btnBack);
	
	
	comboBox.setBounds(152, 231, 88, 20);
	panel.add(comboBox);
	
	lbl_type.setBounds(10, 192, 116, 21);
	panel.add(lbl_type);
	
	
	combo_type.setBounds(152, 188, 88, 20);
	panel.add(combo_type);
	
	combo_type.addItem("Saving");
	combo_type.addItem("Spending");
	
	
	scrollPane.setBounds(10, 275, 721, 228);
	panel.add(scrollPane);
	
	table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"Name", "IdAccout", "Money","Deposit","Withdraw", "TypeAccount", "Currency"
			}
		));
	
	
	scrollPane.setColumnHeaderView(table);
	
	JLabel lbl_deposit = new JLabel("Deposit");
	lbl_deposit.setBounds(10, 107, 116, 21);
	panel.add(lbl_deposit);
	
	txt_deposit = new JTextField();
	txt_deposit.setColumns(10);
	txt_deposit.setBounds(152, 108, 252, 20);
	panel.add(txt_deposit);
	
	txt_witdraw = new JTextField();
	txt_witdraw.setColumns(10);
	txt_witdraw.setBounds(152, 139, 252, 20);
	panel.add(txt_witdraw);
	
	JLabel lbl_Withdraw = new JLabel("Withdraw");
	lbl_Withdraw.setBounds(10, 142, 116, 21);
	panel.add(lbl_Withdraw);
	
	}
	


	public String getTxt_money() {
		return txt_money.getText();
	}



	public void setTxt_money(JTextField txt_money) {
		this.txt_money = txt_money;
	}



	public String getTxt_idAccount() {
		return txt_idAccount.getText();
	}



	public void setTxt_idAccount(JTextField txt_idAccount) {
		this.txt_idAccount = txt_idAccount;
	}



	public String getTxt_Name() {
		return txt_Name.getText();
	}



	public void setTxt_Name(JTextField txt_Name) {
		this.txt_Name = txt_Name;
	}



	public String getTxt_deposit() {
		return txt_deposit.getText();
	}



	public void setTxt_deposit(JTextField txt_deposit) {
		this.txt_deposit = txt_deposit;
	}



	public String getTxt_witdraw() {
		return txt_witdraw.getText();
	}



	public void setTxt_witdraw(JTextField txt_witdraw) {
		this.txt_witdraw = txt_witdraw;
	}



	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
