package projectfiles.model;

public class User {
    private String userID;
    private String password;
    private int permissionLevel;

    public User() {
        // Default constructor
    }

    public User(String id, String password) {
        this.userID = id;
        this.password = password;
    }

    public String getId() {
        return userID;
    }

    public void setId(String id) {
        this.userID = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean authenticate(String password) {
        return this.password.equals(password);
    }

    public int getPermissionLevel() {
        return permissionLevel;
    }

    public void setPermissionLevel(int permissionLevel) {
        this.permissionLevel = permissionLevel;
    }
}