package org.example.student;

import org.example.hibernateUtil.HibernateUtil;

import org.hibernate.Session;

import java.util.List;

/**
 * Hello world!
 *
 */
public class    App
{
    public static void main( String[] args ) {
        HibernateUtil.getSessionFactory();
       Student student = new Student("Bekgazy","Golang",13);
       create(student);
        System.out.println(getById(1));
        for (Student s : getAllStudents()){
            System.out.println(s);
        }
        update(1,"java",85);
        delete(2);


    }

    public static int create (Student student){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(student);
        session.getTransaction().commit();
        session.close();
        System.out.println("student succesfully added : " + student);
        return student.getId();
    }

    public static Student getById(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Student student = session.get(Student.class,id);
        session.getTransaction().commit();
        session.close();
        return student;
    }

    public static List<Student> getAllStudents(){
        Session session =
                HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Student>students = session.createQuery("FROM  Student").getResultList();
        session.getTransaction().commit();
        session.close();
        System.out.println("finded " + students.size() + " students ");
        return students;
    }

    public static void update(int id, String course,int age){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Student student = session.get(Student.class,id);
        student.setCourse(course);
        student.setAge(age);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully updated " + student);
    }


    public  static void delete(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Student student = session.get(Student.class,id);
        session.delete(student);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully deleted " + student);
    }
}
