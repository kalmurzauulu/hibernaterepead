package org.example.city;

import org.example.hibernateUtil.HibernateUtil;

import org.hibernate.Session;

import java.util.List;

public class App {
    public static void main(String[] args) {
        HibernateUtil.getSessionFactory();
        City city = new City("Ozgon","Biygazy","Kyrgyz",52);
        create(city);
        System.out.println(getById(1));
        for (City c: getAllCities()){
            System.out.println(c);
        }
        update(1,"Shergazy",53);
        delete(1);
    }
    public  static int create (City city){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(city);
        session.getTransaction().commit();
        session.close();
        System.out.println("Succesfully added" + city );
        return city.getId();
    }

    public static City getById(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        City city = session.get(City.class,id);
        session.getTransaction().commit();
        session.close();
        return city;
    }

    public static List<City> getAllCities(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<City> city = session.createQuery("FROM City ").getResultList();
        session.getTransaction().commit();
        session.close();
        System.out.println("find " +city.size() +" Cities");
        return city;
    }

    public static void update(int id, String mayor,int area){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        City city = session.get(City.class,id);
        city.setMayor(mayor);
        city.setArea(area);
        session.getTransaction().commit();
        session.close();
        System.out.println("Succesfully update " + city);
    }

    public static void delete(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        City city = session.get(City.class,id);
        session.delete(city);
        session.getTransaction().commit();
        session.close();
        System.out.println("succesfully deleted " + city);
    }
}
