package garage.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Model", schema="public")
public class Model {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  Integer id;
	
	@Column(name="name")
	private String name;
	
	@OneToOne(targetEntity=Make.class)
	@Column(name="make")
	private List<Make> make;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Make> getMake() {
		return make;
	}

	public void setMake(List<Make> make) {
		this.make = make;
	}
	

}
