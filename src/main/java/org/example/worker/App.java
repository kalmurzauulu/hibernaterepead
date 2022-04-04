package org.example.worker;

import org.example.hibernateUtil.HibernateUtil;
import org.example.student.Student;
import org.hibernate.Session;

import java.util.List;

public class App {
    public static void main(String[] args) {
        HibernateUtil.getSessionFactory();
        Worker worker = new Worker("Shergazy","bar","Alimbaev",35000);
        create(worker);
        System.out.println(getById(1));
        for (Worker w:getAllWorkers()){
            System.out.println(w);
        }
        update(2,"garson",30000);
        delete(4);
    }
public static int create(Worker worker){
    Session session =  HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction().commit();
    session.save(worker);
    session.getTransaction();
    session.close();
    System.out.println("worker succesfully added " + worker);
    return worker.getId();
}

public static Worker getById(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction().commit();
        Worker worker = session.get(Worker.class,id);
        session.getTransaction();
        session.close();

        return worker;
}

public static List<Worker> getAllWorkers(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Worker>workers = session.createQuery("FROM Worker").getResultList();
        session.getTransaction().commit();
        session.close();
    System.out.println("Finded " + workers.size() + " workers");
    return workers;
}

public static void update(int id,String position,int salary){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Worker worker = session.get(Worker.class,id);
        worker.setPosition(position);
        worker.setSalary(salary);
        session.getTransaction().commit();
        session.close();
    System.out.println("Succesfully updated " + worker);
}
    public  static void delete(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Worker worker = session.get(Worker.class,id);
        session.delete(worker);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully deleted " + worker);
    }

}

