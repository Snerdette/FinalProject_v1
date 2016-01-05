package garage.services.impl;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.dao.DataIntegrityViolationException;

import garage.dao.CustomerDao;
import garage.entities.Customer;
import garage.services.InvalidInputException;


public class CustomerServiceImplTest {


	private CustomerServiceImpl target;
	private CustomerDao mockEm;
	
	/**
	 * Setting up the CustomerDataServiceImpl for testing
	 */
	@Before
	public void setup(){
		target = new CustomerServiceImpl();
		mockEm = mock(CustomerDao.class);
		target.setCustomerDao(mockEm);
	}
	
	/**
	 * Testing the CustomerDataServiceImpl for getting a list of all the Customeres.
	 */
	@Test
	public void testGetAllCustomeres(){
		target.setCustomerDao(mockEm);
		List<Customer> expected = new ArrayList<Customer>();
		when(mockEm.getCustomerList()).thenReturn(expected);
		List<Customer> actual = target.getCustomerList();
		
		assertEquals(expected, actual);
	}
	
	/**
	 * Testing the CustomerDataServiceImpl for get(Customer customer);
	 */
	@Test
	public void testGetCustomerObject(){
		target.setCustomerDao(mockEm);
		Customer expected = new Customer();
		when(mockEm.getCustomerById(anyInt())).thenReturn(expected);
		Customer actual = null;
		
		try {
			actual = target.getCustomerById(3);
		} catch (InvalidInputException e) {
/*			e.printStackTrace();*/
		}
		assertEquals(actual, expected);	
	}
 
	/**
	 * Testing the CustomerDataServiceImpl for adding a customer.
	 */
	@Test
	public void testAddCustomerObject(){
		Customer customer = new Customer();
		customer.setId(2);
		customer.setFirstName("testFirst");
		customer.setLastName("testLast");
		customer.setEmail("test@Email.com");
		customer.setPhone("503-123-4567");
		
		target.addCustomer(customer);
		verify(mockEm, times(1)).addCustomer(customer);
	}
	
	/**
	 * Testing the CustomerDataServiceImpl for update Customer.
	 */
	@Test
	public void testUpdateCustomerObjectHappy(){
		Customer customer = new Customer();
		target.updateCustomer(customer);	
	}
	
	/**
	 * Testing the CustomerDataServiceImpl for delete Customer.
	 */
	@SuppressWarnings("unused")
	@Test
	public void testDeletingCustomerObjectById() throws InvalidInputException{
		Customer customer = new Customer();
		customer.setId(2);
		target.deleteCustomer(2);
		
		boolean result;
		try{
			target.getCustomerById(2);
			result = false;
		}catch (NullPointerException npe){
			result = true;
		}
		verify(mockEm, times(1)).getCustomerById(2);
	}
	
	//Need to try adding a customer with a null id
	@Test
	public void testAddingCustomerWithNullIdSadPath() {
		Customer customer = new Customer();
		customer.setId(null);
		
		boolean result;
		try {
			target.getCustomerById(null);
			result = true;
			
		}catch(InvalidInputException iie){
			result = false;
			
		}
		assertFalse(result);
		
	}
	
	//Need to try adding a customer with a null value for customer
		@Test
		public void testAddingCustomerWithNullCustomerValueSadPath() {
			Customer customer = new Customer();
			customer = null;
			
			boolean result;
			try {
				target.addCustomer(null);
				result = true;
				
			}catch(DataIntegrityViolationException dive){
				result = false;
				
			}
			assertFalse(result);
			
		}
}
