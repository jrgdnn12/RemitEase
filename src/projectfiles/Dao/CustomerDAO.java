package projectfiles.Dao;

import java.sql.SQLException;

import projectfiles.model.Customer;

public interface CustomerDAO {
	void addCustomer(Customer customer) throws SQLException;  // Now correctly declaring the exception
    Customer getCustomerById(String customerId) throws SQLException;
    void updateCustomer(Customer customer) throws SQLException;
}
