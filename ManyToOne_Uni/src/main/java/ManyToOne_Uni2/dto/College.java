package ManyToOne_Uni2.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class College {

	@Id
	private int id;
	private String name;
	private long fees;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getFees() {
		return fees;
	}
	public void setFees(long fees) {
		this.fees = fees;
	}
	@Override
	public String toString() {
		return "College [id=" + id + ", name=" + name + ", fees=" + fees + "]";
	}
	
	
}
