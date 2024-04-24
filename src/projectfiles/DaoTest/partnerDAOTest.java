package projectfiles.DaoTest;

import projectfiles.model.Partner;
import projectfiles.Dao.PartnerDAOImpl;

import java.sql.SQLException;

public class partnerDAOTest {

    public static void main(String[] args) {
        // Initialize the PartnerDAOImpl
        PartnerDAOImpl partnerDAO = new PartnerDAOImpl();

        // Create a new Partner object
        Partner newPartner = new Partner("partner01", "password123", "RemitEase", "Credit Union ", "USA", "City", "123 ABC Strerge");

        try {
            // Add a partner to the database
            System.out.println("Adding new partner...");
            partnerDAO.addPartner(newPartner);
            System.out.println("New partner added successfully!");
        } catch (SQLException e) {
        	System.err.println("Was not able to add customer");
        }
        	
        try {
            // Retrieve a partner from the database
            System.out.println("Retrieving partner...");
            Partner retrievedPartner = partnerDAO.getPartnerById("partner01");
            if (retrievedPartner != null) {
                System.out.println("Partner retrieved: " + retrievedPartner.getName());
            } else {
                System.out.println("Partner not found.");
            }
        } catch (SQLException e) {
        	System.err.println("Failed to retrive customer");
        }
            
        try {
            	
            // Update partner details
            System.out.println("Updating partner...");
            newPartner.setCity("Brooklyn");
            partnerDAO.updatePartner(newPartner);
            System.out.println("Partner updated successfully!");

            // Retrieve updated partner to verify changes
            System.out.println("Verifying update...");
            Partner updatedPartner = partnerDAO.getPartnerById("partner01");
            if (updatedPartner != null && "Brooklyn".equals(updatedPartner.getCity())) {
                System.out.println("Update verified: Partner city is now " + updatedPartner.getCity());
            } else {
                System.out.println("Update verification failed.");
            }

        } catch (SQLException e) {
            System.err.println("Database operation failed: " + e.getMessage());
        }
    }
}
