package garage.services;

import java.util.List;

import garage.entities.Vehicle;

public interface VehicleService {

	Vehicle getVehicleById(Integer vehicleId) throws InvalidInputException;
	
	public List<Vehicle> getVehicleList();
	
	public void addVehicle(Vehicle vehicle);
	
	public void updateVehicle(Vehicle vehicle);
	
	public void deleteVehicle(Integer vehicleId);
}
