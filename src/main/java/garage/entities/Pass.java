package garage.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.math.BigDecimal;
import java.text.NumberFormat;

@Entity
@Table(name="Pass", schema="public")
public class Pass {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  Integer id;
	
	@Column(name="is_active")
	private boolean isActive;
	
	//Date formatting should be MM/DD/YYYY.
	@Column(name="expDate")
	private Date expDate;
	
	//hoping to figure out MonetaryAmount Later.
	@Column(name="price")
	private BigDecimal price;
	
	//List of Customers that this pass belongs to. Many passes can be held by a customer.
	@ManyToOne(targetEntity=Customer.class)
	@Column(name="customers")
	public List<Customer> customers;
	
	//List of Vehicles this Pass Might belong to, a vehicle may have many passes especially if some are expire.
	@OneToMany(targetEntity=Vehicle.class)
	@Column(name="vehicles")
	public List<Vehicle> vehicles;
	
	//Type of a pass is referencing if it is a work day, weekend, annual, monthly or day pass.
	@Column(name="type")
	private String type;

	public Integer getId() {
		return id;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean isIsActive() {
		return isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Date getExpDate() {
		return expDate;
	}

	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
