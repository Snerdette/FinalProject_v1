package garage.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="make", schema="public")
public class Make {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public  Integer id;
	
	@Column(name="make")
	private String make;
	
	@ManyToOne(targetEntity=Model.class)
	public List<Model> model;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Model> getModel() {
		return model;
	}

	public void setModel(List<Model> model) {
		this.model = model;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}
	
}
