package garage.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import garage.entities.Customer;
import garage.services.CustomerService;
import garage.services.InvalidInputException;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	public void setCustomerService(CustomerService customerService){
		this.customerService = customerService;
	}

	@RequestMapping(value="/customer", method=RequestMethod.GET)
	public List<Customer> getCustomerData(){
		return customerService.getCustomerData();
	}
	
	@RequestMapping(value="/customer/{id}", method=RequestMethod.GET)
	public Customer getCustomer(@PathVariable Integer id)throws InvalidInputException{
		return customerService.getCustomer(id);
	}
	
	@RequestMapping(value="/customer", method=RequestMethod.POST)  
	public void add(@RequestBody Customer customer) { 
		System.out.println(customer);
		customerService.add(customer);
	}
	
	@RequestMapping(value="/customer/{id}", method=RequestMethod.PUT)
	public void updateCustomer(@PathVariable Integer id, @RequestBody Customer customer){ 
		customer.setId(id);
		customerService.update(customer);
	}
	
	@RequestMapping(value="/customer/{id}", method=RequestMethod.DELETE)
	public void deleteById(@PathVariable Integer id){
		customerService.delete(id);
	}
	
}
