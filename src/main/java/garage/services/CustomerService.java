package garage.services;

import java.util.List;
import garage.entities.Customer;

public interface CustomerService {

	Customer getCustomerById(Integer customerId) throws InvalidInputException;
	
	public List<Customer> getCustomerList();
	
	public void addCustomer(Customer customer);
	
	public void updateCustomer(Customer customer);
	
	public void deleteCustomer(Integer customerId);	
	
}
