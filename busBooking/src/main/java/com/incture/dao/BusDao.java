package com.incture.dao;

import java.util.ArrayList;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.incture.model.Bus;

@Repository
public class BusDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public void add(Bus bus)
	{
		hibernateTemplate.save(bus);
	}
	
	public void delete(int id)
	{
		Bus bus=new Bus();
		bus.setId(id);
		hibernateTemplate.delete(bus);
	}

	public ArrayList<Bus> showAll() {
		ArrayList <Bus>l=(ArrayList<Bus>) hibernateTemplate.loadAll(Bus.class);
		return l;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Bus> searchByName(String name) {
		ArrayList <Bus>l;
		SessionFactory sf=hibernateTemplate.getSessionFactory();
		Session s=sf.getCurrentSession();
		Query q=s.createNativeQuery("select * from bus where bus_name='"+name+"'");
		l=(ArrayList<Bus>) q.getResultList();
		return l;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Bus> searchById(int id)
	{
		ArrayList <Bus>l;
		SessionFactory sf=hibernateTemplate.getSessionFactory();
		Session s=sf.getCurrentSession();
		Query q=s.createNativeQuery("select * from bus where bus_id='"+id+"'");
		l=(ArrayList<Bus>) q.getResultList();
		return l;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Bus> searchByPrice(int price) {
		ArrayList <Bus>l;
		SessionFactory sf=hibernateTemplate.getSessionFactory();
		Session s=sf.getCurrentSession();
		Query q=s.createNativeQuery("select * from bus where price<='"+price+"'");
		l=(ArrayList<Bus>) q.getResultList();
		return l;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Bus> searchBySD(String s, String d) {
		ArrayList <Bus>l;
		SessionFactory sf=hibernateTemplate.getSessionFactory();
		Session ss=sf.getCurrentSession();
		Query q=ss.createNativeQuery("select * from bus where source='"+s+"' and destination='"+d+"'");
		l=(ArrayList<Bus>) q.getResultList();
		return l;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Bus> searchByD(String d) {
		ArrayList <Bus>l;
		SessionFactory sf=hibernateTemplate.getSessionFactory();
		Session ss=sf.getCurrentSession();
		Query q=ss.createNativeQuery("select * from bus where destination='"+d+"'");
		l=(ArrayList<Bus>) q.getResultList();
		return l;
	}
}
