package PT2018.demo.DemoProject.View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import PT2018.demo.DemoProject.Controller.Generare;

public class Interfata extends JFrame implements ActionListener {

	JFrame frame = new JFrame();
	private JFrame f = new JFrame();
	JPanel panel1=new JPanel(new GridBagLayout());
	JPanel panel = new JPanel(new GridBagLayout());
	JLabel timp_minim_sosire = new JLabel("Timp minim sosire: ");
	JLabel timp_maxim_sosire = new JLabel("Timp maxim  sosire: ");
	JLabel timp_minim_servire = new JLabel("Timp minim de servire: ");
	JLabel timp_maxim_servire = new JLabel("Timp maxim de servire :");
	JLabel numar_cozi = new JLabel("Numarul de cozi: ");
	JLabel simulare = new JLabel("Timpul de simulare: ");
	JLabel timer=new JLabel("Timp = ");
	JLabel empty=new JLabel("Timp coada goala = ");
	JLabel average=new JLabel("Timul mediu de asteptare = ");
	JLabel peak=new JLabel();
	static JTextField peak_txt = new JTextField();
	static JTextField average_txt = new JTextField();
	static JTextField empty_txt = new JTextField();
	JTextField min_sosire = new JTextField();
	JTextField max_sosire = new JTextField();
	JTextField min_servire = new JTextField();
	JTextField max_servire = new JTextField();
	JTextField nr_cozi = new JTextField();
	JTextField timp_simulare = new JTextField();
	static JTextField text_timer=new JTextField();
	static JTextArea simulare_area = new JTextArea(550, 300);
	static JTextArea simulare_area1 = new JTextArea(550, 300);
	JButton Start = new JButton("Start");
	JScrollPane scroll = new JScrollPane();
	private GridBagConstraints grid_c = new GridBagConstraints();

	int minsosire = 0;
	int maxsosire = 0;
	int minservire = 0;
	int maxservire = 0;
	int numarcozi = 0;
	int timpsimulare = 0;
	int texttimer=0;
	int poz = 0;

	public Interfata() {
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800,600);
		this.setVisible(true);
		panel.setPreferredSize(new Dimension(80, 600));

		this.add(panel);
		panel.setLayout(null);
		panel.setSize(800, 600);
		panel.setVisible(true);

		timp_minim_sosire.setSize(500, 50);
		panel.add(timp_minim_sosire);
		timp_minim_sosire.setVisible(true);

		timp_maxim_sosire.setSize(500, 100);
		panel.add(timp_maxim_sosire);
		timp_maxim_sosire.setVisible(true);

		timp_minim_servire.setSize(500, 150);
		panel.add(timp_minim_servire);
		timp_minim_servire.setVisible(true);

		timp_minim_servire.setSize(500, 200);
		panel.add(timp_minim_servire);
		timp_minim_servire.setVisible(true);

		timp_maxim_servire.setSize(500, 250);
		panel.add(timp_maxim_servire);
		timp_maxim_servire.setVisible(true);

		numar_cozi.setSize(500, 350);
		panel.add(numar_cozi);
		numar_cozi.setVisible(true);

		simulare.setSize(500, 400);
		panel.add(simulare);
		simulare.setVisible(true);

		min_sosire.setBounds(160, 15, 60, 15);
		panel.add(min_sosire);
		min_sosire.setVisible(true);

		max_sosire.setBounds(160, 40, 60, 15);
		panel.add(max_sosire);
		max_sosire.setVisible(true);

		min_servire.setBounds(160, 90, 60, 15);
		panel.add(min_servire);
		min_servire.setVisible(true);

		max_servire.setBounds(160, 120, 60, 15);
		panel.add(max_servire);
		max_servire.setVisible(true);

		nr_cozi.setBounds(160, 170, 60, 15);
		panel.add(nr_cozi);
		nr_cozi.setVisible(true);

		timp_simulare.setBounds(160, 190, 60, 15);
		panel.add(timp_simulare);
		timp_simulare.setVisible(true);
		
		
		timer.setSize(100, 50);
		timer.setLocation(300, 100);
		panel.add(timer);
		timer.setVisible(true);
		
		empty.setText("Timpul in care coada este goala = ");
		empty.setSize(200, 50);
		empty.setLocation(300, 123);
		panel.add(empty);
		empty.setVisible(true);
		
		average.setText("Timpul mediu de asteptare = ");
		average.setSize(200, 50);
		average.setLocation(300, 155);
		panel.add(average);
		average.setVisible(true);
		
		peak.setText("Ora de varf = ");
		peak.setSize(200, 50);
		peak.setLocation(300, 180);
		panel.add(peak);
		peak.setVisible(true);
		
		text_timer.setSize(50, 20);
		text_timer.setLocation(350, 115);
		panel.add(text_timer);
		text_timer.setVisible(true);
		text_timer.setEditable(false);
		text_timer.setText("0");
		
		peak_txt.setSize(50, 20);
		peak_txt.setLocation(390, 195);
		panel.add(peak_txt);
		peak_txt.setVisible(true);
		peak_txt.setEditable(false);
		peak_txt.setText("0");

		empty_txt.setSize(50, 20);
		empty_txt.setLocation(500, 140);
		panel.add(empty_txt);
		empty_txt.setVisible(true);
		empty_txt.setEditable(false);
		empty_txt.setText("0");
		
