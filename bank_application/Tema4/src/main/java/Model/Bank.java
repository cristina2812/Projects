package Model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

public class Bank implements BankProc {
//hashmap<Person,List<Account>>
//metode: addAccount, addPersoon, removePerson,
	
	private HashMap<Person, ArrayList<Account>> hash;
	
	public Bank(){
		hash=new HashMap<Person, ArrayList<Account>>();
	}
	
	
	public void adaugarePersoane(Person p){
		
		assert p != null;
		hash.put(p, new ArrayList<Account>());
		
	}
	
	public void stergerePersoane(Person p){
		assert p !=null;
		hash.remove(p.getCNP());
		
	}
	
	public void editarePersoane(Person p, String Name, Integer CNP, String email){
		assert p!=null;
		
		Person persoanaNoua= new Person(Name, CNP, email);
		hash.put(persoanaNoua, hash.get(p));
		hash.remove(p);
	}
	
	public void vizualizarePersoane(Person p){
		
		assert !hash.isEmpty();
		for(Person person :hash.keySet())
			System.out.println(p.getName()+" "+ p.getCNP()+ " "+ p.getEmail());
		
	}
	
	public void adaugareConturi(Account a, Person p){
		
		assert a!=null:"Eroare adaugare cont";
		assert p!=null:"Eroare adaugare persoana";
		
		ArrayList<Account> acc=hash.get(p);
		acc.add(a);
		hash.remove(p);
		hash.put(p, acc);
	}
	
	public void stergereConturi(Account a, int id, int id1){
		assert !hash.isEmpty();
		Account gasit=null;
		
		for(Person person :hash.keySet()){
			for(ArrayList<Account> ac :hash.values()){
				for(Account a1: ac){
					if(a.getIdAccount()== id && id1==person.getCNP())
						gasit=a1;
				}
				ac.remove(gasit);
			}
		}
		
		
		
	}
	

	public void vizualizareConturi(Account a){
		assert !hash.isEmpty();
		for(Person person :hash.keySet())
			System.out.println(a.getName()+" "+a.getIdAccount()+" "+a.getMoney()+" "+a.getDeposit()+" "+a.getWithdraw()+" "+a.getTypeAccount()+" "+a.getCurrency());
	}


	public HashMap<Person, ArrayList<Account>> getHash() {
		return hash;
	}


	public void setHash(HashMap<Person, ArrayList<Account>> hash) {
		this.hash = hash;
	}

}
