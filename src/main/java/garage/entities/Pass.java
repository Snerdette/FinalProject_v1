package garage.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.text.NumberFormat;

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
	@Column(name="exp_date")
	private Date expDate;
	
	//hoping to figure out MonetaryAmount Later.
	@Column(name="price")
	private double price;
	
	//List of Customers that this pass belongs to. Many passes can be held by a customer.
	@ManyToOne (cascade = CascadeType.MERGE)
	@JoinColumn(name="customer_id")
	public Customer customer;
	
	//List of Vehicles this Pass Might belong to, a vehicle may have many passes especially if some are expire.
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

	public Date getExpDate() {
		return expDate;
	}

	public void setExpDate(Date expDate) {
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
