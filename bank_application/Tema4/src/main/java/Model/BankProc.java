package Model;

public interface BankProc {
	
	
	public void adaugarePersoane(Person p);
	
	public void stergerePersoane(Person p);
	
	public void editarePersoane(Person p, String Name, Integer CNP, String email);
	
	public void vizualizarePersoane(Person p);
	
	public void adaugareConturi(Account a, Person p);
	
	public void stergereConturi(Account a, int id, int id1);
	
	public void vizualizareConturi(Account a);
}
