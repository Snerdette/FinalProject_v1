package garage.services;

import java.util.List;

import garage.entities.Vehicle;

public interface VehicleService {

	Vehicle getVehicle(Integer vehicleId) throws InvalidInputException;
	
	public List<Vehicle> getAllVehicles();
	
	public void add(Vehicle vehicle);
	
	public void update(Vehicle vehicle);
	
	public void delete(Integer vehicleId);
	
}
