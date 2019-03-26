package PT2018.demo.DemoProject.Models;

public class Monom {

	float coeff;
	int putere;

	public float getCoeff() {
		return coeff;
	}

	public void setCoeff(float coeff) {
		this.coeff = coeff;
	}

	public int getPutere() {
		return putere;
	}

	public void setPutere(int putere) {
		this.putere = putere;
	}

	@Override
	public String toString() {
		return ("Coeficientul: " + this.getCoeff() + " Puterea: " + this.getPutere());
	}

}
