package projectfiles.Dao;

import java.sql.SQLException;
import projectfiles.model.User;
/**
 * Interface for UserDAO
 */
public interface UserDAO {
    boolean doesUserExist(String userId) throws SQLException;
    void addUser(User userId) throws SQLException;
    User getUserById(String userId) throws SQLException;
    void updatePassword(String userId, String newPassword) throws SQLException;

}
