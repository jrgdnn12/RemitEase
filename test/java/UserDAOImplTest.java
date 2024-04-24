package projectfiles.test.java;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import projectfiles.Dao.UserDAOImpl;
import projectfiles.model.User;
import projectfiles.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class UserDAOImplTest {

    @Mock
    private Connection connection;
    @Mock
    private PreparedStatement preparedStatement;
    @Mock
    private ResultSet resultSet;

    @InjectMocks
    private UserDAOImpl userDAO;

    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        when(DatabaseUtil.getConnection()).thenReturn(connection);
        when(connection.prepareStatement(anyString())).thenReturn(preparedStatement);
    }

    @Test
    void addUser_whenUserDoesNotExist_shouldAddUser() throws SQLException {
        when(preparedStatement.executeUpdate()).thenReturn(1);
        userDAO.addUser(new User("user1", "password123"));
        verify(preparedStatement, times(1)).executeUpdate();
    }

    @Test
    void getUserById_whenUserExists_shouldReturnUser() throws SQLException {
        when(resultSet.next()).thenReturn(true);
        when(resultSet.getString("UserId")).thenReturn("user1");
        when(resultSet.getString("Password")).thenReturn("password123");
        when(preparedStatement.executeQuery()).thenReturn(resultSet);

        User user = userDAO.getUserById("user1");

        verify(preparedStatement, times(1)).executeQuery();
        assert user != null;
        assert "user1".equals(user.getUserId());
        assert "password123".equals(user.getPassword());
    }

    @Test
    void updatePassword_updatesSuccessfully() throws SQLException {
        when(preparedStatement.executeUpdate()).thenReturn(1);
        userDAO.updatePassword("user1", "newPassword");
        verify(preparedStatement, times(1)).executeUpdate();
    }
}