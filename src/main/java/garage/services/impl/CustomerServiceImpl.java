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
	public List<Customer> getCustomerData() {
		List<Customer> customer = customerDao.getCustomerData();
		List<Customer> allCustomer = new ArrayList<>();
		
		for (Customer e : customer) {
			allCustomer.add(e);
		}
		return allCustomer;
	}

	@Override
	public Customer getCustomer(Integer id) throws InvalidInputException {
		if (id == null || id < 0) {
			throw new InvalidInputException("customerId.NullOrNegative");
		}
		return customerDao.getCustomer(id);
	}

	@Override
	public void add(Customer customer) {
		if (customer == null) {
			throw new DataIntegrityViolationException("Customer number is null");
		}else{
			customerDao.add(customer);
		}		
	}
	
	public void update(Customer customer) {
		if (customer == null) {
			throw new DataIntegrityViolationException("Customer number is null");
		}else{
			customerDao.update(customer);
		}	
	}
	
	@Override
	public void delete(Integer customerId) {
		customerDao.delete(customerId);
	}

}
