package garage.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import garage.entities.Vehicle;
import garage.services.InvalidInputException;
import garage.services.VehicleService;

@RestController
public class VehicleController {

	@Autowired
	private VehicleService vehicleService;
	
	public void setVehicleService(VehicleService vehicleService){
		this.vehicleService = vehicleService;
	}
	
	@RequestMapping(value="/vehicle", method=RequestMethod.GET)
	public List<Vehicle> getAllVehicles(){
		return vehicleService.getAllVehicles();
	}
	
	@RequestMapping(value="/vehicle/{id}", method=RequestMethod.GET)
	public Vehicle getVehicle(@PathVariable Integer id)throws InvalidInputException{
		return vehicleService.getVehicle(id);
	}
	
	@RequestMapping(value="/vehicle", method=RequestMethod.POST)  
	public void add(@RequestBody Vehicle vehicle) { 
		System.out.println(vehicle);
		vehicleService.add(vehicle);
	}
	
	@RequestMapping(value="/vehicle/{id}", method=RequestMethod.PUT)
	public void updateVehicle(@PathVariable Integer id, @RequestBody Vehicle vehicle){ 
		vehicle.setId(id);
		vehicleService.update(vehicle);
	}
	
	@RequestMapping(value="/vehicle/{id}", method=RequestMethod.DELETE)
	public void deleteById(@PathVariable Integer id){
		vehicleService.delete(id);
	}
	
	/*@RequestMapping(value="/vehicle/{vehicle}", method=RequestMethod.DELETE)
	public void delete(@PathVariable Integer id, @RequestBody Vehicle vehicle){
		vehicleService.delete(vehicle);
	}*/
}
