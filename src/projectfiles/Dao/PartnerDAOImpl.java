package projectfiles.Dao;


import projectfiles.model.Partner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PartnerDAOImpl implements PartnerDAO {
    private UserDAO userDAO; // Dependency to handle User related database operations

    public PartnerDAOImpl() {
        this.userDAO = new UserDAOImpl(); // Initialize with concrete implementation
    }

    @Override
    public void addPartner(Partner partner) throws SQLException {
        // Check if the user already exists using the provided UserDAO
        if (!userDAO.doesUserExist(partner.getId())) {
            // Since the user does not exist, add them to the User table first
            userDAO.addUser(partner);  // This handles the insertion into the 'users' table

            // SQL statement to insert the new customer into the 'customers' table
            String sql = "INSERT INTO Partner (PartnerId, Name, Type, Country, City, Address) VALUES (?, ?, ?, ?, ?, ?)";
            try (Connection conn = DatabaseCreds.getConnection();  // Ensure the connection is managed correctly
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, partner.getId());
                pstmt.setString(2, partner.getName());
                pstmt.setString(3, partner.getType());
                pstmt.setString(4, partner.getCountry());
                pstmt.setString(5, partner.getCity());
                pstmt.setString(6, partner.getAddress());

                int affectedRows = pstmt.executeUpdate();
                if (affectedRows == 0) {
                    // No rows affected indicates that the insertion failed
                    throw new SQLException("Creating partner failed, no rows affected.");
                }
            } catch (SQLException e) {
                // Proper error logging and re-throwing exception
                System.err.println("SQL exception occurred while adding customer: " + e.getMessage());
                throw e;
            }
        } else {
            // Handle the case where the user already exists
            throw new SQLException("User already exists with ID: " + partner.getId());
        }
    }

    
    @Override
    public Partner getPartnerById(String partnerId) throws SQLException {
        String sql = "SELECT PartnerId, Name, Type, Country, City, Address FROM Partner WHERE PartnerId = ?";  // Exclude password for security
        try (Connection conn = DatabaseCreds.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, partnerId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Partner(
                        rs.getString("PartnerId"),
                        "",
                        rs.getString("Name"),
                        rs.getString("Type"),
                        rs.getString("Country"),
                        rs.getString("City"),
                        rs.getString("Address")
                    );
                }
            }
        } catch (SQLException e) {
            System.err.println("SQL Error: " + e.getMessage());
            throw e;
        }
        return null;
    }


    @Override
    public void updatePartner(Partner partner) throws SQLException {
        String sql = "UPDATE Partner SET Name = ?, Type = ?, Country = ?, City = ?, Address = ? WHERE PartnerId = ?";
        try (Connection conn = DatabaseCreds.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, partner.getName());
            pstmt.setString(2, partner.getType());
            pstmt.setString(3, partner.getCountry());
            pstmt.setString(4, partner.getCity());
            pstmt.setString(5, partner.getAddress());
            pstmt.setString(6, partner.getId());
            pstmt.executeUpdate();
        }
    }

}

