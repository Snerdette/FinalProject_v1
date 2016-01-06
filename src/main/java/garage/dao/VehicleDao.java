package garage.dao;

import java.util.List;

import garage.entities.Vehicle;

public interface VehicleDao {


	public List<Vehicle> getVehicleList();

	void deleteVehicle(Integer vehicleId);

	void updateVehicle(Vehicle vehicle);

	void addVehicle(Vehicle vehicle);

	public Vehicle getVehicleById(Integer vehicleId);
}
