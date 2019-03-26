package PT2018.demo.DemoProject.Models;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import PT2018.demo.DemoProject.Controller.Interfata_Controller;;

public class Polinom {
	// lista de monoame

	public ArrayList<Monom> monom = new ArrayList<Monom>();

	public Polinom(ArrayList<PT2018.demo.DemoProject.Models.Monom> monom) {
		this.monom = monom;
	}

	public ArrayList<Monom> getMonom() {
		return monom;
	}

	public void setMonom(ArrayList<Monom> monom) {
		this.monom = monom;
	}

}
