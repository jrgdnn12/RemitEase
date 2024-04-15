package projectfiles;

public class Partner extends User {
    private String name;
    private String type;
    private String country;
    private String city;
    private String address;
    private double balance;

    public Partner() {
        // Default constructor
    }

    public Partner(String id, String password, String name, String type) {
        super(id, password);
        this.name = name;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            // Handle insufficient balance
        }
    }

    public void addPartner(Partner partner) {
        // Implementation for adding a partner
    }
}