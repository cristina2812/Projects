package Model;

public class customer{
	private int idCustomer;
	private String nameCustomer;
	private String AddressCustomer;
	
	public customer()
	{
		super();
	}
	
	public customer(int idCustomer, String nameCustomer, String AddressCustomer) {
		this.idCustomer=idCustomer;
		this.nameCustomer=nameCustomer;
		this.AddressCustomer=AddressCustomer;
	}
	public int getIdCustomer() {
		return idCustomer;
	}
	public void setIdCustomer(int idCustomer) {
		this.idCustomer = idCustomer;
	}
	public String getNameCustomer() {
		return nameCustomer;
	}
	public void setNameCustomer(String nameCustomer) {
		this.nameCustomer = nameCustomer;
	}
	public String getAdrressCustomer() {
		return AddressCustomer;
	}
	public void setAddressCustomer(String adrressCustomer) {
		AddressCustomer = adrressCustomer;
	}
	@Override
	public String toString() {
		return "customer [idCustomer=" + idCustomer + ", nameCustomer=" + nameCustomer + ", AddressCustomer="
				+ AddressCustomer + "]";
	}

}
