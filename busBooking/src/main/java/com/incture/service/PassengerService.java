package com.incture.service;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.incture.dao.PassengerDao;
import com.incture.model.Passenger;

@Service
public class PassengerService {
	
	@Autowired
	private PassengerDao passengerDao;
	
	@Transactional
	public void add(Passenger passenger)
	{
		passengerDao.add(passenger);
	}
	
	@Transactional
	public void delete(int id)
	{
		passengerDao.delete(id);
	}
	
	@Transactional
	public ArrayList<Passenger> showAll()
	{
		ArrayList<Passenger>l= passengerDao.showAll();
		return l;
	}
}
