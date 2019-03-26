package PT2018.demo.DemoProject.Controller;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.text.JTextComponent;

import PT2018.demo.DemoProject.Model.Coada;
import PT2018.demo.DemoProject.Model.Cumparator;
import PT2018.demo.DemoProject.View.Interfata;

public class Generare extends Thread implements ActionListener {

	// private static final int MAX_COADA = 10;
	// private static JFrame frame;

	Coada coada[];
	int numar_case;
	int minservire;
	int maxservire;
	int minsosire;
	int maxsosire;
	int numarcozi;
	int timpsimulare;
	int texttimer = 0;
	int empty = 0;

	public Generare(int maxservire, int minservire, int minsosire, int maxsosire, int numarcozi, int timpsimulare,
			int texttimer) {
		

		this.minservire = minservire;
		this.maxservire = maxservire;
		this.minsosire = minsosire;
		this.maxsosire = maxsosire;
		this.numarcozi = numarcozi;
		this.timpsimulare = timpsimulare;
		this.texttimer = texttimer;

		this.numar_case = numarcozi;
		coada = new Coada[numar_case];

		for (int i = 0; i < numar_case; i++) {
			coada[i] = new Coada(i + 1);
		}

		for (int i = 0; i < numar_case; i++) {
			// coada[i].start();
			coada[i].deschide_casa();
			System.out.println(coada[i]);
		}

	}

	public void run() {
		boolean ok = true;
		int avg=0;
		int peak=0;
		for (int i = 0; i < numarcozi; i++) {
			(new Thread(coada[i])).start();
		}
		try {

			Cumparator cumparatorl = generareCumparatorRandom(texttimer + minsosire, texttimer + maxsosire, minservire,
					maxservire);
			while (ok) {
				for(int j=0;j<numarcozi;j++) {
				 if(coada[j].isEmpty()) {
						empty++;  //verifica cat timp o coada este goala
						String s1=" ";
						Interfata.inserareEmpty(s1.valueOf(empty));
					}
				}
				if (cumparatorl.getTimpSosire() < texttimer) {
					cumparatorl = generareCumparatorRandom(texttimer + minsosire, texttimer + maxsosire, minservire,
							maxservire);
					Random random = new Random();
					 peak = random.nextInt(texttimer) + minservire;
					
				} else if (cumparatorl.getTimpSosire() == texttimer) {
					int min = cautareCoadaMinima();
					// System.out.println(texttimer+" "+min);
					coada[min].addCumparator(cumparatorl);
					avg++;
					String s =cumparatorl + "a fost adaugat in coada: " + coada[min].getId_coada();
					Interfata.inserareText(s);
					String s3="";
					Interfata.inserareAverage(s3.valueOf((maxservire+minservire)/2));

				}
				Interfata.inserareTextArea1("");
				for(int i=0; i<numarcozi;i++) {
					String str= new String("In coada : "+ coada[i].getId_coada() + " se afla clientii : ");
					for(int j=0;j<coada[i].getLungimecoada_casa(); j++) {
						Cumparator c = coada[i].getCumparatorcasa(j);
						str=str.concat(c.getIdCumparator() + " ");
						//System.out.println(coada[i].getCumparatorcasa(j));
					}
					Interfata.inserareTextArea(str);
			
				}
			
				
				String s = "";
				texttimer++;
				Thread.sleep(1000);

				Interfata.inserare(s.valueOf(texttimer));
				if (timpsimulare == texttimer) {

					String mesaj4 = "Stop simulare";
					JOptionPane.showMessageDialog(new JFrame(), mesaj4, "Stop simulare", JOptionPane.ERROR_MESSAGE);
					ok = false;
				}
				String s4="";
				Interfata.inserarePeak(s4.valueOf(peak ));
				
			}
		
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
}

	public Cumparator generareCumparatorRandom(int minsosire, int maxsosire, int minservire, int maxservire) { // generam
																												// un
																												// client
																												// random
		try {
			int i = 0;
			Random random = new Random();
			int random_id = random.nextInt(50);
			int random_procesare = random.nextInt(maxservire) + minservire;
			// int random_sosire=random.nextInt(maxsosire)+minsosire;

			int r = -1;
			while ((r < 0) || (r < minsosire) || (r > maxsosire))
				r = (random.nextInt() % (maxsosire - minsosire)) + minsosire;
			int random_sosire = r;
			// timp procesare inim si maxim
			Cumparator cumparatorl = new Cumparator(random_id, random_sosire, random_procesare);

			return cumparatorl;
		} catch (Exception e) {
			String eroare = "Timpul minim de servire si maxim" + "de servire trebuie sa fie diferite de 0";
			JOptionPane.showMessageDialog(new JFrame(), eroare, "Dialog", JOptionPane.ERROR_MESSAGE);

		}
		return null;

	}

	private int cautareCoadaMinima() {
		// cautam cea mai mica coada si returnam care coada este pentru a putea pune
		// urmatorul client la acea coada
		int coadaminima = coada[0].getLungimecoada_casa();
		int numar_coada = 0;

		for (int i = 0; i < numar_case; i++) {

			if (coada[i].getLungimecoada_casa() < coadaminima) {
				coadaminima = coada[i].getLungimecoada_casa();
				numar_coada = i; // am salvat numarul cozii minime
			}
		

		}
		return numar_coada;
	}

	// private void adaugare_coada_noua(int index_coada) {
	// for (int i = 0; i < numar_case; i++) {
	// if (coada[i].getOpen_c() == false) {
	// coada[i].start();
	// coada[i].deschide_casa();
	//
	//
	// }
	// }
	//
	// }


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
