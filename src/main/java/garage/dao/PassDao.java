package garage.dao;

import java.util.List;
import garage.entities.Pass;

public interface PassDao {

	public List<Pass> getPassList();

	void deletePass(Integer passId);

	void updatePass(Pass pass);

	void addPass(Pass pass);

	public Pass getPassById(Integer passId);
}
