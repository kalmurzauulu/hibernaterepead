package org.example.region;

import org.example.hibernateUtil.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class App {
    public static void main(String[] args) {
        HibernateUtil.getSessionFactory();
        Region region = new Region("Kochkor",12000,"Salay","Kyrgyzstan");
        create(region);
        System.out.println(getById(1));

        for (Region r :getAllRegions()){
            System.out.println(r);
        }
        update(1,2000,"Valay");
        deleted(3);
    }

    public static int create (Region region){
        Session session  = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(region);
        session.getTransaction().commit();
        session.close();
        System.out.println("Succesfully created " + region);
        return  region.getId();
    }

    public static Region getById(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Region region = session.get(Region.class,id);
        session.getTransaction().commit();
        session.close();
        return region;
    }

    public static List<Region> getAllRegions(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Region>regions=session.createQuery("FROM Region").getResultList();
        session.getTransaction().commit();
        session.close();
        System.out.println("Finded " + regions.size() + " regions");
        return regions;
    }

    public static void update (int id ,int region_population,String mayor_name){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Region region = session.get(Region.class,id);
        region.setRegion_population(region_population);
        region.setMayor_name(mayor_name);
        session.getTransaction().commit();
        session.close();
        System.out.println("Succesfully updated " + region);
    }

    public static void deleted (int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Region region = session.get(Region.class,id);
        session.getTransaction().commit();
        session.close();
        System.out.println("succesfully deleted " + region);
    }
}
