package banksystem.composite;

import java.io.Serializable;

public abstract class BankCommand implements OperationInfo, Serializable
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