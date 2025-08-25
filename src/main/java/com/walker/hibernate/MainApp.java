package com.walker.hibernate;
import com.walker.hibernate.model.Person;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import com.walker.hibernate.model.AadhaarCard;

public class MainApp {

    public static void main(String[] args) {
        
    	// Dummy Indian Person 1
    	Person person1 = new Person();
    	person1.setName("Rajesh Kumar");
    	person1.setAge(32);

    	AadhaarCard aadhaar1 = new AadhaarCard();
    	aadhaar1.setAadharNumber("1234-5678-9012");
    	aadhaar1.setAddress("H.No. 45, Sector 12, New Delhi, India");

    	// Set bidirectional relationship
    	person1.setAadhaarCard(aadhaar1);
    	aadhaar1.setPerson(person1);

    	// Dummy Indian Person 2
    	Person person2 = new Person();
    	person2.setName("Priya Singh");
    	person2.setAge(28);

    	AadhaarCard aadhaar2 = new AadhaarCard();
    	aadhaar2.setAadharNumber("9876-5432-1098");
    	aadhaar2.setAddress("Flat No. 502, Marine Lines, Mumbai, Maharashtra, India");

    	// Set bidirectional relationship
    	person2.setAadhaarCard(aadhaar2);
    	aadhaar2.setPerson(person2);
    	
    	Configuration configure = new Configuration().configure();
    	Session openSession = configure.buildSessionFactory().openSession();
    	openSession.getTransaction().begin();
    	
    	openSession.persist(aadhaar1);
    	openSession.persist(person1);
    	openSession.persist(aadhaar2);
    	openSession.persist(person2);
    	
    	Person person = openSession.get(Person.class,1 );
    	System.out.println(person + person.getAadhaarCard().toString());
    	
    	openSession.getTransaction().commit();
    	openSession.close();
           
        
    }
}
