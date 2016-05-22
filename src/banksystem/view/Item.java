package banksystem.view;

import banksystem.composite.BankCommand;

/**
 * Created by init0 on 21.05.16.
 */
public class Item {

    private String name;
    private int c;

    public Item (String name, int c){
        this.name = name;
        this.c = c;
    }

    @Override
    public String toString() {
        return name;
    }

    public int getCommand(){
        return c;
    }


}
