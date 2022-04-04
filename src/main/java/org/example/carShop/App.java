package org.example.carShop;

import org.example.hibernateUtil.HibernateUtil;
import org.example.menu.Menu;
import org.example.order.Order;
import org.hibernate.Session;

import java.util.List;

public class App {
    public static void main(String[] args) {
        HibernateUtil.getSessionFactory();
        CarShop carShop = new CarShop(6,200000,"Kurmangazy","bugatty");
        create(carShop);

        System.out.println(getById(1));
        for (CarShop c:getAllCars()){
            System.out.println(c);
        }
        update(2,"bmw",30000);
        delete(4);
    }

    public static int create(CarShop carShop){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(carShop);
        session.getTransaction().commit();
        session.close();
        System.out.println("carShop succesfully added " + carShop);
        return carShop.getId();
    }


    public static CarShop getById(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        CarShop carShop = session.get(CarShop.class,id);
        session.getTransaction().commit();
        session.close();
        return carShop;
    }

    public static List<CarShop> getAllCars(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<CarShop> cars = session.createQuery("FROM CarShop ").getResultList();
        session.getTransaction().commit();
        session.close();
        System.out.println("find " +cars.size() +" Car");
        return cars;
    }

    public static void update(int id, String markName,int price){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        CarShop carShop = session.get(CarShop.class,id);
        carShop.setMarkName(markName);
        carShop.setPrice(price);
        session.getTransaction().commit();
        session.close();
        System.out.println("Succesfully update " + carShop);
    }

    public static void delete(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        CarShop carShop = session.get(CarShop.class,id);
        session.delete(carShop);
        session.getTransaction().commit();
        session.close();
        System.out.println("succesfully deleted " + carShop);
    }
}
