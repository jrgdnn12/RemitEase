package projectfiles.model;

import java.util.ArrayList;

/**
 * This class manages a collection of recipients list.
 */
public class RecipientList {
    //initialize the arrayList
    private ArrayList<Recipient> recipientsList;

    /**
     * Default constructor for the RecipientList class.
     */
    public RecipientList() {
        recipientsList = new ArrayList<Recipient>();
    }

    /**
     * Method to return a list of all recipients
     * @return An ArrayList of all recipients
     */
    public ArrayList<Recipient> getRecipientsList() {
        return recipientsList;
    }
    /**
     * Method to find a recipient by their ID
     * @param recipientId The ID of the recipient to find
     */
    public Recipient findRecipientById(String recipientId) {
        for (Recipient recipient : recipientsList) {
            if (recipient.getRecipientId().equals(recipientId)) {
                return recipient;
            }
        }
        return null;
    }
}
