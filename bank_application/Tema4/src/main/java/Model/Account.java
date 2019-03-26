package Model;

public class Account {
//iban,money(currency)
	
	protected static int idAccount;
	protected static String currency;
	protected static String Name;
	protected static float Money;
	protected static float Deposit;
	protected static float Withdraw;
	protected static String typeAccount;
	
	public Account(String Name, int idAccount,float Money,float Deposit,float Withdraw, String typeAccount,String currency){
		
		this.Name=Name;
		this.idAccount=idAccount;
		this.Money=Money;
		this.Deposit=Deposit;
		this.Withdraw=Withdraw;
		this.typeAccount=typeAccount;
		this.currency=currency;
	}


	public static String getName() {
		return Name;
	}


	public static void setName(String name) {
		Name = name;
	}


	public static float getMoney() {
		return Money;
	}


	public static void setMoney(float money) {
		Money = money;
	}


	public static float getDeposit() {
		return Deposit;
	}


	public static void setDeposit(float deposit) {
		Deposit = deposit;
	}


	public static float getWithdraw() {
		return Withdraw;
	}


	public static void setWithdraw(float withdraw) {
		Withdraw = withdraw;
	}


	public static String getTypeAccount() {
		return typeAccount;
	}


	public static void setTypeAccount(String typeAccount) {
		Account.typeAccount = typeAccount;
	}


	public int getIdAccount() {
		return idAccount;
	}

	public void setIdAccount(int idAccount) {
		this.idAccount = idAccount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}


	@Override
	public String toString() {
		return "Account [getIdAccount()=" + getIdAccount() + ", getCurrency()=" + getCurrency() + "]";
	}


	
	
	
}
