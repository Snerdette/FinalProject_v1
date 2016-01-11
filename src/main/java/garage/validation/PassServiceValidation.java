package garage.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import garage.dao.PassDao;
import garage.dao.impl.PassDaoImpl;
import garage.entities.Customer;
import garage.entities.Pass;
import garage.entities.Vehicle;

@Service
public class PassServiceValidation {

	/*@Autowired
	PassDaoImpl passDaoImpl;
	
	public boolean validatePass(Pass pass) throws Exception{
		return validatePrice(pass) && validateExpDate(pass) && validateCustomer(pass) && validateVehicle(pass);
	}
	
	public boolean validatePrice(Pass pass) throws Exception {
		
	}
	
	public boolean validateCustomer(Pass pass) throws Exception {
		boolean result = true;
		Customer customer = customer.getCustomer();
		int passId = pass.getPassById();
		if(lineItemTypeId == 0){
			result = false;
			throw new Exception("Not a line item type");
		}
		return result;
	}
	
	public boolean validateExpDate(Pass pass) throws Exception {
		
		return false;
	}
	
	public boolean validateVehicle(Pass pass) throws Exception {
		
		return false;
	}*/
}	
