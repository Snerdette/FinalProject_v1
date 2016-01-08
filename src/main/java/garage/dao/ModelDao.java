package garage.dao;

import java.util.List;
import garage.entities.Model;

public interface ModelDao {

	public List<Model> getAllModels();

	public Model getModelById(Integer modelId);
}
