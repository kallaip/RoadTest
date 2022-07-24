package com.monkeygarage.RoadTest.bean;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Supervisor {
	//==============================	
	
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private boolean inactive;
		
	//==============================

	protected Supervisor() {}

	public Supervisor(String name) {
		super();
		this.name = name;
		this.inactive = false;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isInactive() {
		return inactive;
	}

	public void setInactive(boolean inactive) {
		this.inactive = inactive;
	}

	@Override
	public int hashCode() {
		return Objects.hash(inactive, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Supervisor other = (Supervisor) obj;
		return inactive == other.inactive && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Supervisor [id=" + id + ", name=" + name + ", inactive=" + inactive + "]";
	}
	
}
