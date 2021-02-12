package com.incture.dao;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import com.incture.model.Booking;
import com.incture.model.Bus;
import com.incture.model.Passenger;

@Repository
public class BookingDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public void booking(int passengerid,int busid)
	{
		Passenger passenger=new Passenger();
		passenger.setId(passengerid);
		Bus bus=new Bus();
		bus.setId(busid);
		//bus.setAvailableSeat(bus.getAvailableSeat()-1);
		SessionFactory sf=hibernateTemplate.getSessionFactory();
		Session session=sf.getCurrentSession();
		Query q= session.createNativeQuery("update bus set availableseat=(select availableseat from bus where bus_id="+busid+")-1 where bus_id="+busid);
		q.executeUpdate();
		Booking booking=new Booking();
		List<Passenger>passengerlist=new ArrayList<Passenger>();
		passengerlist.add(passenger);
		booking.setPassengerlist(passengerlist);
		List<Bus> buslist=new ArrayList<Bus>();
		buslist.add(bus);
		booking.setBuslist(buslist);;
		java.util.Date date=new java.util.Date();
		booking.setBookingDate(date);
		booking.setTravalDate(date);
		hibernateTemplate.save(booking);
	}

	@SuppressWarnings("rawtypes")
	public ArrayList showAll(int userid) {
		ArrayList b;
		SessionFactory sf=hibernateTemplate.getSessionFactory();
		Session s=sf.getCurrentSession();
		Query q=s.createNativeQuery("select booking.booking_id,passenger.passenger_name,bus.bus_name,booking.bookingdate,booking_bus.buslist_bus_id ,booking_passenger.passengerlist_passenger_id from booking,passenger,booking_bus,booking_passenger,bus where booking.booking_id=booking_bus.booking_booking_id AND bus.bus_id=booking_bus.buslist_bus_id AND passenger.passenger_id=booking_passenger.passengerlist_passenger_id AND booking_passenger.passengerlist_passenger_id="+userid);
		b=(ArrayList) q.getResultList();
		return b;
	}
}
