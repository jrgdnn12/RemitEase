package projectfiles.model;

/**
 * This model class represents a recipient of remittance. 
 * This class extends the {@code User} class, adding more attributes and methods
 * that are specific to the remittance recipient.  
 */

public class Recipient extends User {
    private String name;
    private String phoneNumber;
    private String email;
    private double balance;
    private String country;
    private String city;
    private String address;

    public Recipient() {
        // Default constructor
    }
    
    /**
     * Constructs the new recipient with specified identification and contact details.
     * @param id The unique identifier for the recipient
     * @param email The email address of the recipient
     * @param password Not sure how the recipient will use this, should this parameter be removed?
     * @param name The full name of the recipient
     * @param phoneNumber The contact phone number of the recipient.
     * @param balance The balance in US dollars.
     */
    public Recipient(String id, String email, String password, String name, String phoneNumber) {
        super(id, password, 0); //Default user permission.
        this.email = email;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.balance = 0.00; //intiallize the balance to 0.00
    }
    
    //Getter and setters
    
    /**
     * Get the name of the recipient
     * @return A string containing the name of the recipient.
     */
    public String getName() {
        return name;
    }
    
    /**
     * Sets the name of the recipient
     * @param name A string containing the name of the recipient
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Get the contact phone number of the recipient
     * @return A String containing the contact phone numbe of the recipient.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

	/**
	 * Set the contact phone number of the recipient
	 * @param phoneNumber A String containing the contact phone number of the recipient.
	 */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Gets the email of the recipient.
     * @return A string containing the email fo the recipient.
     */
    public String getEmail() {
        return email;
    }

	/**
	 * Sets the email of the recipient
	 * @param email A string containing the email of the recipient.
	 */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the balance of the recipients account.
     * @return A double to represent the recipients available balance.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Sets the balance. Use carefully, may be deprecated by deposit and withdraw method
     * @param balance A double containing the amount to arbitrarily change balance to.
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Get the name of the recipient country.
     * @return A string containing the name of the recipient's country.
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the name of the recipients country.
     * @param country A string containing the name of the recipients country.
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Gets the name of the recipients city.
     * @return A String containing the name of the recipients city.
     * 
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the name of the recipients city.
     * @param city A String containing the name of the recipient's city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets the address of the recipient
     * @return A String containing the address of the recipient.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Set the address of the recipient
     * @param address A string containing the address of the recipient
     */
    public void setAddress(String address) {
        this.address = address;
    }
    
    //Methods for balance management
    
    /**
     * Method to receive remittance, add to the balance. 
     * @param amount
     */
    public void receive(double amount) {
        balance += amount;
    }
    
    /**
     * Method to update balance after a partner remittance disbursement.
     * @param amount
     */
    public void disburse(double amount) {
    	balance -= amount;
    }
    
    /**
     * Send an email update to the customer with the message specified.
     * @param message
     */
    public void sendEmailUpdate(String message) {
        // Implementation for sending email update
        System.out.println("Email sent: " + message);
    }
    
    /**
     * Send an SMS update to the customer with the message specified.
     */
    public void sendSMSupdate() {
    	// actual implementation for sending sms is to be done here
    	
    }
}