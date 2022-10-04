package entity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "student")
public class Student {
    @Id
    private
    String id;
    @Embedded
    private Name name;
    private String address;
    private int age;
    private String gender;
    private String date;
    private String time;
    @OneToMany(mappedBy = "studentId")
    private List<Registration> registrationList = new ArrayList<>();

    public Student() {
    }

    public Student(String id, Name name, String address, int age, String gender, String date, String time, List<Registration> registrationList) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.age = age;
        this.gender = gender;
        this.date = date;
        this.time = time;
        this.registrationList = registrationList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public List<Registration> getRegistrationList() {
        return registrationList;
    }

    public void setRegistrationList(List<Registration> registrationList) {
        this.registrationList = registrationList;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name=" + name +
                ", address='" + address + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
