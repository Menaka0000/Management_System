package entity;

import javax.persistence.*;

@Entity(name = "registration")
public class Registration {
    @Id
    @GeneratedValue(generator = "reg_id",strategy=GenerationType.SEQUENCE)
    @SequenceGenerator(name = "reg_id",sequenceName = "reg_sequence",initialValue = 1,allocationSize = 1)
    private
    int id;

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private
    Student studentId;
    @ManyToOne
    @JoinColumn(name = "programme_id", referencedColumnName = "id")
    private
    Programme programmeId;
    private String date;
    private String time;

    public Registration() {
    }

    public Registration( Student studentId, Programme programmeId, String date, String time) {
        this.studentId = studentId;
        this.programmeId = programmeId;
        this.setDate(date);
        this.setTime(time);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student getStudentId() {
        return studentId;
    }

    public void setStudentId(Student studentId) {
        this.studentId = studentId;
    }

    public Programme getProgrammeId() {
        return programmeId;
    }

    public void setProgrammeId(Programme programmeId) {
        this.programmeId = programmeId;
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

    @Override
    public String toString() {
        return "Registration{" +
                "id='" + id + '\'' +
                ", studentId=" + studentId +
                ", programmeId=" + programmeId +
                '}';
    }


}
