package projectfiles.Dao;

import projectfiles.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOImpl implements UserDAO {

    @Override
    public void addUser(User user) throws SQLException {
        if (!doesUserExist(user.getId())) {
            String sql = "INSERT INTO User (UserId, Password) VALUES (?, ?)";
            try (Connection conn = DatabaseCreds.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, user.getId());
                pstmt.setString(2, user.getPassword());
                pstmt.executeUpdate();
            }
        } else {
            System.out.println("User with ID " + user.getId() + " already exists.");
            // Optionally, throw an exception or handle this case as needed.
        }
    }
    
    @Override 
    public boolean doesUserExist(String userId) throws SQLException {
        String sql = "SELECT 1 FROM User WHERE UserId = ?";
        try (Connection conn = DatabaseCreds.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, userId);
            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next(); // Returns true if there is at least one result, meaning the user ID exists.
            }
        }
    }

    @Override
    public User getUserById(String userId) throws SQLException {
        String sql = "SELECT * FROM User WHERE UserId = ?";
        try (Connection conn = DatabaseCreds.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, userId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    User user = new User();
                    user.setId(rs.getString("UserId"));
                    user.setPassword(rs.getString("Password"));
                    return user;
                }
            }
        }
        return null;
    }

    @Override
    public void updatePassword(String userId, String newPassword) throws SQLException {
        String sql = "UPDATE User SET Password = ? WHERE UserId = ?";
        try (Connection conn = DatabaseCreds.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, newPassword);
            pstmt.setString(2, userId);
            pstmt.executeUpdate();
        }
    }
}
