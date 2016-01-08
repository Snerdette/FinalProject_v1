package garage.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import garage.entities.Model;
import garage.services.ModelService;
import garage.services.InvalidInputException;

@RestController
public class ModelController {

	@Autowired
	private ModelService modelService;
	
	public void setModelService(ModelService modelService){
		this.modelService = modelService;
	}

	@RequestMapping(value="/model", method=RequestMethod.GET)
	public List<Model> getModelData(){
		return modelService.getModelData();
	}
	
	@RequestMapping(value="/model/{id}", method=RequestMethod.GET)
	public Model getModelById(@PathVariable Integer id)throws InvalidInputException{
		return modelService.getModelById(id);
	}

}
