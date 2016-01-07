package garage.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import garage.entities.Pass;
import garage.services.InvalidInputException;
import garage.services.PassService;

@RestController
public class PassController {

	@Autowired
	private PassService passService;
	
	public void setPassService(PassService passService){
		this.passService = passService;
	}
	
	@RequestMapping(value="/pass", method=RequestMethod.GET)
	public List<Pass> getPassList(){
		return passService.getPassList();
	}
	
	@RequestMapping(value="/pass/{id}", method=RequestMethod.GET)
	public Pass getPassById(@PathVariable Integer id)throws InvalidInputException{
		return passService.getPassById(id);
	}
	
	@RequestMapping(value="/pass", method=RequestMethod.POST)  
	public void addPass(@RequestBody Pass pass) { 
		System.out.println(pass);
		passService.addPass(pass);
	}
	
	@RequestMapping(value="/pass/{id}", method=RequestMethod.PUT)
	public void updatePass(@PathVariable Integer id, @RequestBody Pass pass){ 
		pass.setPassId(id);
		passService.updatePass(pass);
	}
	
	@RequestMapping(value="/pass/{id}", method=RequestMethod.DELETE)
	public void deletePass(@PathVariable Integer id){
		passService.deletePass(id);
	}
}
