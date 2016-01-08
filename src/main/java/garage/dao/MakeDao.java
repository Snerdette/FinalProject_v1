package garage.dao;

import java.util.List;
import garage.entities.Make;

public interface MakeDao {

	public List<Make> getAllMakes();

	public Make getMakeById(Integer makeId);
}
