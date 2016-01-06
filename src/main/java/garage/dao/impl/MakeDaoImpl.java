package garage.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import garage.dao.MakeDao;
import garage.entities.Make;

@Repository
@Transactional
public class MakeDaoImpl implements MakeDao{

	@PersistenceContext
	private EntityManager em;
	
	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	@Override
	public List<Make> getMakeList() {
		return em.createQuery("SELECT t FROM Make t", Make.class)
				.getResultList();
	}
	
	//need to grab list of powers from linking table Make_Power where Make.id = Make_Power.makeId
	@Override
	public Make getMakeById(Integer makeId) {
		return em.createQuery("SELECT e FROM Make e WHERE e.id = :id", Make.class)
				.setParameter("id", makeId)
				.getSingleResult();
	}
}
