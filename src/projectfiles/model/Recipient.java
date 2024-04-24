package projectfiles.model;


public class Recipient  {
    private String recipientId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String country;
    private String city;
    private String address;

    public Recipient() {
        // Default constructor
    }
    
    /**
     * Constructs the new recipient with specified identification and contact details.
     * @param id Specified by the database autoincrement feature.
     * @param email The email address of the recipient
     * @param firstName The the first name of the recipient
     * @param lastName the last name of the recipient
     * @param phoneNumber The contact phone number of the recipient.
     */
    public Recipient( String email, String firstname, String lastName, String phoneNumber) {
        this.email = email;
        this.firstName = firstname;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }
    
    //Getter and setters

    /**
     * Getter for the recipient ID
     * @return A string containing the recipient ID.
     *
     */
    public String getRecipientId() {
        return recipientId;
    }

    
    /**
     * Getter for the first name of the recipient
     * @return A string containing the name of the recipient.
     */
    public String getFirstName() {
        return firstName;
    }
    
    /**
     * Setter for the first name of the recipient
     * @param name A string containing the name of the recipient
     */
    public void setFirstName(String name) {
        this.firstName = name;
    }
    
    /** Getter for the last name of recipient
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/** Setter for the last name of recipient.
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
     * Get the contact phone number of the recipient
     * @return A String containing the contact phone number of the recipient.
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