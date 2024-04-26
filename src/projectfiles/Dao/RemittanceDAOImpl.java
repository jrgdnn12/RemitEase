package projectfiles.Dao;

import projectfiles.model.Customer;
import projectfiles.model.Partner;
import projectfiles.model.Recipient;
import projectfiles.model.Remittance;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Statement;

public class RemittanceDAOImpl implements RemittanceDAO {

    @Override
    public int addRemittance(Remittance remittance) throws SQLException {
        String sql = "INSERT INTO Remittance (SenderId, RecipientId, PartnerId, AmountSent, AmountReceived, SourceCurrency, TargetCurrency, Status, CreatedAt, UpdatedAt, CancellationReason, ConfirmationDetails) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseCreds.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, remittance.getSenderID().getId()); // Assuming getSenderID returns a Customer object with an getId method
            stmt.setInt(2, remittance.getRecipientID().getId()); // Assuming getRecipientID returns a Recipient object with an getId method
            stmt.setString(3, remittance.getPartnerID().getId()); // Assuming getPartnerID returns a Partner object with an getId method
            stmt.setDouble(4, remittance.getAmountSent());
            stmt.setDouble(5, remittance.getAmountReceived());
            stmt.setString(6, remittance.getSourceCurrency());
            stmt.setString(7, remittance.getTargetCurency());
            stmt.setString(8, remittance.getStatus());
            stmt.setTimestamp(9, Timestamp.valueOf(remittance.getCreatedAt()));
            stmt.setTimestamp(10, Timestamp.valueOf(remittance.getUpdatedAt()));
            stmt.setString(11, remittance.getCancellationReason());
            stmt.setString(12, remittance.getConfirmationDetails());
            
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1); // Assuming the auto-incremented key is the first column
                } else {
                    throw new SQLException("Creating remittance failed, no ID obtained.");
                }
            }
        }
    }


    @Override
    public Remittance getRemittanceById(int remittanceId) throws SQLException {
        String sql = "SELECT * FROM Remittance WHERE TransactionId = ?";
        //isntation DAO for customer and partner and recipient
        CustomerDAO customerDAO = new CustomerDAOImpl();
        PartnerDAO partnerDAO = new PartnerDAOImpl();
        RecipientDAO recipientDAO = new RecipientDAOImpl();

        try (Connection conn = DatabaseCreds.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, remittanceId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Remittance(
                    rs.getInt("TransactionId"),
                    customerDAO.getCustomerById(rs.getString("SenderId")),
                    partnerDAO.getPartnerById(rs.getString("PartnerId")),
                    recipientDAO.getRecipientById(rs.getInt("RecipientId")),
                    rs.getDouble("AmountSent"),
                    rs.getDouble("AmountReceived"),
                    rs.getString("SourceCurrency"),
                    rs.getString("TargetCurrency"),
                    rs.getString("Status"),
                    rs.getTimestamp("CreatedAt").toLocalDateTime(),
                    rs.getTimestamp("UpdatedAt").toLocalDateTime(),
                    rs.getString("CancellationReason"),
                    rs.getString("ConfirmationDetails")
                );
            }
        }
 
    }

    @Override
    public void updateRemittance(Remittance remittance) throws SQLException {
        String sql = "UPDATE Remittance SET SenderId = ?, RecipientId = ?, PartnerId = ?, AmountSent = ?, AmountReceived = ?, SourceCurrency = ?, TargetCurrency = ?, Status = ?, UpdatedAt = ?, CancellationReason = ?, ConfirmationDetails = ? WHERE TransactionId = ?";

        try (Connection conn = DatabaseCreds.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, remittance.getSenderID().getId());
            stmt.setString(2, remittance.getRecipientID().getId());
            stmt.setString(3, remittance.getPartnerID().getId());
            stmt.setDouble(4, remittance.getAmountSent());
            stmt.setDouble(5, remittance.getAmountReceived());
            stmt.setString(6, remittance.getSourceCurrency());
            stmt.setString(7, remittance.getTargetCurency());
            stmt.setString(8, remittance.getStatus());
            stmt.setTimestamp(9, Timestamp.valueOf(remittance.getUpdatedAt()));
            stmt.setString(10, remittance.getCancellationReason());
            stmt.setString(11, remittance.getConfirmationDetails());
            stmt.setString(12, remittance.getTransactionId());

            stmt.executeUpdate();
        }
    }
}
