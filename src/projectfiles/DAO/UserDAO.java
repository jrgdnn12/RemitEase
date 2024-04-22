package projectfiles.DAO;

import java.sql.SQLException;
import projectfiles.model.User;
/**
 * Interface for UserDAO
 */
public interface UserDAO {
    boolean doesUserExist(String userId) throws SQLException;
    void addUser(User user) throws SQLException;
    User getUserByID(String userId) throws SQLException;
    void updatePassword(String userId, String newPassword) throws SQLException;

}
