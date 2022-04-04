package org.example.teacher;

import javax.persistence.*;

@Entity
@Table(name = "teachers")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String teach_language;
    private int salary;
    private boolean have_home;

    public Teacher() {
    }

    public Teacher(String name, String teach_language, int salary, boolean have_home) {
        this.name = name;
        this.teach_language = teach_language;
        this.salary = salary;
        this.have_home = have_home;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeach_language() {
        return teach_language;
    }

    public void setTeach_language(String teach_language) {
        this.teach_language = teach_language;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public boolean isHave_home() {
        return have_home;
    }

    public void setHave_home(boolean have_home) {
        this.have_home = have_home;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", teach_language='" + teach_language + '\'' +
                ", salary=" + salary +
                ", have_home=" + have_home +
                '}';
    }
}
