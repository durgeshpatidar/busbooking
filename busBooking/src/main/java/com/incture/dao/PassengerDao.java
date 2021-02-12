package com.incture.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.incture.model.Passenger;

@Repository
public class PassengerDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public void add(Passenger passenger)
	{
		hibernateTemplate.save(passenger);
	}
	public void delete(int id)
	{
		Passenger ps=new Passenger();
		ps.setId(id);
		hibernateTemplate.delete(ps);
	}
	public ArrayList<Passenger> showAll()
	{
		ArrayList <Passenger>l=(ArrayList<Passenger>) hibernateTemplate.loadAll(Passenger.class);
		return l;
	}
}
