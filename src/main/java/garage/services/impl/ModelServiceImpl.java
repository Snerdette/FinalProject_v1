package garage.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import garage.dao.ModelDao;
import garage.entities.Model;
import garage.services.InvalidInputException;
import garage.services.ModelService;

@Service
public class ModelServiceImpl implements ModelService {

	@Autowired
	ModelDao modelDao;
	

	public void setModelDao(ModelDao modelDao) {
		this.modelDao = modelDao;
	}

	@Override
	public List<Model> getAllModels() {
		List<Model> model = modelDao.getAllModels();
		List<Model> allModel = new ArrayList<>();
		
		for (Model e : model) {
			allModel.add(e);
		}
		return allModel;
	}

	@Override
	public Model getModelById(Integer modelId) throws InvalidInputException {
		if (modelId == null || modelId < 0) {
			throw new InvalidInputException("modelId.NullOrNegative");
		}
		return modelDao.getModelById(modelId);
	}


}
