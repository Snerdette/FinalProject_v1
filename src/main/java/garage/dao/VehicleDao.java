package garage.dao;

import java.util.List;

import garage.entities.Vehicle;

public interface VehicleDao {

	public List<Vehicle> getAllVehicles();

	void add(Vehicle vehicle);
	
	void update(Vehicle vehicle);

	void delete(Integer vehicleId);
	
	void delete(Vehicle vehicle);

	public Vehicle getVehicle(Integer vehicleId);
}
