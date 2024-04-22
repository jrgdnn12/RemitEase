

package projectfiles.model;

import java.util.ArrayList;


/**
 * This model class will handle a collection of remittance objects.
 */
public class RemittanceList {
    //Array list of remittance objects
    private ArrayList<Remittance> remittanceList;

    /**
     * Default constructor for the remittance list.
     */
    public RemittanceList() {
        remittanceList = new ArrayList<Remittance>();
        
    }

    /**
     * adds a remittance to the list.
     * @param remittance The remitance object to be added to the list.
     */
    public void addRemittance(Remittance remittance) {
        remittanceList.add(remittance);
    }

    /**
     *  Removes a remittance from the list. 
     * @param remittance The remittance object to be removed from the list.
     * @return True if the remittance was removed successfully, false otherwise.
     */
    public boolean removeRemittance(Remittance remittance) {
        return remittanceList.remove(remittance);
    }

    /**
     * Returns a list of all  remittance list.
     * @return The remittance list.
     */
    public ArrayList<Remittance> getRemittanceList() {
        return remittanceList;
    }

    /**
     * Method to return a remittance object by transactionID. 
     * @param remittanceID The unique identifier of the remittance object.  
     */
    public Remittance getRemittance(String remittanceID) {
        for (Remittance remittance : remittanceList) {
            if (remittance.getTransactionId().equals(remittanceID)) {
                return remittance;
            }
        }
        return null;
    }
    
    


    

}




