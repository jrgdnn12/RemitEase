package projectfiles.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.protocol.a.SqlDateValueEncoder;

import projectfiles.model.User;


public class UserDAOImpl implements UserDAO{

    @Override
    public boolean doesUserExist(String userID) throws SQLException {
        String sql = "SELECT * FROM users WHERE userID = ?";
        try (Connection conn = DatabaseCreds.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
        ) {
            stmt.setString(1, userID);
            ResultSet rs = stmt.executeQuery();
            return rs.next(); //return true when userID exists
        }   
    }

    @Override
    public void addUser(User userId) throws SQLException {
        if (!doesUserExist(userId.getId())) {
            String sql = "INSERT INTO User (UserID, Password) VALUES (?, ?)";
            try (Connection conn = DatabaseCreds.getConnection();
                PreparedStatement smt = conn.prepareStatement(sql)) {
                    smt.setString(1, userId.getId());
                    smt.setString(2, userId.getPassword());
                }
        } else {
                throw new SQLException("User already exists");
                //How are we going to hanfle this Expection?
        }
    }

    @Override
    public User getUserByID(String userId) throws SQLException {
        String sql = "SELECT * FROM User WHERE UserId = ?";
        try (Connection conn = DatabaseCreds.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, userId);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    User userbyid = new User();
                    userbyid.setId(rs.getString("UserId"));
                    userbyid.setPassword(rs.getString("Password"));
                    return userbyid;
                }
            }
            return null;
        } 


    @Override
    public void updatePassword(String userId, String newPassword) throws SQLException {
        String sql = "UPDATE USER SET Password = ? WHERE UserID = ?";
        try (Connection conn = DatabaseCreds.getConnection(); 
            PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, userId);
                stmt.setString(2, newPassword);
                stmt.executeUpdate();
            }
    }
    

}
