package garage.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import garage.entities.Make;
import garage.services.MakeService;
import garage.services.InvalidInputException;

@RestController
public class MakeController {
	
	@Autowired
	private MakeService makeService;
	
	public void setMakeService(MakeService makeService){
		this.makeService = makeService;
	}

	@RequestMapping(value="/make", method=RequestMethod.GET)
	public List<Make> getAllMakes(){
		return makeService.getAllMakes();
	}
	
	@RequestMapping(value="/make/{id}", method=RequestMethod.GET)
	public Make getMakeById(@PathVariable Integer id)throws InvalidInputException{
		return makeService.getMakeById(id);
	}
	
}
