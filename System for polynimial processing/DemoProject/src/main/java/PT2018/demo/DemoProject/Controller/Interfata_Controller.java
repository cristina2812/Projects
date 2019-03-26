package PT2018.demo.DemoProject.Controller;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import PT2018.demo.DemoProject.Models.Monom;
import PT2018.demo.DemoProject.Models.Polinom;
import PT2018.demo.DemoProject.view.Interfata_Polinom;

public class Interfata_Controller {
	private Monom monom;
	private Polinom models;
	public Interfata_Polinom view = new Interfata_Polinom();
	private Polinom polinom1;
	private Polinom polinom2;
	private Polinom rezultat;
	private JTextField view1 = new JTextField();

	public Interfata_Controller() {
		ArrayList<Monom> ListPol1 = new ArrayList<>(); // pentru polinom1
		ArrayList<Monom> ListPol2 = new ArrayList<>(); // pentru polinom2
		ArrayList<Monom> rezultatList = new ArrayList<>();
		ArrayList<Monom> rezultatList1 = new ArrayList<>();

		view.actionAdd(l -> {
			rezultatList.removeAll(rezultatList);
			int[] a = new int[200];
			int contor = 0;
			for (Monom i : ListPol1) {
				for (Monom j : ListPol2) {
					Monom adunare = new Monom();
					if (i.getPutere() == j.getPutere()) {
						adunare.setCoeff(i.getCoeff() + j.getCoeff());
						adunare.setPutere(i.getPutere());
						rezultatList.add(adunare);
						a[contor] = i.getPutere();
						contor++;
					}
				}
			}
			for (Monom i : ListPol1) {
				Monom ad = new Monom();
				int ok = 0;
				for (int t = 0; t < contor && ok == 0; t++) {
					if (i.getPutere() == a[t]) {
						ok = 1;
					}
				}
				if (ok == 0) {
					ad.setCoeff(i.getCoeff());
					ad.setPutere(i.getPutere());
					rezultatList.add(ad);
				}
			}

			for (Monom j : ListPol2) {
				Monom ad1 = new Monom();
				int ok = 0;
				for (int t = 0; t < contor && ok == 0; t++) {
					if (j.getPutere() == a[t]) {
						ok = 1;
					}
				}
				if (ok == 0) {
					ad1.setCoeff(j.getCoeff());
					ad1.setPutere(j.getPutere());
					rezultatList.add(ad1);
				}
			}

			String s = " ";
			for (Monom i : rezultatList) {

				s = s.concat(" + ");
				s = s.concat(String.valueOf(i.getCoeff()));
				s = s.concat(String.valueOf("x^"));
				s = s.concat(String.valueOf(i.getPutere()));

				System.out.print(" + " + i.getCoeff() + "x^" + i.getPutere());
				view.setRez(s);
				view.revalidate();
				view.repaint();

			}
		});

		view.actionSubtract(l -> {
			rezultatList.removeAll(rezultatList);
			for (Monom i : ListPol2) {
				Monom scad = new Monom();
				scad.setCoeff(0 - (i.getCoeff()));
				scad.setPutere(i.getPutere());
				rezultatList1.add(scad);
			}

			int[] a = new int[200];
			int contor = 0;
			for (Monom i : ListPol1) {
				for (Monom j : rezultatList1) {
					Monom adunare = new Monom();
					if (i.getPutere() == j.getPutere()) {
						adunare.setCoeff(i.getCoeff() + j.getCoeff());
						adunare.setPutere(i.getPutere());
						rezultatList.add(adunare);
						a[contor] = i.getPutere();
						contor++;
					}
				}
			}
			for (Monom i : ListPol1) {
				Monom ad = new Monom();
				int ok = 0;
				for (int t = 0; t < contor && ok == 0; t++) {
					if (i.getPutere() == a[t]) {
						ok = 1;
					}
				}
				if (ok == 0) {
					ad.setCoeff(i.getCoeff());
					ad.setPutere(i.getPutere());
					rezultatList.add(ad);
				}
			}

			for (Monom j : rezultatList1) {
				Monom ad1 = new Monom();
				int ok = 0;
				for (int t = 0; t < contor && ok == 0; t++) {
					if (j.getPutere() == a[t]) {
						ok = 1;
					}
				}
				if (ok == 0) {
					ad1.setCoeff(j.getCoeff());
					ad1.setPutere(j.getPutere());
					rezultatList.add(ad1);
				}
			}

			String s = " ";
			for (Monom i : rezultatList) {

				s = s.concat(" + ");
				s = s.concat(String.valueOf(i.getCoeff()));
				s = s.concat(String.valueOf("x^"));
				s = s.concat(String.valueOf(i.getPutere()));

				view.setRez(s);
				view.revalidate();
				view.repaint();
				System.out.print(" + " + i.getCoeff() + "x^" + i.getPutere());

			}

		});

		view.actionMultiply(l -> {
			rezultatList.removeAll(rezultatList);
			for (Monom i : ListPol1) {
				for (Monom j : ListPol2) {
					Monom multiply = new Monom();
					multiply.setCoeff(i.getCoeff() * j.getCoeff());
					multiply.setPutere(i.getPutere() + j.getPutere());
					rezultatList.add(multiply);
				}
			}

			String s = " ";
			for (Monom i : rezultatList) {

				s = s.concat(" + ");
				s = s.concat(String.valueOf(i.getCoeff()));
				s = s.concat(String.valueOf("x^"));
				s = s.concat(String.valueOf(i.getPutere()));
				System.out.print(" + " + i.getCoeff() + "x^" + i.getPutere());
				view.setRez(s);
				view.revalidate();
				view.repaint();

			}

		});
		view.actionDivision(l -> {
			rezultatList.removeAll(rezultatList);
			Monom rest= new Monom();
			Monom cat= new Monom();
			for(Monom i:ListPol1) {
				for(Monom j:ListPol2) {
					if(i.getPutere() >j.getPutere()) {
						cat.setCoeff(0);
						cat.getPutere();
						rest.setPutere(i.getPutere());
						rest.setCoeff(i.getCoeff());
						rezultatList.add(rest);
						rezultatList.add(cat);
					}else {
						int k=3;
						while(rest.getPutere() >= j.getPutere() && k>=3) {
							
						}
					}
				}
			}
			String s = "Impartirea nu functioneaza!!! ";
			view.setRez(s);
			view.revalidate();
			view.repaint();
		});

		view.actionDerivation1(l -> {
			rezultatList.removeAll(rezultatList);
			for (Monom i : ListPol1) {
				Monom derivation1 = new Monom();
				if (i.getPutere() > 0) {
					derivation1.setCoeff(i.getCoeff() * i.getPutere());
					derivation1.setPutere(i.getPutere() - 1);
					rezultatList.add(derivation1);
				}
				if(i.getPutere()==0) {
					derivation1.setCoeff(0);
					derivation1.setPutere(0);
					rezultatList.add(derivation1);
				}
			}
			String s = " ";
			for (Monom i : rezultatList) {

				s = s.concat(" + ");
				s = s.concat(String.valueOf(i.getCoeff()));
				s = s.concat(String.valueOf("x^"));
				s = s.concat(String.valueOf(i.getPutere()));

				view.setRez(s);
				view.revalidate();
				view.repaint();
				System.out.print(" + " + i.getCoeff() + "x^" + i.getPutere());

			}

		});

		view.actionIntegration1(l -> {
			rezultatList.removeAll(rezultatList);
			for (Monom i : ListPol1) {
				Monom integration1 = new Monom();
				if (i.getPutere() > 0) {
					integration1.setPutere((i.getPutere() + 1));
					integration1.setCoeff(i.getCoeff() / i.getPutere());
					rezultatList.add(integration1);
				}
				if (i.getPutere() == 0) {
					integration1.setCoeff(i.getCoeff());
					integration1.setPutere(i.getPutere() + 1);
					rezultatList.add(integration1);
				}
			}
			String s = " ";
			for (Monom i : rezultatList) {

				s = s.concat(" + ");
				s = s.concat(String.valueOf(i.getCoeff()));
				s = s.concat(String.valueOf("x^"));
				s = s.concat(String.valueOf(i.getPutere()));
				System.out.print(" + " + i.getCoeff() + "x^" + i.getPutere());
				view.setRez(s);
				view.revalidate();
				view.repaint();

			}

		});

		view.actionDerivation2(l -> {
			rezultatList.removeAll(rezultatList);
			String s = " ";
			for (Monom i : ListPol2) {
				Monom derivation2 = new Monom();
				if (i.getPutere() > 0) {
					derivation2.setCoeff(i.getCoeff() * i.getPutere());
					derivation2.setPutere(i.getPutere() - 1);
					rezultatList.add(derivation2);
				}
				 if(i.getPutere()==0) {
					derivation2.setCoeff(0);
					derivation2.setPutere(0);
					rezultatList.add(derivation2);
				}
			}
			
			for (Monom i : rezultatList) {
				s = s.concat(" + ");
				s = s.concat(String.valueOf(i.getCoeff()));
				s = s.concat(String.valueOf("x^"));
				s = s.concat(String.valueOf(i.getPutere()));
				System.out.print(" + " + i.getCoeff() + "x^" + i.getPutere());
				view.setRez(s);
				view.revalidate();
				view.repaint();

			}

		});

		view.actionIntegration2(l -> {
			rezultatList.removeAll(rezultatList);
			for (Monom i : ListPol2) {
				Monom integration2 = new Monom();
				if (i.getPutere() > 0) {
					integration2.setPutere((i.getPutere() + 1));
					integration2.setCoeff(i.getCoeff() / i.getPutere());
					rezultatList.add(integration2);
				}
				if (i.getPutere() == 0) {
					integration2.setCoeff(i.getCoeff());
					integration2.setPutere(i.getPutere() + 1);
					rezultatList.add(integration2);
				}
			}
			String s = " ";
			for (Monom i : rezultatList) {

				s = s.concat(" + ");
				s = s.concat(String.valueOf(i.getCoeff()));
				s = s.concat(String.valueOf("x^"));
				s = s.concat(String.valueOf(i.getPutere()));
				System.out.print(" + " + i.getCoeff() + "x^" + i.getPutere());
				view.setRez(s);
				view.revalidate();
				view.repaint();

			}

		});
		view.actionAdaugare1(l -> {
			int ok=0;
			String input = view.getPol1().getText(); // se ia ce scriu eu in
			Pattern p = Pattern.compile("(-?\\b\\d+)[xX]\\^(-?\\d+\\b)");
			Matcher m = p.matcher(input);
			while (m.find()) {
				System.out.println("Coef: " + m.group(1));// m.group(1) = coef ca si string
				System.out.println("Putere: " + m.group(2));// m.group(2) = putere ca si string
				float coef = Float.parseFloat(m.group(1));
				int putere = Integer.parseInt(m.group(2));
				Monom aux = new Monom();
				aux.setCoeff(coef);
				aux.setPutere(putere);
				ListPol1.add(aux);
				System.out.println(ListPol1);
				ok=1;
			}
			String msg=	"\"Ati introdus polinomul gresit.\"\n"
			        + "Forma corecta este:ax^n+bx^n-1+...+cx^0\n"
					+ "a,b,..,c reprezinta coeficientii\n"
			        + "n,n-1,..,0 reprezinta puterea";
					if(ok==0) {
						 JOptionPane.showMessageDialog(new JFrame(), msg, "Dialog",
							        JOptionPane.ERROR_MESSAGE);
					}
				
					rezultatList.removeAll(rezultatList);
		});

		view.actionAdaugare2(l -> {
			int ok=0;
			rezultatList.removeAll(rezultatList);
			String input = view.getPol2().getText(); // se ia ce scriu eu in
			Pattern p = Pattern.compile("(-?\\b\\d+)[xX]\\^(-?\\d+\\b)");
			Matcher m = p.matcher(input);
			while (m.find()) {
				System.out.println("Coef: " + m.group(1));// m.group(1) = coef ca si string
				System.out.println("Putere: " + m.group(2));// m.group(2) = putere ca si string
				float coef = Float.parseFloat(m.group(1));
				int putere = Integer.parseInt(m.group(2));
				Monom aux = new Monom();
				aux.setCoeff(coef);
				aux.setPutere(putere);
				ListPol2.add(aux);
				System.out.println(ListPol2);
				ok=1;
			}
			String msg=	"\"Ati introdus polinomul gresit.\"\n"
	        + "Forma corecta este:ax^n+bx^n-1+...+cx^0\n"
			+ "a,b,..,c reprezinta coeficientii\n"
	        + "n,n-1,..,0 reprezinta puterea";
			if(ok==0) {
				 JOptionPane.showMessageDialog(new JFrame(), msg, "Dialog",
					        JOptionPane.ERROR_MESSAGE);
			}
			rezultatList.removeAll(rezultatList);
		});

	}
}
