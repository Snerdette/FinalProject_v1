package garage.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Vehicle", schema="public")
public class Vehicle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public  Integer id;
	
	@Column(name="make")
	public String make;
	
	@Column(name="model")
	public String model;
	
	@Column(name="color")
	private String color;
	
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

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	//not in requirements to have a Vehicle belong to a customer, but should recommend some type of link.
/*	@OneToOne(targetEntity=Customer.class)
	@Column(name="customers")
	public List<Customer> customers;*/
	
	
}
