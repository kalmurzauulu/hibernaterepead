package org.example.order;


import org.example.hibernateUtil.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class App {
    public static void main(String[] args) {
        HibernateUtil.getSessionFactory();
        Order order = new Order("Mirgazy",40500,"40x38","01.02.1998");
        create(order);
        System.out.println(getById(1));
        for (Order o:getAllOrders()){
            System.out.println(o);
        }
        update(1,800000,"50x50");
        delete(1);

    }

    public static int create (Order order){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(order);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully created "  + order);
        return order.getId();
    }

    public static Order getById (int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Order order = session.get(Order.class,id);
        session.getTransaction().commit();
        session.close();
        return order;
    }

    public  static List<Order> getAllOrders (){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Order>orders = session.createQuery("FROM Order ").getResultList();
        session.getTransaction().commit();
        session.close();
        System.out.println("Finded " + orders.size() + " orders");
        return orders;
    }

    public  static  void  update(int id ,int price,String order_size ){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Order order = session.get(Order.class,id);
        order.setPrice(price);
        order.setOrder_size(order_size);
        session.getTransaction().commit();
        session.close();
        System.out.println("succesfully updated " + order);

    }

    public static  void  delete(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Order order = session.get(Order.class,id);
        session.delete(order);
        session.getTransaction().commit();
        session.close();
        System.out.println("succesfully deleted " + order);
    }
}

