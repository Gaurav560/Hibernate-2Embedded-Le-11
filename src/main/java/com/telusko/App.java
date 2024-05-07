//package com.telusko;
//
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
//import org.hibernate.cfg.Configuration;
//import org.hibernate.service.ServiceRegistry;
//
//public class App
//{
//    public static void main( String[] args )
//    {
//Alien telusko=new Alien();
//telusko.setAid(105);
//telusko.setAname("navin");
//telusko.setColor("green");
//        Configuration con=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Alien.class);
//        ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
//        SessionFactory sf= con.buildSessionFactory(reg);
//        Session session= sf.openSession();
//
//        Transaction tx= session.beginTransaction();
//        session.persist(telusko);
//        tx.commit();
//    }
//}


package com.telusko;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class App
{
    public static void main(String[] args)
    {
        Alien telusko = null;
//        telusko.setAid(108);
//        telusko.setAname("Navin");
//        telusko.setColor("Green");

        // Create registry
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml") // Load settings from hibernate.cfg.xml
                .build();

        // Create MetadataSources
        MetadataSources sources = new MetadataSources(registry);

        // Add annotated classes
        sources.addAnnotatedClass(Alien.class);

        // Create Metadata
        Metadata metadata = sources.getMetadataBuilder().build();

        // Build SessionFactory
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        // Get session and begin transaction
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();


//fetching an object of Alien class
        telusko=session.get(Alien.class,106);

        // saving an object of Alien class
       // session.persist(telusko);
        tx.commit();

        System.out.println(telusko);

    }
}

