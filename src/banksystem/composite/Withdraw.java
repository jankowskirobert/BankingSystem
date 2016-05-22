package banksystem.composite;

/**
 * Created by init0 on 17.05.16.
 */
public class Withdraw extends BankCommand {

    private long clientID;
    private double amount;

    public Withdraw(double amount, long clientID, Bank b ){
        super(b);
        this.clientID = clientID;
        this.amount = amount;
    }

    @Override
    public void makeDecision() {
        double currentBalance = getBank().getClient(clientID).getAccount().getBalance();
        getBank().getClient(clientID).getAccount().setBalance(currentBalance - amount);
    }


    @Override
    public String history() {
        return null;
    }
}
