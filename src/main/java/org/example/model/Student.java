package org.example.model;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.Entity;
import javax.persistence.Id;

// Persistence API is the Java EE specification.
// If we define the Class as Entity then Hibernate will create the table of the class.

@Entity
//@Table(name = "MyStudents") // Only Table name is changed not complete Entity.
public class Student {
    // Primary Key
    @Id
    private int id;
    private String name;
    private String city;

    public Student(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public Student(){
        super();
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
