package com.walker.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.walker.hibernate.model.Cricketer;
import com.walker.hibernate.model.Footballer;
import com.walker.hibernate.model.Player;

public class PlayerInheritanceTest {
    public static void main(String[] args) {
    	
    	Configuration configuration = new Configuration();
    	Configuration configure = configuration.configure();
    	SessionFactory sessionFactory = configure.buildSessionFactory();
    	Session session = sessionFactory.openSession();
    	
    	Cricketer cricketer1 = Cricketer.builder()
    	        .name("Virat Kohli")
    	        .age(35)
    	        .batStyle("Right-hand")
    	        .bowlStyle("Right-arm")
    	        .games(270)
    	        .build();

    	Cricketer cricketer2 = Cricketer.builder()
    	        .name("Rohit Sharma")
    	        .age(36)
    	        .batStyle("Right-hand")
    	        .bowlStyle("Right-arm")
    	        .games(240)
    	        .build();

    	Footballer footballer1 = Footballer.builder()
    	        .name("Sunil Chhetri")
    	        .age(38)
    	        .goals(85)
    	        .assists(35)
    	        .build();

    	Footballer footballer2 = Footballer.builder()
    	        .name("Gurpreet Singh Sandhu")
    	        .age(31)
    	        .goals(0)  
    	        .assists(0)
    	        .build();

    	System.out.println(session);
    	session.beginTransaction();
    	 session.persist(cricketer1);
    	 session.persist(cricketer2);
    	 session.persist(footballer1);
    	 session.persist(footballer2);
    	 session.getTransaction().commit();
    	 String hql = "FROM Player";
    	 List<Player> players = session.createQuery(hql, Player.class).getResultList();
    	 players.stream().forEach((p)->{
    		 if(p instanceof Footballer ) {
    			 System.out.println(p);
    		 }else{
    			 System.out.println(p);
    		 }
    	 });
    	 
    	      System.out.println(players);
    	      
    	 }
    	 
    	
    
}
