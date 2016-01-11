package garage.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import garage.dao.PassDao;
import garage.entities.Customer;
import garage.entities.Pass;
import garage.entities.Vehicle;

@Service
public class PassServiceValidation {

	@Autowired
	PassDao passDao;
	
	/*public boolean validatePass(Pass pass){
		return validatePrice(pass) && validateExpDate(pass) && validateCustomer(pass) && validateVehicle(pass);
	}
	
	public boolean validateCustomer(Pass pass) throws Exception {
		boolean result = true;
		Customer customer = customer.getCustomer();
		int lineItemTypeId = lineItemType.getLineItemTypeId();
		if(lineItemTypeId == 0){
			result = false;
			throw new Exception("Not a line item type");
		}
		return result;
	}
	
	public boolean validateExpDate(Pass pass) throws Exception {
		boolean result = true;
		Customer customer = customer.getCustomer();
		int lineItemTypeId = lineItemType.getLineItemTypeId();
		if(lineItemTypeId == 0){
			result = false;
			throw new Exception("Not a line item type");
		}
		return result;
	}
	
	public boolean validateVehicle(Pass pass) throws Exception {
		boolean result = true;
		Vehicle vehicle = vehicle.getVehicleById();
		int lineItemTypeId = lineItemType.getLineItemTypeId();
		if(lineItemTypeId == 0){
			result = false;
			throw new Exception("Not a line item type");
		}
		return result;
	}*/
}	
