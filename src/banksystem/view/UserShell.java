package banksystem.view;

import banksystem.composite.*;
import banksystem.filter.CriteriaHolder;
import banksystem.filter.SearchMethods;
import banksystem.customer.ConsoleDataInput;
import banksystem.customer.CustomerAccount;
import banksystem.customer.CustomerAddress;
import banksystem.customer.CustomerPersonalInformation;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

/**
* Created by init0 on 22.05.16.
*/
public class UserShell {
	private Bank b;

	public UserShell(Bank b){this.b=b;}

	public void depositMoney(Scanner g){
		try {
			System.out.println("Enter client account Number:");
			long receiver = g.nextLong();
			System.out.println("Enter Value:");
			double v = g.nextDouble();
			if (accept(new Scanner(System.in))) {
				b.dispatch(new Deposite(v, receiver, b));
				saveToFile();
			} else
				System.out.println("NO CHANGES");
		}catch (InputMismatchException e){
			System.out.println("ERROR "+e);
		}
	}

	public void withdrawMoney(Scanner g){
		try {
			System.out.println("Enter client account number:");
			long receiver = g.nextLong();
			System.out.println("Enter Value:");
			double v = g.nextDouble();
			if (accept(new Scanner(System.in))) {
				b.dispatch(new Withdraw(v, receiver, b));
				saveToFile();
			} else
				System.out.println("NO CHANGES");
		}catch (InputMismatchException e){
			System.out.println("ERROR "+e);
		}
	}

	public void searchClient(Scanner g){
		try {
			System.out.println("address, account, personal");
			g.nextLine();
			String determinant = g.nextLine();
			switch (determinant) {
				case "address":
					CustomerAddress l = new CustomerAddress();
					ConsoleDataInput h = l;
					h.informationSetting(g);
					SearchMethods m = new CriteriaHolder();
					System.out.println(m.search(b.getClients(), l));
					break;
				case "account":
					CustomerAccount a = new CustomerAccount();
					ConsoleDataInput h1 = a;
					h1.informationSetting(g);
					SearchMethods m1 = new CriteriaHolder();
					System.out.println(m1.search(b.getClients(), a));
					break;
				case "personal":
					CustomerPersonalInformation p = new CustomerPersonalInformation();
					ConsoleDataInput h2 = p;
					h2.informationSetting(g);
					SearchMethods m2 = new CriteriaHolder();
					System.out.println(m2.search(b.getClients(), p));
					break;
				default:
					break;
			}
		}catch (InputMismatchException e){
			System.out.println("ERROR "+e);
		}

	}

	public void removeClient(Scanner g){
		try {
			System.out.println("Enter Client Number:");
			long receiver = g.nextLong();
			if (accept(new Scanner(System.in))) {
				b.dispatch(new RemoveClient(receiver, b));
				saveToFile();
			} else
				System.out.println("NO CHANGES");
		}catch (InputMismatchException e){
			System.out.println("ERROR "+e);
		}
	}

	public void saveToFile(){
		try {
			FileOutputStream fos1 = new FileOutputStream("ser1.xml");
			java.beans.XMLEncoder xe1 = new java.beans.XMLEncoder(fos1);
			xe1.writeObject(b);
			xe1.flush();
			xe1.close();
			System.out.println("Serialization complete");
		}catch (IOException e){
			System.out.println("ERROR "+e);
		}
	}

	public void makeTransaction(Scanner g){
		try {
			System.out.println("Enter Sender Number:");
			long sender = g.nextLong();
			System.out.println("Enter Receiver Number:");
			long receiver = g.nextLong();
			System.out.println("Enter Value:");
			double v = g.nextDouble();
			if (accept(new Scanner(System.in))) {
				b.dispatch(new Transaction(receiver, sender, v, b));
				saveToFile();
			} else
				System.out.println("NO CHANGES");
		}catch (InputMismatchException e){
			System.out.println("ERROR "+e);
		}
	}

	public void createAccount(Scanner g){
		try {
			CustomerAccount a = new CustomerAccount();
			CustomerPersonalInformation p = new CustomerPersonalInformation();
			CustomerAddress l = new CustomerAddress();
			ConsoleDataInput h;
			h = a;
			h.informationSetting(g);
			h = p;
			h.informationSetting(g);
			h = l;
			h.informationSetting(g);
			if (accept(new Scanner(System.in))) {
				b.dispatch(new CreateAccount(b, a, p, l));
				saveToFile();
				System.out.println("User Added");
			} else
				System.out.println("NO CHANGES");
		}catch (InputMismatchException e){
			System.out.println("ERROR "+e);
		}
	}

	public boolean accept(Scanner s){
		System.out.println("Are You Sure? [yes=t | no=f]");
		if(s.nextLine().equals("t"))
			return true;
		else if(s.nextLine().equals("f"))
			return false;
		else{
			System.out.println("ERROR, no acceptation");
			return false;
		}
	}

	public void printMenu(BankConsole con){
		int i = 0;
		System.out.println("\n");
		for(Iterator<Item> g = con.getIterator(); g.hasNext(); i++){
			System.out.println(i+". "+g.next());
		}
	}

	public static void main(String[] args) {


		Bank x = new Bank();
		UserShell s = new UserShell(x);

		BankConsole con = new BankConsole();
		
		con.addPosition(new Item("Create new client account", 0));
		con.addPosition(new Item("Remove client",5));
		con.addPosition(new Item("Make Transaction", 4));
		con.addPosition(new Item("Deposit", 7));
		con.addPosition(new Item("Withdraw", 8));
		con.addPosition(new Item("Print Clients", 3));
		con.addPosition(new Item("Search", 6));
		con.addPosition(new Item("Print Menu", 2));
		con.addPosition(new Item("Remove", 9));
		con.addPosition(new Item("EXIT", -1));
		s.printMenu(con);

		while(true) {
			Scanner f = new Scanner(System.in);
			switch (con.getPosition(f.nextInt()).getCommand()) {
				case 0:
					s.createAccount(f);
					s.printMenu(con);
					break;
				case -1:
					System.exit(1);
					s.saveToFile();
					break;
				case 2:
					s.printMenu(con);
					break;
				case 3:
					System.out.println(x);
					s.printMenu(con);
					break;
				case 4:
					s.makeTransaction(f);
					s.printMenu(con);
					break;
				case 5:
					s.makeTransaction(f);
					s.printMenu(con);
					break;
				case 6:
					s.searchClient(f);
					s.printMenu(con);
					break;
				case 7:
					s.depositMoney(f);
					s.printMenu(con);
					break;
				case 8:
					s.withdrawMoney(f);
					s.printMenu(con);
					break;
				case 9:
					s.removeClient(f);
					s.saveToFile();
					s.printMenu(con);
					break;
				default:
					break;
			}
		}

	}

}
