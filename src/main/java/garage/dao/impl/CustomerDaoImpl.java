package garage.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import garage.dao.CustomerDao;
import garage.entities.Customer;

@Repository
@Transactional
public class CustomerDaoImpl implements CustomerDao{

	@PersistenceContext
	private EntityManager em;
	
	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	@Override
	public List<Customer> getCustomerList() {
		return em.createQuery("SELECT t FROM Customer t", Customer.class)
				.getResultList();
	}
	
	@Override
	public void addCustomer(Customer customer) {
		em.persist(customer);
	}
	
	@Override
	public void updateCustomer(Customer customer) {
		em.merge(customer);
	}
	
	//need to grab list of powers from linking table Customer_Power where Customer.id = Customer_Power.customerId
	@Override
	public Customer getCustomerById(Integer customerId) {
		return em.createQuery("SELECT e FROM Customer e WHERE e.id = :id", Customer.class)
				.setParameter("id", customerId)
				.getSingleResult();
	}

	@Override
	public void deleteCustomer(Integer customerId) {
		em.merge(customerId);	
	}
	
	/*@Override
	public void deleteCustomerById(Integer customerId) {
		Customer customer = getCustomerById(customerId);
		em.remove(customer);
	}*/

}
