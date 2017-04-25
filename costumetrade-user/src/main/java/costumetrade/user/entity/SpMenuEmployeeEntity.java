package costumetrade.user.entity;

import java.io.Serializable;
import java.util.List;

import costumetrade.domain.SpMenuEmployee;

public class SpMenuEmployeeEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private List<SpMenuEmployee> spMenuEmployees;

	public List<SpMenuEmployee> getSpMenuEmployees() {
		return spMenuEmployees;
	}

	public void setSpMenuEmployees(List<SpMenuEmployee> spMenuEmployees) {
		this.spMenuEmployees = spMenuEmployees;
	}
	
	
}
