package garage.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity(name="pass")
/*@Table(name="pass", schema="public")*/
public class Pass {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="pass_id")
	public  Integer id;
	
	@Column(name="is_active")
	private boolean isActive;
	
	//Date formatting should be MM/DD/YYYY.
	
	/*@Pattern(regexp="(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)")*/
	@NotNull
	@Column(name="exp_date")
	private String expDate;
	
	@NotNull
	@Column(name="price")
	private double price;
	
	@NotNull
	@ManyToOne (cascade = CascadeType.MERGE)
	@JoinColumn(name="customer_id")
	public Customer customer;
	
	//List of Vehicles this Pass Might belong to, a vehicle may have many passes especially if some are expire.
	@NotNull
	@OneToOne
	@JoinColumn(name="vehicle_id")
	public Vehicle vehicle;
	
	//Type of a pass is referencing if it is a work day, weekend, annual, monthly or day pass.
	@Column(name="type")
	private String type;

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public boolean isIsActive() {
		return isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
}
