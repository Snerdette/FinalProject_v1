package garage.services;

import java.util.List;

import garage.entities.Pass;

public interface PassService {

	Pass getPass(Integer passId) throws InvalidInputException;
	
	public List<Pass> getAllPasses();
	
	public void add(Pass pass);
	
	public void update(Pass pass);
	
	public void delete(Integer passId);

}
