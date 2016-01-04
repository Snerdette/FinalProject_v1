package garage.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name="Vehicle", schema="public")
public class Vehicle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  Integer id;
	
	@ManyToOne(targetEntity=Make.class)
	public List<Make> make;
	
	@OneToMany(targetEntity=Color.class)
	@Column(name="color")
	private List<Color> color;
	
	@Column(name="plate_number")
	private String plateNumber;
	
	@Column(name="plate_state")
	private String plateState;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Make> getMake() {
		return make;
	}

	public void setMake(List<Make> make) {
		this.make = make;
	}

	public List<Color> getColor() {
		return color;
	}

	public void setColor(List<Color> color) {
		this.color = color;
	}

	public String getPlateNumber() {
		return plateNumber;
	}

	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}

	public String getPlateState() {
		return plateState;
	}

	public void setPlateState(String plateState) {
		this.plateState = plateState;
	}

	//not in requirements to have a Vehicle belong to a customer, but should recommend some type of link.
/*	@OneToOne(targetEntity=Customer.class)
	@Column(name="customers")
	public List<Customer> customers;*/
	
	
}
