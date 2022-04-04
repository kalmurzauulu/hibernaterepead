package org.example.country;

import org.example.hibernateUtil.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class App {
    public static void main(String[] args) {
        HibernateUtil.getSessionFactory();
        Country country = new Country("Kyrgyzstan","Mirgazy",199999,"Bishkek");
        create(country);
        System.out.println(getById(1));
        for (Country c: getAllCountries()){
            System.out.println(c);
        }
        update(2,"Shergazy","Osh");
        delete(3);
    }
    public  static int create (Country country){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(country);
        session.getTransaction().commit();
        session.close();
        System.out.println("Succesfully added" + country );
        return country.getId();
    }

    public static Country getById(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Country country = session.get(Country.class,id);
        session.getTransaction().commit();
        session.close();
        return country;
    }

    public static List<Country> getAllCountries(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Country> country = session.createQuery("FROM Country ").getResultList();
        session.getTransaction().commit();
        session.close();
        System.out.println("find " +country.size() +" Countryes");
        return country;
    }

    public static void update(int id, String president,String capital){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Country country = session.get(Country.class,id);
        country.setPresident(president);
        country.setCapital(capital);
        session.getTransaction().commit();
        session.close();
        System.out.println("Succesfully update " + country);
    }

    public static void delete(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Country country = session.get(Country.class,id);
        session.delete(country);
        session.getTransaction().commit();
        session.close();
        System.out.println("succesfully deleted " + country);
    }
}
