package com.incture.service;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.incture.dao.BusDao;
import com.incture.model.Bus;

@Service
public class BusService {
	
	@Autowired
	private BusDao busDao;
	
	@Transactional
	public void add(Bus bus)
	{
		busDao.add(bus);
	}
	@Transactional
	public void delete(int id)
	{
		busDao.delete(id);
	}
	@Transactional
	public ArrayList<Bus> showAll() {
		return busDao.showAll();
	}
	@Transactional
	public ArrayList<Bus> searchByName(String name) {
		return busDao.searchByName(name);
	}
	
	@Transactional
	public ArrayList<Bus> searchById(int id) {
		return busDao.searchById(id);
	}
	@Transactional
	public ArrayList<Bus> searchByPrice(int price) {
		return busDao.searchByPrice(price);

	}
	@Transactional
	public ArrayList<Bus> searchBySD(String a, String d) {
		return busDao.searchBySD(a,d);
	}
	@Transactional
	public ArrayList<Bus> searchByD(String d) {
		return busDao.searchByD(d);
	}
}
