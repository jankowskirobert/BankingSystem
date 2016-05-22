package banksystem.composite;

public abstract class BankCommand implements OperationInfo
{

    private Bank b;
    public BankCommand(Bank b){
        this.b = b;
    }
    public abstract void makeDecision();
    public Bank getBank(){
        return b;
    }

}