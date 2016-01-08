package garage.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import garage.dao.PassDao;
import garage.entities.Pass;
import garage.services.InvalidInputException;
import garage.services.PassService;

@Service
public class PassServiceImpl implements PassService {

	@Autowired
	PassDao passDao;
	

	public void setPassDao(PassDao passDao) {
		this.passDao = passDao;
	}

	@Override
	public List<Pass> getPassData() {
		List<Pass> pass = passDao.getPassData();
		List<Pass> allPass = new ArrayList<>();
		
		for (Pass e : pass) {
			allPass.add(e);
		}
		return allPass;
	}

	@Override
	public Pass getPass(Integer passId) throws InvalidInputException {
		if (passId == null || passId < 0) {
			throw new InvalidInputException("passId.NullOrNegative");
		}
		return passDao.getPass(passId);
	}

	@Override
	public void add(Pass pass) {
		if (pass == null) {
			throw new DataIntegrityViolationException("Pass number is null");
		}else{
			passDao.add(pass);
		}		
	}
	
	@Override
	public void update(Pass pass) {
		if (pass == null) {
			throw new DataIntegrityViolationException("Pass number is null");
		}else{
			passDao.update(pass);
		}	
	}
	
	@Override
	public void delete(Integer passId) {
		passDao.delete(passId);
	}
	
}
