package banksystem.composite;

import banksystem.customer.*;

/**
 * Created by init0 on 21.05.16.
 */
public class CreateAccount extends BankCommand{
    private CustomerAccount a;
    private CustomerPersonalInformation p;
    private CustomerAddress l;

    public CreateAccount(Bank b, CustomerAccount a, CustomerPersonalInformation p, CustomerAddress l) {
        super(b);
        this.a = a;
        this.p = p;
        this.l = l;
    }

    @Override
    public void makeDecision() {
        Customer tmp = new Customer();
        tmp.setAccount(a);
        tmp.setPersonals(p);
        tmp.setAddress(l);
        getBank().addClient(tmp);
    }


    @Override
    public String history() {
        return null;
    }
}
