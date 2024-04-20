package projectfiles.model;

import java.time.LocalDateTime;

/**
 * This models a single remittance.  
 */

public class Remittance {
    private String transactionId;
    private Customer senderID;
    private Recipient recipientID;
    private Partner partnerID;
    private double amount;
    private String localCurrency;
    private String targetCurency;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String cancellationReason;
    private String confirmationDetails;

    /**
     * Getter for remittance transaction ID
     * @return A unique identifier for the remittance transaction.
     */
    public String getTransactionId() {
        return transactionId;
    }

    /**
     * Setter for TransactionID.
     * Deprecated by database primary key autoincrement feature
     * @param transactionId A unique identifier for the remittance 
     */
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }
    
    /**
     * Getter for the senderID linked to transactionID
     * @return A unique identifier for the remittance sender
     */
    public Customer getSenderID() {
        return senderID;
    }
    
    /**
     * Links transaction to the sender
     * @param sender Unique identifier for remittance sender
     */
    public void setSenderID(Customer sender) {
        this.senderID = sender;
    }

    /**
     * Getter for the recipientID linked to the transaction.  
     * @return Recipients unique identifier.
     */
    public Recipient getRecipientID() {
        return recipientID;
    }
    
    /**
     * Setter for the recipientID, deprecated by database auto-increment primary key feature.
     * @param recipient An unique identifier for the recipient
     */
    public void setRecipientID(Recipient recipient) {
        this.recipientID = recipient;
    }

    
    /**
     * Getter for the partner ID linked to transaction
     * @return A unique identifier for the partner.
     */
    public Partner getPartnerID() {
        return partnerID;
    }

    /**
     * Setter for the partner ID linked to the transaction.
     * @param partner A unique identifier for the partner.
     */
    public void setPartnerID(Partner partner) {
        this.partnerID = partner;
    }

    /**
     * Getter for the remittance amount
     * @return A double containing the remittance amount.
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Setter for the remittance amount
     * @param amount A double containing the remittance amount.
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * Getter for the local currency
     * @return A string containing the local currency.
     */
    public String getLocalCurrency() {
        return localCurrency;
    }

    /**
     * Setter for the local currency
     * @param localCurrency A string containing the local currency.
     */
    public void setLocalCurrency(String localCurrency) {
        this.localCurrency = localCurrency;
    }

    /**
	 * @return the targetCurency
	 */
	public String getTargetCurency() {
		return targetCurency;
	}

	/**
	 * @param targetCurency the targetCurency to set
	 */
	public void setTargetCurency(String targetCurency) {
		this.targetCurency = targetCurency;
	}

    /**
     * Getter for the status of the remittance
     * @return  A string containing the status of the remittance.
     */
	public String getStatus() {
        return status;
    }

    /**
     * Setter for the status of the remittance
     * @param status A string containing the status of the remittance.
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Getter for the creation date of the remittance. 
     * @return A LocalDateTime containing the creation date of the remittance.
     */
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    /**
     * Setter for the creation date of the remittance. DEPRECATED by database auto-timestamp feature.
     * @param createdAt A LocalDateTime containing the creation date of the remittance.
     */
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Getter for the update date of the remittance. 
     * @return A LocalDateTime containing the update date of the remittance.
     */
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Setter for the update date of the remittance. DEPRECATED by database auto-timestamp feature.
     * @param updatedAt A LocalDateTime containing the update date of the remittance.
     */
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * Getter for the cancellation reason of the remittance
     * @return A string containing the cancellation reason of the remittance.
     */
    public String getCancellationReason() {
        return cancellationReason;
    }

    /**
     * Setter for the cancellation reason of the remittance
     * @param cancellationReason A string containing the cancellation reason of the remittance.
     */
    public void setCancellationReason(String cancellationReason) {
        this.cancellationReason = cancellationReason;
    }

    /**
     * Getter for the confirmation details of the remittance
     * @return A string containing the confirmation details of the remittance.
     */
    public String getConfirmationDetails() {
        return confirmationDetails;
    }

    /**
     * Setter for the confirmation details of the remittance
     * @param confirmationDetails A string containing the confirmation details of the remittance.
     */
    public void setConfirmationDetails(String confirmationDetails) {
        this.confirmationDetails = confirmationDetails;
    }

    /**
     * Method for processing transaction
     * @return
     */
    public boolean processTransaction() {
        // Implementation for processing transaction
        return true; // Placeholder return value
    }

    /**
     * Method for handling transaction error
     * @param errorMessage
     */
    public void handleTransactionError(String errorMessage) {
        // Implementation for handling transaction error
    }

    /**
     * Method for sending email update
     * @param message 
     */
    public void sendEmailUpdate(String message) {
        // Implementation for sending email update
    }

    /**
     * Method for sending SMS update
     * @param message
     */
    public void sendSMSUpdate(String message) {
        // Implementation for sending SMS update
    }
}