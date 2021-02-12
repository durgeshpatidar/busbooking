package com.incture.service;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.incture.dao.BookingDao;


@Service
public class BookingService {
	
	@Autowired
	private BookingDao bookingDao;
	
	@Transactional
	public void booking(int passengerid,int busid)
	{
		bookingDao.booking(passengerid,busid);
	}

	@SuppressWarnings("rawtypes")
	@Transactional
	public ArrayList showAll(int userid) {
		ArrayList l=bookingDao.showAll(userid);
		return l;
	}
}
