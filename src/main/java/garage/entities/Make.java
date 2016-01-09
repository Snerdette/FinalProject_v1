package garage.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name="make")
/*@Table(name="make", schema="public")*/
public class Make {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="make_id")
	public  Integer id;
	
/*	@OneToMany(cascade = CascadeType.MERGE)
	@JoinColumn(name="model_id")
	public Model model;*/
	
	@Column(name="name")
	private String name;

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

	/*public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}*/
	
}
