package banksystem.customer;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by init0 on 04.05.16.
 */
public class CustomerAddress implements ConsoleDataInput, Serializable {

    private String city;
    private String country;
    private String street;
    private int houseNumber;
    private int zipCode;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerAddress that = (CustomerAddress) o;

        if (houseNumber != that.houseNumber) return false;
        if (zipCode != that.zipCode) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (country != null ? !country.equals(that.country) : that.country != null) return false;
        if (street != null ? !street.equals(that.street) : that.street != null) return false;

        return true;
    }

    public CustomerAddress(){

    }

    public CustomerAddress(String city, String country, String street, int houseNumber, int zipCode){
        this.city = city;
        this.country = country;
        this.street = street;
        this.houseNumber = houseNumber;
        this.zipCode = zipCode;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    @Override
    public String toString() {
        return "CustomerAddress{" +
                "city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", street='" + street + '\'' +
                ", houseNumber=" + houseNumber +
                ", zipCode=" + zipCode +
                '}';
    }

    @Override
    public void informationSetting(Scanner s) {

            System.out.println("City:");
            String tmpCi = s.nextLine();
            setCity(tmpCi);

            System.out.println("Country:");
            String tmpCo = s.nextLine();
            setCountry(tmpCo);

            System.out.println("Street:");
            String tmpSt = s.nextLine();
            setStreet(tmpSt);

            System.out.println("HouseNumber:");
            int tmpHn = s.nextInt();
            setHouseNumber(tmpHn);

            System.out.println("ZipCode:");
            int tmpZc = s.nextInt();
            setZipCode(tmpZc);
            s.nextLine();

    }
}
