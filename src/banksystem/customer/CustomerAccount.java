package banksystem.customer;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by init0 on 04.05.16.
 */
public class CustomerAccount implements Serializable, ConsoleDataInput {

    private long accountNo;
    private double balance;
    private double procentage;

    public CustomerAccount(){
        this.balance = 0;
        this.procentage = 0;
    }

    public double getProcentage() {
        return procentage;
    }

    public void setProcentage(double procentage) {
        this.procentage = procentage;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public long getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(long accountNo) {
        this.accountNo = accountNo;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerAccount that = (CustomerAccount) o;

        if (accountNo != that.accountNo) return false;

        return true;
    }

    @Override
    public String toString() {
        return "CustomerAccount{" +
                "accountNo=" + accountNo +
                ", balance=" + balance +
                ", procentage=" + procentage +
                '}';
    }

    @Override
    public void informationSetting(Scanner s) {

            System.out.println("Enter new account number:");
            long tmpNo = s.nextLong();
            this.accountNo = tmpNo;
            System.out.println("Enter new balance of account:");
            double tmpBalance = s.nextDouble();
            this.balance = tmpBalance;
            s.nextLine();

    }
}
