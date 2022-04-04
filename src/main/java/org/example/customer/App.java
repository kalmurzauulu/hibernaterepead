package org.example.customer;

import org.example.hibernateUtil.HibernateUtil;
import org.example.menu.Menu;
import org.example.order.Order;
import org.hibernate.Session;

import java.util.List;

public class App {
    public static void main(String[] args) {
        HibernateUtil.getSessionFactory();
        Customer customer = new Customer("Baygazy","20080",20080,"Masalieva 58");
        create(customer);
        System.out.println(getById(1));
        for (Customer c:getAllCustomers()){
            System.out.println(c);
        }
        update(1,"30555",25009);
        delete(2);
    }

    public  static int create (Customer customer){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(customer);
        session.getTransaction().commit();
        session.close();
        System.out.println("Succesfully added" + customer );
        return customer.getId();
    }

    public static Customer getById(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Customer customer = session.get(Customer.class,id);
        session.getTransaction().commit();
        session.close();
        return customer;
    }

    public static List<Customer> getAllCustomers(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Customer> customer = session.createQuery("FROM Customer ").getResultList();
        session.getTransaction().commit();
        session.close();
        System.out.println("find " +customer +" Сustomer");
        return customer;
    }

    public static void update(int id, String orderNummer,int chek){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Customer customer = session.get(Customer.class,id);
        customer.setOrderNummer(orderNummer);
        customer.setChek(chek);
        session.getTransaction().commit();
        session.close();
        System.out.println("Succesfully update " + customer);
    }

    public static void delete(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Customer customer = session.get(Customer.class,id);
        session.delete(customer);
        session.getTransaction().commit();
        session.close();
        System.out.println("succesfully deleted " + customer);
    }
}
