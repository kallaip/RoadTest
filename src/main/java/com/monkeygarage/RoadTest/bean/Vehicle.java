package com.monkeygarage.RoadTest.bean;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Vehicle {
//==============================	
	
	@Id
	@GeneratedValue
	private Long id;
	private String LPN;
	private String brand;
	@ManyToOne
	private Owner owner;
	
//==============================	

	protected Vehicle() {}

	public Vehicle(String lPN, String brand, Owner owner) {
		super();
		this.LPN = lPN;
		this.brand = brand;
		this.owner = owner;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLPN() {
		return LPN;
	}

	public void setLPN(String lPN) {
		LPN = lPN;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	@Override
	public int hashCode() {
		return Objects.hash(LPN, brand, owner);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle other = (Vehicle) obj;
		return Objects.equals(LPN, other.LPN) && Objects.equals(brand, other.brand)
				&& Objects.equals(owner, other.owner);
	}

	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", LPN=" + LPN + ", brand=" + brand + ", owner=" + owner + "]";
	}
	
}
