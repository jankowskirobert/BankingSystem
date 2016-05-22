package banksystem.composite;

/**
 * Created by init0 on 22.05.16.
 */
public class RemoveClient extends BankCommand{

    private long clientID;
    public RemoveClient(long clientID, Bank b) {
        super(b);
        this.clientID = clientID;
    }

    @Override
    public void makeDecision() {
        getBank().getClients().remove(getBank().getClient(clientID));
    }

    @Override
    public String history() {
        return null;
    }
}
