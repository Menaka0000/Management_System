package bo.custom;

import bo.SuperBO;
import entity.Student;
import java.util.List;

public interface RegistrationsBO extends SuperBO {
    List<Student> getRegisteredStu(String id);
}
