package banksystem.composite;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by init0 on 21.05.16.
 */
public class MacroOperations extends BankCommand{

    public MacroOperations(Bank b) {
        super(b);
        commands = new LinkedHashSet<BankCommand>();
    }

    @Override
    public void makeDecision() {
        for(BankCommand c: commands){
            c.makeDecision();
        }
    }


    private Set<BankCommand> commands;

    public void addCommand(BankCommand c){
        commands.add(c);
    }
    public void removeCommand(BankCommand c){
        commands.remove(c);
    }

    @Override
    public String history() {
        return null;
    }
}