		average_txt.setSize(50, 20);
		average_txt.setLocation(470, 170);
		panel.add(average_txt);
		average_txt.setVisible(true);
		average_txt.setEditable(false);
		average_txt.setText("0");
		
		panel.add(Start);
		Start.setLocation(300, 50);
		Start.setSize(100, 50);
		Start.setVisible(true);

		simulare_area.setLocation(20, 250);
		simulare_area.setSize(760, 290);
		panel.add(simulare_area);
		simulare_area.setEditable(false); // nu o sa modificam textArea
		simulare_area.setVisible(true);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setLocation(20, 250);
		scrollPane.setSize(750, 300);
		frame.getContentPane().add(scrollPane);

		scrollPane.setViewportView(simulare_area);
		panel.add(scrollPane);
		scrollPane.setVisible(true);
	
	
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(800,600);
		f.setVisible(true);
		//panel1.setPreferredSize(new Dimension(80, 600));
		f.setLayout(null);
		f.setLocationRelativeTo(null);
		
		f.add(panel1);
		panel1.setLayout(null);
		panel1.setSize(800, 600);
		panel1.setVisible(true);
	
		simulare_area1.setSize(800,600);
		panel1.add(simulare_area1);
		simulare_area1.setEditable(false); // nu o sa modificam textArea
		simulare_area1.setVisible(true);
		
		JScrollPane scrollPane1 = new JScrollPane();
		scrollPane1.setSize(800, 600);
		f.getContentPane().add(scrollPane1);

		scrollPane1.setViewportView(simulare_area1);
		panel1.add(scrollPane1);
		scrollPane1.setVisible(true);
		

		
	
	Start.addActionListener(new ActionListener()
		{
	
	@Override
	public void actionPerformed(ActionEvent l) {
		
		try {

			minsosire = Integer.parseInt(min_sosire.getText());
			maxsosire = Integer.parseInt(max_sosire.getText());
			minservire = Integer.parseInt(min_servire.getText());
			maxservire = Integer.parseInt(max_servire.getText());
			numarcozi = Integer.parseInt(nr_cozi.getText());
			timpsimulare = Integer.parseInt(timp_simulare.getText());
			texttimer=Integer.parseInt(text_timer.getText());
			System.out.println(minsosire);
			if (minsosire >= maxsosire) {
				String mesaj = "Timpul minim de sosire nu poate" + "\n" + "fi mai mare decat timpul maxim de sosire";
				JOptionPane.showMessageDialog(new JFrame(), mesaj, "Eroare", JOptionPane.ERROR_MESSAGE);
			} else if (minservire >= maxservire) {
				String mesaj2 = "Timpul minim de servire nu poate" + "\n" + "fi mai mare decat timpul maxim de servire";
				JOptionPane.showMessageDialog(new JFrame(), mesaj2, "Eroare", JOptionPane.ERROR_MESSAGE);
				
			}
			
			if(texttimer == timpsimulare) {
				String mesaj3 = "Stop simulare";
				JOptionPane.showMessageDialog(new JFrame(), mesaj3, "Stop simulare", JOptionPane.ERROR_MESSAGE);
			}
			Generare generare = new Generare(maxservire,minservire,minsosire,maxsosire, numarcozi,timpsimulare,texttimer);
			Thread th = new Thread(generare);
			th.start();

		} catch (Exception e) {
			String er = "Trebuie completate toate campurile";
			// System.err.println("ERR:  " + e.getMessage());
			JOptionPane.showMessageDialog(new JFrame(), er, "Dialog", JOptionPane.ERROR_MESSAGE);
		}
	}
	});

	}

	public static void  inserareText(String inseraretxt) {
		simulare_area.append(inseraretxt + "\n");

	}
	
	public static void  inserareTextArea(String inseraretxtArea) {
		simulare_area1.append(inseraretxtArea + "\n");
		

	}
	
	public static void  inserareTextArea1(String ins1) {
		simulare_area1.setText(ins1); 
	}
		
	public static void  inserare(String ins) {
		text_timer.setText(ins); 
	}
	
	public static void  inserareEmpty(String pk) {
		empty_txt.setText(pk); 
	}
	
	public static void  inserareAverage(String av) {
		average_txt.setText(av); 
	}
	
	public static void  inserarePeak(String pk1) {
		peak_txt.setText(pk1); 
	}
	
	public JTextField getMin_sosire() {
		return min_sosire;
	}

	public void setMin_sosire(JTextField min_sosire) {
		this.min_sosire = min_sosire;
	}

	public JTextField getMax_sosire() {
		return max_sosire;
	}

	public void setMax_sosire(JTextField max_sosire) {
		this.max_sosire = max_sosire;
	}

	public JTextField getMin_servire() {
		return min_servire;
	}

	public void setMin_servire(JTextField min_servire) {
		this.min_servire = min_servire;
	}

	public JTextField getMax_servire() {
		return max_servire;
	}

	public void setMax_servire(JTextField max_servire) {
		this.max_servire = max_servire;
	}

	public JTextField getNr_cozi() {
		return nr_cozi;
	}

	public void setNr_cozi(JTextField nr_cozi) {
		this.nr_cozi = nr_cozi;
	}

	public JTextField getTimp_simulare() {
		return timp_simulare;
	}

	public int getTexttimer() {
		return texttimer;
	}

	public void setTexttimer(int texttimer) {
		this.texttimer = texttimer;
	}

	public void setTimp_simulare(JTextField timp_simulare) {
		this.timp_simulare = timp_simulare;
	}

	public String getText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}		
		
}
		
		