package garage.services;

import java.util.List;

import garage.entities.Model;

public interface ModelService {

	Model getModelById(Integer modelId) throws InvalidInputException;
	
	public List<Model> getModelList();

}
