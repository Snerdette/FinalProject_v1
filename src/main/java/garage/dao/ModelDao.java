package garage.dao;

import java.util.List;
import garage.entities.Model;

public interface ModelDao {

	public List<Model> getModelList();

	public Model getModelById(Integer modelId);
}
