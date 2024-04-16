package projectfiles.model;

public class Customer extends User {
    private String name;
    private String phoneNumber;
    private String email;
    private double balance;
    private String country;
    private String city;
    private String address;

    public Customer() {
        // Default constructor
    }

    public Customer(String id, String email, String password, String name, String phoneNumber) {
        super(id, password);
        this.email = email;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public void sendEmailUpdate(String message) {
        // Implementation for sending email update
        System.out.println("Email sent: " + message);
    }

    public void deleteAccount() {
        // Implementation for deleting customer account
    }
}