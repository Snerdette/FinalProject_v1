package garage.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity(name="make")
/*@Table(name="make", schema="public")*/
public class Make {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="make_id")
	public  Integer makeId;
	
	@Column(name="name")
	private String name;

	public Integer getMakeId() {
		return makeId;
	}

	public void setMakeId(Integer makeId) {
		this.makeId = makeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
