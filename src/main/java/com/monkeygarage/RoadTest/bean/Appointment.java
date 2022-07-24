package com.monkeygarage.RoadTest.bean;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Appointment {

	enum AppointmentState {
		NEW,
		CANCELED,
		ACCEPTED,
		INPROGRESS,
		SUCCESSFUL,
		FAILED
	}
	
//==============================	
	
	@Id
	@GeneratedValue
	private Long id;
	private Date date;
	private AppointmentState state;
	@OneToOne
	private Vehicle vehicle;
	@OneToOne
	private Supervisor supervisor;
	
//==============================
	protected Appointment () {}

	public Appointment(Date date, Vehicle vehicle, Supervisor supervisor) {
		super();
		this.date = date;
		this.vehicle = vehicle;
		this.supervisor = supervisor;
		this.state = AppointmentState.NEW;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Supervisor getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(Supervisor supervisor) {
		this.supervisor = supervisor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(date, supervisor, vehicle);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Appointment other = (Appointment) obj;
		return Objects.equals(date, other.date) && Objects.equals(supervisor, other.supervisor)
				&& Objects.equals(vehicle, other.vehicle);
	}

	@Override
	public String toString() {
		return "Appointment [id=" + id + ", date=" + date + ", state=" + state + ", vehicle=" + vehicle
				+ ", supervisor=" + supervisor + "]";
	}
	
	
}
