package PT2018.demo.DemoProject.view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.Caret;

import PT2018.demo.DemoProject.Models.Monom;

public class Interfata_Polinom extends JFrame implements ActionListener {

	// TODO Auto-generated method stub
	//JPanel p = new JPanel();
	JFrame pol = new JFrame("Polynomials");
	JLabel polinom1 = new JLabel("Polynomial 1: ");
	JLabel polinom2 = new JLabel("Polynomial 2: ");
	JLabel rezultat = new JLabel("Result: ");
	JButton add = new JButton("Addition");
	JButton subtract = new JButton("Subtract");
	JButton multiply = new JButton("Multiply");
	JButton division = new JButton("Division");
	JButton derivation1 = new JButton("Derivation");
	JButton integration1 = new JButton("Integration");
	JButton derivation2 = new JButton("Derivation");
	JButton integration2 = new JButton("Integration");
	JButton adaugare1 = new JButton("Adding");
	JButton adaugare2 = new JButton("Adding");
	JTextField pol1 = new JTextField(50);
	JTextField pol2 = new JTextField(50);
	JTextField rez = new JTextField(50);
	private JPanel panel = new JPanel();

	public Interfata_Polinom() {

		/*try {
			pol.setContentPane(new JLabel(
					new ImageIcon(ImageIO.read(new File("C:\\Users\\Adam Cristina-Ioana\\Desktop\\image2.jpg")))));
		} catch (IOException e) {
			System.out.println("Image doesn't exist");
		}*/

		pol.setLayout(new FlowLayout());
		pol.setSize(900, 700);
		pol.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pol.getContentPane().setLayout(null);
		pol.setVisible(true);
		panel.setLayout(null);

		panel.setSize(900, 700);
		pol.add(panel);
		pol.add(add);

		add.setLocation(650, 50);
		add.setSize(200, 50);
		panel.add(add);
		add.setVisible(true);

		panel.add(subtract);
		subtract.setLocation(650, 200);
		subtract.setSize(200, 50);
		subtract.setVisible(true);

		panel.add(multiply);
		multiply.setLocation(650, 350);
		multiply.setSize(200, 50);
		multiply.setVisible(true);

		panel.add(division);
		division.setLocation(650, 500);
		division.setSize(200, 50);
		division.setVisible(true);

		panel.add(adaugare1); // adaugare
		adaugare1.setBounds(50, 150, 100, 50);
		adaugare1.setVisible(true);

		panel.add(derivation1);
		derivation1.setBounds(250, 150, 100, 50);
		derivation1.setVisible(true);

		panel.add(integration1);
		integration1.setBounds(450, 150, 100, 50);
		integration1.setVisible(true);

		panel.add(adaugare2); // adaugare
		adaugare2.setBounds(50, 360, 100, 50);
		adaugare2.setVisible(true);

		panel.add(derivation2);
		derivation2.setBounds(250, 360, 100, 50);
		derivation2.setVisible(true);

		panel.add(integration2);
		integration2.setBounds(450, 360, 100, 50);
		integration2.setVisible(true);

		polinom1.setSize(100, 50);
		panel.add(polinom1);
		polinom1.setVisible(true);

		pol1.setBounds(30, 70, 550, 45);
		panel.add(pol1);
		pol1.setVisible(true);

		polinom2.setSize(500, 450);
		panel.add(polinom2);
		polinom2.setVisible(true);

		pol2.setBounds(30, 270, 550, 45);
		panel.add(pol2);
		pol2.setVisible(true);

		rezultat.setSize(900, 900);
		panel.add(rezultat);
		rezultat.setVisible(true);

		rez.setBounds(30, 500, 550, 45);
		panel.add(rez);
		rez.setEditable(false);
		rez.setVisible(true);

	}

	public void actionAdd(ActionListener l) {
		this.add.addActionListener(l);
	}

	public void actionSubtract(ActionListener l) {
		this.subtract.addActionListener(l);
	}

	public void actionMultiply(ActionListener l) {
		this.multiply.addActionListener(l);
	}

	public void actionDivision(ActionListener l) {
		this.division.addActionListener(l);
	}

	public void actionDerivation1(ActionListener l) {
		this.derivation1.addActionListener(l);
	}

	public void actionIntegration1(ActionListener l) {
		this.integration1.addActionListener(l);
	}

	public void actionDerivation2(ActionListener l) {
		this.derivation2.addActionListener(l);
	}

	public void actionIntegration2(ActionListener l) {
		this.integration2.addActionListener(l);
	}

	public void actionAdaugare1(ActionListener l) {
		this.adaugare1.addActionListener(l);
	}

	public void actionAdaugare2(ActionListener l) {
		this.adaugare2.addActionListener(l);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

	public JTextField getPol1() {
		return pol1;
	}

	public void setPol1(JTextField pol1) {
		this.pol1 = pol1;
	}

	public JTextField getPol2() {
		return pol2;
	}

	public void setPol2(JTextField pol2) {
		this.pol2 = pol2;
	}

	public JTextField getRez() {
		return rez;
	}

	public void setRez(String rez) {
		this.rez.setText(rez);
	}
}
