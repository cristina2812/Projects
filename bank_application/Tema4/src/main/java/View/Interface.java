package View;

import java.awt.BorderLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.sound.midi.Soundbank;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.text.SimpleAttributeSet;

import Model.SavingAccount;
import Model.SpendingAccount;



public class Interface {
	public JButton btn_ViewPerson = new JButton("View");
	JButton btn_EditPerson = new JButton("Edit");
	JButton btn_DeletePerson = new JButton("Delete");
	JButton btn_AddPerson = new JButton("Add");
	JTextField txt_AddressPerson = new JTextField();
	JTextField txt_CNPPerson = new JTextField();
	JTextField txt_NamePerson = new JTextField();
	JLabel lbl_AddressPerson = new JLabel("Address");
	JLabel lbl_CNPPerosn = new JLabel("CNP");
	JLabel lbl_NamePerson = new JLabel("Name");
	JTable tablePerson = new JTable();
	JScrollPane scrollPanePerson = new JScrollPane();
	JPanel panel = new JPanel();
	JFrame frmPerson = new JFrame();
	
	InterfaceAccount interfaceAccount=new InterfaceAccount();

	Object[] row = new Object[3];
	DefaultTableModel model = new DefaultTableModel();

	public Interface() {

		frmPerson.setTitle("Person");
		frmPerson.setBounds(100, 100, 545, 523);
		frmPerson.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPerson.getContentPane().setLayout(null);
		frmPerson.setVisible(true);

		panel.setBounds(0, 0, 578, 516);
		frmPerson.getContentPane().add(panel);
		panel.setLayout(null);
		panel.setVisible(true);

		tablePerson.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name", "CNP", "Email"
			}
		));

		scrollPanePerson.setBounds(10, 219, 501, 254);
		panel.add(scrollPanePerson);
		tablePerson.setFillsViewportHeight(true);

		scrollPanePerson.setViewportView(tablePerson);

		lbl_NamePerson.setBounds(10, 11, 86, 14);
		panel.add(lbl_NamePerson);
		lbl_NamePerson.setVisible(true);

		lbl_CNPPerosn.setBounds(10, 36, 86, 14);
		panel.add(lbl_CNPPerosn);
		lbl_CNPPerosn.setVisible(true);

		lbl_AddressPerson.setBounds(10, 61, 86, 14);
		panel.add(lbl_AddressPerson);
		lbl_AddressPerson.setVisible(true);

		txt_NamePerson.setBounds(159, 8, 297, 20);
		txt_NamePerson.setColumns(10);
		panel.add(txt_NamePerson);
		txt_NamePerson.setVisible(true);

		txt_CNPPerson.setColumns(10);
		txt_CNPPerson.setBounds(159, 33, 297, 20);
		panel.add(txt_CNPPerson);
		txt_CNPPerson.setVisible(true);

		txt_AddressPerson.setColumns(10);
		txt_AddressPerson.setBounds(159, 58, 297, 20);
		panel.add(txt_AddressPerson);
		txt_AddressPerson.setVisible(true);

		btn_ViewPerson.setBounds(381, 108, 89, 23);
		panel.add(btn_ViewPerson);
		btn_ViewPerson.setVisible(true);

		btn_AddPerson.setBounds(7, 108, 89, 23);
		panel.add(btn_AddPerson);
		btn_DeletePerson.setBounds(133, 108, 89, 23);
		panel.add(btn_DeletePerson);
		btn_EditPerson.setBounds(263, 108, 89, 23);
		panel.add(btn_EditPerson);
		
		JButton btn_Account = new JButton("Account");
		btn_Account.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				interfaceAccount.frame.setVisible(true);
				interfaceAccount.panel.setVisible(true);
				
				int i = tablePerson.getSelectedRow();
				if (i >= 0) {
					
				} else {
					System.out.println("Add account error");
				}
				
				
				
			}
		});
		
		interfaceAccount.btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				interfaceAccount.frame.dispose();
				
			}
		});
	
		btn_Account.setBounds(133, 162, 89, 23);
		panel.add(btn_Account);
		

		btn_AddPerson.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int i = tablePerson.getSelectedRow();
				if (i >= 0) {
					System.out.println(model);
				} else {
					System.out.println("Selected Error");
				}
				
				row[0] = getTxt_NamePerson();
				row[1] = getTxt_CNPPerson();
				row[2] = getTxt_AddressPerson();
				
			

				model.addRow(row);
				tablePerson.setModel(model);
				scrollPanePerson.setViewportView(tablePerson);
				Object[] columns = { "Name", "CNP", "Email"};

				model.setColumnIdentifiers(columns);

				tablePerson.setModel(model);
				tablePerson.setVisible(true);
				tablePerson.repaint();
				tablePerson.revalidate();

			}

		});

		btn_DeletePerson.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// i = the index of the selected row
				int i = tablePerson.getSelectedRow();
				if (i >= 0) {
					// remove a row from jtable
					model.removeRow(i);
				} else {
					System.out.println("Delete Error");
				}
			}
		});

		tablePerson.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jTable1MouseClicked(evt);
			}
		});

		btn_EditPerson.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		btn_ViewPerson.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		panel.revalidate();
		panel.repaint();
	}

	
	private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {
		int index = tablePerson.getSelectedRow();

		TableModel model = tablePerson.getModel();
		
		String name=(String) model.getValueAt(index, 0);
		
		JOptionPane.showMessageDialog(null, "Name is " + name);

	}
	
	

	public String getTxt_AddressPerson() {
		return txt_AddressPerson.getText();
	}

	public void setTxt_AddressPerson(JTextField txt_AddressPerson) {
		this.txt_AddressPerson = txt_AddressPerson;
	}

	public String getTxt_CNPPerson() {
		return txt_CNPPerson.getText();
	}

	public void setTxt_CNPPerson(JTextField txt_CNPPerson) {
		this.txt_CNPPerson = txt_CNPPerson;
	}

	public String getTxt_NamePerson() {
		return txt_NamePerson.getText();
	}

	public void setTxt_NamePerson(JTextField txt_NamePerson) {
		this.txt_NamePerson = txt_NamePerson;
	}

}
