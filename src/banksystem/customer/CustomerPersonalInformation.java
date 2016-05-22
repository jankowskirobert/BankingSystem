package banksystem.customer;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by init0 on 17.05.16.
 */
public class CustomerPersonalInformation implements ConsoleDataInput, Serializable {
    private String firstName;
    private String lastName;
    private int personalNo;

    public CustomerPersonalInformation(String firstName, String lastName, int personalNo){
        this.firstName = firstName;
        this.lastName = lastName;
        this.personalNo = personalNo;
    }

    public CustomerPersonalInformation(){
        this.firstName = "";
        this.lastName = "";
        this.personalNo = 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerPersonalInformation that = (CustomerPersonalInformation) o;

        if (personalNo != that.personalNo) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return personalNo;
    }

    @Override
    public String toString() {
        return "CustomerPersonalInformations{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", personalNo=" + personalNo +
                '}';
    }

    @Override
    public void informationSetting(Scanner s) {

            System.out.println("First Name:");
            String tmpFn = s.nextLine();
            this.firstName = tmpFn;
            System.out.println("Last Name:");
            String tmpLn = s.nextLine();
            this.lastName = tmpLn;
            System.out.println("Personal Number:");
            int tmpPn = s.nextInt();
            this.personalNo = tmpPn;
            s.nextLine();


    }
}
