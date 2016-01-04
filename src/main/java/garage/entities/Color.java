package garage.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

public class Color {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  Integer id;
	
	@Column(name="name")
	private String name;
	
	@OneToMany(targetEntity=Vehicle.class)
	private List<Vehicle> vehicles;
	

}
