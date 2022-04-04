package org.example.teacher;

import org.example.hibernateUtil.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class App {
    public static void main(String[] args) {
        HibernateUtil.getSessionFactory();
        Teacher teacher = new Teacher("Madgazy","kazakh",20000,true);
        create(teacher);
        System.out.println(getById(1));

        for (Teacher t : getAllTeachers()){
            System.out.println(t);
        }
        update(1,300000,false);
         delete(2);
    }

    public static int create(Teacher teacher){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(teacher);
        session.getTransaction().commit();
        session.close();
        System.out.println("teacher succesfully added " + teacher);
        return teacher.getId();

    }

    public static Teacher getById (int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Teacher teacher = session.get(Teacher.class,id);
        session.getTransaction().commit();
        session.close();
        return teacher;
    }

    public static List<Teacher> getAllTeachers(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Teacher> teachers = session.createQuery("FROM Teacher").getResultList();
        session.getTransaction().commit();
        session.close();
        System.out.println("Finded " + teachers.size() + " teachers");
        return teachers;
    }

public static void update (int id,int salary,boolean have_home){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Teacher teacher = session.get(Teacher.class,id);
        teacher.setSalary(salary);
        teacher.setHave_home(have_home);
        session.getTransaction().commit();
        session.close();
    System.out.println("Succesfully updated " +  teacher);

}

public static void delete(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Teacher teacher = session.get(Teacher.class,id);
        session.delete(teacher);
        session.getTransaction().commit();
        session.close();
    System.out.println("Succesfully deleted " + teacher);
}
}
