package garage.dao;

import java.util.List;

import garage.controllers.CustomerController;
import garage.entities.Customer;

public interface CustomerDao {

	public List<Customer> getCustomerList();

	void deleteCustomer(Integer customerId);
	
	void deleteCustomer(Customer customer);

	void updateCustomer(Customer customer);

	void addCustomer(Customer customer);

	public Customer getCustomerById(Integer customerId);

}
