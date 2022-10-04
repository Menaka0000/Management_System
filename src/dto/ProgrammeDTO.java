package dto;

import entity.Registration;
import entity.Student;

import java.util.ArrayList;
import java.util.List;

public class ProgrammeDTO {
    private String id;
    private String name;
    private String duration;
    private double fee;
    List<Registration> registrationList = new ArrayList<>();

    public ProgrammeDTO() {
    }

    public ProgrammeDTO(String id, String name, String duration, double fee, List<Registration> studentList) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.fee = fee;
        this.registrationList = studentList;
    }

    public List<Registration> getStudentList() {
        return registrationList;
    }

    public void setStudentList(List<Registration> studentList) {
        this.registrationList = studentList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    @Override
    public String toString() {
        return "ProgrammeDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", duration='" + duration + '\'' +
                ", fee=" + fee +
                '}';
    }
}
