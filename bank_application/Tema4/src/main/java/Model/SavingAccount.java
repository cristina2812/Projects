package Model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.omg.CORBA.PUBLIC_MEMBER;

import View.Interface;

public class SavingAccount extends Account{
	public SavingAccount(String Name, int idAccount, float Money, float Deposit, float Withdraw, String typeAccount,
			String currency) {
		super(Name, idAccount, Money, Deposit, Withdraw, typeAccount, currency);
		
	}

	Interface interface1 =new Interface();

	

}
