package Model;

public class Person {
	//cnp,nume,(nrTelefon,email)
	
	private String Name;
	private int CNP;
	private String email;
	
	
	public Person(String Name, int CNP, String email){
		this.Name=Name;
		this.CNP=CNP;
		this.email=email;
	}


	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}


	public int getCNP() {
		return CNP;
	}


	public void setCNP(int cNP) {
		CNP = cNP;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return "Person [Name=" + Name + ", CNP=" + CNP + ", email=" + email + "]";
	}
	
	
	
	
}
