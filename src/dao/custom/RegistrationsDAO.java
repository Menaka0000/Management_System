package dao.custom;

import dao.SuperDAO;
import entity.Student;

import java.util.List;

public interface RegistrationsDAO extends SuperDAO {
    List<Student> getRegisteredStu(String id);
}
