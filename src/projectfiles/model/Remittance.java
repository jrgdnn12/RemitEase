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

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getLocalCurrency() {
        return localCurrency;
    }

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

	public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getCancellationReason() {
        return cancellationReason;
    }

    public void setCancellationReason(String cancellationReason) {
        this.cancellationReason = cancellationReason;
    }

    public String getConfirmationDetails() {
        return confirmationDetails;
    }

    public void setConfirmationDetails(String confirmationDetails) {
        this.confirmationDetails = confirmationDetails;
    }

    public boolean processTransaction() {
        // Implementation for processing transaction
        return true; // Placeholder return value
    }

    public void handleTransactionError(String errorMessage) {
        // Implementation for handling transaction error
    }

    public void sendEmailUpdate(String message) {
        // Implementation for sending email update
    }

    public void sendSMSUpdate(String message) {
        // Implementation for sending SMS update
    }
}