package garage.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import garage.dao.VehicleDao;
import garage.entities.Customer;
import garage.entities.Vehicle;
import garage.services.InvalidInputException;
import garage.services.VehicleService;

@Service
public class VehicleServiceImpl implements VehicleService{

	@Autowired
	VehicleDao vehicleDao;
	

	public void setVehicleDao(VehicleDao vehicleDao) {
		this.vehicleDao = vehicleDao;
	}

	@Override
	public List<Vehicle> getAllVehicles() {
		List<Vehicle> vehicle = vehicleDao.getAllVehicles();
		List<Vehicle> allVehicle = new ArrayList<>();
		
		for (Vehicle e : vehicle) {
			allVehicle.add(e);
		}
		return allVehicle;
	}

	@Override
	public Vehicle getVehicle(Integer vehicleId) throws InvalidInputException {
		if (vehicleId == null || vehicleId < 0) {
			throw new InvalidInputException("vehicleId.NullOrNegative");
		}
		return vehicleDao.getVehicle(vehicleId);
	}

	@Override
	public void add(Vehicle vehicle) {
		if (vehicle == null) {
			throw new DataIntegrityViolationException("Vehicle number is null");
		}else{
			vehicleDao.add(vehicle);
		}		
	}
	
	@Override
	public void update(Vehicle vehicle) {
		if (vehicle == null) {
			throw new DataIntegrityViolationException("Vehicle number is null");
		}else{
			vehicleDao.update(vehicle);
		}	
	}
	
	@Override
	public void delete(Integer vehicleId) {
		vehicleDao.delete(vehicleId);
	}
	
}
