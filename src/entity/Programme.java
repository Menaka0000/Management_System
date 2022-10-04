package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "programme")
public class Programme {
    @Id
    private
    String id;
    private String name;
    private String duration;
    private double fee;
    @OneToMany(mappedBy = "programmeId")
    private List<Registration> registrationList = new ArrayList<>();

    public Programme() {
    }

    public Programme(String id, String name, String duration, double fee, List<Registration> registrationList) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.fee = fee;
        this.registrationList = registrationList;
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

    public List<Registration> getRegistrationList() {
        return registrationList;
    }

    public void setRegistrationList(List<Registration> registrationList) {
        this.registrationList = registrationList;
    }

    @Override
    public String toString() {
        return "Programme{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", duration='" + duration + '\'' +
                ", fee=" + fee +
                '}';
    }
}
