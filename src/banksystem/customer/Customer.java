package banksystem.customer;

import java.io.Serializable;

/**
 * Created by init0 on 04.05.16.
 */
public class Customer implements Serializable{

    private CustomerPersonalInformation personals;
    private CustomerAddress address;
    private CustomerAccount account;

	private boolean activated;

	public Customer(){
        this.personals = new CustomerPersonalInformation();
        this.address = new CustomerAddress();
        this.account = new CustomerAccount();
    };

    public CustomerPersonalInformation getPersonals() {
        return personals;
    }

    public void setPersonals(CustomerPersonalInformation personals) {
        this.personals = personals;
    }

    public boolean isActivated(){
		return activated;
	}
	
	public void setActive(boolean activated){
		this.activated = activated;
	}

    public CustomerAddress getAddress() {
        return address;
    }

    public void setAddress(CustomerAddress address) {
        this.address = address;
    }

    public CustomerAccount getAccount() {
        return account;
    }

    public void setAccount(CustomerAccount account) {
        this.account = account;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (!account.equals(customer.account)) return false;
        if (!personals.equals(customer.personals)) return false;
        if (!address.equals(customer.address)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = personals.hashCode();
        result = 31 * result + account.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Customer [activated: "+activated+"] {" +
                personals +
                ", address=" + address +

                ", accounts=" + account +
                '}';
    }
}
