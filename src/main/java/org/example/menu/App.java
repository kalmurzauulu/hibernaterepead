package org.example.menu;

import org.example.hibernateUtil.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class App {
    public static void main(String[] args) {
        HibernateUtil.getSessionFactory();
    Menu menu = new Menu("Manty",50,5,"Nurgazy");
    create(menu);
    System.out.println(getById(1));
    for (Menu m : getAllMenu()){
        System.out.println(m);
    }
    update(1,200,25);
    delete(1);

    }

    public  static int create (Menu menu){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(menu);
        session.getTransaction().commit();
        session.close();
        System.out.println("Succesfully added" + menu );
        return menu.getId();
    }

    public static Menu getById(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Menu menu = session.get(Menu.class,id);
        session.getTransaction().commit();
        session.close();
        return menu;
    }

    public static List<Menu> getAllMenu(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Menu> menu = session.createQuery("FROM Menu ").getResultList();
        session.getTransaction().commit();
        session.close();
        System.out.println("find " +menu.size() +" Menu");
    return menu;
    }

    public static void update(int id, int price,int makeTime){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Menu menu = session.get(Menu.class,id);
        menu.setPrice(price);
        menu.setMaketime(makeTime);
        session.getTransaction().commit();
        session.close();
        System.out.println("Succesfully update " + menu);
    }

    public static void delete(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Menu menu = session.get(Menu.class,id);
        session.delete(menu);
        session.getTransaction().commit();
        session.close();
        System.out.println("succesfully deleted " + menu);
    }
}
