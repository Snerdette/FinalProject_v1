package garage.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import garage.dao.PassDao;
import garage.entities.Pass;

@Repository
@Transactional
public class PassDaoImpl implements PassDao{

	@PersistenceContext
	private EntityManager em;
	
	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	@Override
	public List<Pass> getAllPasses() {
		return em.createQuery("SELECT t FROM pass t", Pass.class)
				.getResultList();
	}
	
	@Override
	public void add(Pass pass) {
		em.persist(pass);
	}
	
	@Override
	public void update(Pass pass) {
		em.merge(pass);
	}
	
	//need to grab list of powers from linking table Pass_Power where Pass.id = Pass_Power.passId
	@Override
	public Pass getPass(Integer passId) {
		return em.createQuery("SELECT e FROM pass e WHERE e.id = :id", Pass.class)
				.setParameter("id", passId)
				.getSingleResult();
	}

	@Override
	public void delete(Pass pass) {
		em.merge(pass);	
	}
	
	@Override
	public void delete(Integer passId) {
		Pass pass = getPass(passId);
		em.remove(pass);
	}

}
