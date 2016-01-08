package garage.dao;

import java.util.List;

import garage.controllers.CustomerController;
import garage.entities.Customer;

public interface CustomerDao {

	public List<Customer> getCustomerData();

	void add(Customer customer);
	
	void update(Customer customer);
	
	void delete(Customer customer);
	
	void delete(Integer customerId);

	public Customer getCustomer(Integer customerId);

}
