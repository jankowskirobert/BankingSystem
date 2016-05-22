package banksystem.view;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by init0 on 21.05.16.
 */
public class BankConsole {

    List<Item> menuItems;

    public BankConsole(){
        menuItems = new ArrayList<Item>();
    }

    public void addPosition(Item name){
        menuItems.add(name);
    }

    public Iterator<Item> getIterator(){
        return new BankConsoleIterator();
    }

    public Item getPosition(int i){
        return menuItems.get(i);
    }

    class BankConsoleIterator implements Iterator<Item> {
        int currentIndex = 0;
        @Override
        public boolean hasNext() {
            if (currentIndex >= menuItems.size()) {
                return false;
            } else {
                return true;
            }
        }

        @Override
        public Item next() {
            return menuItems.get(currentIndex++);
        }
    }

}
