package projectfiles.DaoTest;

import projectfiles.model.User;
import projectfiles.Dao.UserDAOImpl;

public class TestUserDAO {

    public static void main(String[] args) {
        UserDAOImpl userDao = new UserDAOImpl();

        try {
            // Test addUser
            System.out.println("Testing addUser...");
            User newUser = new User("testUser01", "testPassword");
            userDao.addUser(newUser);
            System.out.println("User added successfully.");

            // Test doesUserExist
            System.out.println("Testing doesUserExist...");
            boolean exists = userDao.doesUserExist("testUser01");
            System.out.println("Does user exist? " + exists);

            // Test getUserByID
            System.out.println("Testing getUserByID...");
            User fetchedUser = userDao.getUserByID("testUser01");
            if (fetchedUser != null) {
                System.out.println("User Found: ID = " + fetchedUser.getId() + ", Password = " + fetchedUser.getPassword());
            } else {
                System.out.println("User not found.");
            }

            // Test updatePassword
            System.out.println("Testing updatePassword...");
            userDao.updatePassword("testUser01", "newTestPassword");
            System.out.println("Password updated successfully.");

            // Verify password update
            System.out.println("Verifying password update...");
            User updatedUser = userDao.getUserByID("testUser01");
            if (updatedUser != null && "newTestPassword".equals(updatedUser.getPassword())) {
                System.out.println("Password update verified.");
            } else {
                System.out.println("Password update failed.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
