package garage.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import garage.dao.ModelDao;
import garage.entities.Model;

@Repository
@Transactional
public class ModelDaoImpl implements ModelDao{

	@PersistenceContext
	private EntityManager em;
	
	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	@Override
	public List<Model> getModelData() {
		return em.createQuery("SELECT t FROM model t", Model.class)
				.getResultList();
	}
	
	//need to grab list of powers from linking table Model_Power where Model.id = Model_Power.modelId
	@Override
	public Model getModelById(Integer modelId) {
		return em.createQuery(("SELECT e FROM model e WHERE e.id = :id"), Model.class)
				.setParameter("id", modelId)
				.getSingleResult();
	}

	@Override
	public List<Model> getModelsForMake(Integer makeId) {
		return em.createQuery("SELECT mo FROM model mo WHERE mo.make.id = :id", Model.class)
				.setParameter("id", makeId)
				.getResultList();
	}

}
