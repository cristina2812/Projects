package PT2018.demo.DemoProject.Model;

import java.util.Date;

public class Cumparator {
	private int idCumparator;
	private int timpSosire;
	private int timpProcesare;
	
	public Cumparator(int idCumparator, int timpSosire, int timpProcesare) {
		this.idCumparator=idCumparator;
		this.timpSosire=timpSosire;
		this.timpProcesare=timpProcesare;
	}

	public int getIdCumparator() {
		return idCumparator;
	}

	public int getTimpSosire() {
		return timpSosire;
	}

	public int getTimpProcesare() {
		return timpProcesare;
	}

	@Override
	public String toString() {
		return ("Cumparatorul  : " + idCumparator + "  timpsosire: " + timpSosire + "   timpProcesare: "
				+ timpProcesare +"\n" );
	}
	
}
