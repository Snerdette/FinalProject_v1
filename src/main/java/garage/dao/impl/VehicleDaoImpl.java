package garage.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import garage.dao.VehicleDao;
import garage.entities.Vehicle;

@Repository
@Transactional
public class VehicleDaoImpl implements VehicleDao {

	@PersistenceContext
	private EntityManager em;
	
	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	@Override
	public List<Vehicle> getVehicleList() {
		return em.createQuery("SELECT t FROM Vehicle t", Vehicle.class)
				.getResultList();
	}
	
	@Override
	public void addVehicle(Vehicle vehicle) {
		em.persist(vehicle);
	}
	
	@Override
	public void updateVehicle(Vehicle vehicle) {
		em.merge(vehicle);
	}
	
	//need to grab list of powers from linking table Vehicle_Power where Vehicle.id = Vehicle_Power.vehicleId
	@Override
	public Vehicle getVehicleById(Integer vehicleId) {
		return em.createQuery("SELECT e FROM Vehicle e WHERE e.id = :id", Vehicle.class)
				.setParameter("id", vehicleId)
				.getSingleResult();
	}

	@Override
	public void deleteVehicle(Integer vehicleId) {
		em.merge(vehicleId);	
	}
	
	/*@Override
	public void deleteVehicleById(Integer vehicleId) {
		Vehicle vehicle = getVehicleById(vehicleId);
		em.remove(vehicle);
	}*/

}
