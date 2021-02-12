package com.incture.model;


import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="booking")
public class Booking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="booking_id")
	private int id;
	
	@Column
	private Date bookingDate;

	@Column
	private Date travalDate;
	
	@Column(name="passenger_id")
	@ManyToMany
	@JoinColumn(name="passenger_id")
	private List<Passenger> passengerlist;
	
	@Column(name="bus_id")
	@ManyToMany
	@JoinColumn(name="bus_id")
	private List<Bus>buslist;

	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Date getBookingDate() {
		return bookingDate;
	}


	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}


	public Date getTravalDate() {
		return travalDate;
	}


	public void setTravalDate(Date travalDate) {
		this.travalDate = travalDate;
	}


	public List<Passenger> getPassengerlist() {
		return passengerlist;
	}


	public void setPassengerlist(List<Passenger> passengerlist) {
		this.passengerlist = passengerlist;
	}


	public List<Bus> getBuslist() {
		return buslist;
	}


	public void setBuslist(List<Bus> buslist) {
		this.buslist = buslist;
	}

	
	@Override
	public String toString() {
		return "Booking [id=" + id + ", bookingDate=" + bookingDate + ", travalDate=" + travalDate + ", passengerlist="
				+ passengerlist + ", buslist=" + buslist + "]";
	}


	public Booking(int id, Date bookingDate, Date travalDate, List<Passenger> passengerlist, List<Bus> buslist) {
		super();
		this.id = id;
		this.bookingDate = bookingDate;
		this.travalDate = travalDate;
		this.passengerlist = passengerlist;
		this.buslist = buslist;
	}


	public Booking() {
		super();
	}
	
	
}
