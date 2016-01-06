package garage.services;

import java.util.List;

import garage.entities.Make;

public interface MakeService {

	Make getMakeById(Integer makeId) throws InvalidInputException;
	
	public List<Make> getMakeList();
	
}
