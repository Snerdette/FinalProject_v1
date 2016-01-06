package garage.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import garage.dao.VehicleDao;
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
	public List<Vehicle> getVehicleList() {
		List<Vehicle> vehicle = vehicleDao.getVehicleList();
		List<Vehicle> allVehicle = new ArrayList<>();
		
		for (Vehicle e : vehicle) {
			allVehicle.add(e);
		}
		return allVehicle;
	}

	@Override
	public Vehicle getVehicleById(Integer vehicleId) throws InvalidInputException {
		if (vehicleId == null || vehicleId < 0) {
			throw new InvalidInputException("vehicleId.NullOrNegative");
		}
		return vehicleDao.getVehicleById(vehicleId);
	}

	@Override
	public void addVehicle(Vehicle vehicle) {
		if (vehicle == null) {
			throw new DataIntegrityViolationException("Vehicle number is null");
		}else{
			vehicleDao.addVehicle(vehicle);
		}		
	}
	
	@Override
	public void updateVehicle(Vehicle vehicle) {
		if (vehicle == null) {
			throw new DataIntegrityViolationException("Vehicle number is null");
		}else{
			vehicleDao.updateVehicle(vehicle);
		}	
	}
	
	@Override
	public void deleteVehicle(Integer vehicleId) {
		vehicleDao.deleteVehicle(vehicleId);
	}
}
