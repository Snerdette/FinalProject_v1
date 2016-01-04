package garage.services;

import java.util.List;

import garage.entities.Pass;

public interface PassService {

	Pass getPassById(Integer passId) throws InvalidInputException;
	
	public List<Pass> getPassList();
	
	public void addPass(Pass pass);
	
	public void updatePass(Pass pass);
	
	public void deletePass(Integer passId);

}
