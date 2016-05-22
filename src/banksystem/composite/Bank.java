package banksystem.composite;

import banksystem.customer.Customer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Bank implements Serializable {

    private List<Customer> clients;
    private List<OperationInfo> history;
    public Bank(){
        history = new ArrayList<OperationInfo>();
        clients = new ArrayList<Customer>();
    }

    public List<Customer> getClients() {
        return clients;
    }

    public void setClients(List<Customer> clients) {
        this.clients = clients;
    }

/*
    public Customer getClient(long clientID, CustomerAddress addrs, CustomerAccount acc){

    }
*/
    public void addToHistory(OperationInfo h){
        history.add(h);
    }

    public List<OperationInfo> getHistory() {
        return history;
    }

    public void addClient(Customer c){
        this.clients.add(c);
    }

    public Customer getClient(final long clientID) {

            for (int i = 0; i<clients.size();i++) {
                if (Long.compare(clients.get(i).getAccount().getAccountNo(),clientID) == 0) {
                    return clients.get(i);
                }
            }
        return null;
    }

    public void dispatch(BankCommand command){
        command.makeDecision();
        addToHistory(command);
    }


    @Override
    public String toString() {
        return "Bank{\n" +
                "clients=" + clients +
                "}\n";
    }


}
