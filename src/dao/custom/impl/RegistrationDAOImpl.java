package dao.custom.impl;

import dao.custom.RegistrationsDAO;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.FactoryConfiguration;

import java.util.List;

public class RegistrationDAOImpl implements RegistrationsDAO {
    @Override
    public List<Student> getRegisteredStu(String id) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "SELECT studentId FROM registration where programme_id =:id";
        Query students = session.createQuery(hql);
        students.setParameter("id", id);
        List list = students.list();
        transaction.commit();
        session.close();
        return list;
//      return getList(list); getList method doesn't need because this method already do it.

    }

   /* private List<Student> getList(List<String> stuIdList) {
        List<Student> studentList = new ArrayList<>();

        for (String id :stuIdList
             ) {
            Session session = FactoryConfiguration.getInstance().getSession();
            Transaction transaction = session.beginTransaction();
            studentList.add(session.get(Student.class,id));
            transaction.commit();
            session.close();
        }
        return studentList;
    }*/
}
