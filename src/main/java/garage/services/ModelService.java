package garage.services;

import java.util.List;

import garage.entities.Make;
import garage.entities.Model;

public interface ModelService {

	Model getModelById(Integer modelId) throws InvalidInputException;
	
	public List<Model> getModelData();
	
	public List<Model> getModelsForMake(Integer makeId) throws InvalidInputException;

}
