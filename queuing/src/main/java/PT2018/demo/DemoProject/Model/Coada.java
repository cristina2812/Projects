package PT2018.demo.DemoProject.Model;

import java.util.LinkedList;

import javax.swing.JFrame;

import PT2018.demo.DemoProject.View.Interfata;

public class Coada extends Thread {
	private int idCoada;
	private boolean open_c; //ne arata daca o casa este deschisa sau inchisa
	private volatile LinkedList<Cumparator> coada_casa; //coada de cumparatori
	//private static JFrame frame;
	
	
	public Coada (int idCoada) {
		this.idCoada=idCoada;
		this.open_c=false;
		this.coada_casa=new LinkedList<Cumparator> ();
		//this.view=view;
	}
	

	public LinkedList<Cumparator> getCoada_casa() {
		return coada_casa;
	}
	

	public boolean isEmpty()
	{
		return this.coada_casa.isEmpty();
	}
	public int coadaPlina() {
		return this.coada_casa.size();
	}
	
	public void run() {
			while(true) {
				if(!this.coada_casa.isEmpty()) { //stergem din lista de cozi un Cumparator, daca coada nu este goala
					eliminareCumparator(); //pentru stergere am creat o metoda care se numeste removeCumparator
				}
				else
			try {
				Thread.sleep(1000);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public synchronized void addCumparator(Cumparator cumparatorl) {
		this.coada_casa.add(cumparatorl); //adaugare cumparator in coada
	}
	
	public void eliminareCumparator() {
		
		try {
			Cumparator ratat = coada_casa.peekFirst();
			if (ratat!=null)
			{System.out.println(coada_casa.peekFirst().getIdCumparator());	
			 //afisam mesajul : clientul x a fost servit la casa cu numarul y
			Thread.sleep((ratat.getTimpProcesare()+1) * 1000); //stergem un cumparator si thread ul doarme gettimpPrrocesare * 1000 ms, adica daca am un client cu 5 sec_procesare thread ul asteapta 5 secunde dupa care urmeaza urmatorul client 
			Interfata.inserareText(ratat.getIdCumparator() + " a fost servit la casa cu numarul "+ idCoada );
			coada_casa.pollFirst();
			}
			

		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public int getId_coada() {
		return idCoada;
	}
	
	public Cumparator eliminareLastCumparator() {
		return coada_casa.pollLast();
	}
	
	public int getLungimecoada_casa() {
		return this.coada_casa.size();
	}

	public boolean getOpen_c() {
		return this.open_c;
	}
	
	public void deschide_casa() {
		Interfata.inserareText("S-a deschis casa:" + idCoada);
		this.open_c=true;
	}
//	public void inchide_casa() {
//		System.out.println("Casa " + idCoada + "a fost inchisa \n" );
//	}


	public Cumparator getCumparatorcasa(int id) {
		return coada_casa.get(id);
	}
	
}
