package garage.dao;

import java.util.List;
import garage.entities.Pass;

public interface PassDao {

	public List<Pass> getAllPasses();

	void add(Pass pass);
	
	void update(Pass pass);
	
	void delete(Integer passId);
	
	void delete(Pass pass);

	public Pass getPass(Integer passId);
}
