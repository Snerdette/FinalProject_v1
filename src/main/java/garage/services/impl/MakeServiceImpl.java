package garage.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import garage.dao.MakeDao;
import garage.entities.Make;
import garage.services.InvalidInputException;
import garage.services.MakeService;

@Service
public class MakeServiceImpl implements MakeService {

	@Autowired
	MakeDao makeDao;
	

	public void setMakeDao(MakeDao makeDao) {
		this.makeDao = makeDao;
	}

	@Override
	public List<Make> getAllMakes() {
		List<Make> make = makeDao.getAllMakes();
		List<Make> allMake = new ArrayList<>();
		
		for (Make e : make) {
			allMake.add(e);
		}
		return allMake;
	}

	@Override
	public Make getMakeById(Integer makeId) throws InvalidInputException {
		if (makeId == null || makeId < 0) {
			throw new InvalidInputException("makeId.NullOrNegative");
		}
		return makeDao.getMakeById(makeId);
	}
}
