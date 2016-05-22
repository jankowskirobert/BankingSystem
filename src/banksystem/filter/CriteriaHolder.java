package banksystem.filter;

import banksystem.customer.Customer;
import banksystem.customer.CustomerAccount;
import banksystem.customer.CustomerAddress;
import banksystem.customer.CustomerPersonalInformation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by init0 on 22.05.16.
 */
public class CriteriaHolder implements SearchMethods {


    @Override
    public List<Customer> search(List<Customer> clients, CustomerPersonalInformation info) {
        List<Customer> tmpC = new ArrayList<Customer>();
        for(Customer c: clients)
        {
            if(c.equals(info))
                tmpC.add(c);
        }
        return tmpC;
    }

    @Override
    public List<Customer> search(List<Customer> clients, CustomerAddress addr) {
        List<Customer> tmpC = new ArrayList<Customer>();
        for(Customer c: clients)
        {
            if(addr.equals(c.getAddress()))
                tmpC.add(c);
        }
        return tmpC;
    }

    @Override
    public List<Customer> search(List<Customer> clients, CustomerAccount acc) {
        List<Customer> tmpC = new ArrayList<Customer>();
        for(Customer c: clients)
        {
            if(c.equals(acc))
                tmpC.add(c);
        }
        return tmpC;
    }
}
