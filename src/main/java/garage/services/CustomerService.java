package garage.services;

import java.util.List;
import garage.entities.Customer;

public interface CustomerService {
	
	public List<Customer> getCustomerData();

	Customer getCustomer(Integer customerId)throws InvalidInputException;
	
	public void add(Customer customer);
	
	public void update(Customer customer);
	
	public void delete(Integer customerId);	
	
	/*public void delete(Customer customer);	*/
	
}
