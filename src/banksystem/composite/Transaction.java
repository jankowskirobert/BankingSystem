package banksystem.composite;

import banksystem.customer.Customer;

/**
 * Created by init0 on 04.05.16.
 */
public class Transaction extends BankCommand {

    private int transactionNo;
    private long receiver;
    private long sender;
    private double value;
    private Bank b;

    public Transaction(long receiver, long sender, double value, Bank b) {
        super(b);
        this.sender = sender;
        this.receiver = receiver;
        this.value = value;
    }

    @Override
    public void makeDecision() {
        try {
            Customer senderAccount = getBank().getClient(sender);
            Customer receiverAccount = getBank().getClient(receiver);
            double senderBalance = senderAccount.getAccount().getBalance();
            double receiverBalance = receiverAccount.getAccount().getBalance();
            senderAccount.getAccount().setBalance(senderBalance - value);
            receiverAccount.getAccount().setBalance(receiverBalance + value);
        }catch (NullPointerException e){
            System.err.println(e);
        }
    }

    @Override
    public String history() {
        return "Transaction from: "+sender+" to: "+receiver+" for: "+value+"$";
    }
}
