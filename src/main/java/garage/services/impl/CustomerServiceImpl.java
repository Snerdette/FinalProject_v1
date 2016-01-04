package garage.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import garage.controllers.CustomerController;
import garage.dao.CustomerDao;
import garage.entities.Customer;
import garage.services.CustomerService;
import garage.services.InvalidInputException;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDao customerDao;
	

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	public List<Customer> getCustomerList() {
		List<Customer> customer = customerDao.getCustomerList();
		List<Customer> allCustomer = new ArrayList<>();
		
		for (Customer e : customer) {
			allCustomer.add(e);
		}
		return allCustomer;
	}

	@Override
	public Customer getCustomerById(Integer customerId) throws InvalidInputException {
		if (customerId == null || customerId < 0) {
			throw new InvalidInputException("customerId.NullOrNegative");
		}
		return customerDao.getCustomerById(customerId);
	}

	@Override
	public void addCustomer(Customer customer) {
		if (customer == null) {
			throw new DataIntegrityViolationException("Customer number is null");
		}else{
			customerDao.addCustomer(customer);
		}		
	}
	
	public void updateCustomer(Customer customer) {
		if (customer == null) {
			throw new DataIntegrityViolationException("Customer number is null");
		}else{
			customerDao.updateCustomer(customer);
		}	
	}
	
	@Override
	public void deleteCustomer(Integer customerId) {
		customerDao.deleteCustomer(customerId);
	}

}
