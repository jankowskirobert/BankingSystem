package banksystem.filter;

import banksystem.customer.Customer;
import banksystem.customer.CustomerAccount;
import banksystem.customer.CustomerAddress;
import banksystem.customer.CustomerPersonalInformation;

import java.util.List;

/**
 * Created by init0 on 22.05.16.
 */
public interface SearchMethods {
    public List<Customer> search(List<Customer> clients, CustomerPersonalInformation info);
    public List<Customer> search(List<Customer> clients, CustomerAddress addr);
    public List<Customer> search(List<Customer> clients, CustomerAccount acc);
}
