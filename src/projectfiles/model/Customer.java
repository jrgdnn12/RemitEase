package projectfiles.model;

/**
 * This model class represents a customer.
 * <p>
 * This class extends the User Class, adds more attributes pertinent to the customer.
 */

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
    
    /**
     * Constructor for objects of the class Customer
     * @param id Unique identifier of the customer
     * @param email the email address of the sender
     * @param password The customer's password for authentication purposes.
     * @param name The full name of the customer.
     * @param phoneNumber The contact phoner number of the customer
     */
    public Customer(String id, String email, String password, String name, String phoneNumber) {
        super(id, password, 0); //here we assume 0 is the default permission.
        this.email = email;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.balance = 0.00; //Assuming default balance is 0
    }
    
    //Getter and setter for name
    
    /**
     * Gets the name of the customer.
     * @return A string with the name of the customer.
     */
    public String getName() {
        return name;
    }
    
    /**
     * Sets the name of the customer
     * @param name A string with the name of the customer.
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Gets the phone number of the customer
     * @return A String with the phone number of the customer.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    /**
     * Sets the phone number of the customer 
     * @param phoneNumber A String with the phone number of the customer.
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

	/**
	 * Gets the email of the customer.
	 * @return A string containing the customer's email.
	 */
    public String getEmail() {
        return email;
    }
    
    /**
     * Sets the email of the customer
     * @param email A String containing the email of the customer.
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    /**
     * Gets the balance of the customer
     * @return A double containing the balance of the customer.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Sets the balance of the customer. Use carefully, as its better to deposit and withdraw. 
     * @param balance A double containing the balance of the customer.
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    /**
     * Gets the Country of the customer
     * @return A string containing the name of the customer's Country. 
     */
    public String getCountry() {
        return country;
    }
    
    /**
     * sets the name of the country
     * @param country A string containing the name of the country.
     */
    public void setCountry(String country) {
        this.country = country;
    }
    
    /**
     * Gets the name of the city of the customer
     * @return A string containing the name of the customer's city.
     */
    public String getCity() {
        return city;
    }
    
    /**
     * Sets the name of the city.
     * @param city A String containing the name if the customer's city.
     */
    public void setCity(String city) {
        this.city = city;
    }

	/**
	 * Gets the customer address
	 * @return A string containing the address of the customer.
	 */
    public String getAddress() {
        return address;
    }
    
    /**
     * Sets the address of the customer
     * @param address A String containing the address of the customer
     */
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    /**
     * Deposits the specified amount to the customer's account balance.
     * @param amount A double containing the amount to be added to the balance.
     */
    public void deposit(double amount) {
        balance += amount; //what if the value is negative? there migth be an exception needed here?
    }

    /**
     * The specified amount will substa
     * @param amount
     * @return
     */
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