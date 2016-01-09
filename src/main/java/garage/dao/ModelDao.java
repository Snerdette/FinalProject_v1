package garage.dao;

import java.util.List;
import garage.entities.Model;

public interface ModelDao {

	public List<Model> getModelData();

	public Model getModelById(Integer modelId);
	
	public List<Model> getModelsForMake(Integer makeId);
}
