package projectfiles.DaoTest;

import java.sql.SQLException;

import projectfiles.Dao.RecipientDAOImpl;
import projectfiles.model.Recipient;

/**
 * This class tests the RecipientDAO class.
 */
public class RecipientDAOTest {

    public static void main(String[] args) {
    
    // Create a test recipient
    Recipient testRecipient = new Recipient(
        0 , // no id
        "emailfsf@gmail.com",
        "Jorge",
        "Alvarez",
        "702-888-8888",
        "USA",
        "Las Vegas",
        "123 Test St."

    ); 

    //Instantiate the DAO implementationq
    RecipientDAOImpl recipientDAO = new RecipientDAOImpl();
    int AddedrecipienID = 0;
    //Test adding recipient
    try {
        System.out.println("Testing addRecipient...");
        AddedrecipienID = recipientDAO.addRecipient(testRecipient);
        
        System.out.println("Recipient added successfully. the generated ID is: " + AddedrecipienID) ;
    } catch (SQLException e) {
        System.err.println(e.getMessage());
    
    }

    Recipient retrievedRecipient = null;
    //test retrieving a recipient
    try {
        System.out.println("Testing getRecipientById...");
         retrievedRecipient = recipientDAO.getRecipientById(AddedrecipienID);
        System.out.println("Recipient retrieved: " + retrievedRecipient.getId() + " " + retrievedRecipient.getLastName());
     } catch (SQLException e) {
        System.err.println(e.getMessage());
    }
    
    //test updating a 
    try {
        System.out.println("Testing updateRecipient...");
        //retrievedRecipient.setId(8759879); //invalidate test
        retrievedRecipient.setCity("Henderson");
        recipientDAO.updateRecipient(retrievedRecipient);
        System.out.println("Recipient updated successfully.");
    } catch (SQLException e) {
        System.err.println(e.getMessage());
    }
}
}
