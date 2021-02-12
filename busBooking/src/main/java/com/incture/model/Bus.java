package com.incture.model;


import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bus")
public class Bus 
{
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="bus_id")
	@Id
	private int id;
	
	@Column(name="bus_name")
	private String name;
	
	@Column(name="no_of_seats")
	private int noOfSeats;

	@Column(name="price")
	private int price;
	
	@Column(name="source")
	private String source;
	
	@Column(name="destination")
	private String destination;

	@Column
	private Time departedTime;
	
	@Column
	private Time arrivalTime;
	
	@Column
	private int availableSeat;
	public Bus() {
		super();
	}
	public Bus(int id, String name, int noOfSeats, int price, String source, String destination, Time departedTime,
			Time arrivalTime, int availableSeat) {
		super();
		this.id = id;
		this.name = name;
		this.noOfSeats = noOfSeats;
		this.price = price;
		this.source = source;
		this.destination = destination;
		this.departedTime = departedTime;
		this.arrivalTime = arrivalTime;
		this.availableSeat = availableSeat;
	}
	@Override
	public String toString() {
		return "Bus [id=" + id + ", name=" + name + ", noOfSeats=" + noOfSeats + ", price=" + price + ", source="
				+ source + ", destination=" + destination + ", departedTime=" + departedTime + ", arrivalTime="
				+ arrivalTime + ", availableSeat=" + availableSeat + "]";
	}
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
	public int getNoOfSeats() {
		return noOfSeats;
	}
	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public Time getDepartedTime() {
		return departedTime;
	}
	public void setDepartedTime(Time departedTime) {
		this.departedTime = departedTime;
	}
	public Time getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(Time arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public int getAvailableSeat() {
		return availableSeat;
	}
	public void setAvailableSeat(int availableSeat) {
		this.availableSeat = availableSeat;
	}

	
}
