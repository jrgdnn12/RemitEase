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

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Customer getSender() {
        return senderID;
    }

    public void setSender(Customer sender) {
        this.senderID = sender;
    }

    public Recipient getRecipient() {
        return recipientID;
    }

    public void setRecipient(Recipient recipient) {
        this.recipientID = recipient;
    }

    public Partner getPartner() {
        return partnerID;
    }

    public void setPartner(Partner partner) {
        this.partnerID = partner;
    }

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